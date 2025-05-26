package co.edu.unicauca.companyservice.services;

import co.edu.unicauca.companyservice.entities.Company;
import co.edu.unicauca.companyservice.infra.dto.CompanyDTO;
import co.edu.unicauca.companyservice.infra.mapper.CompanyMapper;
import co.edu.unicauca.companyservice.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class CompanyService implements ICompanyService {

    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;

    public CompanyService(CompanyRepository companyRepository, CompanyMapper companyMapper) {
        this.companyRepository = companyRepository;
        this.companyMapper = companyMapper;
    }

    @Override
    public CompanyDTO createCompany(CompanyDTO dto) {
        if (companyRepository.existsByNit(dto.getNit())) {
            throw new IllegalArgumentException("Ya existe una compañía con ese NIT.");
        }
        Company company = companyMapper.toEntity(dto);
        Company saved = companyRepository.save(company);
        return companyMapper.toDto(saved);
    }

    @Override
    public CompanyDTO getCompanyByNit(Long nit) {
        Company company = companyRepository.findByNit(nit)
                .orElseThrow(() -> new NoSuchElementException("Compañía no encontrada con NIT: " + nit));
        return companyMapper.toDto(company);
    }

    @Override
    public List<CompanyDTO> getAllCompanies() {
        return companyRepository.findAll()
                .stream()
                .map(companyMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public CompanyDTO updateCompanyByNit(Long nit, CompanyDTO dto) {
        Company existing = companyRepository.findByNit(nit)
                .orElseThrow(() -> new NoSuchElementException("Compañía no encontrada con NIT: " + nit));

        // Actualizar campos
        existing.setName(dto.getName());
        existing.setEmail(dto.getEmail());
        existing.setWebsite(dto.getWebsite());
        existing.setContactPhone(dto.getContactPhone());
        existing.setContactName(dto.getContactName());
        existing.setContactLastName(dto.getContactLastName());
        existing.setContactPost(dto.getContactPost());
        existing.setIndustrialSector(dto.getIndustrialSector());

        Company updated = companyRepository.save(existing);
        return companyMapper.toDto(updated);
    }

    @Override
    public void deleteCompanyByNit(Long nit) {
        if (!companyRepository.existsByNit(nit)) {
            throw new NoSuchElementException("No existe compañía con NIT: " + nit);
        }
        companyRepository.deleteByNit(nit);
    }
}