package co.edu.unicauca.academicproject.entities;


/**
 * @author lopez
 * @date 10/06/2025
 */
public class AssignmentRequest {
    private Long studentCode;
    private Long projectId;

    public AssignmentRequest() {}

    public AssignmentRequest(Long studentCode, Long projectId) {
        this.studentCode = studentCode;
        this.projectId = projectId;
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
}
