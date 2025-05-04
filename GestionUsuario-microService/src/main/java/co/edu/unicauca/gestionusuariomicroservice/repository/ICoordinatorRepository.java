package co.edu.unicauca.gestionusuariomicroservice.repository;

import co.edu.unicauca.gestionusuariomicroservice.entities.Coordinator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICoordinatorRepository extends JpaRepository<Coordinator, String> {
}
