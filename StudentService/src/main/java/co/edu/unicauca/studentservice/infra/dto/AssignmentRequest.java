package co.edu.unicauca.studentservice.infra.dto;

import java.util.Date;

public class AssignmentRequest {
    private Long id;
    private Long student;
    private Long project;
    private Date dateAssignment;

    public AssignmentRequest(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStudent() {
        return student;
    }

    public void setStudent(Long student) {
        this.student = student;
    }

    public Long getProject() {
        return project;
    }

    public void setProject(Long project) {
        this.project = project;
    }

    public Date getDateAssignment() {
        return dateAssignment;
    }

    public void setDateAssignment(Date dateAssignment) {
        this.dateAssignment = dateAssignment;
    }
}
