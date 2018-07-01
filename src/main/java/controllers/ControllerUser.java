package controllers;

import dto.UserDTO;
import model.User;
import security.AuthenticatedUser;
import security.Secured;
import service.UserService;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Stateless
@LocalBean
@Produces("application/json")
@Path("/users")
public class ControllerUser {

    @Inject
    private UserService userService;

    @Inject
    @AuthenticatedUser
    private User authUser;

    @POST
    @Path("/login")
    @Consumes("application/json")
    public Response login(UserDTO userDTO) {
        return userService.login(userDTO);
    }


    @GET
    public List<UserDTO> getAll(){
        return userService.getAll();
    }

    @GET
    @Path("/{id}")
    public UserDTO getById(@PathParam("id") int id){
        return userService.getById(id);
    }

    @POST
    @Path("/register")
    @Consumes("application/json")
    public Response register(UserDTO userDTO){
        return userService.register(userDTO);
    }

    @GET
    @Path("/token")
    @Secured
    public UserDTO getUserByToken(){
        return userService.convertToDTO(authUser, UserDTO.class);
    }

    @GET
    @Path("/activate/{id}")
    public Response activate(@PathParam("id") String id){
        return userService.activate(id);
    }
}
