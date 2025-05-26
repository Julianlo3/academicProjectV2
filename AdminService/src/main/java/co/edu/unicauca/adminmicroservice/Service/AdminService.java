package co.edu.unicauca.adminmicroservice.Service;

import co.edu.unicauca.adminmicroservice.dto.AdminDTO;
import co.edu.unicauca.adminmicroservice.dto.CoordinatorDecisionDTO;
import java.util.List;

public interface AdminService {
    // Métodos existentes para decisiones de coordinadores
    CoordinatorDecisionDTO processDecision(CoordinatorDecisionDTO decisionDTO);
    List<CoordinatorDecisionDTO> getDecisionsByAdmin(String adminEmail);

    // Nuevos métodos para gestión de administradores
    List<AdminDTO> getAllAdmins();
    AdminDTO getAdminByEmail(String email);
}