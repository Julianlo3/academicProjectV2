package co.edu.unicauca.gestionusuariomicroservice.Service;


import co.edu.unicauca.gestionusuariomicroservice.entities.Project;
import co.edu.unicauca.gestionusuariomicroservice.repository.IProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author lopez
 * @date 15/04/2025
 */
@Service
public class ProjectService {
    @Autowired
    private IProjectRepository projectRepository;

    public Project saveProject(Project project) {
        return projectRepository.save(project);
    }

    public Optional<Project> getProjectByTitle(String title) {
        return projectRepository.findById(title);
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Project updateProject(Project student) {
        return projectRepository.save(student);
    }

    public void deleteProject(String title) {
        projectRepository.deleteByTitle((title));
    }


}
