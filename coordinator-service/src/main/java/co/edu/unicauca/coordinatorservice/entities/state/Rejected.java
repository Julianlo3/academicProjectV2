package co.edu.unicauca.coordinatorservice.entities.state;


import co.edu.unicauca.coordinatorservice.entities.Coordinator;

public class Rejected implements ICoordinatorState {

    @Override
    public void verify(Coordinator coordinator) throws Exception {
        throw new IllegalAccessException("The coordinator cannot change to \"Verified\" from \"Rejected\"");
    }

    @Override
    public void reject(Coordinator coordinator) throws Exception {
        throw new IllegalAccessException("The coordinator has already been \"Rejected\"");
    }
}
