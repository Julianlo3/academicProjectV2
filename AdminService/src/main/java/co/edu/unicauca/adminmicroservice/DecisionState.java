package co.edu.unicauca.adminmicroservice;

import co.edu.unicauca.adminmicroservice.dto.CoordinatorDecisionDTO;
import co.edu.unicauca.adminmicroservice.entities.AdminDecision;

public interface DecisionState {
    AdminDecision processDecision(CoordinatorDecisionDTO decisionDTO);
}