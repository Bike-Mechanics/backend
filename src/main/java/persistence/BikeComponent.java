package persistence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class BikeComponent {

    @Id
    @GeneratedValue
    int id;

    String name;
}
