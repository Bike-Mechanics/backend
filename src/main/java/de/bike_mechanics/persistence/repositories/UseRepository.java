package de.bike_mechanics.persistence.repositories;

import de.bike_mechanics.persistence.entities.Use;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UseRepository extends JpaRepository<Use, Long> {

}

