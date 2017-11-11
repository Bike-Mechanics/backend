package bike_mechanics.persistence.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Entity
public class User implements Serializable {
	
	@Id
	String stravaUserId;
	String email;
	List<Bike> bikes;
}