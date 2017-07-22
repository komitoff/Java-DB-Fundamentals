package entity;

import javax.persistence.*;
import java.sql.ResultSet;

@Entity
@Table(name = "result_prediction")
public class ResultPrediction {
    private Long id;
    private String prediction;

    public ResultPrediction() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "prediction")
    public String getPrediction() {
        return prediction;
    }

    public void setPrediction(String prediction) {
        this.prediction = prediction;
    }
}
