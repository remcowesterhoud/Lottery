package lottery.ejb;

import lottery.entities.Lottery;

import javax.ejb.EJBException;
import javax.ejb.Startup;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;

/**
 * Created by Remco on 15-11-2015.
 */
@Startup
@Stateful
public class LotteryEJB {

    @PersistenceContext
    EntityManager em;

    public Lottery getNextLottery(){
        try{
            return em.createNamedQuery("nextLottery", Lottery.class)
                    .setParameter("currentDate", new Date())
                    .setMaxResults(1).getSingleResult();
        }
        catch (EJBException e){
            return null;
        }
    }
}
