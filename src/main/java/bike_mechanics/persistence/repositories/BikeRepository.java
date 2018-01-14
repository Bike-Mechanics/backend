package bike_mechanics.persistence.repositories;

import bike_mechanics.persistence.entities.Bike;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BikeRepository extends CrudRepository<Bike, Long>{
}
