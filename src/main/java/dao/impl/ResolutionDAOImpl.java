package dao.impl;

import dao.ResolutionDAO;
import model.Resolution;
import utils.Database;

import javax.enterprise.context.Dependent;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Dependent
public class ResolutionDAOImpl implements ResolutionDAO {

    //SQL//
    private static final String INSERT_SQL      = "INSERT INTO resolution(description, width, height, max_price, min_price, is_default) VALUES(?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_SQL      = "UPDATE resolution SET description = ?, width = ?, height = ?, max_price = ?, min_price = ?, is_default = ? WHERE id = ?";
    private static final String REMOVE_SQL      = "DELETE FROM resolution WHERE id = ?";
    private static final String GET_ALL_SQL     = "SELECT * FROM resolution";
    private static final String GET_BY_ID_SQL   = "SELECT * FROM resolution WHERE id = ?";
    private static final String GET_DEFAULT_SQL = "SELECT * FROM resolution WHERE is_default = 1";


    @Override
    public int add(Resolution object) throws SQLException {
        Connection connection = Database.getConnection();
        PreparedStatement ps = connection.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, object.getDescription());
        ps.setInt(2, object.getWidth());
        ps.setInt(3, object.getHeight());
        ps.setDouble(4, object.getMaxPrice());
        ps.setDouble(5, object.getMinPrice());
        ps.setBoolean(6, object.isDefault());
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
    public void update(Resolution object) throws SQLException {
        Connection connection = Database.getConnection();
        PreparedStatement ps = connection.prepareStatement(UPDATE_SQL);
        ps.setString(1, object.getDescription());
        ps.setInt(2, object.getWidth());
        ps.setInt(3, object.getHeight());
        ps.setDouble(4, object.getMaxPrice());
        ps.setDouble(5, object.getMinPrice());
        ps.setBoolean(6, object.isDefault());
        ps.setInt(7, object.getId());
        ps.execute();
        connection.close();
    }

    @Override
    public List<Resolution> getAll() throws SQLException {
        Connection connection = Database.getConnection();
        PreparedStatement ps = connection.prepareStatement(GET_ALL_SQL);
        ResultSet rs = ps.executeQuery();
        List<Resolution> resolutions = getResolutionsFromResultSet(rs);
        connection.close();

        return resolutions;
    }

    @Override
    public Resolution getById(int id) throws SQLException {
        Connection connection = Database.getConnection();
        PreparedStatement ps = connection.prepareStatement(GET_BY_ID_SQL);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        Resolution resolution = null;
        if(rs.next())
            resolution = getResolutionFromResultSet(rs);

        connection.close();

        return resolution;
    }

    @Override
    public Resolution getDefault() throws SQLException {
        Connection connection = Database.getConnection();
        PreparedStatement ps = connection.prepareStatement(GET_DEFAULT_SQL);
        ResultSet rs = ps.executeQuery();

        Resolution resolution = null;
        if(rs.next())
            resolution = getResolutionFromResultSet(rs);

        connection.close();

        return resolution;
    }

    private Resolution getResolutionFromResultSet(ResultSet rs) throws SQLException {
        Resolution resolution = new Resolution();
        resolution.setId(rs.getInt("id"));
        resolution.setDescription(rs.getString("description"));
        resolution.setWidth(rs.getInt("width"));
        resolution.setHeight(rs.getInt("height"));
        resolution.setMaxPrice(rs.getDouble("max_price"));
        resolution.setMinPrice(rs.getDouble("min_price"));
        resolution.setDefault(rs.getBoolean("is_default"));
        return resolution;
    }

    private List<Resolution> getResolutionsFromResultSet(ResultSet rs) throws SQLException{
        List<Resolution> resolutions = new ArrayList<>();
        while(rs.next()){
            resolutions.add(getResolutionFromResultSet(rs));
        }
        return resolutions;
    }

}
