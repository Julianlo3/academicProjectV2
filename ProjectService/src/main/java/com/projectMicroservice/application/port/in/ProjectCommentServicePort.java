package com.projectMicroservice.application.port.in;

import com.projectMicroservice.presentation.DTO.CreateProjectCommentDTO;
import com.projectMicroservice.presentation.DTO.ProjectCommentDTO;

import java.util.List;

public interface ProjectCommentServicePort {
    void createComment(Long projectId, CreateProjectCommentDTO dto);
    List<ProjectCommentDTO> getCommentsByProject(Long projectId);
}
