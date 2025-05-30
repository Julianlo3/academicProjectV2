package co.edu.unicauca.companyservice.repositories;

import co.edu.unicauca.companyservice.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    Optional<Company> findByNit(Long nit);
    boolean existsByNit(Long nit);
    void deleteByNit(Long nit);
}
