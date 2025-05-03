package co.edu.unicauca.studentservice.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Assignment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

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

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Date getDateAssignment() {
        return dateAssignment;
    }

    public void setDateAssignment(Date dateAssignment) {
        this.dateAssignment = dateAssignment;
    }
}
