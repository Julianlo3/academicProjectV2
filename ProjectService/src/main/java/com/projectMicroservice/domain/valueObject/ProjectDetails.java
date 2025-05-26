package com.projectMicroservice.domain.valueObject;

import java.util.Objects;

public class ProjectDetails {

    private final String name;
    private final String summary;
    private final String objectives;
    private final String description;

    public ProjectDetails(String name, String summary, String objectives, String description) {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("The name is required.");
        if (summary == null || summary.isBlank()) throw new IllegalArgumentException("The summary is required.");
        if (objectives == null || objectives.isBlank()) throw new IllegalArgumentException("The objectives are required.");
        if (description == null || description.isBlank()) throw new IllegalArgumentException("The description is required.");

        this.name = name;
        this.summary = summary;
        this.objectives = objectives;
        this.description = description;

    }

    public String getName() {
        return name;
    }

    public String getSummary() {
        return summary;
    }

    public String getObjectives() {
        return objectives;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProjectDetails)) return false;
        ProjectDetails that = (ProjectDetails) o;
        return name.equals(that.name) &&
                summary.equals(that.summary) &&
                objectives.equals(that.objectives) &&
                description.equals(that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, summary, objectives, description);
    }
}