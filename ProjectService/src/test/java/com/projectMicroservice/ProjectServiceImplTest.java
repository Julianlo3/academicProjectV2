package com.projectMicroservice;

import com.projectMicroservice.adapter.in.rest.ProjectServiceImpl;
import com.projectMicroservice.application.port.out.ProjectCommentRepositoryPort;
import com.projectMicroservice.application.port.out.ProjectRepositoryPort;
import com.projectMicroservice.domain.model.Project;
import com.projectMicroservice.domain.model.ProjectComment;
import com.projectMicroservice.domain.state.IProjectState;
import com.projectMicroservice.domain.state.Received;
import com.projectMicroservice.domain.valueObject.AcademicPeriod;
import com.projectMicroservice.domain.valueObject.ProjectDetails;
import com.projectMicroservice.domain.valueObject.ProjectTimeline;
import com.projectMicroservice.presentation.DTO.CreateProjectCommentDTO;
import com.projectMicroservice.presentation.mapper.ProjectCommentDTOMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProjectServiceImplTest {

    @Mock
    private ProjectRepositoryPort projectRepository;

    @Mock
    private ProjectCommentRepositoryPort commentRepository;

    @InjectMocks
    private ProjectServiceImpl projectService;

    private ProjectCommentDTOMapper projectCommentDTOMapper;

    @Test
    void createProject_shouldSaveProjectAndReturnIt() {
        // Arrange
        Long companyNit = 21564862321L;
        String stateName = "Created";

        // Dominio
        ProjectDetails details = new ProjectDetails(
                "Sistema de Gestión Académica",
                "Resumen del sistema",
                "Objetivo general del sistema",
                "Este sistema permitirá gestionar cursos, profesores y estudiantes."
        );

        ProjectTimeline timeline = new ProjectTimeline(5, LocalDate.of(2025, 8, 1));

        BigDecimal budget = new BigDecimal("7500.00");

        AcademicPeriod academicPeriod = new AcademicPeriod(2025, 2);

        IProjectState initialState = new Received();

        Project projectToSave = Project.create(
                10L, companyNit, details, timeline, budget, academicPeriod, initialState
        );

        Project savedProject = Project.create(
                10L, companyNit, details, timeline, budget, academicPeriod, initialState
        );

        // Simula el comportamiento del repositorio
        when(projectRepository.save(any(Project.class))).thenReturn(savedProject);

        // Act
        Project result = projectService.createProject(projectToSave);

        // Assert
        assertNotNull(result);
        assertEquals(10L, result.getProjectId());
        assertEquals("Sistema de Gestión Académica", result.getDetails().getName());
        assertEquals("Resumen del sistema", result.getDetails().getSummary());
        assertEquals("Objetivo general del sistema", result.getDetails().getObjectives());
        assertEquals("Este sistema permitirá gestionar cursos, profesores y estudiantes.", result.getDetails().getDescription());
        assertEquals("Received", result.getState().getClass().getSimpleName());

        verify(projectRepository).save(any(Project.class));
    }

    @Test
    void approveProject_shouldChangeStateToApproved() throws Exception {
        // Arrange
        Long projectId = 1L;
        Project projectMock = mock(Project.class);

        ProjectComment comment = mock(ProjectComment.class);

        when(projectRepository.findById(projectId)).thenReturn(Optional.of(projectMock));

        // Act
        projectService.approveProject(projectId, comment);

        // Assert
        verify(projectMock).approve();
        verify(projectRepository).save(projectMock);
    }

    @Test
    void rejectProject_shouldChangeStateToRejected() throws Exception {
        Long projectId = 2L;
        Project projectMock = mock(Project.class);

        ProjectComment comment = mock(ProjectComment.class);

        when(projectRepository.findById(projectId)).thenReturn(Optional.of(projectMock));

        projectService.rejectProject(projectId, comment);

        verify(projectMock).reject();
        verify(projectRepository).save(projectMock);
    }

    @Test
    void assignProject_shouldChangeStateToAssigned() throws Exception {
        Long projectId = 3L;
        Project projectMock = mock(Project.class);
        when(projectRepository.findById(projectId)).thenReturn(Optional.of(projectMock));

        projectService.assignProject(projectId);

        verify(projectMock).assign();
        verify(projectRepository).save(projectMock);
    }

    @Test
    void completeProject_shouldChangeStateToCompleted() throws Exception {
        Long projectId = 4L;
        Project projectMock = mock(Project.class);
        when(projectRepository.findById(projectId)).thenReturn(Optional.of(projectMock));

        projectService.completeProject(projectId);

        verify(projectMock).complete();
        verify(projectRepository).save(projectMock);
    }

    @Test
    void approveProject_shouldThrowException_whenProjectNotFound() {
        Long projectId = 99L;
        ProjectComment comment = mock(ProjectComment.class);
        when(projectRepository.findById(projectId)).thenReturn(Optional.empty());

        Exception exception = assertThrows(Exception.class, () -> {
            projectService.approveProject(projectId, comment);
        });

        assertEquals("Project not found with ID: 99", exception.getMessage());
    }

    @Test
    void rejectProject_shouldThrowException_whenStateRejectFails() throws Exception {
        Long projectId = 1L;
        ProjectComment comment = mock(ProjectComment.class);
        Project projectMock = mock(Project.class);
        when(projectRepository.findById(projectId)).thenReturn(Optional.of(projectMock));
        doThrow(new IllegalStateException("Cannot reject an already approved project"))
                .when(projectMock).reject();

        Exception exception = assertThrows(IllegalStateException.class, () -> {
            projectService.rejectProject(projectId, comment);
        });

        assertEquals("Cannot reject an already approved project", exception.getMessage());
    }

    @Test
    void editProjectDetails_shouldThrowException_whenInvalidDuration() {
        Long projectId = 1L;
        when(projectRepository.findById(projectId)).thenReturn(Optional.of(mock(Project.class)));

        Exception exception = assertThrows(Exception.class, () -> {
            projectService.editProjectTimeline(projectId, -5, LocalDate.of(2025, 8, 1));
        });

        assertEquals("The maximum duration must be greater than zero.", exception.getMessage());
    }

}