package com.projectMicroservice.domain.model;

import com.projectMicroservice.domain.state.IProjectState;
import com.projectMicroservice.domain.state.PendingState;
import com.projectMicroservice.domain.valueObject.*;

import java.util.Objects;

public class Project {
    private final Long projectId;
    private final Long companyNit;

    private ProjectDetails details;
    private AcademicPeriod academicPeriod;
    private TechnologyStack technologyStack;
    private ProjectRequirements requirements;

    private IProjectState state;

    // Constructor privado: usar fábrica si deseas control centralizado
    private Project(Long projectId,
                    Long companyNit,
                    ProjectDetails details,
                    AcademicPeriod academicPeriod,
                    TechnologyStack technologyStack,
                    ProjectRequirements requirements) {

        this.projectId = projectId;
        this.companyNit = companyNit;
        this.details = details;
        this.academicPeriod = academicPeriod;
        this.technologyStack = technologyStack;
        this.requirements = requirements;
        this.state = new PendingState();
    }

    // Fábrica estática
    public static Project create(Long projectId,
                                 Long companyNit,
                                 ProjectDetails details,
                                 AcademicPeriod academicPeriod,
                                 TechnologyStack technologyStack,
                                 ProjectRequirements requirements) {
        return new Project(projectId, companyNit, details, academicPeriod, technologyStack, requirements);
    }

    // Delegación al estado actual
    public void approve() throws Exception {
        this.state.approve(this);
    }

    public void reject() throws Exception {
        this.state.reject(this);
    }

    public void assign() throws Exception {
        this.state.assign(this);
    }

    public void complete() throws Exception {
        this.state.complete(this);
    }

    // Modificadores de atributos
    public void editDetails(ProjectDetails newDetails) throws Exception {
        this.state.editDetails(this, newDetails);
    }

    public void updateRequirements(ProjectRequirements newRequirements) throws Exception {
        this.state.updateRequirements(this, newRequirements);
    }

    public void updateTechnologyStack(TechnologyStack newStack) throws Exception {
        this.state.updateTechnologyStack(this, newStack);
    }

    // Setter de estado (solo accesible por estados)
    public void changeState(IProjectState newState) {
        this.state = newState;
    }

    // Getters
    public Long getProjectId() {
        return projectId;
    }

    public Long getCompanyId() {
        return companyNit;
    }

    public ProjectDetails getDetails() {
        return details;
    }

    public AcademicPeriod getAcademicPeriod() {
        return academicPeriod;
    }

    public TechnologyStack getTechnologyStack() {
        return technologyStack;
    }

    public ProjectRequirements getRequirements() {
        return requirements;
    }

    public IProjectState getState() {
        return state;
    }

    // Métodos usados por los estados
    public void applyDetailsChange(ProjectDetails details) {
        this.details = Objects.requireNonNull(details);
    }

    public void applyRequirementsChange(ProjectRequirements requirements) {
        this.requirements = Objects.requireNonNull(requirements);
    }

    public void applyTechnologyStackChange(TechnologyStack technologyStack) {
        this.technologyStack = Objects.requireNonNull(technologyStack);
    }
}
