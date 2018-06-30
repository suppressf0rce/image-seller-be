package controllers;

import dto.UserDTO;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Stateless
@LocalBean
@Produces("application/json")
@Path("/users")
public class ControllerUser {


    @POST
    @Path("/login")
    @Consumes("application/json")
    public Response authenticateUser(UserDTO userDTO) {
        try {

            // Authenticate the user using the credentials provided
            authenticate(userDTO.getUsername(), userDTO.getPassword());

            // Issue a token for the user
            String token = issueToken(userDTO.getUsername());

            // Return the token on the response
            return Response.ok(token).build();

        } catch (Exception e) {
            return Response.status(Response.Status.FORBIDDEN).build();
        }
    }

    private void authenticate(String username, String password) throws Exception {
        // Authenticate against a database, LDAP, file or whatever
        // Throw an Exception if the credentials are invalid

        //TODO:implement
    }

    private String issueToken(String username) {
        // Issue a token (can be a random String persisted to a database or a JWT token)
        // The issued token must be associated to a user
        // Return the issued token
        return null;
    }
}
