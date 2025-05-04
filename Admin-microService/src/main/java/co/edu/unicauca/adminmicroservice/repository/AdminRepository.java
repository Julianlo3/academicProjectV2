package co.edu.unicauca.adminmicroservice.repository;

import co.edu.unicauca.adminmicroservice.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admin, String> {
    @Query("SELECT a FROM Admin a") // Consulta manual
    List<Admin> findAllAdmins();
    List<Admin> findAll();
    Optional<Admin> findByEmail(String email);
    boolean existsByEmail(String email);
}