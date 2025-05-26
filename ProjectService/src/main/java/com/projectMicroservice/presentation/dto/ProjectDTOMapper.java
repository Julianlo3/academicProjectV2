package com.projectMicroservice.presentation.dto;

import com.projectMicroservice.domain.model.Project;
import com.projectMicroservice.domain.state.Received;
import com.projectMicroservice.domain.state.Rejected;
import com.projectMicroservice.domain.valueObject.*;

import org.springframework.stereotype.Component;

@Component
public class ProjectDTOMapper {

    public Project toDomain(ProjectDTO dto) {
        ProjectDetails details = new ProjectDetails(
                dto.getName(),
                dto.getSummary(),
                dto.getObjectives(),
                dto.getDescription()
        );

        ProjectTimeline timeline = new ProjectTimeline(
                dto.getMaxDurationInMonths(),
                dto.getStartDate()
        );

        AcademicPeriod academicPeriod = new AcademicPeriod(
                dto.getAcademicYear(),
                dto.getAcademicTerm()
        );

        return Project.create(
                dto.getProjectId(),
                dto.getCompanyNit(),
                details,
                timeline,
                dto.getBudget(),
                academicPeriod,
                new Received() // Estado inicial
        );
    }

    public ProjectDTO toDto(Project project) {
        ProjectDTO dto = new ProjectDTO();
        dto.setProjectId(project.getProjectId());
        dto.setCompanyNit(project.getCompanyNit());

        dto.setName(project.getDetails().getName());
        dto.setSummary(project.getDetails().getSummary());
        dto.setObjectives(project.getDetails().getObjectives());
        dto.setDescription(project.getDetails().getDescription());

        dto.setMaxDurationInMonths(project.getTimeline().getMaxDurationInMonths());
        dto.setStartDate(project.getTimeline().getStartDate());

        dto.setBudget(project.getBudget());

        dto.setAcademicYear(project.getAcademicPeriod().getYear());
        dto.setAcademicTerm(project.getAcademicPeriod().getTerm());

        dto.setState(project.getState().getClass().getSimpleName());

        return dto;
    }
}

