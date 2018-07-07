package dao.impl;

import dao.CategoryDAO;
import dao.ImageDAO;
import dao.TestDAO;
import dao.UserDAO;
import model.Image;
import utils.Database;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("Duplicates")
@Dependent
public class ImageDAOImpl implements ImageDAO {

    //SQL//
    private static final String INSERT_SQL      = "INSERT INTO image(category_id, test_id, user_id, name, keywords, publish_date, place, description, status) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_SQL      = "UPDATE image SET category_id = ?, test_id = ?, user_id = ?, name = ?, keywords = ?, publish_date = ?, place = ?, description = ?, status = ? WHERE id = ?";
    private static final String REMOVE_SQL      = "DELETE FROM image WHERE id = ?";
    private static final String GET_ALL_SQL     = "SELECT * FROM image";
    private static final String GET_ALL_TEST_SQL= "SELECT * FROM image WHERE test_id = ?";
    private static final String GET_BY_ID_SQL   = "SELECT * FROM image WHERE id = ?";


    @Inject
    private UserDAO userDAO;

    @Inject
    private TestDAO testDAO;

    @Inject
    private CategoryDAO categoryDAO;

    @Override
    public int add(Image object) throws SQLException {
        Connection connection = Database.getConnection();
        PreparedStatement ps = connection.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS);
        if(object.getCategory() == null)
            throw new SQLException();

        ps.setInt(1, object.getCategory().getId());

        if(object.getTest() == null)
            ps.setNull(2, Types.INTEGER);
        else
            ps.setInt(2, object.getTest().getId());

        if(object.getOwner() == null)
            throw new SQLException();

        ps.setInt(3, object.getOwner().getId());
        ps.setString(4, object.getName());
        ps.setString(5, object.getKeywords());
        ps.setLong(6, object.getPublishDate().getTime());
        ps.setString(7, object.getPlace());
        ps.setString(8, object.getDescription());
        ps.setString(9, object.getStatus());

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
    public void update(Image object) throws SQLException {
        Connection connection = Database.getConnection();
        PreparedStatement ps = connection.prepareStatement(UPDATE_SQL);
        if(object.getCategory() == null)
            throw new SQLException();

        ps.setInt(1, object.getCategory().getId());

        if(object.getTest() == null)
            ps.setNull(2, Types.INTEGER);
        else
            ps.setInt(2, object.getTest().getId());

        if(object.getOwner() == null)
            throw new SQLException();

        ps.setInt(3, object.getOwner().getId());
        ps.setString(4, object.getName());
        ps.setString(5, object.getKeywords());
        ps.setLong(6, object.getPublishDate().getTime());
        ps.setString(7, object.getPlace());
        ps.setString(8, object.getDescription());
        ps.setString(9, object.getStatus());
        ps.setInt(10, object.getId());
        ps.execute();

        connection.close();
    }

    @Override
    public List<Image> getAll() throws SQLException {
        Connection connection = Database.getConnection();
        PreparedStatement ps = connection.prepareStatement(GET_ALL_SQL);
        ResultSet rs = ps.executeQuery();
        List<Image> images = getImagesFromResultSet(rs);
        connection.close();

        return images;
    }

    @Override
    public Image getById(int id) throws SQLException {
        Connection connection = Database.getConnection();
        PreparedStatement ps = connection.prepareStatement(GET_BY_ID_SQL);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        Image image = null;
        if(rs.next())
            image = getImageFromResultSet(rs);

        connection.close();

        return image;
    }

    private Image getImageFromResultSet(ResultSet rs) throws SQLException {
        Image image = new Image();
        image.setId(rs.getInt("id"));

        image.setCategory(categoryDAO.getById(rs.getInt("category_id")));
        image.setTest(testDAO.getById(rs.getInt("test_id")));
        image.setOwner(userDAO.getById(rs.getInt("user_id")));

        image.setName(rs.getString("name"));
        image.setKeywords(rs.getString("keywords"));
        image.setPublishDate(new java.util.Date(rs.getLong("publish_date")));

        image.setNumberOfSales(rs.getInt("number_of_sales"));
        image.setRating(rs.getDouble("rating"));
        image.setPlace(rs.getString("place"));
        image.setDescription(rs.getString("description"));
        image.setNumberOfRates(rs.getInt("number_of_rates"));
        image.setRateCount(rs.getInt("rate_count"));
        image.setStatus(rs.getString("status"));

        return image;
    }

    private List<Image> getImagesFromResultSet(ResultSet rs) throws SQLException{
        List<Image> images = new ArrayList<>();
        while(rs.next()){
            images.add(getImageFromResultSet(rs));
        }
        return images;
    }

    @Override
    public List<Image> getAllForTest(int id) throws SQLException {
        Connection connection = Database.getConnection();
        PreparedStatement ps = connection.prepareStatement(GET_ALL_TEST_SQL);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        List<Image> images = getImagesFromResultSet(rs);
        connection.close();

        return images;
    }
}
