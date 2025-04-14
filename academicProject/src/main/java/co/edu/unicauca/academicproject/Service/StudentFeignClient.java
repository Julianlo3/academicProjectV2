package co.edu.unicauca.academicproject.Service;

import co.edu.unicauca.academicproject.entities.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "GestionUsuario-microservicio",url = "http://localhost:8081")
public interface StudentFeignClient {
    @PostMapping("/student")
    void createStudent(@RequestBody Student student);

}
