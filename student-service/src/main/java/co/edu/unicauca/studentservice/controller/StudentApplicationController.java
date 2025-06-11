package co.edu.unicauca.studentservice.controller;

import co.edu.unicauca.studentservice.infra.client.CoordinatorClient;
import co.edu.unicauca.studentservice.service.StudentApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student/application")
public class StudentApplicationController {

    private final StudentApplicationService studentApplicationService;
    private final CoordinatorClient coordinatorClient;

    public StudentApplicationController(StudentApplicationService studentApplicationService, CoordinatorClient coordinatorClient) {
        this.studentApplicationService = studentApplicationService;
        this.coordinatorClient = coordinatorClient;
    }

    @GetMapping("/{studentCode}")
    @PreAuthorize("hasRole('student')")
    public ResponseEntity<?> getRequestsByStudentCode(@PathVariable Long studentCode) {
        return coordinatorClient.getRequestsByStudentCode(studentCode);
    }

    @PostMapping("/apply")
    @PreAuthorize("hasRole('student')")
    public ResponseEntity<Void> applyToProject(@RequestParam Long studentCode, @RequestParam Long projectId) {
        studentApplicationService.applyToProject(studentCode, projectId);
        return ResponseEntity.ok().build();
    }

}
