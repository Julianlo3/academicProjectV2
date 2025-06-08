package co.edu.unicauca.coordinatorservice.services;

import co.edu.unicauca.coordinatorservice.entities.ApplicationStatus;
import co.edu.unicauca.coordinatorservice.entities.ProjectApplicationRequest;
import co.edu.unicauca.coordinatorservice.infra.client.ProjectClient;
import co.edu.unicauca.coordinatorservice.infra.client.StudentClient;
import co.edu.unicauca.coordinatorservice.infra.dto.AssignmentRequestDTO;
import co.edu.unicauca.coordinatorservice.infra.dto.ProjectApplicationRequestDTO;
import co.edu.unicauca.coordinatorservice.infra.dto.ProjectApplicationResponseDTO;
import co.edu.unicauca.coordinatorservice.repository.ProjectApplicationRequestRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectApplicationRequestService implements IProjectApplicationRequestService {

    private final ProjectApplicationRequestRepository repository;
    private final StudentClient studentClient;
    private final ProjectClient projectClient;

    public ProjectApplicationRequestService(ProjectApplicationRequestRepository repository, StudentClient studentClient, ProjectClient projectClient)  {
        this.repository = repository;
        this.studentClient = studentClient;
        this.projectClient = projectClient;
    }

    @Override
    public void createRequest(ProjectApplicationRequestDTO dto) throws Exception {
        // Validar si ya existe una solicitud para ese estudiante y proyecto
        repository.findByStudentCodeAndProjectId(dto.getStudentCode(), dto.getProjectId())
                .ifPresent(existing -> {
                    throw new IllegalStateException("Ya existe una solicitud para este estudiante y proyecto");
                });

        ProjectApplicationRequest request = new ProjectApplicationRequest(
                dto.getStudentCode(),
                dto.getProjectId(),
                ApplicationStatus.PENDING,
                LocalDateTime.now()
        );

        repository.save(request);
    }

    @Override
    public List<ProjectApplicationResponseDTO> getAllRequests() throws Exception {
        return repository.findAll().stream()
                .map(req -> new ProjectApplicationResponseDTO(
                        req.getId(),
                        req.getStudentCode(),
                        req.getProjectId(),
                        req.getStatus(),
                        req.getTimestamp()
                )).collect(Collectors.toList());
    }

    @Override
    public void acceptRequest(Long requestId) throws Exception {
        ProjectApplicationRequest request = repository.findById(requestId)
                .orElseThrow(() -> new IllegalArgumentException("Solicitud no encontrada"));

        if(request.getStatus() != ApplicationStatus.PENDING) {
            throw new IllegalAccessException("La solicitud ya fue evaluada");
        }

        request.setStatus(ApplicationStatus.ACCEPTED);
        repository.save(request);

        AssignmentRequestDTO assignmentRequestDTO = new AssignmentRequestDTO(request.getStudentCode(), request.getProjectId());
        studentClient.assignStudent(assignmentRequestDTO);

        projectClient.assignProject(request.getProjectId());
    }

    @Override
    public void rejectRequest(Long requestId) throws Exception {
        ProjectApplicationRequest request = repository.findById(requestId)
                .orElseThrow(() -> new IllegalArgumentException("Solicitud no encontrada"));

        if(request.getStatus() != ApplicationStatus.PENDING) {
            throw new IllegalAccessException("La solicitud ya fue evaluada");
        }

        request.setStatus(ApplicationStatus.REJECTED);
        repository.save(request);
    }

    @Override
    public List<ProjectApplicationResponseDTO> getRequestsByProjectId(Long projectId) throws Exception {
        return repository.findByProjectId(projectId).stream()
                .map(req -> new ProjectApplicationResponseDTO(
                        req.getId(),
                        req.getStudentCode(),
                        req.getProjectId(),
                        req.getStatus(),
                        req.getTimestamp()
                )).collect(Collectors.toList());
    }

    @Override
    public List<ProjectApplicationResponseDTO> getRequestsByStudentCode(Long studentCode) throws Exception {
        return repository.findByStudentCode(studentCode).stream()
                .map(req -> new ProjectApplicationResponseDTO(
                        req.getId(),
                        req.getStudentCode(),
                        req.getProjectId(),
                        req.getStatus(),
                        req.getTimestamp()
                )).collect(Collectors.toList());
    }

    @Override
    public List<ProjectApplicationResponseDTO> getRequestsByStatus(String status) throws Exception {
        return repository.findByStatus(ApplicationStatus.valueOf(status)).stream()
                .map(req -> new ProjectApplicationResponseDTO(
                        req.getId(),
                        req.getStudentCode(),
                        req.getProjectId(),
                        req.getStatus(),
                        req.getTimestamp()
                )).collect(Collectors.toList());
    }
}
