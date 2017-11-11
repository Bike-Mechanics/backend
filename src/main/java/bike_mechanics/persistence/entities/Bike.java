package bike_mechanics.persistence.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

@Entity
public class Bike implements Serializable {
	
	@Id
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
}