/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.gestionusuariomicroservice.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "PROJECT")
public class Project {

    @Id
    private String title;
    private String description;
    @ManyToOne
    @JsonBackReference
    private Company company;
    @ManyToOne
    private Student student;
    private String state; // "PROPUESTO", "ASIGNADO", "FINALIZADO"

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Postulacion> postulaciones = new ArrayList<>();


    public Project(String titulo, String descripcion, Company empresa) {
        this.title = titulo;
        this.description = descripcion;
        this.company = empresa;
        this.state = "PROPUESTO"; // Estado inicial
    }


}
