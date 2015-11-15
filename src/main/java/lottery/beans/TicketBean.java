package lottery.beans;

import lottery.ejb.TicketEJB;
import lottery.entities.Lottery;
import lottery.entities.Player;
import lottery.entities.Ticket;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * Created by Remco on 15-11-2015.
 */
@ManagedBean(name = "ticketBean")
@RequestScoped
public class TicketBean {

    @EJB
    private TicketEJB ticketEJB;
    private Ticket ticket;

    public Ticket createTicket(Player player, Lottery lottery){
        ticket = ticketEJB.createTicket(player, lottery);
        if (ticket != null){
            return ticket;
        }
        else {
            return null;
        }
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
