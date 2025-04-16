package co.edu.unicauca.gestionusuariomicroservice.Service;


import co.edu.unicauca.gestionusuariomicroservice.entities.Postulacion;
import co.edu.unicauca.gestionusuariomicroservice.repository.IPostulacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lopez
 * @date 15/04/2025
 */
@Service
public class PostulacionService {
    @Autowired
    private IPostulacionRepository postulacionRepository;

    public Postulacion crearPostulacion(Postulacion postulacion) {
        return postulacionRepository.save(postulacion);
    }

    public List<Postulacion> findByProjecTitle(String title) {
        return postulacionRepository.findByProjectTitle(title);
    }

    public List<Postulacion> obtenerPorEstudiante(String studentCode) {
        return postulacionRepository.findByStudentCode(studentCode);
    }

}
