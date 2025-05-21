package com.projectMicroservice.application.port.in;

import com.projectMicroservice.domain.model.Project;

public interface ProjectServicePort {

    Project createProject(Project project);
    void approveProject(Long projectId) throws Exception;
    void rejectProject(Long projectId) throws Exception;
    void assignProject(Long projectId) throws Exception;
    void completeProject(Long projectId) throws Exception;

    void editProjectDetails(Long projectId, String title, String description, int durationWeeks) throws Exception;
    void updateRequirements(Long projectId, int semester, String skills) throws Exception;
    void updateTechnologyStack(Long projectId, java.util.List<String> stack) throws Exception;
}
