package bike_mechanics.persistence.entities;

import bike_mechanics.persistence.base_entities.BikeComponent;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class Chain extends BikeComponent implements Serializable {
}