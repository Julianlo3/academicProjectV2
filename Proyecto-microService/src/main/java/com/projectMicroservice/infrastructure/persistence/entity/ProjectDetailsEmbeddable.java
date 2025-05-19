package com.projectMicroservice.infrastructure.persistence.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class ProjectDetailsEmbeddable {

    private String title;
    private String description;
    private int estimatedDurationWeeks;

    public ProjectDetailsEmbeddable(String title, String description, int estimatedDurationWeeks) {
        this.title = title;
        this.description = description;
        this.estimatedDurationWeeks = estimatedDurationWeeks;
    }

    public ProjectDetailsEmbeddable() {

    }

    // Getters y setters
    public String getTitle() {
         return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getEstimatedDurationWeeks() {
        return estimatedDurationWeeks;
    }

    public void setEstimatedDurationWeeks(int estimatedDurationWeeks) {
        this.estimatedDurationWeeks = estimatedDurationWeeks;
    }
}
