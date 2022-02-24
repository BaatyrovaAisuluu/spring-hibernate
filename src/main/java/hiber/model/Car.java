package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String model;
    private int series;

    @OneToOne(cascade = {CascadeType.DETACH, CascadeType.
            PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, mappedBy = "car")
    private User user;


    public Car() {
    }

    public Car(String model, int series) {
        this.model = model;
        this.series = series;
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
        return
                "CarId       " + id + '\n' +
                        "model       " + model + '\n' +
                        "series      " + series + '\n';
    }

}
