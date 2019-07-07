package de.bike_mechanics.persistence.repositories;

import de.bike_mechanics.persistence.entities.ComponentUsage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UseRepository extends JpaRepository<ComponentUsage, Long> {

}

