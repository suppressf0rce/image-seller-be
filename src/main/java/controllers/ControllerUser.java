package controllers;

import dto.UserDTO;
import jdk.nashorn.internal.objects.annotations.Getter;
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
    @Secured
    public List<UserDTO> getAll(){
        return userService.getAll();
    }

    @GET
    @Path("/admins")
    @Secured
    public List<UserDTO> getAllAdmins(){
        return userService.getAllAdmins();
    }

    @DELETE
    @Path("/admins")
    @Secured
    @Consumes("application/json")
    public UserDTO deleteAdmin(UserDTO admin){
        return userService.removeAdmin(admin, authUser);
    }

    @POST
    @Path("/admins")
    @Consumes("application/json")
    @Secured
    public Response addAdmin(UserDTO admin){
        return userService.addAdmin(admin, authUser);
    }

    @GET
    @Path("/operators")
    @Secured
    public List<UserDTO> getAllOperators(){
        return userService.getAllOperators();
    }

    @GET
    @Path("/buyers")
    @Secured
    public List<UserDTO> getAllBuyers(){
        return userService.getAllBuyers();
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

    @POST
    @Path("/reset")
    @Consumes("application/json")
    public Response sendResetMail(UserDTO user){
        return userService.sendResetMail(user);
    }

    @GET
    @Path("/reset")
    @Secured
    public String getResetRequestID(){
        return userService.getResetLink(authUser);
    }

    @POST
    @Path("/reset/{requestID}")
    @Consumes("application/json")
    public Response resetMail(UserDTO user, @PathParam("requestID") String requestID){
        return userService.resetPassword(user, requestID);
    }

    @PUT
    @Consumes("application/json")
    public UserDTO editUser(UserDTO user){
        return userService.update(user, authUser);
    }
}
