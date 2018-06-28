package model;

import java.util.Date;
import java.util.List;

public class Image extends Entity{

    //Content//
    //----------------------------------------------------------------------------------------------------------------//
    private Category category;
    private Test test;
    private User owner;
    private String name;
    private String keywords;
    private Date publishDate;
    private int numberOfSales;
    private double rating;
    private String place;
    private String description;
    private int numberOfRates;
    private int rateCount;
    private String status;
    private List<ImageResolution> resolutionList;

    //Getters & Setters//
    //----------------------------------------------------------------------------------------------------------------//
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
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

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public List<ImageResolution> getResolutionList() {
        return resolutionList;
    }

    public void setResolutionList(List<ImageResolution> resolutionList) {
        this.resolutionList = resolutionList;
    }
}
