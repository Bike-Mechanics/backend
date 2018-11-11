package de.bike_mechanics.persistence.entities.base;

import de.bike_mechanics.domain.enums.ReplacementStatus;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import java.io.Serializable;
import java.time.ZonedDateTime;

@Entity
@Inheritance
public abstract class BikeComponent implements Serializable {

    private static final long serialVersionUID = -2696919732054181366L;

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    long id;

    float distance;

    ZonedDateTime assemblyDate;

    ReplacementStatus status;
}
