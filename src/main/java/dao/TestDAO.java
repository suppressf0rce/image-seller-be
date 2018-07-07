package dao;

import model.Test;

import java.sql.SQLException;
import java.util.List;

public interface TestDAO extends AbstractDAO<Test> {

    List<Test> getReviewed() throws SQLException;
    List<Test> getUnrivewed() throws SQLException;

    Test getPendingById(int id) throws SQLException;

}
