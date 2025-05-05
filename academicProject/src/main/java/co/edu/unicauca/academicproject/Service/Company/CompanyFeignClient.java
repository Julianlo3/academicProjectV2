package co.edu.unicauca.academicproject.Service.Company;


import co.edu.unicauca.academicproject.entities.Company;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "Empresa-microservice",url = "http://localhost:8084")
public interface CompanyFeignClient {

    @PostMapping("/api/company")
    void createCompany(@RequestBody Company company);

    @GetMapping("/api/company")
    List<Company> getAllCompanies();

    @GetMapping("/api/company/search")
    Company getCompanyByNit(@RequestParam Long nit);

    @PutMapping("api/company/{id}")
    void updateCompany(@PathVariable Long id, @RequestBody Company CompanyRequest);

    @DeleteMapping("api/company/{id}")
    void deleteCompany(@PathVariable Long id);
}
