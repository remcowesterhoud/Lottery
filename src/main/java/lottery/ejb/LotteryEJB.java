package lottery.ejb;

import lottery.entities.Lottery;
import lottery.entities.Player;
import lottery.entities.Ticket;

import javax.annotation.PostConstruct;
import javax.ejb.EJBException;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Stateful;
import javax.persistence.NoResultException;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

/**
 * Created by Remco on 15-11-2015.
 */
@Startup
@Singleton
public class LotteryEJB extends EJB {

    private static final Logger logger = Logger.getLogger("lottery.ejb.LotteryEJB");
    private Lottery nextLottery;

    /**
     * Create new lottery
     * @param pullDate
     * @return Created lottery or null
     */
    public Lottery createLottery(Date pullDate) {
        try {
            Lottery lottery = new Lottery(pullDate);
            em.persist(lottery);
            return lottery;
        } catch (Exception e) {
            logger.warning("Could not create lottery");
            return null;
        }
    }

    /**
     * Fetches the next lottery from the database
     */
    public void fetchNextLottery() {
        try {
            nextLottery = em.createNamedQuery("nextLottery", Lottery.class)
                    .setParameter("currentDate", new Date())
                    .setMaxResults(1).getSingleResult();
        }
        catch (NoResultException e){
            logger.warning("No available lotteries");
        }
        catch (EJBException e) {
            logger.warning("Error fetching lottery");
        }
    }

    public Lottery getNextLottery() {
        return nextLottery;
    }

    /**
     * Randomly pulls a winning ticket from the current lottery
     * @return Winning ticket
     */
    public Ticket pullWinner(){
        try {
            Lottery lottery = em.find(Lottery.class, nextLottery.getLotteryId());
            List<Ticket> tickets = lottery.getTickets();
            Random random = new Random();
            int i = random.nextInt(tickets.size());
            Ticket winner = tickets.get(i);
            lottery.setWinningTicket(winner);
            winner.setWonLottery(lottery);
            em.flush();
            return winner;
        }
        catch (NullPointerException e){
            logger.warning("Could not pull winner. There are currently no lotteries running");
            return null;
        }
        catch (IllegalArgumentException e){
            logger.warning("Could not pull winner. No tickets have been sold");
            return null;
        }
        catch (EJBException e){
            logger.warning("Could not pull winner");
            return null;
        }
    }

    /**
     * @return List of lotteries that have ended or null
     */
    public List<Lottery> getPreviousLotteries(){
        try{
            List<Lottery> lotteries = em.createNamedQuery("previousLotteries", Lottery.class)
                    .setParameter("currentDate", new Date())
                    .getResultList();
            return lotteries;
        }
        catch (NoResultException e){
            logger.warning("No available lotteries");
            return null;
        }
        catch (EJBException e) {
            logger.warning("Error fetching lotteries");
            return null;
        }
    }
}
