package co.edu.unicauca.coordinatorservice.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/coordinator/student")
public class StudentController {

    @PutMapping("/assign")
    @PreAuthorize("hasRole('coordinator')")
    public ResponseEntity<Void> assignStudent() throws Exception {
        return ResponseEntity.ok().build();
    }

}
