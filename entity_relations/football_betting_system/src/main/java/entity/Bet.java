package entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "bet")
public class Bet {
    private Long id;
    private BigDecimal betMoney;
    private Date dateTime;
    private User user;

    public Bet() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "bet_money")
    public BigDecimal getBetMoney() {
        return betMoney;
    }

    public void setBetMoney(BigDecimal betMoney) {
        this.betMoney = betMoney;
    }

    @Column(name = "date_time")
    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    @ManyToOne
    @JoinColumn(name = "user_id",
    referencedColumnName = "id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
