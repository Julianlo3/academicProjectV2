package co.edu.unicauca.studentservice.infra.dto;

import java.util.Date;

public class AssignmentDTO {
    private Long id;
    private Long studentCode;
    private Long projectId;
    private Date dateAssignment;

    public AssignmentDTO(Long id, Long studentCode, Long projectId, Date dateAssignment){
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

    public Date getDateAssignment() {
        return dateAssignment;
    }

    public void setDateAssignment(Date dateAssignment) {
        this.dateAssignment = dateAssignment;
    }
}
