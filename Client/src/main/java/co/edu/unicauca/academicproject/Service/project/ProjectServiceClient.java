package co.edu.unicauca.academicproject.Service.project;


import co.edu.unicauca.academicproject.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lopez
 * @date 15/04/2025
 */
@Service
public class ProjectServiceClient {

    @Autowired
    private ProjectFeingClient FeignClient;

    public void createProject(Project project) {
    FeignClient.createProject(project);
    }

    public List<Project> getAllProjects(){
        return FeignClient.getAllProjects();
    }
}
