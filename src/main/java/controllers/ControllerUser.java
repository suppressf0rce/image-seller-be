package controllers;

import dto.UserDTO;
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


}
