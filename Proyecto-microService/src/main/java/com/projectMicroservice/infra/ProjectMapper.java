package com.projectMicroservice.infra;

import com.projectMicroservice.entities.Project;

public class ProjectMapper {
    /**
     * Convierte un ProjectRequestDTO a una entidad Project.
     *
     * @param dto El DTO de solicitud para crear un proyecto.
     * @return Una instancia de Project con los datos provistos en el DTO.
     */
    public static Project toEntity(ProjectRequestDTO dto) {
        Project project = new Project();
        project.setTitle(dto.getTitle());
        project.setDescription(dto.getDescription());
        return project;
    }

    /**
     * Convierte una entidad Project a un ProjectResponseDTO.
     *
     * @param project La entidad Project que se convertirá.
     * @return Un ProjectResponseDTO con los datos del proyecto.
     */
    public static ProjectResponseDTO toResponseDTO(Project project) {
        return new ProjectResponseDTO(
                project.getId(),
                project.getTitle(),
                project.getDescription(),
                project.getStatus()!=null?project.getStatus().name():null // convirtiendo a string
        );
    }

}
