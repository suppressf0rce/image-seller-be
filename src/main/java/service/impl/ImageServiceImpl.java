package service.impl;

import dto.ImageDTO;
import model.User;
import service.ImageService;

import javax.enterprise.context.Dependent;
import java.util.List;

@Dependent
public class ImageServiceImpl implements ImageService {
    @Override
    public ImageDTO add(ImageDTO object, User authUser) {
        //TODO: It's raining outside, leave me be!
        return null;
    }

    @Override
    public ImageDTO removeById(int id, User authUser) {
        //TODO: It's raining outside, leave me be!
        return null;
    }

    @Override
    public ImageDTO update(ImageDTO object, User authUser) {
        //TODO: It's raining outside, leave me be!
        return null;
    }

    @Override
    public List<ImageDTO> getAll() {
        //TODO: It's raining outside, leave me be!
        return null;
    }

    @Override
    public ImageDTO getById(int id) {
        //TODO: It's raining outside, leave me be!
        return null;
    }
}
