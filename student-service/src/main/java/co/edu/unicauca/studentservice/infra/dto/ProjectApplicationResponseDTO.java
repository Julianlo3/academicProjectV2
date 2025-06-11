package co.edu.unicauca.studentservice.infra.dto;

import java.time.LocalDateTime;

public class ProjectApplicationResponseDTO {
    private Long id;
    private Long studentCode;
    private Long projectId;
    private ApplicationStatus status;
    private LocalDateTime timestamp;

    public ProjectApplicationResponseDTO() {}

    public ProjectApplicationResponseDTO(Long id, Long studentCode, Long projectId, ApplicationStatus status, LocalDateTime timestamp) {
        this.id = id;
        this.studentCode = studentCode;
        this.projectId = projectId;
        this.status = status;
        this.timestamp = timestamp;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(Long studentCode) {
        this.studentCode = studentCode;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public ApplicationStatus getStatus() {
        return status;
    }

    public void setStatus(ApplicationStatus status) {
        this.status = status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
