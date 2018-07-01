package service;

import dto.UserDTO;
import model.User;

import javax.ws.rs.core.Response;

public interface UserService extends Service<User, UserDTO> {

    Response login(UserDTO user);
    Response register(UserDTO user);
    Response activate(String id);

}