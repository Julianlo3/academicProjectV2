package com.projectMicroservice.presentation.DTO;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ProjectCommentDTO {
    private Long id;
    private Long projectId;
    private Long coordinatorCode;
    private String comment;
    private String newState;
    private LocalDateTime timestamp;

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

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

    public String getNewState() {
        return newState;
    }

    public void setNewState(String newState) {
        this.newState = newState;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
