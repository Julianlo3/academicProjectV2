package com.projectMicroservice.presentation.dto;

import com.projectMicroservice.domain.model.Project;

public class ProjectMapper {
    /**
     * Convierte un ProjectDTO a una entidad Project.
     *
     * @param dto El DTO de solicitud para crear un proyecto.
     * @return Una instancia de Project con los datos provistos en el DTO.
     */
    public static Project toEntity(ProjectDto dto) {
        throw  new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Convierte una entidad Project a un ProjectDTO.
     *
     * @param project La entidad Project que se convertirá.
     * @return Un ProjectResponseDTO con los datos del proyecto.
     */
    public static ProjectDto toDto(Project project) {
        throw  new UnsupportedOperationException("Not supported yet.");
    }

}
