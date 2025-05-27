package co.edu.unicauca.coordinatorservice.services;

import co.edu.unicauca.coordinatorservice.entities.Coordinator;
import co.edu.unicauca.coordinatorservice.infra.dto.CoordinatorRequest;
import co.edu.unicauca.coordinatorservice.infra.dto.CoordinatorResponse;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface ICoordinatorService {

    @Transactional
    Optional<Coordinator> getCoordinatorByCode(Long code) throws Exception;

    @Transactional
    List<Coordinator> getAllCoordinators() throws Exception;

    @Transactional
    Coordinator createCoordinator(CoordinatorRequest coordinatorRequest) throws Exception;

    @Transactional
    Coordinator updateCoordinator(Long code, CoordinatorRequest coordinatorRequest) throws Exception;

    @Transactional
    Coordinator deleteCoordinator(Long code) throws Exception;

    @Transactional
    Coordinator verifyCoordinator(Long code) throws Exception;

    @Transactional
    Coordinator rejectCoordinator(Long code) throws Exception;
}
