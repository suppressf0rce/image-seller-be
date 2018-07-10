package service;

import dto.ImageDTO;
import model.Image;
import model.Resolution;

public interface ImageStorageService {

    void store(String image, ImageDTO imageDTO, Image imageInfo);

    String loadOriginal(Image imageInfo);

    String loadForResolution(Image image, Resolution resolution, boolean watermark);

}
