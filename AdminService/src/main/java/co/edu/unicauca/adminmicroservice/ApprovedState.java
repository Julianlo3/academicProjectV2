package co.edu.unicauca.adminmicroservice;

import co.edu.unicauca.adminmicroservice.dto.CoordinatorDecisionDTO;
import co.edu.unicauca.adminmicroservice.entities.AdminDecision;

public class ApprovedState implements DecisionState {
    @Override
    public AdminDecision processDecision(CoordinatorDecisionDTO decisionDTO) {
        return AdminDecision.builder()
                .coordinatorEmail(decisionDTO.getCoordinatorEmail())
                .adminEmail(decisionDTO.getAdminEmail())
                .status("APPROVED")
                .reason(decisionDTO.getReason())
                .build();
    }
}