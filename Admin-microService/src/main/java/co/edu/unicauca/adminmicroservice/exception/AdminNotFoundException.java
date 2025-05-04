package co.edu.unicauca.adminmicroservice.exception;

public class AdminNotFoundException extends RuntimeException {
    public AdminNotFoundException(String email) {
        super("Administrador con email " + email + " no encontrado");
    }
}