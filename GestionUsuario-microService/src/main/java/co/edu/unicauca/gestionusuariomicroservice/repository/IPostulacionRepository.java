package co.edu.unicauca.gestionusuariomicroservice.repository;

import co.edu.unicauca.gestionusuariomicroservice.entities.Postulacion;
import co.edu.unicauca.gestionusuariomicroservice.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPostulacionRepository extends JpaRepository<Postulacion, String> {
    List<Postulacion> findByStudentCode(String code);
    List<Postulacion> findByProjectTitle(String title);
}
