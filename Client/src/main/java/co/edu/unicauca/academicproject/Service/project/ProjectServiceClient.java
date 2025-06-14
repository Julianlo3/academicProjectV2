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

    public List<Project> searchByName(String name, String token){
        return FeignClient.searchByName(name, token);
    }

    public Project getProjectById(Long id, String token){
        return FeignClient.getProjectById(id, token);
    }

    public List<Project> getProjectByState(String state, String token){
        return FeignClient.getProjectByState(state, token);
    }

    public List<Project> getProjectsFilter(String state,int year,int term,String token){
        return FeignClient.getProjectsByStateAndPeriod(state,year,term,token);
    }

    public List<Project> getProjectsByCompany(Long nitCompany, String token){
        return FeignClient.getProjectsByCompany(nitCompany, token);
    }
}
