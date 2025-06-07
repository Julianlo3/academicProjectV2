/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.academicproject.entities;



import com.toedter.calendar.JDateChooser;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *
 * @author anvig
 */
public class Project {

     private long companyNit;
     private String name,summary,objectives,description;
     private int maxDurationInMonths;
     private LocalDate startDate;
     private BigDecimal budget;
     private int academicYear;
     private int academicTerm;
     private String state;
     private Long projectId;

    public Project(){}

    public Project(long companyNit, String name, String summary, String objectives, String description, int maxDurationInMonths, LocalDate startDate, BigDecimal budget, int academicYear, int academicTerm) {
        this.companyNit = companyNit;
        this.name = name;
        this.summary = summary;
        this.objectives = objectives;
        this.description = description;
        this.maxDurationInMonths = maxDurationInMonths;
        this.startDate = startDate;
        this.budget = budget;
        this.academicYear = academicYear;
        this.academicTerm = academicTerm;
    }

    public Long getprojectId() {
        return projectId;
    }

    public void setprojectId(Long id) {
        this.projectId = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public String getObjectives() {
        return objectives;
    }

    public void setObjectives(String objectives) {
        this.objectives = objectives;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxDurationInMonths() {
        return maxDurationInMonths;
    }

    public void setMaxDurationInMonths(int maxDurationInMonths) {
        this.maxDurationInMonths = maxDurationInMonths;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getCompanyNit() {
        return companyNit;
    }

    public void setCompanyNit(long companyNit) {
        this.companyNit = companyNit;
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
}
