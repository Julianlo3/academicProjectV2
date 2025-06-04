package com.projectMicroservice.domain.model;

import java.time.LocalDateTime;

public class ProjectComment {

    private final Long id;
    private final Long projectId;
    private final Long coordinatorCode;
    private String comment;
    private String newStatus;
    private final LocalDateTime timestamp;

    public ProjectComment(Long id, Long projectId, Long coordinatorCode, String comment, String newStatus, LocalDateTime timestamp) {
        this.id = id;
        this.projectId = projectId;
        this.coordinatorCode = coordinatorCode;
        this.comment = comment;
        this.newStatus = newStatus;
        this.timestamp = timestamp;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public Long getProjectId() {
        return projectId;
    }

    public Long getCoordinatorCode() {
        return coordinatorCode;
    }

    public String getComment() {
        return comment;
    }

    public String getNewStatus() {
        return newStatus;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void changeStatus(String newStatus) {
        this.newStatus = newStatus;
    }
}
