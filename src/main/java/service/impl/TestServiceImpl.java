package service.impl;

import dao.ImageDAO;
import dao.TestDAO;
import dao.UserDAO;
import dto.ImageDTO;
import dto.TestDTO;
import dto.UserDTO;
import model.Category;
import model.Image;
import model.Test;
import model.User;
import security.AuthUtils;
import service.*;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Dependent
public class TestServiceImpl implements TestService {

    @Inject
    private TestDAO testDAO;

    @Inject
    private UserDAO userDAO;

    @Inject
    private ImageDAO imageDAO;

    @Inject
    private CategoryService categoryService;

    @Inject
    private ImageStorageService imageStorageService;

    @Inject
    private UserService userService;

    @Inject
    private ImageService imageService;

    @Override
    public List<TestDTO> getReviewedTests(User authUser) {
        if (!AuthUtils.checkIfOperator(authUser))
            throw new NotAuthorizedException("");

        List<TestDTO> dtoList = new ArrayList<>();

        try {
            for (Test test : testDAO.getReviewed()){
                TestDTO dto = convertToDTO(test, TestDTO.class);
                dto.setUserDTO(userService.convertToDTO(test.getUser(), UserDTO.class));
                dtoList.add(dto);
            }
        } catch (SQLException e) {
            throw new BadRequestException();
        }

        return dtoList;
    }

    @Override
    public List<TestDTO> getUnreviewedTests(User authUser) {
        if (!AuthUtils.checkIfOperator(authUser))
            throw new NotAuthorizedException("");

        List<TestDTO> dtoList = new ArrayList<>();

        try {
            for (Test test : testDAO.getUnrivewed()){
                TestDTO dto = convertToDTO(test, TestDTO.class);
                dto.setUserDTO(userService.convertToDTO(test.getUser(), UserDTO.class));
                dtoList.add(dto);
            }
        } catch (SQLException e) {
            throw new BadRequestException();
        }

        return dtoList;
    }

    @Override
    public TestDTO updateTest(TestDTO test, User authUser) {

        if (!AuthUtils.checkIfOperator(authUser) || !AuthUtils.checkIfAdmin(authUser))
            throw new NotAuthorizedException("");

        if (test.getUserDTO() == null)
            throw new BadRequestException("User of test is null");

        Test testEntity = convertToEntity(test, Test.class);
        try {
            User user = userDAO.getById(test.getUserDTO().getId());
            if (user == null)
                throw new BadRequestException("User with that id not found");

            testEntity.setUser(user);
            testDAO.update(testEntity);
            return test;

        } catch (SQLException e) {
            throw new BadRequestException(e.getMessage());
        }
    }

    @Override
    public Response addTest(List<ImageDTO> images, User authUser) {

        if (!AuthUtils.checkIfUser(authUser))
            throw new NotAuthorizedException("");

        if(!checkIfCanDoTest(authUser))
            throw new BadRequestException("");

        Test test = new Test();
        test.setStatus("PENDING");
        test.setUser(authUser);

        try {
            test.setId(testDAO.add(test));

            for(ImageDTO image: images){
                Image imageEntity = new Image();
                imageEntity.setCategory(categoryService.convertToEntity(image.getCategory(), Category.class));
                imageEntity.setOwner(authUser);
                imageEntity.setDescription(image.getDescription());
                imageEntity.setName(image.getName());
                imageEntity.setPublishDate(new Date());
                imageEntity.setTest(test);

                imageEntity.setId(imageDAO.add(imageEntity));
                imageStorageService.store(image.getImage(), image, imageEntity);
            }
        } catch (SQLException e) {
            throw new BadRequestException(e.getMessage());
        }

        return null;
    }

    @Override
    public boolean checkIfCanDoTest(User authUser) {
        try {
            if (testDAO.getPendingById(authUser.getId()) == null)
                return true;
            else
                return false;
        } catch (SQLException e) {
            throw new BadRequestException(e.getMessage());
        }
    }

    @Override
    public TestDTO add(TestDTO object, User authUser) {
        //TODO: It's raining outside, leave me be!
        return null;
    }

    @Override
    public TestDTO removeById(int id, User authUser) {
        //TODO: It's raining outside, leave me be!
        return null;
    }

    @Override
    public TestDTO update(TestDTO object, User authUser) {
        //TODO: It's raining outside, leave me be!
        return null;
    }

    @Override
    public List<TestDTO> getAll() {
        //TODO: It's raining outside, leave me be!
        return null;
    }

    @Override
    public TestDTO getById(int id) {
        try {
            Test test = testDAO.getById(id);
            TestDTO dto = convertToDTO(test, TestDTO.class);
            dto.setUserDTO(userService.convertToDTO(test.getUser(), UserDTO.class));
            List<Image> images = imageDAO.getAllForTest(test.getId());
            List<ImageDTO> imagesDTO = new ArrayList<>();
            for(Image image: images){
                ImageDTO imageDTO = imageService.convertToDTO(image, ImageDTO.class);

                //TODO: migrate this so it will save images as server resource so it won't be needed to encode image every time

                imageDTO.setImage("data:image/png;base64,"+imageStorageService.loadOriginal(image));
                imagesDTO.add(imageDTO);
            }
            dto.setImages(imagesDTO);
            return dto;
        } catch (SQLException e) {
            throw new BadRequestException(e.getMessage());
        }
    }
}
