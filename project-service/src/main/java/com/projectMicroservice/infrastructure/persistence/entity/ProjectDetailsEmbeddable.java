package com.projectMicroservice.infrastructure.persistence.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class ProjectDetailsEmbeddable {

    private String name;
    private String summary;
    private String objectives;
    private String description;

    public ProjectDetailsEmbeddable(String name, String summary, String objectives, String description) {
        this.name = name;
        this.summary = summary;
        this.objectives = objectives;
        this.description = description;
    }

    public ProjectDetailsEmbeddable() {

    }

    // Getters y setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getObjectives() {
        return objectives;
    }

    public void setObjectives(String objectives) {
        this.objectives = objectives;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
