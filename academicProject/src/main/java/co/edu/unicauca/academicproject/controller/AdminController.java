package co.edu.unicauca.academicproject.controller;


import co.edu.unicauca.academicproject.Service.Admin.AdminServiceClient;
import co.edu.unicauca.academicproject.entities.Coordinator;

/**
 * @author lopez
 * @date 4/05/2025
 */
public class AdminController {

    private final AdminServiceClient adminServiceClient;
    public AdminController(AdminServiceClient adminServiceClient) {
        this.adminServiceClient = adminServiceClient;
    }

    public void aceptarCoordi(Coordinator coordinator){
        adminServiceClient.approveCoordinator(coordinator);
        System.out.println("Coordi aceptado");
    }

}
