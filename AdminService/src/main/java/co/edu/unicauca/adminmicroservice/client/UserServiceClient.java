package co.edu.unicauca.adminmicroservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface UserServiceClient {
    @PutMapping("/api/users/update-role")
    void updateUserRole(
            @RequestParam String email,
            @RequestParam String role
    );
}