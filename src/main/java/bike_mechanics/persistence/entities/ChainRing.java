package bike_mechanics.persistence.entities;

import java.io.Serializable;

import javax.persistence.Entity;

import bike_mechanics.persistence.base_entities.BikeComponent;

@Entity
public class ChainRing extends BikeComponent implements Serializable {
}