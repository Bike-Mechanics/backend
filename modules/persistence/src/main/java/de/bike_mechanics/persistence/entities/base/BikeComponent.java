package de.bike_mechanics.persistence.entities.base;

import de.bike_mechanics.persistence.entities.ComponentUsage;
import de.bike_mechanics.persistence.enums.ReplacementStatus;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance
@Data
public abstract class BikeComponent implements Serializable {

    private static final long serialVersionUID = -2696919732054181366L;

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    Long id;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "bikeComponent", orphanRemoval = true)
    List<ComponentUsage> usages;

    @Enumerated(EnumType.STRING)
    ReplacementStatus status = ReplacementStatus.DISASSEMBLED;

    public BikeComponent() {
        this.usages = new ArrayList<>();
    }

    public void addUsage(ComponentUsage use) {
        use.setBikeComponent(this);
        this.usages.add(use);
    }
}
