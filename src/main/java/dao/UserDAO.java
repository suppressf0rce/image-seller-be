package dao;

import model.Permission;
import model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO extends AbstractDAO<User>{

    User findByUsername(String username) throws SQLException;
    User findByEmail(String email) throws SQLException;
    List<User> getAllAdmins() throws SQLException;
    List<User> getAllOperators() throws SQLException;
    List<User> getAllBuyers() throws SQLException;

    void assignPermission(int permId, int userId) throws SQLException;
}
