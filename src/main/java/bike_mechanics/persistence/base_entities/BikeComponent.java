package bike_mechanics.persistence.base_entities;

import bike_mechanics.persistence.enums.ReplacementStatus;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
public class BikeComponent implements Serializable {

    @Id
    int id;
    float milage;
    Date assemblyDate;
    ReplacementStatus status;
}
