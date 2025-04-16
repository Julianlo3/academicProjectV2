package co.edu.unicauca.gestionusuariomicroservice.repository;

import co.edu.unicauca.gestionusuariomicroservice.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICompanyRepository extends JpaRepository<Company, String> {
}
