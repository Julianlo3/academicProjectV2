package co.edu.unicauca.studentservice.controller;

import co.edu.unicauca.studentservice.service.StudentApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
public class StudentApplicationController {

    private final StudentApplicationService studentApplicationService;

    public StudentApplicationController(StudentApplicationService studentApplicationService) {
        this.studentApplicationService = studentApplicationService;
    }

        @PostMapping("/apply")
    @PreAuthorize("hasRole('student')")
    public ResponseEntity<Void> applyToProject(@RequestParam Long studentCode, @RequestParam Long projectId) {
        studentApplicationService.applyToProject(studentCode, projectId);
        return ResponseEntity.ok().build();
    }
}
