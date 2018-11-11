package de.bike_mechanics.persistence.repositories;

import de.bike_mechanics.persistence.entities.Chain;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChainRepository extends CrudRepository<Chain, Long> {
}
