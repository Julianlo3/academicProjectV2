package co.edu.unicauca.gestionusuariomicroservice.controller;

import co.edu.unicauca.gestionusuariomicroservice.Service.ProjectService;
import co.edu.unicauca.gestionusuariomicroservice.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author lopez
 * @date 15/04/2025
 */
@RestController
@RequestMapping("/project")
public class ProjectController {
    
    @Autowired
    private ProjectService projectService;

    @PostMapping
    public ResponseEntity<Project> createProject(@RequestBody Project Project) {
        Project savedProject = projectService.saveProject(Project);
        return new ResponseEntity<>(savedProject, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Project>> getAllProjects() {
        List<Project> Project = projectService.getAllProjects();
        return new ResponseEntity<>(Project, HttpStatus.OK);
    }

    @GetMapping("/{title}")
    public ResponseEntity<Project> getProjectByTi(@PathVariable String title) {
        Optional<Project> Project = projectService.getProjectByTitle(title);
        return Project.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{title}")
    public ResponseEntity<Project> updateProject(@PathVariable String title, @RequestBody Project Project) {
        if (!projectService.getProjectByTitle(title).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Project.setTitle(title);
        Project updatedProject = projectService.updateProject(Project);
        return new ResponseEntity<>(updatedProject, HttpStatus.OK);
    }

    @DeleteMapping("/{title}")
    public ResponseEntity<Void> deleteProject(@PathVariable String title) {
        projectService.deleteProject(title);
        return ResponseEntity.noContent().build();
    }
}
