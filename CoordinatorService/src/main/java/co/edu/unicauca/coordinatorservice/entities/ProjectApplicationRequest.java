package co.edu.unicauca.coordinatorservice.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ProjectApplicationRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long studentCode;
    private Long projectId;
    @Enumerated(EnumType.STRING)
    private ApplicationStatus status;
    private LocalDateTime timestamp;

    public ProjectApplicationRequest() {}

    public ProjectApplicationRequest(Long studentCode, Long projectId, ApplicationStatus status, LocalDateTime timestamp) {
        this.studentCode = studentCode;
        this.projectId = projectId;
        this.status = status;
        this.timestamp = timestamp;
    }

    // Getters and Setters

    public Long getId() {
        return id;
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
