package com.academic_projects_prototype.companyMicroservice.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "publish_project")
public class PublishProject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Generación del ID único automáticamente
    private Long id;

    @Column(name = "project_id", nullable = false) // Relación con el microservicio de proyectos
    private Long projectId;

    @Column(name = "company_id", nullable = false) // Nueva columna para relacionar con la empresa
    private Long companyId;

    @Column(name = "title", nullable = false, length = 255)
    private String title; // Título del proyecto

    @Column(name = "description", nullable = false, length = 2000)
    private String description; // Descripción detallada del proyecto

    @Enumerated(EnumType.STRING) // Indica que el estado es un ENUM
    @Column(name = "project_status", nullable = false)
    private ProjectStatus projectStatus; // Estado actual del proyecto

    // Constructor sin argumentos (necesario para JPA)
    public PublishProject() {
    }

    // Constructor con argumentos
    public PublishProject(Long projectId, String title, String description, ProjectStatus projectStatus) {
        this.projectId = projectId;
        this.title = title;
        this.description = description;
        this.projectStatus = projectStatus;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
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

    public ProjectStatus getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(ProjectStatus projectStatus) {
        this.projectStatus = projectStatus;
    }

}
