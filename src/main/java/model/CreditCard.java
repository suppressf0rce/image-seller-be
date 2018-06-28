package model;

public class CreditCard extends Entity{

    //Content//
    //----------------------------------------------------------------------------------------------------------------//
    private User user;
    private String number;


    //Getters & Setters
    //----------------------------------------------------------------------------------------------------------------//
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
