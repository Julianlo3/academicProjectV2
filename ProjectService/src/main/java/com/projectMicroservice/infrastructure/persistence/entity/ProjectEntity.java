package com.projectMicroservice.infrastructure.persistence.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "project")
public class ProjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectId;

    private Long companyNit;

    private BigDecimal budget;

    @Embedded
    private ProjectDetailsEmbeddable details;

    @Embedded
    private AcademicPeriodEmbeddable academicPeriod;

    @Embedded
    private ProjectTimelineEmbeddable timeline;

    @Column(name = "state")
    private String currentState; // Guarda el nombre del estado, ej: "Pending", "Approved"

    // Getters y Setters
    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getCompanyNit() {
        return companyNit;
    }

    public void setCompanyNit(Long companyNit) {
        this.companyNit = companyNit;
    }

    public ProjectDetailsEmbeddable getDetails() {
        return details;
    }

    public void setDetails(ProjectDetailsEmbeddable details) {
        this.details = details;
    }

    public AcademicPeriodEmbeddable getAcademicPeriod() {
        return academicPeriod;
    }

    public void setAcademicPeriod(AcademicPeriodEmbeddable academicPeriod) {
        this.academicPeriod = academicPeriod;
    }

    public ProjectTimelineEmbeddable getTimeline() {
        return timeline;
    }

    public void setTimeline(ProjectTimelineEmbeddable timeline) {
        this.timeline = timeline;
    }

    public String getCurrentState() {
        return currentState;
    }

    public void setCurrentState(String currentState) {
        this.currentState = currentState;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }
}
