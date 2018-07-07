package dto;

import model.Category;
import model.ImageResolution;
import model.Test;
import model.User;

import java.util.Date;
import java.util.List;

public class ImageDTO extends AbstractDTO {

    //Variables
    //----------------------------------------------------------------------------------------------------------------//
    private String name;
    private CategoryDTO category;
    private String description;
    private String image;
    private Double price;
    private String keywords;
    private String place;
    private Test test;
    private User owner;
    private Date publishDate;
    private int numberOfSales;
    private double rating;
    private int numberOfRates;
    private int rateCount;
    private String status;
    private List<ImageResolutionDTO> resolutionList;


    //Getters & Setters
    //----------------------------------------------------------------------------------------------------------------/
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoryDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryDTO category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public int getNumberOfSales() {
        return numberOfSales;
    }

    public void setNumberOfSales(int numberOfSales) {
        this.numberOfSales = numberOfSales;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getNumberOfRates() {
        return numberOfRates;
    }

    public void setNumberOfRates(int numberOfRates) {
        this.numberOfRates = numberOfRates;
    }

    public int getRateCount() {
        return rateCount;
    }

    public void setRateCount(int rateCount) {
        this.rateCount = rateCount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ImageResolutionDTO> getResolutionList() {
        return resolutionList;
    }

    public void setResolutionList(List<ImageResolutionDTO> resolutionList) {
        this.resolutionList = resolutionList;
    }
}
