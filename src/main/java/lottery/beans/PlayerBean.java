package lottery.beans;


import lottery.ejb.LotteryEJB;
import lottery.ejb.PlayerEJB;
import lottery.ejb.TicketEJB;
import lottery.entities.Lottery;
import lottery.entities.Player;
import lottery.entities.Ticket;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.validation.constraints.NotNull;

/**
 * Created by Remco on 14-11-2015.
 */
@ManagedBean(name = "playerBean")
@RequestScoped
public class PlayerBean {

    @EJB
    private PlayerEJB playerEJB;
    @EJB
    private LotteryEJB lotteryEJB;
    @EJB
    private TicketEJB ticketEJB;
    @ManagedProperty(value = "#{ticketBean}")
    private TicketBean ticketBean;
    @NotNull
    private String firstName, lastName, email;
    private boolean signupConfirmed, signupFailed;

    public PlayerBean() {
        signupConfirmed = false;
        signupFailed = false;
    }

    public void signup() {
        Player player = playerEJB.createPlayer(firstName, lastName, email);
        Lottery lottery = lotteryEJB.getNextLottery();
        if (player != null && lottery != null) {
            Ticket ticket = ticketBean.createTicket(player.getPlayerId(), lottery.getLotteryId());
            if (ticket != null){
//                playerEJB.addTicket(player.getPlayerId(), ticket);
//                lotteryEJB.addTicket(lottery.getLotteryId(), ticket);
                setSignupConfirmed(true);
            }
            else {
                setSignupFailed(false);
            }
        } else {
            setSignupFailed(true);
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String fistName) {
        this.firstName = fistName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isSignupConfirmed() {
        return signupConfirmed;
    }

    public void setSignupConfirmed(boolean signupConfirmed) {
        this.signupConfirmed = signupConfirmed;
    }

    public boolean isSignupFailed() {
        return signupFailed;
    }

    public void setSignupFailed(boolean signupFailed) {
        this.signupFailed = signupFailed;
    }

    public TicketBean getTicketBean() {
        return ticketBean;
    }

    public void setTicketBean(TicketBean ticketBean) {
        this.ticketBean = ticketBean;
    }
}
