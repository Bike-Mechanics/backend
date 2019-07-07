package de.bike_mechanics.persistence.entities.base;

import de.bike_mechanics.persistence.entities.Use;
import de.bike_mechanics.persistence.enums.ReplacementStatus;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance
public abstract class BikeComponent implements Serializable {

    private static final long serialVersionUID = -2696919732054181366L;

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    long id;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "bikeComponent", orphanRemoval = true)
    List<Use> uses = new ArrayList<>();

    ReplacementStatus status;

    public void addUse(Use use){
        use.setBikeComponent(this);
        this.uses.add(use);
    }
}
