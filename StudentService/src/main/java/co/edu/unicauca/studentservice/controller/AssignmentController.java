package co.edu.unicauca.studentservice.controller;

import co.edu.unicauca.studentservice.entity.Assignment;
import co.edu.unicauca.studentservice.infra.dto.AssignmentRequest;
import co.edu.unicauca.studentservice.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/assignment")
public class AssignmentController {

    @Autowired
    private AssignmentService assignmentService;

    //CRUDs para asignacion

    @GetMapping
    @PreAuthorize("hasAnyRole('admin', 'coordinator')")
    public ResponseEntity<?> getAllAssignment() {
        try {
            List<Assignment> assignments = assignmentService.findAllAssignment();
            if (assignments == null) {
                return ResponseEntity.notFound().build();
            } else {
                return ResponseEntity.ok(assignments);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error al recuperar datos de las asignaciones, " + e.getMessage() + "\"}");
        }
    }

    @GetMapping("/{code}")
    @PreAuthorize("hasAnyRole('admin', 'coordinator','student')")
    public ResponseEntity<?> getAssignmentByStudentCode(@PathVariable Long code) {
        try {
            Optional<List<Assignment>> assignments = assignmentService.findAssignmentByStudentCode(code);
            if (assignments.isEmpty()) {
                return ResponseEntity.notFound().build();
            } else {
                return ResponseEntity.ok(assignments);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error al obtener las asignaciones del estudiante, " + e.getMessage() + "\"}");
        }
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('admin', 'coordinator')")
    public ResponseEntity<?> createAssignment(@RequestBody AssignmentRequest assignmentRequest) {
        try {
            try {
                Assignment savedAssignment = assignmentService.createAssignment(assignmentRequest);
                return ResponseEntity.ok(savedAssignment);
            } catch (IllegalAccessException e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error al crear la asignacion, " + e.getMessage() + "\"}");
        }
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('admin', 'coordinator')")
    public ResponseEntity<?> deleteAssignment(@PathVariable Long id) {
        try {
            try {
                Assignment deletedAssignment = assignmentService.deleteAssignment(id);
                return ResponseEntity.ok(deletedAssignment);
            } catch (IllegalAccessException e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error al eliminar datos de la asignacion, " + e.getMessage() + "\"}");
        }
    }

}
