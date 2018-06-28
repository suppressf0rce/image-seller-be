package model;

public class CreditCard {

    //Content//
    //----------------------------------------------------------------------------------------------------------------//
    private int id;
    private User user;
    private String number;


    //Getters & Setters
    //----------------------------------------------------------------------------------------------------------------//
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
