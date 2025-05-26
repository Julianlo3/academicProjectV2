package co.edu.unicauca.gestioncoordinadormicroservice.repository;

import co.edu.unicauca.gestioncoordinadormicroservice.entities.Coordinator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICoordinatorRepository extends JpaRepository<Coordinator, String> {
}
