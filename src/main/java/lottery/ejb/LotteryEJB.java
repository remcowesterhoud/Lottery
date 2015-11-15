package lottery.ejb;

import lottery.entities.Lottery;

import javax.annotation.PostConstruct;
import javax.ejb.EJBException;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Stateful;
import java.util.Date;
import java.util.logging.Logger;

/**
 * Created by Remco on 15-11-2015.
 */
@Startup
@Singleton
public class LotteryEJB extends EJB {

    private static final Logger logger = Logger.getLogger("lottery.ejb.LotteryEJB");
    private Lottery nextLottery;

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

    public void fetchNextLottery() {
        try {
            nextLottery = em.createNamedQuery("nextLottery", Lottery.class)
                    .setParameter("currentDate", new Date())
                    .setMaxResults(1).getSingleResult();
        } catch (EJBException e) {
            logger.warning("Error fetching lottery");
        }
    }

    public Lottery getNextLottery() {
        return nextLottery;
    }
}
