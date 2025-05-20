package com.projectMicroservice.infraestructure;

import com.projectMicroservice.domain.model.ProjectStatus;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

/**
 * DTO para manejar las solicitudes entrantes (ejm: una empresa crea un proyecto)
 */
public class ProjectRequestDTO {

    @NotEmpty(message = "El título no puede estar vacío.")
    private String title;

    @NotEmpty(message = "La descripción no puede estar vacía.")
    private String description;

    @NotEmpty(message = "El nit de la empresa no puede estar vacío.")
    private String companyNit   ;

    @NotNull(message = "El estado no puede ser nulo.")
    private ProjectStatus status;

    public ProjectRequestDTO() {}

    public ProjectRequestDTO(String title, String description, ProjectStatus status) {
        this.title = title;
        this.description = description;
        this.status = status;
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
}
