package co.edu.unicauca.coordinatorservice.entities.state;


import co.edu.unicauca.coordinatorservice.entities.Coordinator;

public interface ICoordinatorState {
    void verify(Coordinator coordinator) throws Exception;
    void reject(Coordinator coordinator) throws Exception;
}
