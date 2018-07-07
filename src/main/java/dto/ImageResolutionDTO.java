package dto;

import model.Resolution;

public class ImageResolutionDTO extends AbstractDTO {

    //Content//
    //----------------------------------------------------------------------------------------------------------------//
    private Resolution resolution;
    private ImageDTO imageDTO;
    private String link;
    private double price;

    //Getters & Setters//
    //----------------------------------------------------------------------------------------------------------------//
    public Resolution getResolution() {
        return resolution;
    }

    public void setResolution(Resolution resolution) {
        this.resolution = resolution;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ImageDTO getImageDTO() {
        return imageDTO;
    }

    public void setImageDTO(ImageDTO imageDTO) {
        this.imageDTO = imageDTO;
    }
}
