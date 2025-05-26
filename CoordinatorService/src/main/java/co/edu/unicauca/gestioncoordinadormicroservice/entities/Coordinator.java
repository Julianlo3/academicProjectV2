package  co.edu.unicauca.gestioncoordinadormicroservice.entities;

import co.edu.unicauca.gestioncoordinadormicroservice.entities.state.ICoordinatorState;
import co.edu.unicauca.gestioncoordinadormicroservice.entities.state.Pending;
import co.edu.unicauca.gestioncoordinadormicroservice.entities.state.Rejected;
import co.edu.unicauca.gestioncoordinadormicroservice.entities.state.Verified;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Coordinator {
    @Id
    private long code;
    private String  name;
    private String  phone;
    private String  email;
    private String  programaAcademico;
    @Column(name = "estado")
    private String estadoActual;
    @JsonIgnore
    @Transient
    private ICoordinatorState estado;

    public Coordinator() {
        this.estadoActual = "PENDIENTE";
    }

    public Coordinator(long code, String name, String phone, String email, String programaAcademico) {
        this.code = code;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.programaAcademico = programaAcademico;
        this.estadoActual = "PENDIENTE";
    }

    @PostLoad
    public void cargarEstadoCoordinator() {
        if (estadoActual == null) {
            this.estado = null;
            return;
        }

        switch (estadoActual) {
            case "PENDIENTE" -> this.estado = new Pending(this);
            case "RECHAZADO" -> this.estado = new Rejected(this);
            case "VERIFICADO" -> this.estado = new Verified(this);
            default -> System.out.println("El estado no existe");
        }
    }

}
