package service.impl;

import dao.CardDAO;
import dao.UserDAO;
import dto.CardDTO;
import dto.CountryDTO;
import model.Country;
import model.CreditCard;
import model.User;
import security.AuthUtils;
import service.CardService;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.NotAuthorizedException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Dependent
public class CardServiceImpl implements CardService {

    @Inject
    private CardDAO cardDAO;

    @Inject
    private UserDAO userDAO;

    @Override
    public CardDTO add(CardDTO object, User authUser) {
        try {
            CreditCard creditCard = convertToEntity(object, CreditCard.class);
            creditCard.setUser(authUser);
            object.setId(cardDAO.add(creditCard));
            return object;
        } catch (SQLException e) {
            throw new BadRequestException(e.getMessage());
        }
    }

    @Override
    public CardDTO removeById(int id, User authUser) {
        try {

            cardDAO.removeById(id);
            CardDTO dto = new CardDTO();
            dto.setId(id);
            return dto;
        } catch (SQLException e) {
            throw new BadRequestException(e.getMessage());
        }
    }

    @Override
    public CardDTO update(CardDTO object, User authUser) {
        try {
            cardDAO.update(convertToEntity(object, CreditCard.class));
            return object;
        } catch (SQLException e) {
            throw new BadRequestException(e.getMessage());
        }
    }

    @Override
    public List<CardDTO> getAll() {
        try {
            List<CreditCard> cards = cardDAO.getAll();
            List<CardDTO> dtos = new ArrayList<>();
            for(CreditCard card: cards)
                dtos.add(convertToDTO(card,CardDTO.class));
            return dtos;
        } catch (SQLException e) {
            throw new BadRequestException(e.getMessage());
        }
    }

    @Override
    public CardDTO getById(int id) {
        try {
            CreditCard card =cardDAO.getById(id);
            return convertToDTO(card, CardDTO.class);
        } catch (SQLException e) {
            throw new BadRequestException(e.getMessage());
        }
    }

    @Override
    public List<CardDTO> getAllForAuth(User authUser) {
        try {
            List<CreditCard> cards = cardDAO.getAllById(authUser.getId());
            List<CardDTO> dtos = new ArrayList<>();
            for(CreditCard card: cards)
                dtos.add(convertToDTO(card,CardDTO.class));
            return dtos;
        } catch (SQLException e) {
            throw new BadRequestException(e.getMessage());
        }
    }
}
