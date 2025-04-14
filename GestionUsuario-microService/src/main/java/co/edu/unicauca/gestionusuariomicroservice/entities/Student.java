
package co.edu.unicauca.gestionusuariomicroservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="STUDENT")
public class Student {

    @Id
    private String code;
    private String name;
    private String phone;
    private String email;
    private String password;



}
