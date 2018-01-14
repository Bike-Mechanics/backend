package de.bike_mechanics.persistence.base_entities;


import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Notifcation implements Serializable {
    @Id
    long id;
}
