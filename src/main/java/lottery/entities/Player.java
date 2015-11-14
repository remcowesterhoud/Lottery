package lottery.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Remco on 14-11-2015.
 */
@Entity
@Table(name = "LOTTERY_PLAYER")
public class Player {

    @Id @NotNull @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private String fistName, lastName;
    @NotNull
    private String email;
}
