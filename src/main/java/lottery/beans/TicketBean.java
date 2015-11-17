package lottery.beans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import lottery.ejb.TicketEJB;
import lottery.entities.Ticket;

/**
 * Created by Remco on 15-11-2015.
 */
@ManagedBean(name = "ticketBean")
@RequestScoped
public class TicketBean {

    @EJB
    private TicketEJB ticketEJB;
    private Ticket ticket;

    /**
     * Create new ticket and attach it to a player and lottery
     *
     * @param playerId
     * @param lotteryId
     * @return Created ticket or null
     */
    public Ticket createTicket(int playerId, int lotteryId) {
        ticket = ticketEJB.createTicket(playerId, lotteryId);
        if (ticket != null) {
            return ticket;
        } else {
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
