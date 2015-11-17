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

    /**
     * Create new ticket
     * @param playerId
     * @param lotteryId
     * @return Created ticket or null
     */
    public Ticket createTicket(int playerId, int lotteryId){
        try{
            Player player = em.find(Player.class, playerId);
            Lottery lottery = em.find(Lottery.class, lotteryId);
            Ticket ticket = new Ticket(player, lottery);
            player.getTickets().add(ticket);
            lottery.getTickets().add(ticket);
            em.persist(ticket);
            return ticket;
        }
        catch (Exception e){
            logger.warning("Could not create ticket");
            return null;
        }
    }
}
