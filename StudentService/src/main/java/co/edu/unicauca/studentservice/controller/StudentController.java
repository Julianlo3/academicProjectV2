package co.edu.unicauca.studentservice.controller;

import co.edu.unicauca.studentservice.entity.Student;
import co.edu.unicauca.studentservice.infra.dto.StudentRequest;
import co.edu.unicauca.studentservice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public ResponseEntity<?> getAllUser() {
        try {
            List<Student> students = studentService.findAllStudents();
            if (students == null) {
                return ResponseEntity.notFound().build();
            } else {
                return ResponseEntity.ok(students);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error al recuperar datos de los estudiantes.\"}");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        try {
            Optional<Student> student = studentService.findById(id);
            if (student.isEmpty()) {
                return ResponseEntity.notFound().build();
            } else {
                return ResponseEntity.ok(student);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error al recuperar datos del estudiante.\"}");
        }
    }

    @PostMapping
    public ResponseEntity<?> createStudent(@RequestBody StudentRequest studentRequest) {
        try {
            try {
                Student savedStudent = studentService.createStudent(studentRequest);
                return ResponseEntity.ok(savedStudent);
            } catch (IllegalAccessException e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error al guardar datos del estudiante.\"}");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable Long id, @RequestBody StudentRequest studentRequest) {
        try {
            try {
                Student updatedStudent = studentService.updateStudent(id, studentRequest);
                return ResponseEntity.ok(updatedStudent);
            } catch (IllegalAccessException e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error al actualizar datos del estudiante.\"}");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Long id){
        try {
            try {
                Student deletedStudent = studentService.deleteStudent(id);
                return ResponseEntity.ok(deletedStudent);
            } catch (IllegalAccessException e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error al eliminar datos del estudiante.\"}");
        }
    }
}
