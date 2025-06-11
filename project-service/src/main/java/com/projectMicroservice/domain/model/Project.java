package com.projectMicroservice.domain.model;

import com.projectMicroservice.domain.state.IProjectState;
import com.projectMicroservice.domain.valueObject.*;

import java.math.BigDecimal;
import java.util.Objects;

public class Project {

    private final Long projectId;
    private final Long companyNit;

    private ProjectDetails details;           // name, summary, objectives, description
    private ProjectTimeline timeline;         // max duration, date
    private AcademicPeriod academicPeriod;    // periodo academico
    private BigDecimal budget;                // presupuesto

    private IProjectState state;

    private Project(Long projectId,
                    Long companyNit,
                    ProjectDetails details,
                    ProjectTimeline timeline,
                    BigDecimal budget,
                    AcademicPeriod academicPeriod,
                    IProjectState state) {

        this.projectId = projectId;
        this.companyNit = companyNit;
        this.details = details;
        this.timeline = timeline;
        this.budget = budget;
        this.academicPeriod = academicPeriod;
        this.state = state;
    }

    // Fábrica estática
    public static Project create(Long projectId,
                                 Long companyNit,
                                 ProjectDetails details,
                                 ProjectTimeline timeline,
                                 BigDecimal budget,
                                 AcademicPeriod academicPeriod,
                                 IProjectState initialState) {
        return new Project(projectId, companyNit, details, timeline, budget, academicPeriod, initialState);
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

    // Modificaciones permitidas a través del estado
    public void editDetails(ProjectDetails newDetails) throws Exception {
        state.editDetails(this, newDetails);
    }

    public void editTimeline(ProjectTimeline newTimeline) throws Exception {
        state.editTimeline(this, newTimeline);
    }

    public void editBudget(BigDecimal newBudget) throws Exception {
        state.editBudget(this, newBudget);
    }

    // Métodos usados por los estados para aplicar cambios
    public void applyDetailsChange(ProjectDetails details) {
        this.details = Objects.requireNonNull(details);
    }

    public void applyTimelineChange(ProjectTimeline timeline) {
        this.timeline = Objects.requireNonNull(timeline);
    }

    public void applyBudgetChange(BigDecimal budget) {
        this.budget = Objects.requireNonNull(budget);
    }

    public void changeState(IProjectState newState) {
        this.state = newState;
    }

    // Getters
    public Long getProjectId() {
        return projectId;
    }

    public Long getCompanyNit() {
        return companyNit;
    }

    public ProjectDetails getDetails() {
        return details;
    }

    public ProjectTimeline getTimeline() {
        return timeline;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public AcademicPeriod getAcademicPeriod() {
        return academicPeriod;
    }

    public IProjectState getState() {
        return state;
    }
}
