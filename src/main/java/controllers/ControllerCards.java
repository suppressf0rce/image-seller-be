package controllers;

import dto.CardDTO;
import dto.CountryDTO;
import model.User;
import security.AuthenticatedUser;
import security.Secured;
import service.CardService;
import service.CountryService;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.List;

@Stateless
@LocalBean
@Produces("application/json")
@Path("/cards")
public class ControllerCards {

    @Inject
    private CardService service;

    @Inject
    @AuthenticatedUser
    private User authenticatedUser;

    @GET
    @Secured
    public List<CardDTO> getAll(){
        return service.getAllForAuth(authenticatedUser);
    }

    @GET
    @Path("/{id}")
    public CardDTO getByID(@PathParam("id") int id){
        return service.getById(id);
    }

    @POST
    @Consumes("application/json")
    @Secured
    public CardDTO add(CardDTO dto){
        return service.add(dto,authenticatedUser);
    }

    @PUT
    @Consumes("application/json")
    @Secured
    public CardDTO update(CardDTO dto){
        return service.update(dto,authenticatedUser);
    }

    @DELETE
    @Consumes("application/json")
    @Secured
    public CardDTO delete(CardDTO dto){
        return service.removeById(dto.getId(), authenticatedUser);
    }

    @DELETE
    @Path("/{id}")
    @Secured
    public CardDTO delete(@PathParam("id") int id){
        return service.removeById(id, authenticatedUser);
    }

}
