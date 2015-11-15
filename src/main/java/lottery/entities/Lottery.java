package lottery.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 * Created by Remco on 14-11-2015.
 */
@Entity
@Table(name = "LOTTERY_LOTTERY")
public class Lottery implements Serializable {

    @Id
    @Column(name = "LOTTERY_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int lotteryId;

    @NotNull
    @Column(unique = true)
    private Date pullDate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lottery")
    private Collection<Ticket> tickets;

    public Lottery() {
    }

    public Lottery(Date pullDate, Collection<Ticket> tickets) {
        this.pullDate = pullDate;
        this.tickets = tickets;
    }

    public int getLotteryId() {
        return lotteryId;
    }

    public void setLotteryId(int lotteryId) {
        this.lotteryId = lotteryId;
    }

    public Date getPullDate() {
        return pullDate;
    }

    public void setPullDate(Date pullDate) {
        this.pullDate = pullDate;
    }

    public Collection<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Collection<Ticket> tickets) {
        this.tickets = tickets;
    }
}
