package co.edu.unicauca.companyservice.controllers;

import co.edu.unicauca.companyservice.infra.dto.CompanyDTO;
import co.edu.unicauca.companyservice.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @PostMapping
    public ResponseEntity<CompanyDTO> createCompany(@RequestBody CompanyDTO dto) {
        CompanyDTO created = companyService.createCompany(dto);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/{nit}")
    public ResponseEntity<CompanyDTO> getCompanyByNit(@PathVariable Long nit) {
        CompanyDTO company = companyService.getCompanyByNit(nit);
        return ResponseEntity.ok(company);
    }

    @GetMapping
    public ResponseEntity<List<CompanyDTO>> getAllCompanies() {
        List<CompanyDTO> companies = companyService.getAllCompanies();
        return ResponseEntity.ok(companies);
    }

    @PutMapping("/{nit}")
    public ResponseEntity<CompanyDTO> updateCompany(@PathVariable Long nit, @RequestBody CompanyDTO dto) {
        CompanyDTO updated = companyService.updateCompanyByNit(nit, dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{nit}")
    public ResponseEntity<Void> deleteCompany(@PathVariable Long nit) {
        companyService.deleteCompanyByNit(nit);
        return ResponseEntity.noContent().build();
    }
}