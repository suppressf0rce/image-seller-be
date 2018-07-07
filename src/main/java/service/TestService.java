package service;

import dto.ImageDTO;
import dto.TestResponseDTO;
import model.Test;
import model.User;

import javax.ws.rs.core.Response;
import java.util.List;

public interface TestService extends Service<Test, TestResponseDTO>{

    List<TestResponseDTO> getReviewedTests(User authUser);
    List<TestResponseDTO> getUnreviewedTests(User authUser);

    TestResponseDTO updateTest(TestResponseDTO test, User authUser);
    Response addTest(List<ImageDTO> images, User authUser);

    boolean checkIfCanDoTest(User authUser);
}
