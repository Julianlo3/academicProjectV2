package com.projectMicroservice.domain.valueObject;

import java.util.Objects;

public class ProjectDetails {

    private final String title;
    private final String description;
    private final int estimatedDurationWeeks;

    public ProjectDetails(String title, String description, int estimatedDurationWeeks) {
        if (title == null || title.isBlank()) throw new IllegalArgumentException("The title is required.");
        if (description == null || description.isBlank()) throw new IllegalArgumentException("The description is required.");
        if (estimatedDurationWeeks <= 0) throw new IllegalArgumentException("The duration must be positive.");

        this.title = title;
        this.description = description;
        this.estimatedDurationWeeks = estimatedDurationWeeks;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getEstimatedDurationWeeks() {
        return estimatedDurationWeeks;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ProjectDetails)) return false;
        ProjectDetails other = (ProjectDetails) o;
        return title.equals(other.title)
                && description.equals(other.description)
                && estimatedDurationWeeks == other.estimatedDurationWeeks;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, estimatedDurationWeeks);
    }
}