package co.edu.unicauca.coordinatorservice.entities.state;


import co.edu.unicauca.coordinatorservice.entities.Coordinator;

public class Verified implements ICoordinatorState {

    @Override
    public void verify(Coordinator coordinator) throws Exception {
        throw new IllegalAccessException("The coordinator has already been \"Verified\"");
    }

    @Override
    public void reject(Coordinator coordinator) throws Exception {
        throw new IllegalAccessException("The coordinator cannot change to \"Rejected\" from \"Verified\"");
    }
}
