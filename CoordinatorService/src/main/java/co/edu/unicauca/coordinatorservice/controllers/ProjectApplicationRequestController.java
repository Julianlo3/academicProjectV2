package co.edu.unicauca.coordinatorservice.controllers;

import co.edu.unicauca.coordinatorservice.infra.dto.ProjectApplicationRequestDTO;
import co.edu.unicauca.coordinatorservice.infra.dto.ProjectApplicationResponseDTO;
import co.edu.unicauca.coordinatorservice.services.ProjectApplicationRequestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/coordinator/request")
public class ProjectApplicationRequestController {

    private final ProjectApplicationRequestService service;

    public ProjectApplicationRequestController(ProjectApplicationRequestService service) {
        this.service = service;
    }

    //GETs
    @GetMapping
    @PreAuthorize("hasRole('coordinator')")
    public ResponseEntity<?> getAllRequests() {
        try {
            List<ProjectApplicationResponseDTO> responses = service.getAllRequests();
            if (responses == null) {
                return ResponseEntity.notFound().build();
            } else {
                return ResponseEntity.ok(responses);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error al recuperar datos de las solicitudes, " + e.getMessage() + "\"}");
        }
    }

    @GetMapping("/project/{projectId}")
    @PreAuthorize("hasRole('coordinator')")
    public ResponseEntity<?> getRequestsByProjectId(@PathVariable Long projectId) {
        try {
            List<ProjectApplicationResponseDTO> responses = service.getRequestsByProjectId(projectId);
            if (responses == null) {
                return ResponseEntity.notFound().build();
            } else {
                return ResponseEntity.ok(responses);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error al recuperar datos de las solicitudes, " + e.getMessage() + "\"}");
        }
    }

    @GetMapping("/student/{studentCode}")
    @PreAuthorize("hasRole('coordinator')")
    public ResponseEntity<?> getRequestsByStudentCode(@PathVariable Long studentCode) {
        try {
            List<ProjectApplicationResponseDTO> responses = service.getRequestsByStudentCode(studentCode);
            if (responses == null) {
                return ResponseEntity.notFound().build();
            } else {
                return ResponseEntity.ok(responses);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error al recuperar datos de las solicitudes, " + e.getMessage() + "\"}");
        }
    }

    @GetMapping("/status/{status}")
    @PreAuthorize("hasRole('coordinator')")
    public ResponseEntity<?> getRequestsByStatus(@PathVariable String status) {
        try {
            List<ProjectApplicationResponseDTO> responses = service.getRequestsByStatus(status);
            if (responses == null) {
                return ResponseEntity.notFound().build();
            } else {
                return ResponseEntity.ok(responses);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error al recuperar datos de las solicitudes, " + e.getMessage() + "\"}");
        }
    }

    //POSTs
    @PostMapping
    @PreAuthorize("hasRole('student')")
    public ResponseEntity<?> createRequest(@RequestBody ProjectApplicationRequestDTO dto) {
        try {
            try {
                service.createRequest(dto);
                return ResponseEntity.ok().build();
            } catch (IllegalAccessException e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error al crear la solicitud, " + e.getMessage() + "\"}");
        }
    }

    //PUTs
    @PutMapping("/{id}/accept")
    @PreAuthorize("hasRole('coordinator')")
    public ResponseEntity<?> accept(@PathVariable Long id) {
        try {
            try {
                service.acceptRequest(id);
                return ResponseEntity.ok().build();
            } catch (IllegalAccessException e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error al aceptar la solicitud, " + e.getMessage() + "\"}");
        }
    }

    @PutMapping("/{id}/reject")
    @PreAuthorize("hasRole('coordinator')")
    public ResponseEntity<?> reject(@PathVariable Long id) {
        try {
            try {
                service.rejectRequest(id);
                return ResponseEntity.ok().build();
            } catch (IllegalAccessException e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error al rechazar la solicitud, " + e.getMessage() + "\"}");
        }
    }
}
