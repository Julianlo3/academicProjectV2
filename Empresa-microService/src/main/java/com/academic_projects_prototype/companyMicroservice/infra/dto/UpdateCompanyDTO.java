package com.academic_projects_prototype.companyMicroservice.infra.dto;

import com.academic_projects_prototype.companyMicroservice.entities.IndustrialSector;
import jakarta.validation.constraints.Pattern;


/**
 * DTO que contiene los datos que podrían actualizarse dentro del sistema para una empresa existente
 */
public class UpdateCompanyDTO {

    private String name; // El nombre es opcional en la actualización

    @Pattern(regexp = "\\d{10}", message = "El teléfono debe tener 10 dígitos.")
    private String phone; // Validación para el formato del teléfono

    private String website;

    private IndustrialSector industrialSector; // El sector industrial puede ser opcional

    // Constructor vacío
    public UpdateCompanyDTO() {}

    // Getters y Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public IndustrialSector getIndustrialSector() {
        return industrialSector;
    }

    public void setIndustrialSector(IndustrialSector industrialSector) {
        this.industrialSector = industrialSector;
    }


}
