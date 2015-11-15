package lottery.beans;

import lottery.ejb.LotteryEJB;
import lottery.entities.Lottery;

import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Remco on 15-11-2015.
 */
@ManagedBean(name = "lotteryBean")
@ApplicationScoped
public class LotteryBean {

    @EJB
    private LotteryEJB lotteryEJB;

    public LotteryBean(){
    }

    //TODO: delete method, add method for pulling winners
    public String test(){
        return null;
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
}
