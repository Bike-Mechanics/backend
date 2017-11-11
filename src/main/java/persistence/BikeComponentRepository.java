package persistence;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BikeComponentRepository extends CrudRepository<BikeComponent, Long> {
    List<BikeComponent> findById(int id);
}