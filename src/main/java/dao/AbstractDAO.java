package dao;

import model.Entity;

import java.sql.SQLException;
import java.util.List;

public interface AbstractDAO<T extends Entity> {
    void add(T object) throws SQLException;
    void removeById(int id) throws SQLException;
    void update(T object) throws SQLException;
    List<T> getAll() throws SQLException;
    T getById(int id) throws SQLException;
}
