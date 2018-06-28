package model;

public class ImageResolution extends Entity{

    //Content//
    //----------------------------------------------------------------------------------------------------------------//
    private Resolution resolution;
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
}
