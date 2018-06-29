package dao.impl;

import dao.CountryDAO;
import model.Country;
import utils.Database;

import javax.enterprise.context.Dependent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("Duplicates")
@Dependent
public class CountryDAOImpl implements CountryDAO {

    //SQL//
    private static final String INSERT_SQL      = "INSERT INTO country(iso, name, nicename, iso3, numcode, phonecode) VALUES(?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_SQL      = "UPDATE country SET iso = ?, name = ?, nicename = ?, iso3 = ?, numcode = ?, phonecode = ? WHERE id = ?";
    private static final String REMOVE_SQL      = "DELETE FROM country WHERE id = ?";
    private static final String GET_ALL_SQL     = "SELECT * FROM country";
    private static final String GET_BY_ID_SQL   = "SELECT * FROM country WHERE id = ?";


    @Override
    public void add(Country object) throws SQLException {
        Connection connection = Database.getConnection();
        PreparedStatement ps = connection.prepareStatement(INSERT_SQL);
        ps.setString(1, object.getIso());
        ps.setString(2, object.getName());
        ps.setString(3, object.getNiceName());
        ps.setString(4, object.getIso3());
        ps.setInt(5, object.getNumCode());
        ps.setInt(6, object.getPhoneCode());
        ps.execute();
        connection.close();
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
    public void update(Country object) throws SQLException {
        Connection connection = Database.getConnection();
        PreparedStatement ps = connection.prepareStatement(UPDATE_SQL);
        ps.setString(1, object.getIso());
        ps.setString(2, object.getName());
        ps.setString(3, object.getNiceName());
        ps.setString(4, object.getIso3());
        ps.setInt(5, object.getNumCode());
        ps.setInt(6, object.getPhoneCode());
        ps.setInt(7,object.getId());
        ps.execute();
        connection.close();
    }

    @Override
    public List<Country> getAll() throws SQLException {
        Connection connection = Database.getConnection();
        PreparedStatement ps = connection.prepareStatement(GET_ALL_SQL);
        ResultSet rs = ps.executeQuery();
        List<Country> countries = getCountriesFromResultSet(rs);
        connection.close();

        return countries;
    }

    @Override
    public Country getById(int id) throws SQLException {
        Connection connection = Database.getConnection();
        PreparedStatement ps = connection.prepareStatement(GET_BY_ID_SQL);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        rs.next();
        Country country = getCountryFromResultSet(rs);
        connection.close();

        return country;
    }

    private Country getCountryFromResultSet(ResultSet rs) throws SQLException {
        Country country = new Country();
        country.setId(rs.getInt("id"));
        country.setIso(rs.getString("iso"));
        country.setIso3(rs.getString("iso3"));
        country.setName(rs.getString("name"));
        country.setNiceName(rs.getString("nicename"));
        country.setNumCode(rs.getInt("numcode"));
        country.setPhoneCode(rs.getInt("phonecode"));
        return country;
    }

    private List<Country> getCountriesFromResultSet(ResultSet rs) throws SQLException{
        List<Country> users = new ArrayList<Country>();
        while(rs.next()){
            users.add(getCountryFromResultSet(rs));
        }
        return users;
    }
}
