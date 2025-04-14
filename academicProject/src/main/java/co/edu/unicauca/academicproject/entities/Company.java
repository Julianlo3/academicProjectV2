/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.academicproject.entities;

public class Company {

    private String nit;
    private String name;
    private String phone;
    private String pageWeb;
    private SectorCompany sector;
    private String email;
    private String password;

    public Company(){
        
    }
    
    public Company(String nit, String name, String phone, String pageWeb, SectorCompany sector, String email, String password) {
        this.nit = nit;
        this.name = name;
        this.phone = phone;
        this.pageWeb = pageWeb;
        this.sector = sector;
        this.email = email;
        this.password = password;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
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

    public String getPageWeb() {
        return pageWeb;
    }

    public void setPageWeb(String pageWeb) {
        this.pageWeb = pageWeb;
    }

    public SectorCompany getSector() {
        return sector;
    }

    public void setSector(SectorCompany sector) {
        this.sector = sector;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}