package com.projectMicroservice.domain.valueObject;

import java.time.LocalDate;
import java.util.Objects;

public class ProjectTimeline {

    private final int maxDurationInMonths;
    private final LocalDate startDate;

    public ProjectTimeline(int maxDurationInMonths, LocalDate startDate) {
        if (maxDurationInMonths <= 0) {
            throw new IllegalArgumentException("The maximum duration must be greater than zero.");
        }
        this.maxDurationInMonths = maxDurationInMonths;
        this.startDate = Objects.requireNonNull(startDate);
    }

    public int getMaxDurationInMonths() {
        return maxDurationInMonths;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProjectTimeline)) return false;
        ProjectTimeline that = (ProjectTimeline) o;
        return maxDurationInMonths == that.maxDurationInMonths &&
                startDate.equals(that.startDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maxDurationInMonths, startDate);
    }
}