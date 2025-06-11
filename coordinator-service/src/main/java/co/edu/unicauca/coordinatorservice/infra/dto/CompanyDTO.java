package co.edu.unicauca.coordinatorservice.infra.dto;


import co.edu.unicauca.coordinatorservice.entities.IndustrialSector;

public class CompanyDTO {

    private Long id;
    private Long nit;
    private String name;
    private String website;
    private String email;
    private String contactPhone;
    private String contactName;
    private String contactLastName;
    private String contactPost;
    private IndustrialSector industrialSector;

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

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactLastName() {
        return contactLastName;
    }

    public void setContactLastName(String contactLastName) {
        this.contactLastName = contactLastName;
    }

    public String getContactPost() {
        return contactPost;
    }

    public void setContactPost(String contactPost) {
        this.contactPost = contactPost;
    }

    public IndustrialSector getIndustrialSector() {
        return industrialSector;
    }

    public void setIndustrialSector(IndustrialSector industrialSector) {
        this.industrialSector = industrialSector;
    }
}
