package controllers;

import dto.CategoryDTO;
import dto.CountryDTO;
import model.User;
import security.AuthenticatedUser;
import security.Secured;
import service.CategoryService;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.List;

@Stateless
@LocalBean
@Produces("application/json")
@Path("/category")
public class ControllerCategory {

    @Inject
    private CategoryService service;

    @Inject
    @AuthenticatedUser
    private User authenticatedUser;

    @GET
    public List<CategoryDTO> getAll(){
        return service.getAll();
    }

    @GET
    @Path("/{id}")
    public CategoryDTO getByID(@PathParam("id") int id){
        return service.getById(id);
    }

    @POST
    @Consumes("application/json")
    @Secured
    public CategoryDTO add(CategoryDTO dto){
        return service.add(dto,authenticatedUser);
    }

    @PUT
    @Consumes("application/json")
    @Secured
    public CategoryDTO update(CategoryDTO dto){
        return service.update(dto,authenticatedUser);
    }

    @DELETE
    @Consumes("application/json")
    @Secured
    public CategoryDTO delete(CategoryDTO dto){
        return service.removeById(dto.getId(), authenticatedUser);
    }

    @DELETE
    @Path("/{id}")
    @Secured
    public CategoryDTO delete(@PathParam("id") int id){
        return service.removeById(id, authenticatedUser);
    }
}
