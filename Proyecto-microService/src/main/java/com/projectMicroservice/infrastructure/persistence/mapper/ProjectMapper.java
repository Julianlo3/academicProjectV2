package com.projectMicroservice.infrastructure.persistence.mapper;

import com.projectMicroservice.domain.model.Project;
import com.projectMicroservice.domain.state.*;
import com.projectMicroservice.domain.valueObject.*;
import com.projectMicroservice.infrastructure.persistence.entity.*;
import org.springframework.stereotype.Component;

@Component
public class ProjectMapper {

    public ProjectEntity toEntity(Project project) {
        ProjectEntity entity = new ProjectEntity();
        entity.setProjectId(project.getProjectId());
        entity.setCompanyNit(project.getCompanyNit());

        // Value Objects → Embeddables
        entity.setDetails(toDetailsEmbeddable(project.getDetails()));
        entity.setAcademicPeriod(toAcademicPeriodEmbeddable(project.getAcademicPeriod()));
        entity.setRequirements(toRequirementsEmbeddable(project.getRequirements()));
        entity.setTechnologyStack(project.getTechnologyStack().getTechnologies());

        // Estado como String
        entity.setCurrentState(project.getState().getClass().getSimpleName());

        return entity;
    }

    public Project toDomain(ProjectEntity entity) {
        return Project.create(
                entity.getProjectId(),
                entity.getCompanyNit(),
                toDetailsValueObject(entity.getDetails()),
                toAcademicPeriodValueObject(entity.getAcademicPeriod()),
                new TechnologyStack(entity.getTechnologyStack()),
                toRequirementsValueObject(entity.getRequirements()),
                resolveStateFromString(entity.getCurrentState())
        );
    }

    // Métodos auxiliares de conversión

    private ProjectDetailsEmbeddable toDetailsEmbeddable(ProjectDetails details) {
        ProjectDetailsEmbeddable emb = new ProjectDetailsEmbeddable();
        emb.setTitle(details.getTitle());
        emb.setDescription(details.getDescription());
        emb.setEstimatedDurationWeeks(details.getEstimatedDurationWeeks());
        return emb;
    }

    private ProjectDetails toDetailsValueObject(ProjectDetailsEmbeddable emb) {
        return new ProjectDetails(emb.getTitle(), emb.getDescription(), emb.getEstimatedDurationWeeks());
    }

    private AcademicPeriodEmbeddable toAcademicPeriodEmbeddable(AcademicPeriod period) {
        AcademicPeriodEmbeddable emb = new AcademicPeriodEmbeddable();
        emb.setYear(period.getYear());
        emb.setTerm(period.getTerm());
        return emb;
    }

    private AcademicPeriod toAcademicPeriodValueObject(AcademicPeriodEmbeddable emb) {
        return new AcademicPeriod(emb.getYear(), emb.getTerm());
    }

    private ProjectRequirementsEmbeddable toRequirementsEmbeddable(ProjectRequirements req) {
        ProjectRequirementsEmbeddable emb = new ProjectRequirementsEmbeddable();
        emb.setMinimumSemester(req.getMinimumSemester());
        emb.setRequiredSkills(req.getRequiredSkills());
        return emb;
    }

    private ProjectRequirements toRequirementsValueObject(ProjectRequirementsEmbeddable emb) {
        return new ProjectRequirements(emb.getMinimumSemester(), emb.getRequiredSkills());
    }

    private IProjectState resolveStateFromString(String stateName) {
        return switch (stateName) {
            case "Pending" -> new Pending();
            case "Approved" -> new Approved();
            case "Rejected" -> new Rejected();
            case "Assigned" -> new Assigned();
            case "Completed" -> new Completed();
            default -> throw new IllegalArgumentException("State not recognized: " + stateName);
        };
    }
}