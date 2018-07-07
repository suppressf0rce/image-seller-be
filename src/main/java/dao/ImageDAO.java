package dao;

import model.Image;

import java.sql.SQLException;
import java.util.List;

public interface ImageDAO extends AbstractDAO<Image> {

    List<Image> getAllForTest(int id) throws SQLException;

}
