package service.impl;

import dao.CategoryDAO;
import dto.CategoryDTO;
import dto.CountryDTO;
import model.Category;
import model.Country;
import model.User;
import security.AuthUtils;
import service.CategoryService;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.NotAuthorizedException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Dependent
public class CategoryServiceImpl implements CategoryService {

    @Inject
    private CategoryDAO categoryDAO;

    @Override
    public CategoryDTO add(CategoryDTO object, User authUser) {
        try {

            if(!AuthUtils.checkIfAdmin(authUser))
                throw new NotAuthorizedException("Permission Denied");

            object.setId(categoryDAO.add(convertToEntity(object, Category.class)));
            return object;
        } catch (SQLException e) {
            throw new BadRequestException(e.getMessage());
        }
    }

    @Override
    public CategoryDTO removeById(int id, User authUser) {
        try {

            if(!AuthUtils.checkIfAdmin(authUser))
                throw new NotAuthorizedException("Permission Denied");

            categoryDAO.removeById(id);
            CategoryDTO dto = new CategoryDTO();
            dto.setId(id);
            return dto;
        } catch (SQLException e) {
            throw new BadRequestException(e.getMessage());
        }
    }

    @Override
    public CategoryDTO update(CategoryDTO object, User authUser) {
        try {

            if(!AuthUtils.checkIfAdmin(authUser))
                throw new NotAuthorizedException("Permission Denied");

            categoryDAO.update(convertToEntity(object, Category.class));
            return object;
        } catch (SQLException e) {
            throw new BadRequestException(e.getMessage());
        }
    }

    @Override
    public List<CategoryDTO> getAll() {
        try {
            List<Category> categories = categoryDAO.getAll();
            List<CategoryDTO> dtos = new ArrayList<>();
            for(Category category: categories)
                dtos.add(convertToDTO(category,CategoryDTO.class));
            return dtos;
        } catch (SQLException e) {
            throw new BadRequestException(e.getMessage());
        }
    }

    @Override
    public CategoryDTO getById(int id) {
        try {
            Category category =categoryDAO.getById(id);
            return convertToDTO(category, CategoryDTO.class);
        } catch (SQLException e) {
            throw new BadRequestException(e.getMessage());
        }
    }
}
