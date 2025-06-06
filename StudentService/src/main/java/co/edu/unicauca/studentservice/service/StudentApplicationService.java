package co.edu.unicauca.studentservice.service;

import co.edu.unicauca.studentservice.infra.client.CoordinatorClient;
import co.edu.unicauca.studentservice.infra.dto.ProjectApplicationRequestDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentApplicationService implements IStudentApplicationService {

    private final CoordinatorClient coordinatorClient;

    public StudentApplicationService(CoordinatorClient coordinatorClient) {
        this.coordinatorClient = coordinatorClient;
    }

    @Transactional
    public void applyToProject(Long studentCode, Long projectId) {
        ProjectApplicationRequestDTO request = new ProjectApplicationRequestDTO(studentCode, projectId);
        coordinatorClient.submitProjectApplication(request);
    }
}
