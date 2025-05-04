package co.edu.unicauca.academicproject.Service;

import co.edu.unicauca.academicproject.entities.Company;
import co.edu.unicauca.academicproject.entities.Coordinator;
import co.edu.unicauca.academicproject.entities.Project;
import co.edu.unicauca.academicproject.entities.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "GestionUsuario-microservicio",url = "http://localhost:8081")
public interface GestionUsuarioFeignClient {
    
    @PostMapping("/company")
    void createCompany(@RequestBody Company company);
    
    @PostMapping("/coordinator")
    void createCoordi(@RequestBody Coordinator coordinator);
    
    @PostMapping("/project")
    void createProject(@RequestBody Project project);
    
   @PostMapping("/student")
    void createStudent(@RequestBody Student student);

}
