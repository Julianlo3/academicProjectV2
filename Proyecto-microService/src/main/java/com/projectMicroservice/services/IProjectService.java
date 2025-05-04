package com.projectMicroservice.services;

import com.projectMicroservice.infra.ProjectRequestDTO;
import com.projectMicroservice.infra.ProjectResponseDTO;
import java.util.List;

public interface IProjectService {
    /**
     * Crear un nuevo proyecto a partir de los datos proporcionados por una empresa
     * @param projectRequestDTO Los datos del proyecto enviados en la solicitud
     * @return Un DTO que contiene los datos del proyecto creado
     */
    public ProjectResponseDTO createProject(ProjectRequestDTO projectRequestDTO);

    /**
     * Obtiene un proyecto específico por su id
     * @param projectId El id del proyecto
     * @return Un DTO con los detalles del proyecto
     */
    public ProjectResponseDTO getProjectById(Long projectId);

    /**
     * Obtiene todos los proyectos disponibles.
     * @return Una lista con todos los proyectos registrados (en formato DTO)
     */
    List<ProjectResponseDTO> getAllProjects();

    /**
     * Obtiene proyectos basados en su estado (ejm: PENDING, ACCEPTED, REJECTED)
     * @param status El estado del proyecto
     * @return Una lista de proyectos que coinciden con el estado
     */
    List<ProjectResponseDTO> getProjectsByStatus(String status);

    /**
     * Actualiza los datos de un proyecto existente
     * @param projectId El id del proyecto a actualizar
     * @param projectRequestDTO DTO con los nuevos datos del proyecto
     * @return Un DTO con los datos actualizados del proyecto
     */
    ProjectResponseDTO updateProject(Long projectId, ProjectRequestDTO projectRequestDTO);

    /**
     * Elimina un proyecto por su Id
     * @param projectId El id del proyecto que se desea eliminar
     */
    void deleteProject(Long projectId);

}
