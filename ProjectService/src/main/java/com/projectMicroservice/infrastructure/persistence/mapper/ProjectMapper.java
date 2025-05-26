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
        entity.setBudget(project.getBudget());

        // Value Objects → Embeddables
        entity.setDetails(toDetailsEmbeddable(project.getDetails()));
        entity.setAcademicPeriod(toAcademicPeriodEmbeddable(project.getAcademicPeriod()));
        entity.setTimeline(toTimelineEmbeddable(project.getTimeline()));

        // Estado como String
        entity.setCurrentState(project.getState().getClass().getSimpleName());

        return entity;
    }

    public Project toDomain(ProjectEntity entity) {
        return Project.create(
                entity.getProjectId(),
                entity.getCompanyNit(),
                toDetailsValueObject(entity.getDetails()),
                toTimelineValueObject(entity.getTimeline()),
                entity.getBudget(),
                toAcademicPeriodValueObject(entity.getAcademicPeriod()),
                resolveStateFromString(entity.getCurrentState())
        );
    }

    // Métodos auxiliares de conversión

    private ProjectDetailsEmbeddable toDetailsEmbeddable(ProjectDetails details) {
        ProjectDetailsEmbeddable emb = new ProjectDetailsEmbeddable();
        emb.setName(details.getName());
        emb.setSummary(details.getSummary());
        emb.setObjectives(details.getObjectives());
        emb.setDescription(details.getDescription());
        return emb;
    }

    private ProjectDetails toDetailsValueObject(ProjectDetailsEmbeddable emb) {
        return new ProjectDetails(
                emb.getName(),
                emb.getSummary(),
                emb.getObjectives(),
                emb.getDescription()
        );
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

    private ProjectTimelineEmbeddable toTimelineEmbeddable(ProjectTimeline timeline) {
        ProjectTimelineEmbeddable emb = new ProjectTimelineEmbeddable();
        emb.setMaxDurationInMonths(timeline.getMaxDurationInMonths());
        emb.setStartDate(timeline.getStartDate());
        return emb;
    }

    private ProjectTimeline toTimelineValueObject(ProjectTimelineEmbeddable emb) {
        return new ProjectTimeline(emb.getMaxDurationInMonths(), emb.getStartDate());
    }

    private IProjectState resolveStateFromString(String stateName) {
        return switch (stateName) {
            case "Received" -> new Received();
            case "Approved" -> new Approved();
            case "Rejected" -> new Rejected();
            case "Assigned" -> new Assigned();
            case "Completed" -> new Completed();
            default -> throw new IllegalArgumentException("State not recognized: " + stateName);
        };
    }
}