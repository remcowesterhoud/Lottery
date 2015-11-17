package lottery.ejb;

import java.util.logging.Logger;

import javax.ejb.Stateless;

import lottery.entities.Player;

/**
 * Created by Remco on 15-11-2015.
 */
@Stateless
public class PlayerEJB extends EJB {

    private static final Logger logger = Logger.getLogger("lottery.ejb.PlayerEJB");

    /**
     * Creates a new player
     *
     * @param firstName
     * @param lastName
     * @param email
     * @return Create player or null
     */
    public Player createPlayer(String firstName, String lastName, String email) {
        try {
            Player player = new Player(firstName, lastName, email);
            em.persist(player);
            return player;
        } catch (Exception e) {
            logger.warning("Could not create player");
            return null;
        }
    }
}
