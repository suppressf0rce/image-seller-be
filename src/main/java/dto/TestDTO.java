package dto;

import java.util.List;

public class TestDTO extends AbstractDTO{

    //Attributes//
    //----------------------------------------------------------------------------------------------------------------//
    private UserDTO userDTO;
    private String status;
    private List<ImageDTO> images;


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

    public List<ImageDTO> getImages() {
        return images;
    }

    public void setImages(List<ImageDTO> images) {
        this.images = images;
    }
}
