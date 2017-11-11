package bike_mechanics.persistence.base_entities;


import javax.persistence.Id;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class Notifcation implements Serializable {
    @Id
    long id;
}
