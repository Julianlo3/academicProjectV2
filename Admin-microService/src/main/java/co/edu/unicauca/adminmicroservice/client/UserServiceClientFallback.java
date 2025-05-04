package co.edu.unicauca.adminmicroservice.client;

import org.springframework.stereotype.Component;

@Component
public class UserServiceClientFallback implements UserServiceClient {
    @Override
    public void updateUserRole(String email, String role) {
        System.err.println(" UserService no disponible - Fallback activado");
        System.err.println("Operación pendiente: Actualizar rol a " + role + " para " + email);
    }
}