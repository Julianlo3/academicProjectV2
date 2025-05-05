/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.academicproject.entities;

/**
 *
 * @author anvig
 */
public class Project {

    private Long id;
    private String title;
    private String description;
    private String companyNit;
    private String status; // "PROPUESTO", "ASIGNADO", "FINALIZADO"

    public Project(String title, String description, String companyNit) {
        this.title = title;
        this.description = description;
        this.companyNit = companyNit;
    }

    public Project(){}

    public String getCompanyNit() {
        return companyNit;
    }

    public void setCompanyNit(String companyNit) {
        this.companyNit = companyNit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
