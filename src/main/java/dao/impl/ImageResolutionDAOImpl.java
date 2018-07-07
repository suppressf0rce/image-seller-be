package dao.impl;

import dao.ImageDAO;
import dao.ImageResolutionDAO;
import dao.ResolutionDAO;
import model.ImageResolution;
import utils.Database;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("Duplicates")
@Dependent
public class ImageResolutionDAOImpl implements ImageResolutionDAO {


    //SQL//
    private static final String INSERT_SQL      = "INSERT INTO image_resolutions(res_id, image_id, link, price) VALUES(?, ?, ?, ?)";
    private static final String UPDATE_SQL      = "UPDATE image_resolutions SET res_id = ?, image_id = ?, link = ?, price = ? WHERE id = ?";
    private static final String REMOVE_SQL      = "DELETE FROM image_resolutions WHERE id = ?";
    private static final String GET_ALL_SQL     = "SELECT * FROM image_resolutions";
    private static final String GET_BY_ID_SQL   = "SELECT * FROM image_resolutions WHERE id = ?";

    @Inject
    private ResolutionDAO resolutionDAO;

    @Inject
    private ImageDAO imageDAO;

    @Override
    public int add(ImageResolution object) throws SQLException {
        Connection connection = Database.getConnection();
        PreparedStatement ps = connection.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS);

        if(object.getResolution() == null)
            throw new SQLException();

        if(object.getImage() == null)
            throw new SQLException();

        ps.setInt(1, object.getResolution().getId());
        ps.setInt(2, object.getImage().getId());
        ps.setString(3, object.getLink());
        ps.setDouble(4, object.getPrice());
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
    public void update(ImageResolution object) throws SQLException {
        Connection connection = Database.getConnection();
        PreparedStatement ps = connection.prepareStatement(UPDATE_SQL);
        if(object.getResolution() == null)
            throw new SQLException();

        if(object.getImage() == null)
            throw new SQLException();

        ps.setInt(1, object.getResolution().getId());
        ps.setInt(2, object.getImage().getId());
        ps.setString(3, object.getLink());
        ps.setDouble(4, object.getPrice());
        ps.setInt(5, object.getId());

        ps.execute();
        connection.close();
    }

    @Override
    public List<ImageResolution> getAll() throws SQLException {
        Connection connection = Database.getConnection();
        PreparedStatement ps = connection.prepareStatement(GET_ALL_SQL);
        ResultSet rs = ps.executeQuery();
        List<ImageResolution> imageResolutions = getImageResolutionsFromResultSet(rs);
        connection.close();

        return imageResolutions;
    }

    @Override
    public ImageResolution getById(int id) throws SQLException {
        Connection connection = Database.getConnection();
        PreparedStatement ps = connection.prepareStatement(GET_BY_ID_SQL);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        ImageResolution imageResolution = null;
        if(rs.next())
            imageResolution = getImageResolutionFromResultSet(rs);

        connection.close();

        return imageResolution;
    }

    private ImageResolution getImageResolutionFromResultSet(ResultSet rs) throws SQLException {
        ImageResolution imageResolution = new ImageResolution();
        imageResolution.setId(rs.getInt("id"));
        imageResolution.setImage(imageDAO.getById(rs.getInt("image_id")));
        imageResolution.setResolution(resolutionDAO.getById(rs.getInt("res_id")));
        imageResolution.setLink(rs.getString("link"));
        imageResolution.setPrice(rs.getDouble("price"));
        return imageResolution;
    }

    private List<ImageResolution> getImageResolutionsFromResultSet(ResultSet rs) throws SQLException{
        List<ImageResolution> users = new ArrayList<>();
        while(rs.next()){
            users.add(getImageResolutionFromResultSet(rs));
        }
        return users;
    }
}
