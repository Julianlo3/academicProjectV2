package com.projectMicroservice.presentation.dto;

import com.projectMicroservice.domain.model.Project;
import com.projectMicroservice.domain.valueObject.*;
import com.projectMicroservice.domain.state.Pending;

import org.springframework.stereotype.Component;

@Component
public class ProjectDtoMapper {

    public Project toDomain(ProjectDTO dto) {
        return Project.create(
                dto.getProjectId(),
                dto.getCompanyNit(),
                new ProjectDetails(dto.getTitle(), dto.getDescription(), dto.getDurationWeeks()),
                new AcademicPeriod(dto.getAcademicYear(), dto.getAcademicTerm()),
                new TechnologyStack(dto.getTechnologyStack()),
                new ProjectRequirements(dto.getMinimumSemester(), dto.getRequiredSkills()),
                new Pending() // Al crear, el estado es Pending
        );
    }

    public ProjectDTO toDto(Project project) {
        ProjectDTO dto = new ProjectDTO();
        dto.setProjectId(project.getProjectId());
        dto.setCompanyNit(project.getCompanyNit());
        dto.setTitle(project.getDetails().getTitle());
        dto.setDescription(project.getDetails().getDescription());
        dto.setDurationWeeks(project.getDetails().getEstimatedDurationWeeks());
        dto.setAcademicYear(project.getAcademicPeriod().getYear());
        dto.setAcademicTerm(project.getAcademicPeriod().getTerm());
        dto.setTechnologyStack(project.getTechnologyStack().getTechnologies());
        dto.setMinimumSemester(project.getRequirements().getMinimumSemester());
        dto.setRequiredSkills(project.getRequirements().getRequiredSkills());
        dto.setCurrentState(project.getState().getClass().getSimpleName());
        return dto;
    }
}
