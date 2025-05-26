package co.edu.unicauca.academicproject.Service.project;

import co.edu.unicauca.academicproject.entities.Project;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "ProjectService",url = "http://localhost:8081")
public interface ProjectFeingClient {

    @PostMapping("/api/project")
    void createProject(@RequestBody Project project);

    @GetMapping("/api/project")
    List<Project> getAllProjects();
}
