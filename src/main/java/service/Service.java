package service;

import dto.AbstractDTO;
import model.Entity;
import org.modelmapper.ModelMapper;

import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.List;

public interface Service<S extends Entity,T extends AbstractDTO> {
    T add(T object);
    T removeById(int id);
    T update(T object);
    List<T> getAll();
    T getById(int id);

    default T convertToDTO(S entity, Class<T> clazz){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(entity, clazz);
    }

    default S convertToEntity(T object, Class<S> clazz){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(object, clazz);
    }
}

