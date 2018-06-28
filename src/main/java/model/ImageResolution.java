package model;

public class ImageResolution {

    //Content//
    //----------------------------------------------------------------------------------------------------------------//
    private int id;
    private Resolution resolution;
    private String link;
    private double price;

    //Getters & Setters//
    //----------------------------------------------------------------------------------------------------------------//
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
