package service.impl;

import dao.ImageResolutionDAO;
import dao.ResolutionDAO;
import dto.ImageDTO;
import model.Image;
import model.ImageResolution;
import model.Resolution;
import service.ImageStorageService;
import utils.Constants;
import utils.ImageUtils;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.ws.rs.BadRequestException;
import java.awt.image.BufferedImage;
import java.nio.Buffer;
import java.sql.SQLException;
import java.util.List;

@Dependent
public class ImageStorageServiceImpl implements ImageStorageService {

    @Inject
    private ResolutionDAO resolutionDAO;

    @Inject
    private ImageResolutionDAO imageResolutionDAO;


    @Override
    public void store(String image, ImageDTO imageDTO, Image imageInfo) {
        String parts[] = image.split(",");
        String imageString = parts[1];
        String imageType = parts[0];

        if(imageType.contains("png"))
            imageType = "png";

        if(imageType.contains("jpg") || imageType.contains("jpeg"))
            imageType = "png";

        if(imageType.contains("gif"))
            imageType = "gif";

        BufferedImage bufImage = ImageUtils.imageFromBase64(imageString);

        try {
            List<Resolution> availibleResolutions = resolutionDAO.getAll();

            for(Resolution resolution: availibleResolutions){

                if(bufImage.getWidth() > resolution.getWidth() && bufImage.getHeight() > resolution.getHeight()) {

                    String path = Constants.IMAGE_FOLDER + "images/" + imageInfo.getOwner().getUsername() + "/" + imageInfo.getName() + "-" + imageInfo.getPublishDate() + "-" + resolution.getDescription();
                    BufferedImage scaledImage = ImageUtils.resizeImage(bufImage, resolution.getWidth(), resolution.getHeight());

                    ImageUtils.saveImage(scaledImage, path, imageType);

                    ImageResolution imageResolution = new ImageResolution();
                    imageResolution.setLink(path + "." + imageType);
                    if(imageDTO != null && imageDTO.getPrice() != null)
                        imageResolution.setPrice(imageDTO.getPrice());

                    imageResolution.setResolution(resolution);
                    imageResolution.setImage(imageInfo);
                    imageResolutionDAO.add(imageResolution);
                }
            }


            //Save original image
            String path = Constants.IMAGE_FOLDER + "images/" + imageInfo.getOwner().getUsername() + "/" + imageInfo.getName() + "-" + imageInfo.getPublishDate() + "- Original";
            ImageUtils.saveImage(bufImage, path, imageType);

        } catch (SQLException e) {
            throw new BadRequestException();
        }
    }

    @Override
    public String loadOriginal(Image imageInfo) {
        String path = Constants.IMAGE_FOLDER + "images/" + imageInfo.getOwner().getUsername() + "/" + imageInfo.getName() + "-" + imageInfo.getPublishDate() + "- Original.png";
        BufferedImage image = ImageUtils.imageFromFile(path);
        return ImageUtils.base64FromImage(image);
    }
}
