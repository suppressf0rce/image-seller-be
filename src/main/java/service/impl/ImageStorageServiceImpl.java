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
import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.ws.rs.BadRequestException;
import java.awt.*;
import java.awt.geom.Rectangle2D;
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

    @Override
    public String loadForResolution(Image imageInfo, Resolution resolution, boolean watermark) {
        String path = Constants.IMAGE_FOLDER + "images/" + imageInfo.getOwner().getUsername() + "/" + imageInfo.getName() + "-" + imageInfo.getPublishDate() + "-"+resolution.getDescription()+".png";
        BufferedImage image = ImageUtils.imageFromFile(path);

        if(watermark){
            // initializes necessary graphic properties
            Graphics2D w = image.createGraphics();
            AlphaComposite alphaChannel = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.4f);
            w.setComposite(alphaChannel);
            w.setColor(Color.GRAY);
            w.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 26));
            FontMetrics fontMetrics = w.getFontMetrics();
            Rectangle2D rect = fontMetrics.getStringBounds(Constants.WATERMARK_TEXT, w);

            // calculate center of the image
            int centerX = (image.getWidth() - (int) rect.getWidth()) / 2;
            int centerY = image.getHeight() / 2;

            // add text overlay to the image
            w.drawString(Constants.WATERMARK_TEXT, centerX, centerY);
            w.dispose();
        }

        return ImageUtils.base64FromImage(image);
    }
}
