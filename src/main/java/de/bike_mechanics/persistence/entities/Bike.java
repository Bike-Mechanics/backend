package de.bike_mechanics.persistence.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Bike implements Serializable {
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	Long id;

	String stravaGearId;
	String stravaName;

	@OneToMany
	List<Cassette> cassettes;

	@OneToMany
	List<Chain> chains;

	@OneToMany
	List<ChainRing> chainRings;

	@OneToMany
	List<CrankBearing> crankBearings;

	@OneToMany
	List<Tires> tires;

	@OneToMany
	List<WheelBearing> wheelBearings;

	@OneToMany
	List<BowdenCable> bowdenCables;

	public Bike(){
		this.chains = new ArrayList<Chain>();
	}

	public Bike(String pStravaGearId, String pStravaName){
		this();
		this.stravaGearId = pStravaGearId;
		this.stravaName = pStravaName;

	}

	public void addChain(Chain pChain){
		this.chains.add(pChain);
	}

	public List<Chain> getChains(){
		return this.chains;
	}
}