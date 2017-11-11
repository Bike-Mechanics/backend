package persistence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class BikeComponent implements Serializable {

    @Id
    @GeneratedValue
    int id;

    String name;
}
