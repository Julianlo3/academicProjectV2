package co.edu.unicauca.studentservice.service;

import org.springframework.transaction.annotation.Transactional;

public interface IStudentApplicationService {
    @Transactional
    void applyToProject(Long studentCode, Long projectId);
}
