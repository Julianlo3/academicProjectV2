package co.edu.unicauca.companyservice.controllers;

import co.edu.unicauca.companyservice.infra.dto.CompanyDTO;
import co.edu.unicauca.companyservice.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/company")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping
    @PreAuthorize("hasRole('admin')")
    public ResponseEntity<CompanyDTO> createCompany(@RequestBody CompanyDTO dto) {
        CompanyDTO created = companyService.createCompany(dto);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/{nit}")
    @PreAuthorize("hasAnyRole('admin', 'coordinator')")
    public ResponseEntity<CompanyDTO> getCompanyByNit(@PathVariable Long nit) {
        CompanyDTO company = companyService.getCompanyByNit(nit);
        return ResponseEntity.ok(company);
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('admin', 'coordinator')")
    public ResponseEntity<List<CompanyDTO>> getAllCompanies() {
        List<CompanyDTO> companies = companyService.getAllCompanies();
        return ResponseEntity.ok(companies);
    }

    @PutMapping("/{nit}")
    @PreAuthorize("hasAnyRole('admin', 'company')")
    public ResponseEntity<CompanyDTO> updateCompany(@PathVariable Long nit, @RequestBody CompanyDTO dto) {
        CompanyDTO updated = companyService.updateCompanyByNit(nit, dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{nit}")
    @PreAuthorize("hasRole('admin')")
    public ResponseEntity<Void> deleteCompany(@PathVariable Long nit) {
        companyService.deleteCompanyByNit(nit);
        return ResponseEntity.noContent().build();
    }
}