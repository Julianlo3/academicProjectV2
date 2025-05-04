// Interfaz
package co.edu.unicauca.adminmicroservice.Service;

import co.edu.unicauca.adminmicroservice.dto.CoordinatorDecisionDTO;
import java.util.List;

public interface AdminService {
    CoordinatorDecisionDTO processDecision(CoordinatorDecisionDTO decisionDTO);
    List<CoordinatorDecisionDTO> getDecisionsByAdmin(String adminEmail);
}