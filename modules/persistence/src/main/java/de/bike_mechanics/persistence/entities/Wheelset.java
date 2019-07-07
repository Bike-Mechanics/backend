package de.bike_mechanics.persistence.entities;

import de.bike_mechanics.persistence.entities.base.BikeComponent;

import javax.persistence.Entity;

@Entity
public class Wheelset extends BikeComponent{

    private static final long serialVersionUID = -5891272843553282114L;

    public Wheelset(){
        super();
    }
}
