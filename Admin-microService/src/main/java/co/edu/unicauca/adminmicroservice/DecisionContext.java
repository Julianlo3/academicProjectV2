package co.edu.unicauca.adminmicroservice;

import co.edu.unicauca.adminmicroservice.dto.CoordinatorDecisionDTO;
import co.edu.unicauca.adminmicroservice.entities.AdminDecision;

public class DecisionContext {
    private DecisionState state;

    public void setState(DecisionState state) {
        this.state = state;
    }

    public AdminDecision processDecision(CoordinatorDecisionDTO decisionDTO) {
        return state.processDecision(decisionDTO);
    }
}