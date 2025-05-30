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

    public void createCompany(Company company,String token) {
        FeignClient.createCompany(company,token);
    }

    public List<Company> GetAllCompanys(){
        return FeignClient.getAllCompanies();
    }


    public Company getCompanyByCode(Long nit,String token){
        return FeignClient.getCompanyByNit(nit,token);
    }

    public void updateCompany(Long nit, Company CompanyRequest){
        FeignClient.updateCompany(nit, CompanyRequest);
    }

    public void deleteCompany(Long code){
        FeignClient.deleteCompany(code);
    }
}
