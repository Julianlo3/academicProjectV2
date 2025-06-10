package co.edu.unicauca.academicproject.controller;


import co.edu.unicauca.academicproject.Service.Coordinator.CoordinatorServiceClient;
import co.edu.unicauca.academicproject.entities.Coordinator;
import co.edu.unicauca.academicproject.entities.CreateProjectComment;
import co.edu.unicauca.academicproject.entities.ProjectApplicationRequest;
import co.edu.unicauca.academicproject.entities.Student;

import javax.swing.*;
import java.util.List;

/**
 * @author lopez
 * @date 15/04/2025
 */
public class CoordinatorController {

    private final CoordinatorServiceClient coordinatorServiceClient;

    public CoordinatorController(CoordinatorServiceClient coordinatorServiceClient) {
        this.coordinatorServiceClient = coordinatorServiceClient;
    }

    public void registerCoordinator(long code, String name, String phone, String email, String programaAcademico,String token) {
        try{
            Coordinator coordinator = new Coordinator(code,name,phone,email,programaAcademico);
            coordinatorServiceClient.createCoordinator(coordinator,token);
            JOptionPane.showMessageDialog(null, "Coordinador creado con éxito.");
            System.out.println("Coordinador creado: " + coordinator.getName() + coordinator.getCode() + coordinator.getEmail());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al crear coordinador." + e.getMessage());
            System.out.println("Error al crear coordinador." + e.getMessage());
        }
    }

    public List<Coordinator> getAllCoordinators(String token){
        return coordinatorServiceClient.GetAllCoordinators(token);
    }

    public Coordinator getCoordinatortByCode(Long code,String token){
        return coordinatorServiceClient.getCoordinatorByCode(code,token);
    }

    public List<ProjectApplicationRequest> getAllRequests(String token){
        return coordinatorServiceClient.getAllRequests(token);
    }

    public List<ProjectApplicationRequest> getAllRequestsByStudentCode(Long studentCode, String token){
        return coordinatorServiceClient.getAllRequestsByStudentCode(studentCode, token);
    }

    public void acceptRequest(Long id,String token){
        try {
            coordinatorServiceClient.acceptRequest(id,token);
        }catch (Exception e){
            System.out.println("error epa" + e.getMessage());
        }

    }

    public void rejectRequest(Long id,String token){
        try {
            coordinatorServiceClient.rejectRequest(id,token);
        }catch (Exception e){
            System.out.println("error epa" + e.getMessage());
        }
    }

    public void approveProject(Long id, CreateProjectComment projectComment, String token){
        try {
            coordinatorServiceClient.approveProject(id,projectComment,token);
        }catch (Exception e){
            System.out.println("error epa" + e.getMessage());
        }
    }

    public void rejectProject(Long id, CreateProjectComment projectComment, String token){
        try {
            coordinatorServiceClient.rejectProject(id,projectComment,token);
        }catch (Exception e){
            System.out.println("error epa" + e.getMessage());
        }
    }

    public void completeProject(Long id, String token){
        try {
            coordinatorServiceClient.completeProject(id,token);
        }catch (Exception e){
            System.out.println("error epa" + e.getMessage());
        }
    }
}
