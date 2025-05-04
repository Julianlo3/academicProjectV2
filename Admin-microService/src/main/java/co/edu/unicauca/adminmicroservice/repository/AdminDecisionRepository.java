package co.edu.unicauca.adminmicroservice.repository;

import co.edu.unicauca.adminmicroservice.entities.AdminDecision;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminDecisionRepository extends JpaRepository<AdminDecision, Long> {
    List<AdminDecision> findByStatus(String status);
    List<AdminDecision> findByAdminEmail(String adminEmail);
}