package lottery.ejb;

import lottery.entities.Lottery;
import lottery.entities.Player;
import lottery.entities.Ticket;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Created by Remco on 15-11-2015.
 */
@Singleton
@Startup
public class ConfigEJB extends EJB{

    @PostConstruct
    public void insertDummyData() {
        Player player = new Player();
        player.setFistName("Test");
        player.setLastName("Test");
        player.setEmail("Test@test.nl");
        em.persist(player);

        try {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Lottery lottery = new Lottery();
            lottery.setPullDate(df.parse("2015-11-15 20:15:00"));
            em.persist(lottery);

            lottery = new Lottery();
            lottery.setPullDate(df.parse("2015-11-16 15:00:00"));
            em.persist(lottery);

            lottery = new Lottery();
            lottery.setPullDate(df.parse("2015-11-18 12:00:00"));
            em.persist(lottery);

            lottery = new Lottery();
            lottery.setPullDate(df.parse("2015-11-19 15:30:00"));
            em.persist(lottery);

            lottery = new Lottery();
            lottery.setPullDate(df.parse("2015-12-1 10:00:00"));
            em.persist(lottery);

            Ticket ticket = new Ticket(player, lottery);
            em.persist(ticket);
        }
        catch (Exception e){
            //Won't be reached
        }
    }
}
