package entity;

import javax.persistence.*;

@Entity
@Table(name = "player_statistic")
public class PlayerStatistic {
    private Long id;
    private Player player;
    private Integer scoredGoals;
    private Integer playerAssist;
    private Integer playedMinutes;

    public PlayerStatistic () {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @OneToOne
    @JoinColumn(name = "player_id",
    referencedColumnName = "id")
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    @Column(name = "scored_goals")
    public Integer getScoredGoals() {
        return scoredGoals;
    }

    public void setScoredGoals(Integer scoredGoals) {
        this.scoredGoals = scoredGoals;
    }

    @Column(name = "player_assist")
    public Integer getPlayerAssist() {
        return playerAssist;
    }

    public void setPlayerAssist(Integer playerAssist) {
        this.playerAssist = playerAssist;
    }

    @Column(name = "played_minutes")
    public Integer getPlayedMinutes() {
        return playedMinutes;
    }

    public void setPlayedMinutes(Integer playedMinutes) {
        this.playedMinutes = playedMinutes;
    }
}
