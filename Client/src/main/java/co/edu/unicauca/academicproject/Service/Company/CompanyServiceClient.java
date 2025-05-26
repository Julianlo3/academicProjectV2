package co.edu.unicauca.academicproject.Service.Company;


import co.edu.unicauca.academicproject.Service.Company.CompanyFeignClient;
import co.edu.unicauca.academicproject.entities.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lopez
 * @date 15/04/2025
 */
@Service
public class CompanyServiceClient {
    @Autowired
    private CompanyFeignClient FeignClient;

    public void createCompany(Company company) {
        FeignClient.createCompany(company);
    }

    public List<Company> GetAllCompanys(){
        return FeignClient.getAllCompanies();
    }


    public Company getCompanyByCode(Long nit){
        return FeignClient.getCompanyByNit(nit);
    }

    public void updateCompany(Long nit, Company CompanyRequest){
        FeignClient.updateCompany(nit, CompanyRequest);
    }

    public void deleteCompany(Long code){
        FeignClient.deleteCompany(code);
    }
}
