package co.edu.unicauca.gestioncoordinadormicroservice.dto;

public class ProyectoPublicadoDTO {
    private Long id;
    private String title;
    private String description;
    private String companyName;
    private String status;

    // ✅ Recomendado: agregar constructor vacío
    public ProyectoPublicadoDTO() {
    }

    // ✅ Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
