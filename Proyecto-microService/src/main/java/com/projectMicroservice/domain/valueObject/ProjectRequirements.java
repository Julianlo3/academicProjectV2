package com.projectMicroservice.domain.valueObject;

import java.util.Objects;

public class ProjectRequirements {

    private final int minimumSemester;
    private final String requiredSkills;

    public ProjectRequirements(int minimumSemester, String requiredSkills) {
        if (minimumSemester <= 0) {
            throw new IllegalArgumentException("The minimum semester must be greater than zero.");
        }
        if (requiredSkills == null || requiredSkills.isBlank()) {
            throw new IllegalArgumentException("You must specify required skills.");
        }

        this.minimumSemester = minimumSemester;
        this.requiredSkills = requiredSkills;
    }

    public int getMinimumSemester() {
        return minimumSemester;
    }

    public String getRequiredSkills() {
        return requiredSkills;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ProjectRequirements)) return false;
        ProjectRequirements other = (ProjectRequirements) o;
        return minimumSemester == other.minimumSemester &&
                requiredSkills.equals(other.requiredSkills);
    }

    @Override
    public int hashCode() {
        return Objects.hash(minimumSemester, requiredSkills);
    }
}