package co.edu.unicauca.adminmicroservice.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "admins")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Admin {
    @Id
    @Column(name = "email") // Explicit column name mapping
    private String email;

    @Column(nullable = false)
    private String name;
}