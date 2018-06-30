package dao;

import model.User;

import java.sql.SQLException;

public interface UserDAO extends AbstractDAO<User>{

    User findByUsername(String username) throws SQLException;

}
