package dto;

public class TestResponseDTO extends AbstractDTO{

    //Attributes//
    //----------------------------------------------------------------------------------------------------------------//
    private UserDTO userDTO;
    private String status;


    //Getters & Setters//
    //----------------------------------------------------------------------------------------------------------------//
    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
