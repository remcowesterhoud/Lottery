package lottery.beans;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import lottery.ejb.LotteryEJB;
import lottery.ejb.PlayerEJB;
import lottery.entities.Lottery;

/**
 * Created by Remco on 15-11-2015.
 */
@ManagedBean(name = "lotteryBean")
@ApplicationScoped
public class LotteryBean {

    @EJB
    private LotteryEJB lotteryEJB;
    @EJB
    private PlayerEJB playerEJB;

    /**
     * Constructor
     */
    public LotteryBean() {
    }

    /**
     * Randomly pulls a winner for the current lottery.
     * Fetches the next lottery.
     */
    public void endLottery() {
        lotteryEJB.pullWinner();
        lotteryEJB.fetchNextLottery();
    }

    /**
     * @return Pulldate of lottery
     */
    public String getDate() {
        Lottery lottery = lotteryEJB.getNextLottery();
        if (lottery != null) {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = lottery.getPullDate();
            return df.format(date);
        } else {
            return null;
        }
    }

    /**
     * @return List of lotteries that have ended.
     */
    public List<Lottery> getPreviousLotteries() {
        return lotteryEJB.getPreviousLotteries();
    }
}
