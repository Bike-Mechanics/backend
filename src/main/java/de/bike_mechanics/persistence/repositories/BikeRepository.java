package de.bike_mechanics.persistence.repositories;

import de.bike_mechanics.persistence.entities.Bike;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BikeRepository extends CrudRepository<Bike, Long>{
}
