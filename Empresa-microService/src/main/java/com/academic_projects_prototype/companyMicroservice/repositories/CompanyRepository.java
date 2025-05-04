package com.academic_projects_prototype.companyMicroservice.repositories;


import com.academic_projects_prototype.companyMicroservice.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    Optional<Company> findByNit(Long nit);
}
