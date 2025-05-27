package co.edu.unicauca.coordinatorservice.repository;

import co.edu.unicauca.coordinatorservice.entities.Coordinator;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ICoordinatorRepository extends JpaRepository<Coordinator, Long> {
    Optional<Coordinator> findByCode(Long code);
}
