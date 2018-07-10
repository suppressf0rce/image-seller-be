package service.impl;

import dao.ImageDAO;
import dao.ResolutionDAO;
import dto.ImageDTO;
import model.Image;
import model.Resolution;
import model.User;
import service.ImageService;
import service.ImageStorageService;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.ws.rs.BadRequestException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Dependent
public class ImageServiceImpl implements ImageService {

    @Inject
    private ImageDAO imageDAO;

    @Inject
    private ImageStorageService imageStorageService;

    @Inject
    private ResolutionDAO resolutionDAO;

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


    @Override
    public List<ImageDTO> getAllForUser(int id) {
        try{
            List<Image> images = imageDAO.getAllForUser(id);
            List<ImageDTO> imagesDTO = new ArrayList<>();
            Resolution resolution = resolutionDAO.getDefault();
            for(Image image: images){
                ImageDTO imageDTO = convertToDTO(image, ImageDTO.class);

                //TODO: migrate this so it will save images as server resource so it won't be needed to encode image every time

                imageDTO.setImage("data:image/png;base64,"+imageStorageService.loadForResolution(image, resolution, true));
                imagesDTO.add(imageDTO);
            }
           return imagesDTO;
        } catch (SQLException e) {
            throw new BadRequestException(e.getMessage());
        }
    }
}
