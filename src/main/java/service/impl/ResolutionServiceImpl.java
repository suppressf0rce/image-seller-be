package service.impl;

import dao.ResolutionDAO;
import dto.CountryDTO;
import dto.ResolutionDTO;
import model.Country;
import model.Resolution;
import model.User;
import security.AuthUtils;
import service.ResolutionService;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.NotAuthorizedException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Dependent
public class ResolutionServiceImpl implements ResolutionService {

    @Inject
    private ResolutionDAO resolutionDAO;

    @Override
    public ResolutionDTO add(ResolutionDTO object, User authUser) {
        try {

            if(!AuthUtils.checkIfAdmin(authUser))
                throw new NotAuthorizedException("Permission Denied");

            object.setId(resolutionDAO.add(convertToEntity(object, Resolution.class)));
            return object;
        } catch (SQLException e) {
            throw new BadRequestException(e.getMessage());
        }
    }

    @Override
    public ResolutionDTO removeById(int id, User authUser) {
        try {

            if(!AuthUtils.checkIfAdmin(authUser))
                throw new NotAuthorizedException("Permission Denied");

            resolutionDAO.removeById(id);
            ResolutionDTO dto = new ResolutionDTO();
            dto.setId(id);
            return dto;
        } catch (SQLException e) {
            throw new BadRequestException(e.getMessage());
        }
    }

    @Override
    public ResolutionDTO update(ResolutionDTO object, User authUser) {
        try {

            if(!AuthUtils.checkIfAdmin(authUser))
                throw new NotAuthorizedException("Permission Denied");

            resolutionDAO.update(convertToEntity(object, Resolution.class));
            return object;
        } catch (SQLException e) {
            throw new BadRequestException(e.getMessage());
        }
    }

    @Override
    public List<ResolutionDTO> getAll() {
        try {
            List<Resolution> resolutions = resolutionDAO.getAll();
            List<ResolutionDTO> dtos = new ArrayList<>();
            for(Resolution resolution: resolutions)
                dtos.add(convertToDTO(resolution,ResolutionDTO.class));
            return dtos;
        } catch (SQLException e) {
            throw new BadRequestException(e.getMessage());
        }
    }

    @Override
    public ResolutionDTO getById(int id) {
        try {
            Resolution resolution =resolutionDAO.getById(id);
            return convertToDTO(resolution, ResolutionDTO.class);
        } catch (SQLException e) {
            throw new BadRequestException(e.getMessage());
        }
    }
}
