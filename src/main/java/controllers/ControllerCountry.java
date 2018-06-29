package controllers;

import dto.CountryDTO;
import service.CountryService;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

@Stateless
@LocalBean
@Path("/country")
public class ControllerCountry {

    @Inject
    private CountryService service;

    @GET
    @Produces("text/json")
    public List<CountryDTO> getAll(){
        return service.getAll();
    }
}
