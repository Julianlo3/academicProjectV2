package co.edu.unicauca.coordinatorservice.infra.mapper;

import co.edu.unicauca.coordinatorservice.entities.Coordinator;
import co.edu.unicauca.coordinatorservice.infra.dto.CoordinatorRequest;
import co.edu.unicauca.coordinatorservice.infra.dto.CoordinatorResponse;
import org.springframework.stereotype.Component;

@Component
public class CoordinatorMapper {

    public CoordinatorResponse toDTO(co.edu.unicauca.coordinatorservice.entities.Coordinator coordinator) {
        return new CoordinatorResponse(
                coordinator.getId(),
                coordinator.getCode(),
                coordinator.getName(),
                coordinator.getPhone(),
                coordinator.getEmail(),
                coordinator.getDegreeProgram(),
                coordinator.getStatus()
        );
    }

    public Coordinator toEntity(CoordinatorRequest coordinatorRequest) {
        return new Coordinator(
                coordinatorRequest.getCode(),
                coordinatorRequest.getName(),
                coordinatorRequest.getPhone(),
                coordinatorRequest.getEmail(),
                coordinatorRequest.getDegreeProgram()
        );
    }

}
