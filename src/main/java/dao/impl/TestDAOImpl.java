package dao.impl;

import dao.TestDAO;
import dao.UserDAO;
import model.Country;
import model.Test;
import utils.Database;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("Duplicates")
@Dependent
public class TestDAOImpl implements TestDAO {

    @Inject
    private UserDAO userDAO;

    //SQL//
    private static final String INSERT_SQL      = "INSERT INTO tests(user_id, status) VALUES(?, ?)";
    private static final String UPDATE_SQL      = "UPDATE tests SET user_id = ?, status = ? WHERE id = ?";
    private static final String REMOVE_SQL      = "DELETE FROM tests WHERE id = ?";
    private static final String GET_ALL_SQL     = "SELECT * FROM tests";
    private static final String GET_BY_ID_SQL   = "SELECT * FROM tests WHERE id = ?";

    @Override
    public int add(Test object) throws SQLException {
        Connection connection = Database.getConnection();
        PreparedStatement ps = connection.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, object.getUser().getId());
        ps.setString(2, object.getStatus());
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
    public void update(Test object) throws SQLException {
        Connection connection = Database.getConnection();
        PreparedStatement ps = connection.prepareStatement(UPDATE_SQL);
        ps.setInt(1, object.getUser().getId());
        ps.setString(2, object.getStatus());
        ps.setInt(3, object.getId());
        ps.execute();
        connection.close();
    }

    @Override
    public List<Test> getAll() throws SQLException {
        Connection connection = Database.getConnection();
        PreparedStatement ps = connection.prepareStatement(GET_ALL_SQL);
        ResultSet rs = ps.executeQuery();
        List<Test> tests = getTestsFromResultSet(rs);
        connection.close();

        return tests;
    }

    @Override
    public Test getById(int id) throws SQLException {
        Connection connection = Database.getConnection();
        PreparedStatement ps = connection.prepareStatement(GET_BY_ID_SQL);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        Test test = null;
        if(rs.next())
            test = getTestFromResultSet(rs);

        connection.close();

        return test;
    }


    private Test getTestFromResultSet(ResultSet rs) throws SQLException {
        Test test = new Test();
        test.setId(rs.getInt("id"));
        test.setStatus(rs.getString("status"));
        test.setUser(userDAO.getById(rs.getInt("user_id")));
        return test;
    }

    private List<Test> getTestsFromResultSet(ResultSet rs) throws SQLException{
        List<Test> tests = new ArrayList<>();
        while(rs.next()){
            tests.add(getTestFromResultSet(rs));
        }
        return tests;
    }
}
