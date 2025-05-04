package co.edu.unicauca.adminmicroservice.exception;

public class CoordinatorNotFoundException extends RuntimeException {
    public CoordinatorNotFoundException(String email) {
        super("Coordinador con email " + email + " no encontrado");
    }
}