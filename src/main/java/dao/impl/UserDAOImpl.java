package dao.impl;

import dao.CountryDAO;
import dao.UserDAO;
import model.User;
import utils.Database;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("Duplicates")
@Dependent
public class UserDAOImpl implements UserDAO {


    //SQL//
    private static final String INSERT_SQL      = "INSERT INTO users(country_id, username, password, email, rating, password_change, blocked, suspended) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String REMOVE_SQL      = "DELETE FROM users WHERE id = ?";
    private static final String UPDATE_SQL      = "UPDATE users SET country_id = ?, username = ?, password = ?, email = ?, rating = ?, password_change = ?, blocked = ?, suspended = ? WHERE id = ?";
    private static final String GET_BY_ID_SQL   = "SELECT * FROM users WHERE id = ?";
    private static final String GET_ALL_SQL     = "SELECT * FROM users";

    @Inject
    private CountryDAO countryDAO;

    @Override
    public void add(User object) throws SQLException{
        Connection connection = Database.getConnection();
        PreparedStatement ps = connection.prepareStatement(INSERT_SQL);
        ps.setInt(1, object.getCountry().getId());
        ps.setString(2, object.getUsername());
        ps.setString(3, object.getPassword());
        ps.setString(4, object.getEmail());
        ps.setDouble(5, object.getRating());
        ps.setBoolean(6, object.isPasswordChange());
        ps.setBoolean(7,object.isBlocked());
        ps.setBoolean(8,object.isSuspended());
        ps.execute();
        connection.close();
    }

    @Override
    public void removeById(int id) throws SQLException{
        Connection connection = Database.getConnection();
        PreparedStatement ps = connection.prepareStatement(REMOVE_SQL);
        ps.setInt(1, id);
        ps.execute();
        connection.close();
    }

    @Override
    public void update(User object) throws SQLException{
        Connection connection = Database.getConnection();
        PreparedStatement ps = connection.prepareStatement(UPDATE_SQL);
        ps.setInt(1, object.getCountry().getId());
        ps.setString(2, object.getUsername());
        ps.setString(3, object.getPassword());
        ps.setString(4, object.getEmail());
        ps.setDouble(5, object.getRating());
        ps.setBoolean(6, object.isPasswordChange());
        ps.setBoolean(7,object.isBlocked());
        ps.setBoolean(8,object.isSuspended());
        ps.setInt(9, object.getId());
        ps.execute();
        connection.close();
    }

    @Override
    public List<User> getAll() throws SQLException{
        Connection connection = Database.getConnection();
        PreparedStatement ps = connection.prepareStatement(GET_ALL_SQL);
        ResultSet rs = ps.executeQuery();
        List<User> users = getUsersFromResultSet(rs);
        connection.close();

        return users;
    }

    @Override
    public User getById(int id) throws SQLException{
        Connection connection = Database.getConnection();
        PreparedStatement ps = connection.prepareStatement(GET_BY_ID_SQL);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        rs.next();
        User user = getUserFromResultSet(rs);
        connection.close();

        return user;
    }

    private User getUserFromResultSet(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password"));
        user.setEmail(rs.getString("email"));
        user.setCountry(countryDAO.getById(rs.getInt("country_id")));
        //TODO:Write Permission dao
        //user.setTypes();
        user.setRating(rs.getDouble("rating"));
        user.setPasswordChange(rs.getBoolean("password_change"));
        user.setBlocked(rs.getBoolean("blocked"));
        user.setSuspended(rs.getBoolean("suspended"));

        return user;
    }

    private List<User> getUsersFromResultSet(ResultSet rs) throws SQLException{
        List<User> users = new ArrayList<User>();
        while(rs.next()){
            users.add(getUserFromResultSet(rs));
        }

        return users;
    }
}
