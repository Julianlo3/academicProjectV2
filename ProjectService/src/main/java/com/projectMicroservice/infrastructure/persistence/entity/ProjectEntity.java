package com.projectMicroservice.infrastructure.persistence.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "project")
public class ProjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectId;

    private Long companyNit;

    @Embedded
    private ProjectDetailsEmbeddable details;

    @Embedded
    private AcademicPeriodEmbeddable academicPeriod;

    @Embedded
    private ProjectRequirementsEmbeddable requirements;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "project_technologies", joinColumns = @JoinColumn(name = "project_id"))
    @Column(name = "technology")
    private List<String> technologyStack;

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

    public ProjectRequirementsEmbeddable getRequirements() {
        return requirements;
    }

    public void setRequirements(ProjectRequirementsEmbeddable requirements) {
        this.requirements = requirements;
    }

    public List<String> getTechnologyStack() {
        return technologyStack;
    }

    public void setTechnologyStack(List<String> technologyStack) {
        this.technologyStack = technologyStack;
    }

    public String getCurrentState() {
        return currentState;
    }

    public void setCurrentState(String currentState) {
        this.currentState = currentState;
    }
}
