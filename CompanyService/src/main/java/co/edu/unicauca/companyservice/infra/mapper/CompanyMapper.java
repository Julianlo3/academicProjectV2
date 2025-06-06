package co.edu.unicauca.companyservice.infra.mapper;

import co.edu.unicauca.companyservice.entities.Company;
import co.edu.unicauca.companyservice.infra.dto.CompanyDTO;
import org.springframework.stereotype.Component;

@Component
public class CompanyMapper {

    public CompanyDTO toDto(Company company) {
        CompanyDTO dto = new CompanyDTO();
        dto.setId(company.getId());
        dto.setNit(company.getNit());
        dto.setName(company.getName());
        dto.setWebsite(company.getWebsite());
        dto.setEmail(company.getEmail());
        dto.setContactPhone(company.getContactPhone());
        dto.setContactName(company.getContactName());
        dto.setContactLastName(company.getContactLastName());
        dto.setContactPost(company.getContactPost());
        dto.setIndustrialSector(company.getIndustrialSector());
        return dto;
    }

    public Company toEntity(CompanyDTO dto) {
        Company company = new Company();
        company.setId(dto.getId());
        company.setNit(dto.getNit());
        company.setName(dto.getName());
        company.setWebsite(dto.getWebsite());
        company.setEmail(dto.getEmail());
        company.setContactPhone(dto.getContactPhone());
        company.setContactName(dto.getContactName());
        company.setContactLastName(dto.getContactLastName());
        company.setContactPost(dto.getContactPost());
        company.setIndustrialSector(dto.getIndustrialSector());
        return company;
    }
}
