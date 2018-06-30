package service;

import dto.AbstractDTO;
import model.Entity;
import model.User;
import org.modelmapper.ModelMapper;

import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.List;

public interface Service<S extends Entity,T extends AbstractDTO> {
    T add(T object, User authUser);
    T removeById(int id, User authUser);
    T update(T object, User authUser);
    List<T> getAll();
    T getById(int id);

    default T convertToDTO(S entity, Class<T> clazz){
        if(entity == null)
            return null;

        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(entity, clazz);
    }

    default S convertToEntity(T object, Class<S> clazz){
        if(object == null)
            return null;

        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(object, clazz);
    }
}

