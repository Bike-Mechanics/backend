package bike_mechanics.persistence.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Entity
public class User implements Serializable {
	
	@Id
	String stravaUserId;
	String email;

	@OneToMany
	List<Bike> bikes;
}