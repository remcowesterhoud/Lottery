package lottery.ejb;

import lottery.entities.Lottery;
import lottery.entities.Player;
import lottery.entities.Ticket;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;

/**
 * Created by Remco on 15-11-2015.
 */
@Stateful
public class TestEJB {
    @PersistenceContext
    private EntityManager em;

    public void test(){
        Player player = new Player();
        player.setFistName("Test");
        player.setLastName("Test");
        player.setEmail("Test@test.nl");
        em.persist(player);

        Lottery lottery = new Lottery();
        lottery.setPullDate(new Date());
        em.persist(lottery);

        Ticket ticket = new Ticket(player, lottery);
        em.persist(ticket);
    }
}
