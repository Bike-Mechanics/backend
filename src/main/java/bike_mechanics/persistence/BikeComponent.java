package bike_mechanics.persistence;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class BikeComponent implements Serializable {

    @Id
    int id;
}
