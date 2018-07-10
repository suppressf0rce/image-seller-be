package dao;

import model.Resolution;

import java.sql.SQLException;

public interface ResolutionDAO extends AbstractDAO<Resolution> {

    Resolution getDefault() throws SQLException;

}
