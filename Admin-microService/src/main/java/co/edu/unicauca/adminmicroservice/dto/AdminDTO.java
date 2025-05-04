package co.edu.unicauca.adminmicroservice.dto;

import jakarta.persistence.Column;
import lombok.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdminDTO {
    private String email;
    private String name;
    private String department;
}