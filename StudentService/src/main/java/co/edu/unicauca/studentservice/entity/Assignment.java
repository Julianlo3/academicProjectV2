package co.edu.unicauca.studentservice.entity;

import co.edu.unicauca.studentservice.infra.dto.ProjectResponseDTO;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
public class Assignment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
    private Long project;
    @Transient
    private ProjectResponseDTO projectEntity; // Esto no se guarda en BD, solo en tiempo de ejecuacion (aparece en el JSON)

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAssignment;

    public Assignment(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
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

    public ProjectResponseDTO getProjectEntity() {
        return projectEntity;
    }

    public void setProjectEntity(ProjectResponseDTO projectEntity) {
        this.projectEntity = projectEntity;
    }
}
