package com.projectMicroservice.entities;

import com.projectMicroservice.state.IProjectState;
import com.projectMicroservice.state.PendingState;
import jakarta.persistence.*;

@Entity
@Table(name = "proyectos")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String companyNit;

    @Enumerated(EnumType.STRING)
    private ProjectStatus status;

    @Transient
    private IProjectState state;

    public Project() {
        this.state = new PendingState();
        this.status = ProjectStatus.PENDING;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getCompanyNit() {
        return companyNit;
    }

    public void setCompanyNit(String companyNit) {
        this.companyNit = companyNit;
    }

    public ProjectStatus getStatus() {
        return status;
    }

    public void setStatus(ProjectStatus status) {
        this.status = status;
    }

    public IProjectState getState() {
        return state;
    }

    public void setState(IProjectState state) {
        this.state = state;
    }
}
