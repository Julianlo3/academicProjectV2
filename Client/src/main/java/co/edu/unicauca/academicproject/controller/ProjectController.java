package co.edu.unicauca.academicproject.controller;


import co.edu.unicauca.academicproject.Service.project.ProjectServiceClient;
import co.edu.unicauca.academicproject.entities.Company;
import co.edu.unicauca.academicproject.entities.Project;

import javax.swing.*;
import java.util.List;

/**
 * @author lopez
 * @date 5/05/2025
 */
public class ProjectController {

    private final ProjectServiceClient projectServiceClient;

    public ProjectController(ProjectServiceClient projectServiceClient) {
        this.projectServiceClient = projectServiceClient;
    }

    public void crearProyecto(String title, String description,String companyNit){
        try {
            System.out.println("Datos del proyecto:" + title + description + "nit"+ companyNit);
            Project project = new Project(title, description, companyNit);
            projectServiceClient.createProject(project);
            JOptionPane.showMessageDialog(null, "Proyecto creado con éxito.");
        }catch (Exception e){
            System.out.println("Error al crear proyecto" + e.getMessage());
        }
    }

    public List<Project> getAllProjects(){
        return projectServiceClient.getAllProjects();
    }
}
