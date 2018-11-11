package de.bike_mechanics.persistence.repositories;

import de.bike_mechanics.persistence.entities.Activity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepository extends CrudRepository<Activity, Long> {

}

