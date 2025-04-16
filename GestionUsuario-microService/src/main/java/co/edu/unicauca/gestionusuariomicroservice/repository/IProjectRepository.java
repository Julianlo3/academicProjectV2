package co.edu.unicauca.gestionusuariomicroservice.repository;

import co.edu.unicauca.gestionusuariomicroservice.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProjectRepository extends JpaRepository<Project, String> {
    void deleteByTitle(String title);
}
