package co.edu.unicauca.companyservice.services;

import co.edu.unicauca.companyservice.entities.Company;
import co.edu.unicauca.companyservice.infra.dto.CompanyDTO;

import java.util.List;
import java.util.Optional;

public interface ICompanyService {
    CompanyDTO createCompany(CompanyDTO dto);
    CompanyDTO getCompanyByNit(Long nit);
    List<CompanyDTO> getAllCompanies();
    CompanyDTO updateCompanyByNit(Long nit, CompanyDTO dto);
    void deleteCompanyByNit(Long nit);
}
