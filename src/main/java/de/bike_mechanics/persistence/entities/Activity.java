package de.bike_mechanics.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.ZonedDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Table(uniqueConstraints = @UniqueConstraint(name = "Strava ID must be unique", columnNames = {"stravaId"}))
public class Activity implements Serializable {

    private static final long serialVersionUID = -1002508975028988425L;

    @Id
    @GeneratedValue
    private long id;

    @Column(unique = true)
    private int stravaId;

    private Float distance;

    private ZonedDateTime createdOn;

    public Activity(int stravaId, Float distance, ZonedDateTime createdOn){
        this.stravaId = stravaId;
        this.distance = distance;
        this.createdOn = createdOn;
    }
}
