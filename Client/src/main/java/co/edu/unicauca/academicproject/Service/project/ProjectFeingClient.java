package co.edu.unicauca.academicproject.Service.project;

import co.edu.unicauca.academicproject.entities.Project;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "ProjectService",url = "http://localhost:8081")
public interface ProjectFeingClient {

    @PostMapping("/api/project")
    void createProject(@RequestBody Project project,@RequestHeader("Authorization") String token);

    @GetMapping("/api/project")
    List<Project> getAllProjects(@RequestHeader("Authorization") String token);

    @GetMapping("/api/project/name/{name}")
    Project getProjectByName(@PathVariable("name") String name, @RequestHeader("Authorization") String token);
}
