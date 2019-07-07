package de.bike_mechanics.persistence.repositories;

import de.bike_mechanics.persistence.entities.Wheelset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WheelsetRepository extends JpaRepository<Wheelset, Long> {

}

