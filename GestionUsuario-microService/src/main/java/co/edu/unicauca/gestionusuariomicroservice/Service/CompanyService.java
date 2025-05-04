package co.edu.unicauca.gestionusuariomicroservice.Service;



import co.edu.unicauca.gestionusuariomicroservice.entities.Company;
import co.edu.unicauca.gestionusuariomicroservice.repository.ICompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author lopez
 * @date 15/04/2025
 */
@Service
public class CompanyService {

    @Autowired
    private ICompanyRepository companyRepository;

    public Company saveCompany(Company Company) {
        return companyRepository.save(Company);
    }

    public List<Company> getAllCompanys() {
        return companyRepository.findAll();
    }

    public Optional<Company> getCompanyByNit(String nit) {
        return companyRepository.findById(nit);
    }

    public Company updateCompany(Company Company) {
        return companyRepository.save(Company);
    }

    public void deleteCompany(String nit) {
        companyRepository.deleteById(nit);
    }
}
