package co.edu.unicauca.academicproject.Service;


import co.edu.unicauca.academicproject.entities.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lopez
 * @date 15/04/2025
 */
@Service
public class CompanyServiceClient {
    @Autowired
    private GestionUsuarioFeignClient feignClient;

    public void createCompany(Company company) {
        feignClient.createCompany(company);
    }
}
