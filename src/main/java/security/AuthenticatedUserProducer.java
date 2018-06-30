package security;

import dao.UserDAO;
import model.User;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.ws.rs.ForbiddenException;
import java.sql.SQLException;
import java.util.logging.Logger;

@RequestScoped
public class AuthenticatedUserProducer {

    @Produces
    @RequestScoped
    @AuthenticatedUser
    private User authenticatedUser;

    @Inject
    private UserDAO userDao;

    public void handleAuthenticationEvent(@Observes @AuthenticatedUser String username) {
        this.authenticatedUser = findUser(username);
    }

    private User findUser(String username) {
        // Hit the the database or a service to find a user by its username and return it
        // Return the User instance
        try {
            return userDao.findByUsername(username);
        } catch (SQLException e) {
            Logger.getLogger(this.getClass().getSimpleName()).severe("Couldn't Find user ["+username+"]; Message: "+e.getMessage());
            throw new ForbiddenException(e.getMessage());
        }
    }

}
