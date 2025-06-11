package co.edu.unicauca.coordinatorservice.infra.dto;

public class AssignmentRequestDTO {
    private Long studentCode;
    private Long projectId;

    public AssignmentRequestDTO() {}

    public AssignmentRequestDTO(Long studentCode, Long projectId) {
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
