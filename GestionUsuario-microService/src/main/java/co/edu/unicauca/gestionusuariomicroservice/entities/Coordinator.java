/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package  co.edu.unicauca.gestionusuariomicroservice.entities;

import co.edu.unicauca.gestionusuariomicroservice.state.ICoordinatorState;
import co.edu.unicauca.gestionusuariomicroservice.state.PendienteCoordi;
import co.edu.unicauca.gestionusuariomicroservice.state.RechazadoCoordi;
import co.edu.unicauca.gestionusuariomicroservice.state.VerificadoCoordi;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "COORDINATOR")
public class Coordinator {

    @Id
    private String code;
    private String  name;
    private String  phone;
    private String  email;
    private String  programaAcademico;
    private String  password;
    @Column(name = "estado")
    private String estadoActual;
    @Transient
    private ICoordinatorState estado;



    public Coordinator(String code, String name, String phone, String email, String programaAcademico, String password) {
        this.code = code;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.programaAcademico = programaAcademico;
        this.password = password;
        this.estadoActual = "PENDIENTE";
    }

    @PostLoad
    public void cargarEstadoCoordinator() {
        switch (estadoActual){
            case "PENDIENTE":
                this.estado = new PendienteCoordi(this);
                break;
            case "RECHAZADO":
                this.estado = new RechazadoCoordi(this);
                break;
            case "VERIFICADO":
                this.estado = new VerificadoCoordi(this);
                break;
            default:
                System.out.println("El estado no existe");
        }

    }

}
