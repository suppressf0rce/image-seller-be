package service;

import dto.UserDTO;
import model.User;

import javax.ws.rs.core.Response;
import java.util.List;

public interface UserService extends Service<User, UserDTO> {

    Response login(UserDTO user);
    Response register(UserDTO user);
    Response activate(String id);

    List<UserDTO> getAllAdmins();
    List<UserDTO> getAllOperators();
    List<UserDTO> getAllBuyers();

    UserDTO removeAdmin(UserDTO admin, User authUser);
}
