package co.edu.unicauca.adminmicroservice;

import co.edu.unicauca.adminmicroservice.dto.CoordinatorDecisionDTO;
import co.edu.unicauca.adminmicroservice.entities.AdminDecision;
import co.edu.unicauca.adminmicroservice.exception.InvalidDecisionException;

public class RejectedState implements DecisionState {
    @Override
    public AdminDecision processDecision(CoordinatorDecisionDTO decisionDTO) {
        if (decisionDTO.getReason() == null || decisionDTO.getReason().isBlank()) {
            throw new InvalidDecisionException("La razón es requerida para rechazar un coordinador");
        }

        return AdminDecision.builder()
                .coordinatorEmail(decisionDTO.getCoordinatorEmail())
                .adminEmail(decisionDTO.getAdminEmail())
                .status("REJECTED")
                .reason(decisionDTO.getReason())
                .build();
    }
}