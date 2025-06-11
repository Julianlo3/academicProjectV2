package co.edu.unicauca.studentservice.infra.dto;

import java.time.LocalDateTime;

public class AssignmentResponseDTO {
    private Long id;
    private Long studentCode;
    private Long projectId;
    private LocalDateTime dateAssignment;

    public AssignmentResponseDTO(Long id, Long studentCode, Long projectId, LocalDateTime dateAssignment){
        this.id = id;
        this.studentCode = studentCode;
        this.projectId = projectId;
        this.dateAssignment = dateAssignment;
    }

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

    public LocalDateTime getDateAssignment() {
        return dateAssignment;
    }

    public void setDateAssignment(LocalDateTime dateAssignment) {
        this.dateAssignment = dateAssignment;
    }
}
