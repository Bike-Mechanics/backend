package bike_mechanics.persistence.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Entity
public class Bike implements Serializable {
	
	@Id
	String stravaGearId;
	String stravaName;
	List<Cassette> cassettes;
	List<Chain> chains;
	List<ChainRing> chainRings;
	List<CrankBearing> crankBearings;
	List<Tires> tires;
	List<WheelBearing> wheelBearings;
	List<BowdenCable> bowdenCables;
}