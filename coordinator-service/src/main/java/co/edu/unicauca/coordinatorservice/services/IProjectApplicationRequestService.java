package co.edu.unicauca.coordinatorservice.services;

import co.edu.unicauca.coordinatorservice.entities.ApplicationStatus;
import co.edu.unicauca.coordinatorservice.infra.dto.ProjectApplicationRequestDTO;
import co.edu.unicauca.coordinatorservice.infra.dto.ProjectApplicationResponseDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IProjectApplicationRequestService {
    @Transactional
    void createRequest(ProjectApplicationRequestDTO dto) throws Exception;

    @Transactional
    List<ProjectApplicationResponseDTO> getAllRequests() throws Exception;

    @Transactional
    void acceptRequest(Long requestId) throws Exception;

    @Transactional
    void rejectRequest(Long requestId) throws Exception;

    @Transactional
    List<ProjectApplicationResponseDTO> getRequestsByProjectId(Long projectId) throws Exception;

    @Transactional
    List<ProjectApplicationResponseDTO> getRequestsByStudentCode(Long studentCode) throws Exception;

    @Transactional
    List<ProjectApplicationResponseDTO> getRequestsByStatus(String status) throws Exception;
}
