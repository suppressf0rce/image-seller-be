package service;

import dto.ImageDTO;
import model.Image;

import java.util.List;

public interface ImageService extends Service<Image, ImageDTO> {

    List<ImageDTO> getAllForUser(int id);

}
