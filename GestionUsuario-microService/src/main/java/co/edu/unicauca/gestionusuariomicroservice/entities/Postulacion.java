package co.edu.unicauca.gestionusuariomicroservice.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

/**
 * @author lopez
 * @date 15/04/2025
 */
@Entity
@Getter
@Setter
@Table(name ="POSTULACION")
@NoArgsConstructor
@AllArgsConstructor
public class Postulacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Student student;

    @ManyToOne
    private Project project;

    private LocalDate fechaPostulacion;
}
