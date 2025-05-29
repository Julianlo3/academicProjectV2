/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.academicproject.entities;

public class Company {

    private long id;
    private long nit;
    private String name;
    private String phone;
    private String website;
    private String industrialSector;
    private String email;

    public Company(){
        
    }

    public Company(long nit, String name, String phone, String website, String industrialSector, String email) {
        this.nit = nit;
        this.name = name;
        this.phone = phone;
        this.website = website;
        this.industrialSector = industrialSector;
        this.email = email;
    }

    public long getNit() {
        return nit;
    }

    public void setNit(long nit) {
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

    public String getwebsite() {
        return website;
    }

    public void setwebsite(String website) {
        this.website = website;
    }

    public String getindustrialSector() {
        return industrialSector;
    }

    public void setindustrialSector(String  industrialSector) {
        this.industrialSector = industrialSector;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}