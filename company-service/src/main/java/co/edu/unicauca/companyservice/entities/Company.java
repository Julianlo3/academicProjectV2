package co.edu.unicauca.companyservice.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "company")
public class Company {
    // ATRIBUTOS
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long nit;
    private String name;
    private String phone;
    private String website;

    @Enumerated(EnumType.STRING)
    private IndustrialSector industrialSector;

    private String email;
    private String password;

    // GETTERS & SETTERS

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public Long getNit() {return nit;}

    public void setNit(Long nit) {this.nit = nit;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getPhone() {return phone;}

    public void setPhone(String phone) {this.phone = phone;}

    public String getWebsite() {return website;}

    public void setWebsite(String website) {this.website = website;}

    public IndustrialSector getIndustrialSector() {return industrialSector;}

    public void setIndustrialSector(IndustrialSector industrialSector) {this.industrialSector = industrialSector;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}

    public String getPassword() {return password;}

    public void setPassword(String password) {this.password = password;}
}
