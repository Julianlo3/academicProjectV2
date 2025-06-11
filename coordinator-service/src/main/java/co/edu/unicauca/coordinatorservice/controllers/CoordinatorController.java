package co.edu.unicauca.coordinatorservice.controllers;

import co.edu.unicauca.coordinatorservice.entities.Coordinator;
import co.edu.unicauca.coordinatorservice.infra.dto.CoordinatorRequest;
import co.edu.unicauca.coordinatorservice.infra.dto.CoordinatorResponse;
import co.edu.unicauca.coordinatorservice.services.ICoordinatorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/coordinator")
public class CoordinatorController {

    private final ICoordinatorService coordinatorService;

    public CoordinatorController(ICoordinatorService coordinatorService) {
        this.coordinatorService = coordinatorService;
    }

    // GETs
    @GetMapping
    @PreAuthorize("hasRole('admin')")
    public ResponseEntity<?> getAllCoordinators() {
        try {
            List<Coordinator> coordinators = coordinatorService.getAllCoordinators();
            if (coordinators == null) {
                return ResponseEntity.notFound().build();
            } else {
                return ResponseEntity.ok(coordinators);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error al recuperar datos de los coordinadores, " + e.getMessage() + "\"}");
        }
    }

    @GetMapping("/{code}")
    @PreAuthorize("hasAnyRole('admin', 'coordinator')")
    public ResponseEntity<?> getCoordinatorByCode(@PathVariable long code) {
        try {
            Optional<Coordinator> coordinator = coordinatorService.getCoordinatorByCode(code);
            if (coordinator.isEmpty()) {
                return ResponseEntity.notFound().build();
            } else {
                return ResponseEntity.ok(coordinator);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error al recuperar datos del coordinador, " + e.getMessage() + "\"}");
        }
    }

    // POSTs
    @PostMapping
    @PreAuthorize("hasRole('gestionador')")
    public ResponseEntity<?> createCoordinator(@RequestBody CoordinatorRequest coordinator) {
        try {
            try {
                Coordinator savedCoordinator = coordinatorService.createCoordinator(coordinator);
                return ResponseEntity.ok(savedCoordinator);
            } catch (IllegalAccessException e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error al guardar datos del coordinador, " + e.getMessage() + "\"}");
        }
    }

    // PUTs
    @PutMapping("/{code}")
    @PreAuthorize("hasRole('coordinator')")
    public ResponseEntity<?> updateCoordinator(@PathVariable long code, @RequestBody CoordinatorRequest coordinator) {
        try {
            try {
                Coordinator updatedCoordinator = coordinatorService.updateCoordinator(code, coordinator);
                return ResponseEntity.ok(updatedCoordinator);
            } catch (IllegalAccessException e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error al actualizar datos del coordinador, " + e.getMessage() + "\"}");
        }
    }

    @PutMapping("/{code}/verify")
    @PreAuthorize("hasRole('admin')")
    public ResponseEntity<?> verifyCoordinator(@PathVariable long code) {
        try {
            try {
                Coordinator verifiedCoordinator = coordinatorService.verifyCoordinator(code);
                return ResponseEntity.ok(verifiedCoordinator);
            } catch (IllegalAccessException e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error al verificar el coordinador, " + e.getMessage() + "\"}");
        }
    }

    @PutMapping("/{code}/reject")
    @PreAuthorize("hasRole('admin')")
    public ResponseEntity<?> rejectCoordinator(@PathVariable long code) {
        try {
            try {
                Coordinator rejectedCoordinator = coordinatorService.rejectCoordinator(code);
                return ResponseEntity.ok(rejectedCoordinator);
            } catch (IllegalAccessException e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error al actualizar rechazar al coordinador, " + e.getMessage() + "\"}");
        }
    }

    // DELETEs
    @DeleteMapping("/{code}")
    @PreAuthorize("hasRole('admin')")
    public ResponseEntity<?> deleteCoordinator(@PathVariable long code) {
        try {
            try {
                Coordinator deletedCoordinator = coordinatorService.deleteCoordinator(code);
                return ResponseEntity.ok(deletedCoordinator);
            } catch (IllegalAccessException e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error al eliminar datos del coordinador, " + e.getMessage() + "\"}");
        }
    }


}
