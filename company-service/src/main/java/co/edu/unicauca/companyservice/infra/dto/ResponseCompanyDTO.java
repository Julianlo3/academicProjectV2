package co.edu.unicauca.companyservice.infra.dto;

import co.edu.unicauca.companyservice.entities.IndustrialSector;

/**
 * DTO que expone únicamente los datos necesarios para mostrar información pública de una empresa
 */
public class ResponseCompanyDTO {
    // Atributos expuestos
    private Long id; // Id de la empresa
    private Long nit; // NIT (número de identificación tributaria)
    private String name; // Nombre de la empresa
    private String phone; // Teléfono de contacto
    private String website; // Página web de la empresa
    private IndustrialSector industrialSector; // Sector industrial

    // Constructores
    public ResponseCompanyDTO() {}
    public ResponseCompanyDTO(Long id, Long nit, String name, String phone, String website, IndustrialSector industrialSector) {
        this.id = id;
        this.nit = nit;
        this.name = name;
        this.phone = phone;
        this.website = website;
        this.industrialSector = industrialSector;
    }

    // Getters&Setters
    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNit() {
        return nit;
    }

    public void setNit(Long nit) {
        this.nit = nit;
    }

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
