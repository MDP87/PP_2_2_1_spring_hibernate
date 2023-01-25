package hiber.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name = "cars")

public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "car_id", nullable = false)
    private Long id;

    @OneToOne (mappedBy = "car")
    private User owner;
    @Column (name = "model")
    private String model;
    @Column (name = "series")
    private int series;

    public Car() {
    }
    public Long getId() {
        return id;
    }
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    @Override
    public String toString() {
        return String.format("model %s, series %s", getModel(), getSeries());
    }

}
