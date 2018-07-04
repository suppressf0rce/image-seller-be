package dao.impl;

import dao.CategoryDAO;
import model.Category;
import utils.Database;

import javax.enterprise.context.Dependent;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("Duplicates")
@Dependent
public class CategoryDAOImpl implements CategoryDAO {

    //SQL//
    private static final String INSERT_SQL      = "INSERT INTO category(name) VALUES(?)";
    private static final String UPDATE_SQL      = "UPDATE category SET name = ? WHERE id = ?";
    private static final String REMOVE_SQL      = "DELETE FROM category WHERE id = ?";
    private static final String GET_ALL_SQL     = "SELECT * FROM category ORDER BY id ASC";
    private static final String GET_BY_ID_SQL   = "SELECT * FROM category WHERE id = ?";


    @Override
    public int add(Category object) throws SQLException {
        Connection connection = Database.getConnection();
        PreparedStatement ps = connection.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, object.getName());
        ps.execute();

        ResultSet rs = ps.getGeneratedKeys();
        int result = 0;
        if (rs.next())
            result = rs.getInt(1);

        connection.close();

        return result;
    }

    @Override
    public void removeById(int id) throws SQLException {
        Connection connection = Database.getConnection();
        PreparedStatement ps = connection.prepareStatement(REMOVE_SQL);
        ps.setInt(1, id);
        ps.execute();
        connection.close();
    }

    @Override
    public void update(Category object) throws SQLException {
        Connection connection = Database.getConnection();
        PreparedStatement ps = connection.prepareStatement(UPDATE_SQL);
        ps.setString(1, object.getName());
        ps.setInt(2, object.getId());
        ps.execute();
        connection.close();
    }

    @Override
    public List<Category> getAll() throws SQLException {
        Connection connection = Database.getConnection();
        PreparedStatement ps = connection.prepareStatement(GET_ALL_SQL);
        ResultSet rs = ps.executeQuery();
        List<Category> categories = getCategoriesFromResultSet(rs);
        connection.close();

        return categories;
    }

    @Override
    public Category getById(int id) throws SQLException {
        Connection connection = Database.getConnection();
        PreparedStatement ps = connection.prepareStatement(GET_BY_ID_SQL);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        Category category = null;
        if(rs.next())
            category = getCategoryFromResultSet(rs);

        connection.close();

        return category;
    }

    private Category getCategoryFromResultSet(ResultSet rs) throws SQLException {
        Category category = new Category();
        category.setId(rs.getInt("id"));
        category.setName(rs.getString("name"));
        return category;
    }

    private List<Category> getCategoriesFromResultSet(ResultSet rs) throws SQLException{
        List<Category> users = new ArrayList<Category>();
        while(rs.next()){
            users.add(getCategoryFromResultSet(rs));
        }
        return users;
    }
}
