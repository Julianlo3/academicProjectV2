package co.edu.unicauca.gestioncoordinadormicroservice.entities;

import jakarta.persistence.*;

@Entity
public class ProjectToApprove {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long internalId; // ID interno para nuestra tabla

    private Long externalId; // ID original del proyecto que viene desde empresa
    private String title;
    private String description;
    private String companyName;

    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status {
        PENDING,
        APPROVED,
        REJECTED
    }

    public ProjectToApprove() {
    }

    // Getters y setters
    public Long getInternalId() {
        return internalId;
    }

    public void setInternalId(Long internalId) {
        this.internalId = internalId;
    }

    public Long getExternalId() {
        return externalId;
    }

    public void setExternalId(Long externalId) {
        this.externalId = externalId;
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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}