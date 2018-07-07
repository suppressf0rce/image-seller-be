package service;

import dto.ImageDTO;
import dto.TestDTO;
import model.Test;
import model.User;

import javax.ws.rs.core.Response;
import java.util.List;

public interface TestService extends Service<Test, TestDTO>{

    List<TestDTO> getReviewedTests(User authUser);
    List<TestDTO> getUnreviewedTests(User authUser);

    TestDTO updateTest(TestDTO test, User authUser);
    Response addTest(List<ImageDTO> images, User authUser);

    boolean checkIfCanDoTest(User authUser);
}
