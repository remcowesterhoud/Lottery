package lottery.beans;

import lottery.ejb.LotteryEJB;
import lottery.ejb.PlayerEJB;
import lottery.entities.Lottery;
import lottery.entities.Player;
import lottery.entities.Ticket;

import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

    public LotteryBean(){
    }

    public void endLottery(){
        lotteryEJB.pullWinner();
        lotteryEJB.fetchNextLottery();
    }

    public String getDate(){
        Lottery lottery = lotteryEJB.getNextLottery();
        if (lottery != null){
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = lottery.getPullDate();
            return df.format(date);
        }
        else {
            return null;
        }
    }

    public List<Lottery> getPreviousLotteries(){
        return lotteryEJB.getPreviousLotteries();
    }
}
