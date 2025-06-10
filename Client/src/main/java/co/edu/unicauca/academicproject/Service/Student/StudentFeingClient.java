package co.edu.unicauca.academicproject.Service.Student;

import co.edu.unicauca.academicproject.entities.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "StudentService",url = "http://localhost:8081")
public interface StudentFeingClient {

    @PostMapping("/api/student")
    void createStudent(@RequestBody Student student, @RequestHeader("Authorization") String token);

    @GetMapping("/api/student")
    List<Student> getAllUser(@RequestHeader("Authorization") String token);

    @GetMapping("/api/student/{code}")
    Student getStudentByCode(@PathVariable Long code,@RequestHeader("Authorization") String token);

    @PutMapping("api/student/{code}")
    void updateStudent(@PathVariable Long code, @RequestBody Student studentRequest);

    @DeleteMapping("/api/student/{code}")
    void deleteStudent(@PathVariable Long code);

    @PostMapping("/api/student/application/apply")
     void applyToProject(@RequestParam Long studentCode, @RequestParam Long projectId,@RequestHeader("Authorization") String token);

}
