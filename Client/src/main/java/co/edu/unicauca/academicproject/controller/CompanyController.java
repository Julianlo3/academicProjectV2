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

    public void registerCompany(Long nit, String name, String website, String email, String contactPhone, String contactName, String contactLastName, String contactPost, String industrialSector,String token) {
        try{
            Company company = new Company(nit,  name,  website,  email,  contactPhone,  contactName,  contactLastName,  contactPost,  industrialSector);
            companyServiceClient.createCompany(company,token);
            JOptionPane.showMessageDialog(null, "Empresa creada con exito.");
            System.out.println("Empresa creada" + company.getNit() + company.getName() + company.getEmail() + company.getContactPhone() + company.getContactName() + company.getContactLastName() + company.getContactPost() + company.getIndustrialSector() + company.getWebsite());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al crear empresa.");
            System.out.println("Error al crear empresa." + e.getMessage());
        }
    }




    public List<Company> getAllCompanies(String token){
        return companyServiceClient.GetAllCompanys(token);
    }

    public Company getCompanyByNit(Long nit,String token){
        return companyServiceClient.getCompanyByCode(nit,token);
    }

    public void updateCompany(Long nit, Company CompanyRequest){
        companyServiceClient.updateCompany(nit, CompanyRequest);
    }

    public void deleteCompany(Long code){
        companyServiceClient.deleteCompany(code);
    }

}
