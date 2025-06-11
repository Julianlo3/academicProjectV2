package co.edu.unicauca.coordinatorservice.infra.dto;

public class CreateProjectCommentDTO {
    private Long coordinatorCode;
    private String comment;

    public CreateProjectCommentDTO(Long coordinatorCode, String comment) {
        this.coordinatorCode = coordinatorCode;
        this.comment = comment;
    }

    // Getters y setters
    public Long getCoordinatorCode() {
        return coordinatorCode;
    }

    public void setCoordinatorCode(Long coordinatorCode) {
        this.coordinatorCode = coordinatorCode;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}
