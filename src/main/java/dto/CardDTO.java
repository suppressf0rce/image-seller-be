package dto;

public class CardDTO extends AbstractDTO{

    //Content//
    //----------------------------------------------------------------------------------------------------------------//
    private UserDTO user;
    private String number;


    //Getters & Setters
    //----------------------------------------------------------------------------------------------------------------//
    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

}
