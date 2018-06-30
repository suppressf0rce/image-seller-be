package controllers;

import dto.UserDTO;
import service.UserService;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
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

    @Inject
    private UserService userService;

    @POST
    @Path("/login")
    @Consumes("application/json")
    public Response login(UserDTO userDTO) {
        return userService.login(userDTO);
    }


}
