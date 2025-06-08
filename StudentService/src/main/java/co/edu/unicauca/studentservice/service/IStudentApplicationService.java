package co.edu.unicauca.studentservice.service;

import co.edu.unicauca.studentservice.infra.dto.ProjectApplicationResponseDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IStudentApplicationService {
    @Transactional
    void applyToProject(Long studentCode, Long projectId);

}
