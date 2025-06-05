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

    public void createProject(Project project, String token) {
    FeignClient.createProject(project, token);
    }

    public List<Project> getAllProjects(String token){
        return FeignClient.getAllProjects(token);
    }

    public Project getProjectByName(String name, String token){
        return FeignClient.getProjectByName(name, token);
    }

    public List<Project> getProjectsFilter(String state,int year,int term,String token){
        return FeignClient.getProjectsByStateAndPeriod(state,year,term,token);
    }
}
