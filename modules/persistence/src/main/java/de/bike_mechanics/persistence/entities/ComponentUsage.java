package de.bike_mechanics.persistence.entities;

import de.bike_mechanics.persistence.entities.base.BikeComponent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ComponentUsage {

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private long id;

    @ManyToOne
    @JoinColumn(name="bike_component_id", nullable=false)
    private BikeComponent bikeComponent;

    private float distance;

    private ZonedDateTime assemblyDate;

    private ZonedDateTime disassemblyDate;


    public ComponentUsage(ZonedDateTime assemblyDate, ZonedDateTime disassemblyDate){
        this(assemblyDate);
        this.disassemblyDate = disassemblyDate;
    }

    public ComponentUsage(ZonedDateTime assemblyDate){
        this.assemblyDate = assemblyDate;
    }

    public void setBikeComponent(BikeComponent bikeComponent) {
        this.bikeComponent = bikeComponent;
    }

    public void addDistance(float additionalDistance) {
        this.distance += additionalDistance;
    }
}
