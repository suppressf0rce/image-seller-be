package service;

import dto.ImageDTO;
import model.Image;

public interface ImageStorageService {

    void store(String image, ImageDTO imageDTO, Image imageInfo);

    String loadOriginal(Image imageInfo);

}
