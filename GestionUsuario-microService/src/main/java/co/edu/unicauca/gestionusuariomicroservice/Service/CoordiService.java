package co.edu.unicauca.gestionusuariomicroservice.Service;


import co.edu.unicauca.gestionusuariomicroservice.entities.Coordinator;
import co.edu.unicauca.gestionusuariomicroservice.repository.ICoordinatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author lopez
 * @date 15/04/2025
 */
@Service
public class CoordiService {

    @Autowired
    private ICoordinatorRepository coordiRepository;

    public Coordinator saveCoordinator(Coordinator coordinator) {
        return coordiRepository.save(coordinator);
    }

    public List<Coordinator> getAllCoordinators() {
        return coordiRepository.findAll();
    }

    public Optional<Coordinator> getCoordinatorById(String id) {
        return coordiRepository.findById(id);
    }

    public Coordinator updateCoordinator(Coordinator coordinator) {
        return coordiRepository.save(coordinator);
    }

    public void deleteCoordinator(String id) {
        coordiRepository.deleteById(id);
    }

}
