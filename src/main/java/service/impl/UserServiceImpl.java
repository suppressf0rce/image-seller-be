package service.impl;

import com.sun.corba.se.impl.orbutil.closure.Constant;
import dao.UserDAO;
import dto.UserDTO;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import model.User;
import security.AuthenticationFilter;
import service.MailService;
import service.UserService;
import utils.AES;
import utils.Constants;

import javax.crypto.spec.SecretKeySpec;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.core.Response;
import javax.xml.bind.DatatypeConverter;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.Key;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Dependent
public class UserServiceImpl implements UserService {

    @Inject
    private UserDAO userDAO;

    @Inject
    private MailService mailService;

    @Override
    public Response login(UserDTO userDTO) {
        try {

            // Authenticate the user using the credentials provided
            authenticate(userDTO.getUsername(), userDTO.getPassword());

            // Issue a token for the user
            String token = issueToken(userDTO.getUsername());

            // Return the token on the response
            String tokenObj = "{\"token\":\""+token+"\"}";
            return Response.ok(tokenObj).header("Authorization", AuthenticationFilter.AUTHENTICATION_SCHEME+" "+token).build();

        } catch (Exception e) {
            return Response.status(Response.Status.FORBIDDEN).build();
        }
    }

    @Override
    public Response register(UserDTO userDTO){
        if(userDTO.getUsername() == null)
            throw new BadRequestException("Username is null");

        if(userDTO.getPassword() == null)
            throw new BadRequestException("Password is null");

        if(userDTO.getEmail() == null)
            throw new BadRequestException("Email is null");

        userDTO.setTypes(null);

        add(userDTO,null);

        // Issue a token for the user
        //TODO:Send email to the user
        try {
            mailService.sendMail("Activation link:\n"+ issueActivationLink(userDTO),Constants.APP_NAME+ " Activation", userDTO.getEmail());
        } catch (Exception e) {
            removeById(userDTO.getId(), null);
            throw new BadRequestException(e.getMessage());
        }

        return Response.ok().build();
    }

    @Override
    public Response activate(String id) {
        String decrypted = AES.decrypt(id, Constants.API_KEY);
        if (decrypted != null) {
            int userId = Integer.valueOf(decrypted);
            UserDTO userDTO = getById(userId);
            userDTO.setActivated(true);
            update(userDTO, null);
            try {
                return Response.seeOther(new URI(Constants.APP_LOGIN_PATH)).build();
            } catch (URISyntaxException e) {
                throw new BadRequestException();
            }
        }else
            throw new BadRequestException("Unrecognized Activation Request");
    }

    @Override
    public UserDTO add(UserDTO object, User authUser) {
        try {
            object.setId(userDAO.add(convertToEntity(object, User.class)));
            return object;
        } catch (SQLException e) {
            throw new BadRequestException(e.getMessage());
        }
    }

    @Override
    public UserDTO removeById(int id, User authUser) {
        try {
            userDAO.removeById(id);
            UserDTO dto = new UserDTO();
            dto.setId(id);
            return dto;
        } catch (SQLException e) {
            throw new BadRequestException(e.getMessage());
        }
    }

    @Override
    public UserDTO update(UserDTO object, User authuser) {
        try {
            userDAO.update(convertToEntity(object,User.class));
            return object;
        } catch (SQLException e) {
            throw new BadRequestException(e.getMessage());
        }
    }

    @Override
    public List<UserDTO> getAll() {
        try {
            List<User> users = userDAO.getAll();
            List<UserDTO> dtos = new ArrayList<>();
            for(User user: users)
                dtos.add(convertToDTO(user,UserDTO.class));
            return dtos;
        } catch (SQLException e) {
            throw new BadRequestException(e.getMessage());
        }
    }

    @Override
    public UserDTO getById(int id) {
        try {
            return convertToDTO(userDAO.getById(id), UserDTO.class);
        } catch (SQLException e) {
            throw new BadRequestException(e.getMessage());
        }
    }


    private void authenticate(String username, String password) throws Exception {
        // Authenticate against a database, LDAP, file or whatever
        // Throw an Exception if the credentials are invalid

        User user = userDAO.findByUsername(username);
        if(user != null){

            if(!password.equals(user.getPassword()))
                throw new Exception();

            if(!user.isActivated())
                throw new Exception();
        }else
            throw new Exception();
    }

    private String issueToken(String username) {
        //The JWT signature algorithm we will be using to sign the token
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        //We will sign our JWT with our ApiKey secret
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(Constants.API_KEY);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        //Let's set the JWT Claims
        JwtBuilder builder = Jwts.builder().setId(UUID.randomUUID().toString())
                .setIssuedAt(now)
                .setSubject(username)
                .setIssuer(Constants.APP_NAME)
                .signWith(signatureAlgorithm, signingKey);

        //if it has been specified, let's add the expiration
        if (Constants.TOKEN_EXPIRATION >= 0) {
            long expMillis = nowMillis + Constants.TOKEN_EXPIRATION;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);
        }

        //Builds the JWT and serializes it to a compact, URL-safe string
        return builder.compact();
    }

    private String issueActivationLink(UserDTO userDTO){
        return Constants.REST + "users/activate/" + AES.encrypt(userDTO.getId()+"", Constants.API_KEY);
    }
}