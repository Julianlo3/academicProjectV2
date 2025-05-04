package co.edu.unicauca.studentservice.controller;

import co.edu.unicauca.studentservice.entity.Assignment;
import co.edu.unicauca.studentservice.entity.Student;
import co.edu.unicauca.studentservice.infra.dto.AssignmentRequest;
import co.edu.unicauca.studentservice.infra.dto.StudentRequest;
import co.edu.unicauca.studentservice.service.AssignmentService;
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
    @Autowired
    private AssignmentService assignmentService;

    //CRUDs para estudiante

    @GetMapping
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
    public ResponseEntity<?> createStudent(@RequestBody StudentRequest studentRequest) {
        try {
            try {
                Student savedStudent = studentService.createStudent(studentRequest);
                return ResponseEntity.ok(savedStudent);
            } catch (IllegalAccessException e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error al guardar datos del estudiante, " + e.getMessage() + "\"}");
        }
    }

    @PutMapping("/{code}")
    public ResponseEntity<?> updateStudent(@PathVariable Long code, @RequestBody StudentRequest studentRequest) {
        try {
            try {
                Student updatedStudent = studentService.updateStudent(code, studentRequest);
                return ResponseEntity.ok(updatedStudent);
            } catch (IllegalAccessException e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error al actualizar datos del estudiante, " + e.getMessage() + "\"}");
        }
    }

    @DeleteMapping("/{code}")
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

    //CRUDs para asignacion

    @GetMapping("/assignment")
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

    @GetMapping("/assignment/{code}")
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

    @PostMapping("/assignment")
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

    @DeleteMapping("/assignment/{id}")
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
