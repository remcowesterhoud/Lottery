package lottery.ejb;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Created by Remco on 15-11-2015.
 */
@Singleton
@Startup
public class ConfigEJB extends EJB{

    @javax.ejb.EJB
    private LotteryEJB lotteryEJB;
    @javax.ejb.EJB
    private PlayerEJB playerEJB;
    @javax.ejb.EJB
    private TicketEJB ticketEJB;

    @PostConstruct
    public void insertDummyData() {
        try {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            lotteryEJB.createLottery(df.parse("2015-11-15 15:31:00"));
            lotteryEJB.createLottery(df.parse("2015-11-17 09:10:00"));
            lotteryEJB.createLottery(df.parse("2015-11-17 09:17:00"));
            lotteryEJB.createLottery(df.parse("2015-11-19 15:30:00"));
            lotteryEJB.createLottery(df.parse("2015-12-1 10:00:00"));
            lotteryEJB.fetchNextLottery();
        }
        catch (Exception e){
            //Configuration is correct, won't be reached
        }
    }
}
