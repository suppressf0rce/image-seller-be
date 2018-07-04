package service.impl;

import com.sun.corba.se.impl.orbutil.closure.Constant;
import dao.UserDAO;
import dto.UserDTO;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import model.Permission;
import model.User;
import security.AuthUtils;
import security.AuthenticationFilter;
import service.MailService;
import service.UserService;
import utils.Constants;
import utils.EncryptionUtil;

import javax.crypto.spec.SecretKeySpec;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.Consumes;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.NotAuthorizedException;
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
            String tokenObj = "{\"token\":\"" + token + "\"}";
            return Response.ok(tokenObj).header("Authorization", AuthenticationFilter.AUTHENTICATION_SCHEME + " " + token).build();

        } catch (Exception e) {
            return Response.status(Response.Status.FORBIDDEN).build();
        }
    }

    @Override
    public Response register(UserDTO userDTO) {
        if (userDTO.getUsername() == null)
            throw new BadRequestException("Username is null");

        if (userDTO.getPassword() == null)
            throw new BadRequestException("Password is null");

        if (userDTO.getEmail() == null)
            throw new BadRequestException("Email is null");

        userDTO.setTypes(null);

        add(userDTO, null);

        // Issue a token for the user
        //TODO:Send email to the user
        try {
            mailService.sendMail(Constants.getConfirmationMessage(userDTO.getUsername(), issueActivationLink(userDTO)), Constants.APP_NAME + " Activation", userDTO.getEmail());
        } catch (Exception e) {
            removeById(userDTO.getId(), null);
            throw new BadRequestException(e.getMessage());
        }

        return Response.ok().build();
    }

    @Override
    public Response activate(String id) {
        String decrypted = EncryptionUtil.decode(id);
        if (decrypted != null) {
            int userId = Integer.valueOf(decrypted);
            try {
                User user = userDAO.getById(userId);

                if(user == null)
                    throw new BadRequestException("Unrecognized User ID");

                user.setActivated(true);
                userDAO.update(user);

                try {
                    return Response.seeOther(new URI(Constants.APP_LOGIN_PATH)).build();
                } catch (URISyntaxException e) {
                    throw new BadRequestException();
                }
            } catch (SQLException e) {
                throw new BadRequestException("Unrecognized User ID");
            }
        } else
            throw new BadRequestException("Unrecognized Activation Request");
    }

    @Override
    public Response sendResetMail(UserDTO user) {
        if (user.getEmail() == null)
            throw new BadRequestException();

        try {
            User userFound = userDAO.findByEmail(user.getEmail());
            if (userFound == null)
                throw new SQLException();

            try {
                mailService.sendMail(Constants.getResetMessage(userFound.getUsername(), issueResetLink(userFound)), Constants.APP_NAME + " - Password Reset", userFound.getEmail());
                return Response.ok().build();
            } catch (Exception e) {
                throw new BadRequestException("Incorrect Email Address");
            }

        } catch (SQLException e) {
            throw new BadRequestException("User with that email doesn't exist");
        }
    }

    @Override
    public Response resetPassword(UserDTO user, String requestID) {
        if (user.getPassword() == null)
            throw new BadRequestException("Password can't be null");

        try {
            User userFound = userDAO.getById(Integer.valueOf(EncryptionUtil.decode(requestID)));
            userFound.setPassword(user.getPassword());
            userFound.setPasswordChange(false);
            userDAO.update(userFound);

            // Issue a token for the user
            String token = issueToken(userFound.getUsername());

            // Return the token on the response
            String tokenObj = "{\"token\":\"" + token + "\"}";

            return Response.ok(tokenObj).build();
        } catch (Exception e) {
            throw new BadRequestException("Unknown request ID");
        }
    }

    @Override
    public UserDTO add(UserDTO object, User authUser) {
        try {
            object.setId(userDAO.add(convertToEntity(object, User.class)));
            object.setPassword("Secret");
            return object;
        } catch (SQLException e) {
            throw new BadRequestException(e.getMessage());
        }
    }

    @Override
    public UserDTO removeAdmin(UserDTO admin, User authUser) {
        if (!AuthUtils.checkIfAdmin(authUser))
            throw new NotAuthorizedException("");

        if (!AuthUtils.checkIfAdmin(convertToEntity(admin, User.class)))
            throw new BadRequestException("Target is not administrator!");

        try {
            userDAO.removeById(admin.getId());
            UserDTO dto = new UserDTO();
            dto.setId(admin.getId());
            return dto;
        } catch (SQLException e) {
            throw new BadRequestException(e.getMessage());
        }
    }

    @Override
    public Response addAdmin(UserDTO admin, User authUser) {
        if (!AuthUtils.checkIfAdmin(authUser))
            throw new NotAuthorizedException("");

        if (admin.getUsername() == null || admin.getPassword() == null || admin.getEmail() == null)
            throw new BadRequestException();

        try {
            User adminUs = convertToEntity(admin, User.class);
            adminUs.setActivated(true);
            int id = userDAO.add(adminUs);
            userDAO.assignPermission(1, id);
            return Response.ok().build();
        } catch (SQLException e) {
            throw new BadRequestException();
        }
    }

    @Override
    public UserDTO removeOperator(UserDTO admin, User authUser) {
        if (!AuthUtils.checkIfAdmin(authUser))
            throw new NotAuthorizedException("");

        if (!AuthUtils.checkIfOperator(convertToEntity(admin, User.class)))
            throw new BadRequestException("Target is not operater!");

        try {
            userDAO.removeById(admin.getId());
            UserDTO dto = new UserDTO();
            dto.setId(admin.getId());
            return dto;
        } catch (SQLException e) {
            throw new BadRequestException(e.getMessage());
        }
    }

    @Override
    public Response addOperator(UserDTO admin, User authUser) {
        if (!AuthUtils.checkIfAdmin(authUser))
            throw new NotAuthorizedException("");

        if (admin.getUsername() == null || admin.getPassword() == null || admin.getEmail() == null)
            throw new BadRequestException();

        try {
            User adminUs = convertToEntity(admin, User.class);
            adminUs.setActivated(true);
            int id = userDAO.add(adminUs);
            userDAO.assignPermission(2, id);
            return Response.ok().build();
        } catch (SQLException e) {
            throw new BadRequestException();
        }
    }

    @Override
    public UserDTO removeSeller(UserDTO admin, User authUser) {
        if (!AuthUtils.checkIfAdmin(authUser))
            throw new NotAuthorizedException("");

        if (!AuthUtils.checkIfSeller(convertToEntity(admin, User.class)))
            throw new BadRequestException("Target is not seller!");

        try {
            userDAO.removeById(admin.getId());
            UserDTO dto = new UserDTO();
            dto.setId(admin.getId());
            return dto;
        } catch (SQLException e) {
            throw new BadRequestException(e.getMessage());
        }
    }

    @Override
    public Response addSeller(UserDTO admin, User authUser) {
        if (!AuthUtils.checkIfAdmin(authUser))
            throw new NotAuthorizedException("");

        if (admin.getUsername() == null || admin.getPassword() == null || admin.getEmail() == null)
            throw new BadRequestException();

        try {
            User adminUs = convertToEntity(admin, User.class);
            adminUs.setActivated(true);
            int id = userDAO.add(adminUs);
            userDAO.assignPermission(3, id);
            return Response.ok().build();
        } catch (SQLException e) {
            throw new BadRequestException();
        }
    }

    @Override
    public UserDTO removeUser(UserDTO admin, User authUser) {
        if (!AuthUtils.checkIfAdmin(authUser))
            throw new NotAuthorizedException("");


        try {
            userDAO.removeById(admin.getId());
            UserDTO dto = new UserDTO();
            dto.setId(admin.getId());
            return dto;
        } catch (SQLException e) {
            throw new BadRequestException(e.getMessage());
        }
    }

    @Override
    public Response addUser(UserDTO admin, User authUser) {
        if (!AuthUtils.checkIfAdmin(authUser))
            throw new NotAuthorizedException("");

        if (admin.getUsername() == null || admin.getPassword() == null || admin.getEmail() == null)
            throw new BadRequestException();

        try {
            User adminUs = convertToEntity(admin, User.class);
            adminUs.setActivated(true);
            userDAO.add(adminUs);
            return Response.ok().build();
        } catch (SQLException e) {
            throw new BadRequestException();
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
            User user = userDAO.getById(object.getId());
            User updatingUser = convertToEntity(object, User.class);

            if (updatingUser.getPassword() == null)
                updatingUser.setPassword(user.getPassword());


            userDAO.update(updatingUser);

            object.setPassword("Secret");
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
            for (User user : users) {
                UserDTO dto = convertToDTO(user, UserDTO.class);
                dto.setPassword("Secret");
                dtos.add(dto);
            }
            return dtos;
        } catch (SQLException e) {
            throw new BadRequestException(e.getMessage());
        }
    }

    @Override
    public List<UserDTO> getAllAdmins() {
        try {
            List<User> users = userDAO.getAllAdmins();
            List<UserDTO> dtos = new ArrayList<>();
            for (User user : users) {
                UserDTO dto = convertToDTO(user, UserDTO.class);
                dto.setPassword("Secret");
                dtos.add(dto);
            }
            return dtos;
        } catch (SQLException e) {
            throw new BadRequestException(e.getMessage());
        }
    }

    @Override
    public List<UserDTO> getAllOperators() {
        try {
            List<User> users = userDAO.getAllOperators();
            List<UserDTO> dtos = new ArrayList<>();
            for (User user : users) {
                UserDTO dto = convertToDTO(user, UserDTO.class);
                dto.setPassword("Secret");
                dtos.add(dto);
            }
            return dtos;
        } catch (SQLException e) {
            throw new BadRequestException(e.getMessage());
        }
    }

    @Override
    public List<UserDTO> getAllSellers() {
        try {
            List<User> users = userDAO.getAllBuyers();
            List<UserDTO> dtos = new ArrayList<>();
            for (User user : users) {
                UserDTO dto = convertToDTO(user, UserDTO.class);
                dto.setPassword("Secret");
                dtos.add(dto);
            }
            return dtos;
        } catch (SQLException e) {
            throw new BadRequestException(e.getMessage());
        }
    }

    @Override
    public UserDTO getById(int id) {
        try {
            UserDTO dt = convertToDTO(userDAO.getById(id), UserDTO.class);
            dt.setPassword("Secret");
            return dt;
        } catch (SQLException e) {
            throw new BadRequestException(e.getMessage());
        }
    }


    private void authenticate(String username, String password) throws Exception {
        // Authenticate against a database, LDAP, file or whatever
        // Throw an Exception if the credentials are invalid

        User user = userDAO.findByUsername(username);
        if (user != null) {

            if (!password.equals(user.getPassword()))
                throw new Exception();

            if (!user.isActivated())
                throw new Exception();

            if(user.isBlocked())
                throw new Exception();

            if(user.isSuspended())
                throw new Exception();

        } else
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

    private String issueActivationLink(UserDTO userDTO) {
        return Constants.REST + "users/activate/" + EncryptionUtil.encode(userDTO.getId() + "");
    }

    private String issueResetLink(User user) {
        return Constants.WEBSITE + "reset/" + EncryptionUtil.encode(user.getId() + "");
    }

    @Override
    public String getResetLink(User user) {
        String link = EncryptionUtil.encode(user.getId() + "");
        return "{\"requestID\": \"" + link + "\"}";
    }
}
