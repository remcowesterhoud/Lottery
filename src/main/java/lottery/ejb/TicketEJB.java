package lottery.ejb;

import lottery.entities.Lottery;
import lottery.entities.Player;
import lottery.entities.Ticket;

import javax.ejb.Stateless;
import java.util.logging.Logger;

/**
 * Created by Remco on 15-11-2015.
 */
@Stateless
public class TicketEJB extends EJB {

    private static final Logger logger = Logger.getLogger("lottery.ejb.TicketEJB");

    public Ticket createTicket(Player player, Lottery lottery){
        try{
            Ticket ticket = new Ticket(player, lottery);
            em.persist(ticket);
            return ticket;
        }
        catch (Exception e){
            logger.warning("Could not create ticket");
            return null;
        }
    }
}
