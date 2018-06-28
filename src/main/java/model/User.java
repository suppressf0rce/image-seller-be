package model;

import java.util.ArrayList;

public class User {

    //Content//
    //----------------------------------------------------------------------------------------------------------------//
    private int id;
    private String username;
    private String password;
    private String email;
    private Country country;
    private double rating;
    private boolean passwordChange;
    private boolean blocked;
    private boolean suspended;
    private ArrayList<Permission> types;


    //Getters & Setters //
    //----------------------------------------------------------------------------------------------------------------//
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public boolean isPasswordChange() {
        return passwordChange;
    }

    public void setPasswordChange(boolean passwordChange) {
        this.passwordChange = passwordChange;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public boolean isSuspended() {
        return suspended;
    }

    public void setSuspended(boolean suspended) {
        this.suspended = suspended;
    }

    public ArrayList<Permission> getTypes() {
        return types;
    }

    public void setTypes(ArrayList<Permission> types) {
        this.types = types;
    }
}
