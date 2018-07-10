package service;

import dto.CardDTO;
import model.CreditCard;
import model.User;

import java.util.List;

public interface CardService extends Service<CreditCard, CardDTO> {
    List<CardDTO> getAllForAuth(User authUser);
}
