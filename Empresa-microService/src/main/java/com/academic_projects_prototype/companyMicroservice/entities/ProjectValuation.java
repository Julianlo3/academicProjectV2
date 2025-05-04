package com.academic_projects_prototype.companyMicroservice.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "project_valuation")
public class ProjectValuation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Generación automática del ID
    private Long id;

    @Column(name = "project_id", nullable = false) // Relación con el microservicio de proyectos
    private Long projectId;

    @Column(name = "score", nullable = false)
    private Integer score; // Puntuación del proyecto, por ejemplo de 1 a 5

    @Column(name = "feedback", length = 1000)
    private String feedback; // Comentarios sobre el proyecto

    @Column(name = "created_by", nullable = false)
    private String createdBy; // Usuario o actor que valoró el proyecto

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt; // Fecha de creación de la valoración

    // Constructor sin argumentos (obligatorio para JPA)
    public ProjectValuation() {
    }

    // Constructor con argumentos
    public ProjectValuation(Long projectId, Integer score, String feedback, String createdBy, LocalDateTime createdAt) {
        this.projectId = projectId;
        this.score = score;
        this.feedback = feedback;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
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

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

}
