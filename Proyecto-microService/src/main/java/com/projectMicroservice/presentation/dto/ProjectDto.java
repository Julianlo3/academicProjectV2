package com.projectMicroservice.presentation.dto;

import java.util.List;

public class ProjectDto {
    private Long projectId;
    private Long companyNit;

    private String title;
    private String description;
    private int durationWeeks;

    private int academicYear;
    private int academicTerm;

    private List<String> technologyStack;
    private int minimumSemester;
    private String requiredSkills;

    private String currentState;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDurationWeeks() {
        return durationWeeks;
    }

    public void setDurationWeeks(int durationWeeks) {
        this.durationWeeks = durationWeeks;
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

    public List<String> getTechnologyStack() {
        return technologyStack;
    }

    public void setTechnologyStack(List<String> technologyStack) {
        this.technologyStack = technologyStack;
    }

    public int getMinimumSemester() {
        return minimumSemester;
    }

    public void setMinimumSemester(int minimumSemester) {
        this.minimumSemester = minimumSemester;
    }

    public String getRequiredSkills() {
        return requiredSkills;
    }

    public void setRequiredSkills(String requiredSkills) {
        this.requiredSkills = requiredSkills;
    }

    public String getCurrentState() {
        return currentState;
    }

    public void setCurrentState(String currentState) {
        this.currentState = currentState;
    }
}
