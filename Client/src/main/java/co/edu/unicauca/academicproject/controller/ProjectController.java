package co.edu.unicauca.academicproject.controller;


import co.edu.unicauca.academicproject.Service.project.ProjectServiceClient;
import co.edu.unicauca.academicproject.entities.Company;
import co.edu.unicauca.academicproject.entities.Project;

import javax.swing.*;
import java.math.BigDecimal;
import java.time.LocalDate;
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

    public void crearProyecto(long companyNit, String name, String summary, String objectives, String description, int maxDurationInMonths, LocalDate startDate, BigDecimal budget, int academicYear, int academicTerm, String token){
        try {
            System.out.println("Datos del proyecto:" + companyNit + summary + description + name + objectives + maxDurationInMonths + startDate + budget + academicYear + academicTerm);
            Project project = new Project(companyNit, name, summary, objectives, description, maxDurationInMonths, startDate, budget, academicYear, academicTerm);
            System.out.println("Project normal creado:" + project.getCompanyNit() + project.getName() + project.getSummary() + project.getStartDate() + project.getBudget() + project.getAcademicYear() + project.getAcademicTerm() + project.getObjectives() + project.getDescription() + project.getMaxDurationInMonths());
            System.out.println("Tipo de localDate" + project.getStartDate().getClass().getName());
            System.out.println("Tipo de bigDecimal" + project.getBudget().getClass().getName());
            projectServiceClient.createProject(project,token);
            JOptionPane.showMessageDialog(null, "Proyecto creado con éxito.");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Error al crear proyecto" + e.getMessage());
        }
    }

    public List<Project> getAllProjects(String token){
        return projectServiceClient.getAllProjects(token);
    }

    public Project getProjectByName(String name, String token){
        System.out.println("Buscando proyecto por nombre: " + name);
        return projectServiceClient.getProjectByName(name, token);
    }

    public List<Project> getProjectsFilter(String state,int year,int term,String token){
        System.out.println("Obteniendo datos del proyecto por estado: " + state + year + term);
        return projectServiceClient.getProjectsFilter(state, year, term, token);
    }
}
