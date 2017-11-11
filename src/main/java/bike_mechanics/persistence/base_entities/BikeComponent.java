package bike_mechanics.persistence.base_entities;

import bike_mechanics.persistence.enums.ReplacementStatus;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Inheritance
public abstract class BikeComponent implements Serializable {

    @Id
    long id;
    float milage;
    Date assemblyDate;
    ReplacementStatus status;
}
