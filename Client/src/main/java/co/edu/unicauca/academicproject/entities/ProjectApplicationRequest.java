package co.edu.unicauca.academicproject.entities;


import java.time.LocalDateTime;

/**
 * @author lopez
 * @date 7/06/2025
 */
public class ProjectApplicationRequest {

    private Long id;
    private Long studentCode;
    private Long projectId;
    private String status;
    private LocalDateTime timestamp;

    public ProjectApplicationRequest(Long id,Long studentCode, Long projectId, String status, LocalDateTime timestamp) {
        this.id = id;
        this.studentCode = studentCode;
        this.projectId = projectId;
        this.status = status;
        this.timestamp = timestamp;
    }

    public ProjectApplicationRequest(){
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}


