package co.edu.unicauca.studentservice.controller;

import co.edu.unicauca.studentservice.infra.client.ProjectApplicationRequestClient;
import co.edu.unicauca.studentservice.infra.dto.ProjectApplicationResponseDTO;
import co.edu.unicauca.studentservice.service.StudentApplicationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student/application")
public class StudentApplicationController {

    private final StudentApplicationService studentApplicationService;
    private final ProjectApplicationRequestClient projectApplicationRequestClient;

    public StudentApplicationController(StudentApplicationService studentApplicationService, ProjectApplicationRequestClient projectApplicationRequestClient) {
        this.studentApplicationService = studentApplicationService;
        this.projectApplicationRequestClient = projectApplicationRequestClient;
    }

    @GetMapping("/{studentCode}")
    @PreAuthorize("hasRole('student')")
    public ResponseEntity<?> getRequestsByStudentCode(@PathVariable Long studentCode) {
        return projectApplicationRequestClient.getRequestsByStudentCode(studentCode);
    }

    @PostMapping("/apply")
    @PreAuthorize("hasRole('student')")
    public ResponseEntity<Void> applyToProject(@RequestParam Long studentCode, @RequestParam Long projectId) {
        studentApplicationService.applyToProject(studentCode, projectId);
        return ResponseEntity.ok().build();
    }

}
