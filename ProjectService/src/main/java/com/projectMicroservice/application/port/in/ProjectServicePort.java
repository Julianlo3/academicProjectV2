package com.projectMicroservice.application.port.in;

import com.projectMicroservice.domain.model.Project;
import com.projectMicroservice.domain.model.ProjectComment;
import com.projectMicroservice.domain.valueObject.ProjectDetails;
import com.projectMicroservice.domain.valueObject.ProjectTimeline;
import com.projectMicroservice.presentation.DTO.CreateProjectCommentDTO;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface ProjectServicePort {

    Project createProject(Project project);
    void approveProject(Long projectId, ProjectComment projectComment) throws Exception;
    void rejectProject(Long projectId, ProjectComment projectComment) throws Exception;
    void assignProject(Long projectId, ProjectComment projectComment) throws Exception;
    void completeProject(Long projectId, ProjectComment projectComment) throws Exception;

    void editProjectDetails(Long projectId, String name, String summary, String objectives, String description) throws Exception;
    void editProjectTimeline(Long projectId, int maxDurationInMonths, LocalDate startDate) throws Exception;
    void editProjectBudget(Long projectId, BigDecimal newBudget) throws Exception;
}
