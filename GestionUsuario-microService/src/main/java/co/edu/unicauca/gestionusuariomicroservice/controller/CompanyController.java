package co.edu.unicauca.gestionusuariomicroservice.controller;


import co.edu.unicauca.gestionusuariomicroservice.Service.CompanyService;
import co.edu.unicauca.gestionusuariomicroservice.entities.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author lopez
 * @date 15/04/2025
 */
@RestController
@RequestMapping("/company")
public class CompanyController {
    
    @Autowired
    private CompanyService companyService;

    @PostMapping
    public ResponseEntity<Company> createCompany(@RequestBody Company Company) {
        Company savedcompany = companyService.saveCompany(Company);
        return new ResponseEntity<>(savedcompany, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Company>> getAllCompanys() {
        List<Company> company = companyService.getAllCompanys();
        return new ResponseEntity<>(company, HttpStatus.OK);
    }

    @GetMapping("/{nit}")
    public ResponseEntity<Company> getCompanyByNit(@PathVariable String nit) {
        Optional<Company> company = companyService.getCompanyByNit(nit);
        return company.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{nit}")
    public ResponseEntity<Company> updateCompany(@PathVariable String nit, @RequestBody Company company) {
        if (!companyService.getCompanyByNit(nit).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        company.setNit(nit);
        Company updatedcompany = companyService.updateCompany(company);
        return new ResponseEntity<>(updatedcompany, HttpStatus.OK);
    }

    @DeleteMapping("/{nit}")
    public ResponseEntity<Void> deleteCompany(@PathVariable String nit) {
        companyService.deleteCompany(nit);
        return ResponseEntity.noContent().build();
    }
}
