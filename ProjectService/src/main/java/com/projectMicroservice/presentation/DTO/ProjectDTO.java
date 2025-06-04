package com.projectMicroservice.presentation.DTO;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ProjectDTO {
    private Long projectId;
    private Long companyNit;

    private String name;
    private String summary;
    private String objectives;
    private String description;

    private int maxDurationInMonths;
    private LocalDate startDate;

    private BigDecimal budget;

    private int academicYear;
    private int academicTerm;

    private String state;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getObjectives() {
        return objectives;
    }

    public void setObjectives(String objectives) {
        this.objectives = objectives;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }

    public int getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(int academicYear) {
        this.academicYear = academicYear;
    }

    public int getAcademicTerm() {
        return academicTerm;
    }

    public void setAcademicTerm(int academicTerm) {
        this.academicTerm = academicTerm;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
