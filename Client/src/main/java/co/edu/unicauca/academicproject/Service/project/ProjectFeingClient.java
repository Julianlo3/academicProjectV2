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

    @GetMapping("api/project/search")
    List<Project> searchByName(@RequestParam("name") String name,@RequestHeader("Authorization") String token);

    @GetMapping("api/project/{id}")
    Project getProjectById(@PathVariable("id") Long id, @RequestHeader("Authorization") String token);

    @GetMapping("api/project/company/{companyNit}")
    List<Project> getProjectsByCompany(@PathVariable Long companyNit, @RequestHeader("Authorization") String token);

    @GetMapping("api/project/state/{state}")
    List<Project> getProjectByState(@PathVariable("state") String state, @RequestHeader("Authorization") String token);

    @GetMapping("api/project/stateAndPeriod/{state}")
    List<Project> getProjectsByStateAndPeriod(@PathVariable("state") String state, @RequestParam Integer year, @RequestParam Integer term,@RequestHeader("Authorization") String token);
}
