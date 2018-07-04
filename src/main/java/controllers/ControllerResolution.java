package controllers;

import dto.CountryDTO;
import dto.ResolutionDTO;
import model.User;
import security.AuthenticatedUser;
import security.Secured;
import service.ResolutionService;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.List;

@Stateless
@LocalBean
@Produces("application/json")
@Path("/resolution")
public class ControllerResolution {

    @Inject
    private ResolutionService service;

    @Inject
    @AuthenticatedUser
    private User authenticatedUser;

    @GET
    public List<ResolutionDTO> getAll(){
        return service.getAll();
    }

    @GET
    @Path("/{id}")
    public ResolutionDTO getByID(@PathParam("id") int id){
        return service.getById(id);
    }

    @POST
    @Consumes("application/json")
    @Secured
    public ResolutionDTO add(ResolutionDTO dto){
        return service.add(dto,authenticatedUser);
    }

    @PUT
    @Consumes("application/json")
    @Secured
    public ResolutionDTO update(ResolutionDTO dto){
        return service.update(dto,authenticatedUser);
    }

    @DELETE
    @Consumes("application/json")
    @Secured
    public ResolutionDTO delete(ResolutionDTO dto){
        return service.removeById(dto.getId(), authenticatedUser);
    }

    @DELETE
    @Path("/{id}")
    @Secured
    public ResolutionDTO delete(@PathParam("id") int id){
        return service.removeById(id, authenticatedUser);
    }

}
