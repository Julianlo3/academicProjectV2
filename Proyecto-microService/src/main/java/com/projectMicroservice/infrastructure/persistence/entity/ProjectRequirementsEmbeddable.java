package com.projectMicroservice.infrastructure.persistence.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class ProjectRequirementsEmbeddable {

    private int minimumSemester;
    private String requiredSkills;

    public ProjectRequirementsEmbeddable(int minimumSemester, String requiredSkills) {
        this.minimumSemester = minimumSemester;
    }

    public ProjectRequirementsEmbeddable() {}

    // Getters y setters
    public int getMinimumSemester() {
        return minimumSemester;
    }

    public void setMinimumSemester(int minimumSemester) {
        this.minimumSemester = minimumSemester;
    }

    public String getRequiredSkills() {
        return requiredSkills;
    }

    public void setRequiredSkills(String requiredSkills) {
        this.requiredSkills = requiredSkills;
    }
}

