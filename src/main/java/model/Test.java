package model;

public class Test extends Entity{

    //Content//
    //----------------------------------------------------------------------------------------------------------------//
    private User user;
    private String status;

    //Getters & Setters
    //----------------------------------------------------------------------------------------------------------------//
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
