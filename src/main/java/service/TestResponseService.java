package service;

import dto.TestResponseDTO;
import model.Test;
import model.User;

import java.util.List;

public interface TestResponseService extends Service<Test, TestResponseDTO>{

    List<TestResponseDTO> getReviewedTests(User authUser);
    List<TestResponseDTO> getUnreviewedTests(User authUser);

    TestResponseDTO updateTest(TestResponseDTO test, User authUser);

}
