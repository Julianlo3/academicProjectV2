/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.academicproject.entities;

public class Company {

    private Long nit;
    private String name;
    private String website;
    private String email;
    private String contactPhone;
    private String contactName;
    private String contactLastName;
    private String contactPost;
    private String industrialSector;

    public Company() {
    }

    public Company(Long nit, String name, String website, String email, String contactPhone, String contactName, String contactLastName, String contactPost, String industrialSector) {
        this.nit = nit;
        this.name = name;
        this.website = website;
        this.email = email;
        this.contactPhone = contactPhone;
        this.contactName = contactName;
        this.contactLastName = contactLastName;
        this.contactPost = contactPost;
        this.industrialSector = industrialSector;
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

    public String getIndustrialSector() {
        return industrialSector;
    }

    public void setIndustrialSector(String industrialSector) {
        this.industrialSector = industrialSector;
    }
}