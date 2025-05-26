package co.edu.unicauca.academicproject.controller;


import co.edu.unicauca.academicproject.Service.Coordinator.CoordinatorServiceClient;
import co.edu.unicauca.academicproject.entities.Coordinator;
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

    public void registerCoordinator(long code, String name, String phone, String email, String programaAcademico, String password) {
        try{
            Coordinator coordinator = new Coordinator(code,name,phone,email,programaAcademico,password);
            coordinatorServiceClient.createCoordinator(coordinator);
            JOptionPane.showMessageDialog(null, "Coordinador creado con éxito.");
            System.out.println("Coordinador creado: " + coordinator.getName() + coordinator.getCode() + coordinator.getEmail());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al crear coordinador." + e.getMessage());
            System.out.println("Error al crear coordinador." + e.getMessage());
        }
    }

    public Coordinator checkCoordi(Long code, String password) {
        Coordinator coordinator = coordinatorServiceClient.getCoordinatorByCode(code);
        if (coordinator.getPassword().equals(password)) {
            return coordinator;
        } else {
            return null;
        }
    }

    public List<Coordinator> getAllCoordinators(){
        return coordinatorServiceClient.GetAllCoordinators();
    }

    public Coordinator getCoordinatortByCode(Long code){
        return coordinatorServiceClient.getCoordinatorByCode(code);
    }


}
