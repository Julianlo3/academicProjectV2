package co.edu.unicauca.academicproject.entities;


/**
 * @author lopez
 * @date 8/06/2025
 */
public class Assignment {

    private long id;
    private Student student;
    private Long projectId;

    public Assignment(Long id,Student student, Long projectId) {
        this.id = id;
        this.student = student;
        this.projectId = projectId;
    }

    public Assignment() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }
}
