package com.projectMicroservice.presentation.DTO;

public class CreateProjectCommentDTO {
    private Long coordinatorCode;
    private String comment;

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
