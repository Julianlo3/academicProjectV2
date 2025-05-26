package com.projectMicroservice.infrastructure.persistence.entity;

import jakarta.persistence.Embeddable;

import java.time.LocalDate;

@Embeddable
public class ProjectTimelineEmbeddable {

    private int maxDurationInMonths;
    private LocalDate startDate;

    public ProjectTimelineEmbeddable(int maxDurationInMonths, LocalDate startDate) {
        this.maxDurationInMonths = maxDurationInMonths;
        this.startDate = startDate;
    }

    public ProjectTimelineEmbeddable() {

    }

    public int getMaxDurationInMonths() {
        return maxDurationInMonths;
    }

    public void setMaxDurationInMonths(int maxDurationInMonths) {
        this.maxDurationInMonths = maxDurationInMonths;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
}
