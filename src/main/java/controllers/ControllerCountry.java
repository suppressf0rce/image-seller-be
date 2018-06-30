package controllers;

import dto.CountryDTO;
import model.User;
import security.AuthenticatedUser;
import service.CountryService;
import security.Secured;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.List;

@Stateless
@LocalBean
@Produces("application/json")
@Path("/country")
public class ControllerCountry {

    @Inject
    private CountryService service;

    @Inject
    @AuthenticatedUser
    private User authenticatedUser;

    @GET

    public List<CountryDTO> getAll(){
        return service.getAll();
    }

    @GET
    @Path("/{id}")
    public CountryDTO getByID(@PathParam("id") int id){
        return service.getById(id);
    }

    @POST
    @Consumes("application/json")
    @Secured
    public CountryDTO add(CountryDTO dto){
        return service.add(dto);
    }

    @PUT
    @Consumes("application/json")
    @Secured
    public CountryDTO update(CountryDTO dto){
        return service.update(dto);
    }

    @DELETE
    @Consumes("application/json")
    @Secured
    public CountryDTO delete(CountryDTO dto){
        return service.removeById(dto.getId());
    }

    @DELETE
    @Path("/{id}")
    @Secured
    public CountryDTO delete(@PathParam("id") int id){
        return service.removeById(id);
    }

    //TODO:Needs testing!!!
}
