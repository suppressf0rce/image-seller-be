package dao.impl;

import dao.CardDAO;
import dao.UserDAO;
import model.Country;
import model.CreditCard;
import utils.Database;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("Duplicates")
@Dependent
public class CardDAOImpl implements CardDAO {

    //SQL//
    private static final String INSERT_SQL      = "INSERT INTO credit_cards(user_id, number) VALUES(?, ?)";
    private static final String UPDATE_SQL      = "UPDATE credit_cards SET user_id = ?, number = ? WHERE id = ?";
    private static final String REMOVE_SQL      = "DELETE FROM credit_cards WHERE id = ?";
    private static final String GET_ALL_SQL     = "SELECT * FROM credit_cards";
    private static final String GET_ALL_ID_SQL  = "SELECT * FROM credit_cards WHERE user_id = ?";
    private static final String GET_BY_ID_SQL   = "SELECT * FROM credit_cards WHERE id = ?";

    @Inject
    private UserDAO userDAO;

    @Override
    public int add(CreditCard object) throws SQLException {
        Connection connection = Database.getConnection();
        PreparedStatement ps = connection.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, object.getUser().getId());
        ps.setString(2, object.getNumber());
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
    public void update(CreditCard object) throws SQLException {
        Connection connection = Database.getConnection();
        PreparedStatement ps = connection.prepareStatement(UPDATE_SQL);
        ps.setInt(1, object.getUser().getId());
        ps.setString(2, object.getNumber());
        ps.setInt(3,object.getId());
        ps.execute();
        connection.close();
    }

    @Override
    public List<CreditCard> getAll() throws SQLException {
        Connection connection = Database.getConnection();
        PreparedStatement ps = connection.prepareStatement(GET_ALL_SQL);
        ResultSet rs = ps.executeQuery();
        List<CreditCard> cards = getCardsFromResultSet(rs);
        connection.close();

        return cards;
    }

    @Override
    public List<CreditCard> getAllById(int id) throws SQLException {
        Connection connection = Database.getConnection();
        PreparedStatement ps = connection.prepareStatement(GET_ALL_ID_SQL);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        List<CreditCard> cards = getCardsFromResultSet(rs);
        connection.close();

        return cards;
    }

    @Override
    public CreditCard getById(int id) throws SQLException {
        Connection connection = Database.getConnection();
        PreparedStatement ps = connection.prepareStatement(GET_BY_ID_SQL);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        CreditCard card = null;
        if(rs.next())
            card = getCardFromResultSet(rs);

        connection.close();

        return card;
    }

    private CreditCard getCardFromResultSet(ResultSet rs) throws SQLException {
        CreditCard card = new CreditCard();
        card.setId(rs.getInt("id"));
        card.setNumber(rs.getString("number"));
        card.setUser(userDAO.getById(rs.getInt("user_id")));
        return card;
    }

    private List<CreditCard> getCardsFromResultSet(ResultSet rs) throws SQLException{
        List<CreditCard> cards = new ArrayList<>();
        while(rs.next()){
            cards.add(getCardFromResultSet(rs));
        }
        return cards;
    }
}
