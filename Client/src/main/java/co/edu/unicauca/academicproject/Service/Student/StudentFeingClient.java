package co.edu.unicauca.academicproject.Service.Student;

import co.edu.unicauca.academicproject.entities.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClientProperties;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "StudentService",url = "http://localhost:8081")
public interface StudentFeingClient {

    @PostMapping("/api/student")
    void createStudent(@RequestBody Student studen , @RequestHeader("Authorization") String token);

    @GetMapping("/api/student")
    List<Student> getAllUser();

    @GetMapping("/api/student/{code}")
    Student getStudentByCode(@PathVariable Long code);

    @PutMapping("api/student/{code}")
    void updateStudent(@PathVariable Long code, @RequestBody Student studentRequest);

    @DeleteMapping("/api/student/{code}")
    void deleteStudent(@PathVariable Long code);
}
