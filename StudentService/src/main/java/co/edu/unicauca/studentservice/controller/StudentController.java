package co.edu.unicauca.studentservice.controller;

import co.edu.unicauca.studentservice.entity.Student;
import co.edu.unicauca.studentservice.infra.dto.StudentDTO;
import co.edu.unicauca.studentservice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    //CRUDs para estudiante

    @GetMapping
    @PreAuthorize("hasAnyRole('admin', 'coordinator')")
    public ResponseEntity<?> getAllStudents() {
        try {
            List<Student> students = studentService.findAllStudents();
            if (students == null) {
                return ResponseEntity.notFound().build();
            } else {
                return ResponseEntity.ok(students);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error al recuperar datos de los estudiantes, " + e.getMessage() + "\"}");
        }
    }

    @GetMapping("/{code}")
    @PreAuthorize("hasAnyRole('admin', 'coordinator')")
    public ResponseEntity<?> getStudentByCode(@PathVariable Long code) {
        try {
            Optional<Student> student = studentService.findByCode(code);
            if (student.isEmpty()) {
                return ResponseEntity.notFound().build();
            } else {
                return ResponseEntity.ok(student);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error al recuperar datos del estudiante, " + e.getMessage() + "\"}");
        }
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('admin', 'gestionador')")
    public ResponseEntity<?> createStudent(@RequestBody StudentDTO studentDTO) {
        try {
            try {
                Student savedStudent = studentService.createStudent(studentDTO);
                return ResponseEntity.ok(savedStudent);
            } catch (IllegalAccessException e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error al guardar datos del estudiante, " + e.getMessage() + "\"}");
        }
    }

    @PutMapping("/{code}")
    @PreAuthorize("hasAnyRole('admin', 'student')")
    public ResponseEntity<?> updateStudent(@PathVariable Long code, @RequestBody StudentDTO studentDTO) {
        try {
            try {
                Student updatedStudent = studentService.updateStudent(code, studentDTO);
                return ResponseEntity.ok(updatedStudent);
            } catch (IllegalAccessException e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error al actualizar datos del estudiante, " + e.getMessage() + "\"}");
        }
    }

    @DeleteMapping("/{code}")
    @PreAuthorize("hasRole('admin')")
    public ResponseEntity<?> deleteStudent(@PathVariable Long code){
        try {
            try {
                Student deletedStudent = studentService.deleteStudent(code);
                return ResponseEntity.ok(deletedStudent);
            } catch (IllegalAccessException e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error al eliminar datos del estudiante, " + e.getMessage() + "\"}");
        }
    }


}
