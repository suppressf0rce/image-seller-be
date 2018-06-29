package controllers;

import dto.CountryDTO;
import service.CountryService;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.List;

@Stateless
@LocalBean
@Path("/country")
public class ControllerCountry {

    @Inject
    private CountryService service;

    @GET
    @Produces("application/json")
    public List<CountryDTO> getAll(){
        return service.getAll();
    }

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public CountryDTO getByID(@PathParam("id") int id){
        return service.getById(id);
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public CountryDTO add(CountryDTO dto){
        return service.add(dto);
    }

    @PUT
    @Produces("application/json")
    @Consumes("application/json")
    public CountryDTO update(CountryDTO dto){
        return service.update(dto);
    }

    @DELETE
    @Produces("application/json")
    @Consumes("application/json")
    public CountryDTO delete(CountryDTO dto){
        return service.removeById(dto.getId());
    }

    @DELETE
    @Path("/{id}")
    @Produces("application/json")
    @Consumes("application/json")
    public CountryDTO delete(@PathParam("id") int id){
        return service.removeById(id);
    }
}
