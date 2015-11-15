package lottery.ejb;

import lottery.entities.Lottery;
import lottery.entities.Player;
import lottery.entities.Ticket;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Remco on 15-11-2015.
 */
@Stateful
public class TestEJB {
    @PersistenceContext
    private EntityManager em;

    public void test() throws ParseException {
        Player player = new Player();
        player.setFistName("Test");
        player.setLastName("Test");
        player.setEmail("Test@test.nl");
        em.persist(player);

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Lottery lottery = new Lottery();
        lottery.setPullDate(df.parse("2015-11-15 14:50:00"));
        em.persist(lottery);

        lottery = new Lottery();
        lottery.setPullDate(df.parse("2015-11-15 15:00:00"));
        em.persist(lottery);

        Ticket ticket = new Ticket(player, lottery);
        em.persist(ticket);
    }
}
