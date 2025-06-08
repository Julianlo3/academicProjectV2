package co.edu.unicauca.academicproject.controller;


import co.edu.unicauca.academicproject.Service.Coordinator.CoordinatorServiceClient;
import co.edu.unicauca.academicproject.entities.Coordinator;
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

    public Coordinator getCoordinatortByCode(Long code){
        return coordinatorServiceClient.getCoordinatorByCode(code);
    }

    public List<ProjectApplicationRequest> getAllRequests(String token){
        return coordinatorServiceClient.getAllRequests(token);
    }

    public void acceptRequest(Long id,String token){
        coordinatorServiceClient.acceptRequest(id,token);
    }

    public void rejectRequest(Long id,String token){
        coordinatorServiceClient.rejectRequest(id,token);
    }
}
