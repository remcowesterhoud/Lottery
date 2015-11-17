package lottery.entities;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Remco on 14-11-2015.
 */
@Entity
@Table(name = "LOTTERY_PLAYER")
public class Player {

    @Id
    @Column(name = "PLAYER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int playerId;

    @NotNull
    private String fistName, lastName;

    @NotNull
    private String email;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "player")
    private List<Ticket> tickets;

    /**
     * Constructor
     */
    public Player() {
    }

    /**
     * Constructor
     *
     * @param fistName
     * @param lastName
     * @param email
     */
    public Player(String fistName, String lastName, String email) {
        this.fistName = fistName;
        this.lastName = lastName;
        this.email = email;
    }

    /**
     * Constructor
     *
     * @param fistName
     * @param lastName
     * @param email
     * @param tickets
     */
    public Player(String fistName, String lastName, String email, List<Ticket> tickets) {
        this.fistName = fistName;
        this.lastName = lastName;
        this.email = email;
        this.tickets = tickets;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int id) {
        this.playerId = id;
    }

    public String getFistName() {
        return fistName;
    }

    public void setFistName(String fistName) {
        this.fistName = fistName;
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

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}
