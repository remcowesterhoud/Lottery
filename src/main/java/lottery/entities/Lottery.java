package lottery.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Created by Remco on 14-11-2015.
 */
@Entity
@Table(name = "LOTTERY_LOTTERY")
@NamedQueries(
        @NamedQuery(
                name = "nextLottery",
                query = "SELECT l FROM Lottery l WHERE l.pullDate > :currentDate ORDER BY l.pullDate"
        )
)
public class Lottery {

    @Id
    @Column(name = "LOTTERY_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int lotteryId;

    @NotNull
    @Column(unique = true)
    private Date pullDate;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "lottery")
    private List<Ticket> tickets;

    @ManyToOne
    @JoinColumn(name = "WINNER")
    private Player winner;

    public Lottery() {
    }

    public Lottery(Date pullDate) {
        this.pullDate = pullDate;
    }

    public Lottery(Date pullDate, List<Ticket> tickets) {
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

    public List<Ticket> getTickets() {
        if (tickets != null) {
            return tickets;
        }
        else {
            return new ArrayList<Ticket>();
        }
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }
}
