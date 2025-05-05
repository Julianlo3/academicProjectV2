package com.projectMicroservice.infra;

/**
 * DTO para ofrecer información cuando otros micros necesiten detalles de un proyecto
 */
public class ProjectResponseDTO {
    private Long id;
    private String title;
    private String description;
    private String companyNit;
    private String status;

    public ProjectResponseDTO() {}

    public ProjectResponseDTO(Long id, String title, String description, String companyId, String status) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.companyNit = companyId;
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

    public String getCompanyNit() {
        return companyNit;
    }

    public void setCompanyNit(String companyNit) {
        this.companyNit = companyNit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
