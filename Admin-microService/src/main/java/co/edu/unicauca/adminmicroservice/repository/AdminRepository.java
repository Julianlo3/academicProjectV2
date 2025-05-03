package co.edu.unicauca.adminmicroservice.repository;

import co.edu.unicauca.adminmicroservice.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, String> {
    // This will now work because the Admin entity has an email field
    boolean existsByEmail(String email);
}