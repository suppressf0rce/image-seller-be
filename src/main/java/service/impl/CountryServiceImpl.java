package service.impl;

import dao.CountryDAO;
import dto.CountryDTO;
import model.Country;
import service.CountryService;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.ws.rs.BadRequestException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Dependent
public class CountryServiceImpl implements CountryService {

    @Inject
    private CountryDAO countryDao;


    @Override
    public CountryDTO add(CountryDTO object) {
        try {
            countryDao.add(convertToEntity(object, Country.class));
            return object;
        } catch (SQLException e) {
            throw new BadRequestException(e.getMessage());
        }
    }

    @Override
    public CountryDTO removeById(int id) {
        try {
            countryDao.removeById(id);
            CountryDTO dto = new CountryDTO();
            dto.setId(id);
            return dto;
        } catch (SQLException e) {
            throw new BadRequestException(e.getMessage());
        }
    }

    @Override
    public CountryDTO update(CountryDTO object) {
        try {
            countryDao.update(convertToEntity(object, Country.class));
            return object;
        } catch (SQLException e) {
            throw new BadRequestException(e.getMessage());
        }
    }

    @Override
    public List<CountryDTO> getAll() {
        try {
            List<Country> countries = countryDao.getAll();
            List<CountryDTO> dtos = new ArrayList<>();
            for(Country country: countries)
                dtos.add(convertToDTO(country,CountryDTO.class));
            return dtos;
        } catch (SQLException e) {
            throw new BadRequestException(e.getMessage());
        }
    }

    @Override
    public CountryDTO getById(int id) {
        try {
            Country country =countryDao.getById(id);
            return convertToDTO(country, CountryDTO.class);
        } catch (SQLException e) {
            throw new BadRequestException(e.getMessage());
        }
    }
}
