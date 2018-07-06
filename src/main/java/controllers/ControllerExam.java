package controllers;

import dto.TestResponseDTO;
import model.User;
import security.AuthenticatedUser;
import security.Secured;
import service.TestResponseService;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
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
    private TestResponseService responseService;

    @GET
    @Path("/reviewed")
    @Secured
    public List<TestResponseDTO> getReviewedExams(){
        return responseService.getReviewedTests(authUser);
    }


    @GET
    @Path("/unreviewed")
    @Secured
    public List<TestResponseDTO> getUnreviewedExams(){
        return responseService.getUnreviewedTests(authUser);
    }

    @PUT
    @Secured
    @Consumes("application/json")
    public TestResponseDTO updateTest(TestResponseDTO test){
        return responseService.updateTest(test, authUser);
    }

    //TODO: Write request tests
}
