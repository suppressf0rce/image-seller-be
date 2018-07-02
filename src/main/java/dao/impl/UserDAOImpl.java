package dao.impl;

import dao.CountryDAO;
import dao.UserDAO;
import model.Permission;
import model.User;
import utils.Database;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import java.lang.reflect.Type;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("Duplicates")
@Dependent
public class UserDAOImpl implements UserDAO {


    //SQL//
    private static final String INSERT_SQL      = "INSERT INTO users(country_id, username, password, email, rating, password_change, blocked, suspended, activated) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String REMOVE_SQL      = "DELETE FROM users WHERE id = ?";
    private static final String UPDATE_SQL      = "UPDATE users SET country_id = ?, username = ?, password = ?, email = ?, rating = ?, password_change = ?, blocked = ?, suspended = ?, activated = ? WHERE id = ?";
    private static final String GET_BY_ID_SQL   = "SELECT * FROM users WHERE id = ?";
    private static final String GET_BY_USERNAME = "SELECT * FROM users WHERE username = ?";
    private static final String GET_ALL_SQL     = "SELECT users.id, permission_id, users.country_id, users.username, users.password, users.email, users.rating,users.password_change,users.blocked,users.suspended,users.activated " +
                                                  "FROM user_types " +
                                                  "RIGHT JOIN users ON user_id = users.id WHERE permission_id = ?";
    private static final String GET_USERS_SQL   = "SELECT users.id, permission_id, users.country_id, users.username, users.password, users.email, users.rating,users.password_change,users.blocked,users.suspended,users.activated " +
                                                  "FROM user_types " +
                                                   "RIGHT JOIN users ON user_id = users.id WHERE permission_id IS NULL";
    private static final String GET_PERMISSIONS = "SELECT user_types.user_id, user_types.permission_id, permissions.description FROM user_types INNER JOIN permissions ON user_types.permission_id=permissions.id WHERE user_id = ?";

    @Inject
    private CountryDAO countryDAO;

    @Override
    public int add(User object) throws SQLException{
        Connection connection = Database.getConnection();
        PreparedStatement ps = connection.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS);
        if(object.getCountry() == null)
            ps.setNull(1,Types.INTEGER);
        else
            ps.setInt(1, object.getCountry().getId());
        ps.setString(2, object.getUsername());
        ps.setString(3, object.getPassword());
        ps.setString(4, object.getEmail());
        ps.setDouble(5, object.getRating());
        ps.setBoolean(6, object.isPasswordChange());
        ps.setBoolean(7,object.isBlocked());
        ps.setBoolean(8,object.isSuspended());
        ps.setBoolean(9, object.isActivated());
        ps.execute();

        int result = 0;
        ResultSet rs = ps.getGeneratedKeys();
        if(rs.next())
            result = rs.getInt(1);

        connection.close();

        return result;
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
        if(object.getCountry() == null)
            ps.setNull(1,Types.INTEGER);
        else
            ps.setInt(1, object.getCountry().getId());
        ps.setString(2, object.getUsername());
        ps.setString(3, object.getPassword());
        ps.setString(4, object.getEmail());
        ps.setDouble(5, object.getRating());
        ps.setBoolean(6, object.isPasswordChange());
        ps.setBoolean(7,object.isBlocked());
        ps.setBoolean(8,object.isSuspended());
        ps.setBoolean(9, object.isActivated());
        ps.setInt(10, object.getId());
        ps.execute();
        connection.close();
    }

    @Override
    public List<User> getAll() throws SQLException{
        Connection connection = Database.getConnection();
        PreparedStatement ps = connection.prepareStatement(GET_USERS_SQL);
        ResultSet rs = ps.executeQuery();
        List<User> users = getUsersFromResultSet(rs);
        connection.close();

        return users;
    }

    @Override
    public List<User> getAllAdmins() throws SQLException {
        Connection connection = Database.getConnection();
        PreparedStatement ps = connection.prepareStatement(GET_ALL_SQL);
        ps.setInt(1, 1);
        ResultSet rs = ps.executeQuery();
        List<User> users = getUsersFromResultSet(rs);
        connection.close();

        return users;
    }

    @Override
    public List<User> getAllOperators() throws SQLException {
        Connection connection = Database.getConnection();
        PreparedStatement ps = connection.prepareStatement(GET_ALL_SQL);
        ps.setInt(1, 2);
        ResultSet rs = ps.executeQuery();
        List<User> users = getUsersFromResultSet(rs);
        connection.close();

        return users;
    }

    @Override
    public List<User> getAllBuyers() throws SQLException {
        Connection connection = Database.getConnection();
        PreparedStatement ps = connection.prepareStatement(GET_ALL_SQL);
        ps.setInt(1, 3);
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
        User user = null;

        if(rs.next())
            user = getUserFromResultSet(rs);

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
        user.setTypes(getUserPermissions(user.getId()));
        user.setRating(rs.getDouble("rating"));
        user.setPasswordChange(rs.getBoolean("password_change"));
        user.setBlocked(rs.getBoolean("blocked"));
        user.setSuspended(rs.getBoolean("suspended"));
        user.setActivated(rs.getBoolean("activated"));

        return user;
    }

    private List<User> getUsersFromResultSet(ResultSet rs) throws SQLException{
        List<User> users = new ArrayList<User>();
        while(rs.next()){
            users.add(getUserFromResultSet(rs));
        }

        return users;
    }

    private List<Permission> getUserPermissions(int userID) throws SQLException{
        Connection connection = Database.getConnection();
        PreparedStatement ps = connection.prepareStatement(GET_PERMISSIONS);
        ps.setInt(1, userID);
        ResultSet rs = ps.executeQuery();
        List<Permission> permissions = new ArrayList<>();

        while(rs.next()){
            Permission permission = new Permission();
            permission.setId(rs.getInt("permission_id"));
            permission.setDescription(rs.getString("description"));
            permissions.add(permission);
        }

        connection.close();

        return permissions;
    }

    @Override
    public User findByUsername(String username) throws SQLException{
        Connection connection = Database.getConnection();
        PreparedStatement ps = connection.prepareStatement(GET_BY_USERNAME);
        ps.setString(1, username);
        ResultSet rs = ps.executeQuery();
        User user = null;

        if(rs.next())
            user = getUserFromResultSet(rs);

        connection.close();

        return user;
    }
}
