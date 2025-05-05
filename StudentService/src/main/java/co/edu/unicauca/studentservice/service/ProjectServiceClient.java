package co.edu.unicauca.studentservice.service;

import co.edu.unicauca.studentservice.infra.dto.ProjectResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "ProjectService", url = "http://localhost:8085/api/project")  // URL del microservicio de proyecto
public interface ProjectServiceClient {

    /**
     * Endpoint para obtener un proyecto por su id
     */
    @GetMapping("/{id}")
    public ResponseEntity<ProjectResponseDTO> getProjectById(@PathVariable("id") Long projectId);

}
