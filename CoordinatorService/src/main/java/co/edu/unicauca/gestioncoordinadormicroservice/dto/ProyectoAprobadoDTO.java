package co.edu.unicauca.gestioncoordinadormicroservice.dto;

public class ProyectoAprobadoDTO {
    private Long id;
    private String title;
    private String companyName;

    public ProyectoAprobadoDTO() {
    }

    public ProyectoAprobadoDTO(Long id, String title, String companyName) {
        this.id = id;
        this.title = title;
        this.companyName = companyName;
    }

    // Getters y setters
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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
