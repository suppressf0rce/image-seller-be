package controllers;

import dto.ImageDTO;
import service.ImageService;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.List;

@Stateless
@LocalBean
@Produces("application/json")
@Path("/images")
public class ControllerImages {

    @Inject
    private ImageService imageService;

    @GET
    @Path("/{id}")
    public List<ImageDTO> getImagesForUser(@PathParam("id") int id){
        return imageService.getAllForUser(id);
    }

}
