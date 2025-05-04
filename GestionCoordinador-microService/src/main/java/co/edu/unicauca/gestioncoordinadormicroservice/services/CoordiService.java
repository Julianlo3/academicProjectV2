package co.edu.unicauca.gestioncoordinadormicroservice.Service;


import co.edu.unicauca.gestioncoordinadormicroservice.entities.Coordinator;
import co.edu.unicauca.gestioncoordinadormicroservice.repository.ICoordinatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


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
