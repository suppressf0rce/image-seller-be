package controllers;

import dto.ImageDTO;
import dto.TestDTO;
import model.User;
import security.AuthenticatedUser;
import security.Secured;
import service.TestService;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Stateless
@LocalBean
@Produces("application/json")
@Path("/exam")
public class ControllerExam {

    @Inject
    @AuthenticatedUser
    private User authUser;

    @Inject
    private TestService responseService;

    @GET
    @Path("/reviewed")
    @Secured
    public List<TestDTO> getReviewedExams(){
        return responseService.getReviewedTests(authUser);
    }


    @GET
    @Path("/unreviewed")
    @Secured
    public List<TestDTO> getUnreviewedExams(){
        return responseService.getUnreviewedTests(authUser);
    }

    @PUT
    @Secured
    @Consumes("application/json")
    public TestDTO updateTest(TestDTO test){
        return responseService.updateTest(test, authUser);
    }

    @POST
    @Secured
    @Consumes("application/json")
    public Response addTest(List<ImageDTO> images){
        return responseService.addTest(images, authUser);
    }

    @GET
    @Path("/{id}")
    @Secured
    public TestDTO getByID(@PathParam("id") int id){
        return responseService.getById(id);
    }

    @GET
    @Secured
    public Response checkIfCanDoTest(){
        if(responseService.checkIfCanDoTest(authUser))
            return Response.ok().build();
        else
            return Response.status(Response.Status.BAD_REQUEST).build();
    }


    @POST
    @Path("/review")
    @Consumes("application/json")
    @Secured
    public Response reviewTest(TestDTO testDTO){
        return responseService.reviewTest(testDTO, authUser);
    }
//    @GET
//    @Secured
//    @Path("/{id}/images")
//    public Lis

    //TODO: Implement test api calls for admin panel one day!
}
