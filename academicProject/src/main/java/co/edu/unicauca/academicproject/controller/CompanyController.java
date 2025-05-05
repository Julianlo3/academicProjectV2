package co.edu.unicauca.academicproject.controller;


import co.edu.unicauca.academicproject.Service.Company.CompanyServiceClient;
import co.edu.unicauca.academicproject.entities.Company;
import co.edu.unicauca.academicproject.entities.SectorCompany;

import javax.swing.*;
import java.util.List;

/**
 * @author lopez
 * @date 15/04/2025
 */
public class CompanyController {

    private final CompanyServiceClient companyServiceClient;

    public CompanyController(CompanyServiceClient companyServiceClient) {
        this.companyServiceClient = companyServiceClient;

    }

    public void registerCompany(long nit, String name, String phone, String pageWeb, String sector, String email, String password) {
        try{
            Company company = new Company(nit,  name,  phone,  pageWeb,  sector,  email, password);
            companyServiceClient.createCompany(company);
            JOptionPane.showMessageDialog(null, "Empresa creada con éxito.");
            System.out.println("Empresa creada" + company.getNit() + company.getName() + company.getEmail() + company.getindustrialSector() + company.getPhone() + company.getwebsite());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al crear empresa.");
            System.out.println("Error al crear empresa." + e.getMessage());
        }
    }


    public Company checkCompany(Long code, String password){
        Company company = companyServiceClient.getCompanyByCode(code);
        if (company.getPassword().equals(password)) {
            return company;
        } else {
            return null;
        }
    }

    public List<Company> getAllCompanies(){
        return companyServiceClient.GetAllCompanys();
    }

    public Company getCompanyByNit(Long nit){
        return companyServiceClient.getCompanyByCode(nit);
    }

    public void updateCompany(Long nit, Company CompanyRequest){
        companyServiceClient.updateCompany(nit, CompanyRequest);
    }

    public void deleteCompany(Long code){
        companyServiceClient.deleteCompany(code);
    }

}
