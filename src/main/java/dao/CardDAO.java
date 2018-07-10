package dao;

import model.CreditCard;

import java.sql.SQLException;
import java.util.List;

public interface CardDAO extends AbstractDAO<CreditCard> {

    List<CreditCard> getAllById(int id) throws SQLException;

}
