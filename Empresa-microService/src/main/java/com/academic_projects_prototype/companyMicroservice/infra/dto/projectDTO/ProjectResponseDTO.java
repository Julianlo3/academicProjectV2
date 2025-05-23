package com.academic_projects_prototype.companyMicroservice.infra.dto.projectDTO;

/**
 * DTO para ofrecer información cuando otros micros necesiten detalles de un proyecto
 */
public class ProjectResponseDTO {
    private Long id;
    private String title;
    private String description;
    private String status;

    public ProjectResponseDTO() {}

    public ProjectResponseDTO(Long id, String title, String description, String status) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
