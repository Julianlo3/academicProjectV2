package co.edu.unicauca.coordinatorservice.services;

import co.edu.unicauca.coordinatorservice.entities.Coordinator;
import co.edu.unicauca.coordinatorservice.entities.state.*;
import co.edu.unicauca.coordinatorservice.infra.dto.CoordinatorRequest;
import co.edu.unicauca.coordinatorservice.infra.mapper.CoordinatorMapper;
import co.edu.unicauca.coordinatorservice.repository.CoordinatorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoordinatorService implements ICoordinatorService{

    private final CoordinatorRepository coordinatorRepository;
    private final CoordinatorMapper coordinatorMapper;

    public CoordinatorService(CoordinatorRepository coordinatorRepository, CoordinatorMapper coordinatorMapper) {
        this.coordinatorRepository = coordinatorRepository;
        this.coordinatorMapper = coordinatorMapper;
    }

    @Override
    public Optional<Coordinator> getCoordinatorByCode(Long code) throws Exception {
        return coordinatorRepository.findByCode(code);
    }

    @Override
    public List<Coordinator> getAllCoordinators() throws Exception {
        return coordinatorRepository.findAll();
    }

    @Override
    public Coordinator createCoordinator(CoordinatorRequest coordinatorRequest) throws Exception {
        try {
            // 1. Verificar si el codigo fue pasado y si ya existe
            if (coordinatorRequest.getCode() != null) {
                if (coordinatorRepository.findByCode(coordinatorRequest.getCode()).isPresent()) {
                    throw new IllegalAccessException("El coordinador con CODIGO " + coordinatorRequest.getCode() + " ya existe");
                }
            }

            // 2. Crear y mapear el estudiante desde el DTO
            Coordinator coordinator = coordinatorMapper.toEntity(coordinatorRequest);

            return coordinatorRepository.save(coordinator);

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Coordinator updateCoordinator(Long code, CoordinatorRequest coordinatorRequest) throws Exception {
        try {
            // 1. Verificar si el codigo fue pasado y si existe
            if (code != null && coordinatorRequest.getCode() != null && !code.equals(coordinatorRequest.getCode())) {
                throw new IllegalAccessException("El coordinador con CODIGO " + code + " no coincide con el CODIGO del DTO");
            }

            if (coordinatorRepository.findByCode(code).isEmpty()) {
                throw new IllegalAccessException("El coordinador con CODIGO " + code + " no existe");
            }

            // 2. Crear y mapear el estudiante desde el DTO
            Coordinator coordinator = coordinatorRepository.findByCode(code).get();
            coordinator.setName(coordinatorRequest.getName());
            coordinator.setPhone(coordinatorRequest.getPhone());
            coordinator.setEmail(coordinatorRequest.getEmail());
            coordinator.setDegreeProgram(coordinatorRequest.getDegreeProgram());

            return coordinatorRepository.save(coordinator);

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Coordinator deleteCoordinator(Long code) throws Exception {
        try{
            // 1. Verificar si el codigo fue pasado y si existe
            if (code != null) {
                if (coordinatorRepository.findByCode(code).isEmpty()) {
                    throw new IllegalAccessException("El coordinador con codigo " + code + " no existe");
                }
            }

            // 2. Obtener el estudiante a eliminar
            Coordinator coordinator = coordinatorRepository.findByCode(code).get();

            // 3. Eliminar el estudiante
            coordinatorRepository.delete(coordinator);

            return coordinator;

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Coordinator verifyCoordinator(Long code) throws Exception {
        try{
            // 1. Verificar si el codigo fue pasado y si existe
            if (code != null) {
                if (coordinatorRepository.findByCode(code).isEmpty()) {
                    throw new IllegalAccessException("El coordinador con codigo " + code + " no existe");
                }
            }

            // 2. Obtener el estudiante a eliminar
            Coordinator coordinator = coordinatorRepository.findByCode(code).get();
            coordinator.changeState(
                    switch (coordinator.getStatus().name()) {
                        case "PENDING" -> new Pending();
                        case "VERIFIED" -> new Verified();
                        case "REJECTED" -> new Rejected();
                        default -> throw new IllegalArgumentException("State not recognized: " + coordinator.getStatus());
                    }
            );

            coordinator.verify();

            return coordinatorRepository.save(coordinator);

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Coordinator rejectCoordinator(Long code) throws Exception {
        try{
            // 1. Verificar si el codigo fue pasado y si existe
            if (code != null) {
                if (coordinatorRepository.findByCode(code).isEmpty()) {
                    throw new IllegalAccessException("El coordinador con codigo " + code + " no existe");
                }
            }

            // 2. Obtener el estudiante a eliminar
            Coordinator coordinator = coordinatorRepository.findByCode(code).get();
            coordinator.changeState(
                    switch (coordinator.getStatus().name()) {
                        case "PENDING" -> new Pending();
                        case "VERIFIED" -> new Verified();
                        case "REJECTED" -> new Rejected();
                        default -> throw new IllegalArgumentException("State not recognized: " + coordinator.getStatus());
                    }
            );

            coordinator.reject();

            return coordinatorRepository.save(coordinator);

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}

