package co.edu.unicauca.companyservice.infra.dto;

import co.edu.unicauca.companyservice.entities.IndustrialSector;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

/**
 * DTO que define los datos necesarios para crear una empresa
 */
public class CreateCompanyDTO {

    @NotNull(message = "NIT no puede ser nulo.")
    private Long nit;

    @NotNull(message = "El nombre no puede ser nulo.")
    private String name;

    @Pattern(regexp = "\\d{10}", message = "El teléfono debe tener exactamente 10 dígitos.")
    private String phone;

    private String website;

    @NotNull(message = "El sector industrial debe ser definido.")
    private IndustrialSector industrialSector;

    @NotNull(message = "El email no puede ser nulo.")
    private String email;

    @NotNull(message = "La contraseña no puede ser nula.")
    private String password;

    // Constructor vacío
    public CreateCompanyDTO() {}

    // Getters y Setters
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
