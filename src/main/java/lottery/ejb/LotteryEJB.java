package lottery.ejb;

import lottery.entities.Lottery;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Remco on 15-11-2015.
 */
@Stateful
public class LotteryEJB {

    @PersistenceContext
    EntityManager em;

    public Lottery getNextLottery(){
        return null;
    }
}
