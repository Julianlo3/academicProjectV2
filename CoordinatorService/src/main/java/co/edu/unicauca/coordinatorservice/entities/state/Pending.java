package co.edu.unicauca.coordinatorservice.entities.state;

import co.edu.unicauca.coordinatorservice.entities.Coordinator;
import co.edu.unicauca.coordinatorservice.entities.CoordinatorStatus;

public class Pending implements ICoordinatorState {

    @Override
    public void verify(Coordinator coordinator) throws Exception {
        coordinator.changeState(new Verified());
        coordinator.setStatus(CoordinatorStatus.VERIFIED);
    }

    @Override
    public void reject(Coordinator coordinator) throws Exception {
        coordinator.changeState(new Rejected());
        coordinator.setStatus(CoordinatorStatus.REJECTED);
    }
}
