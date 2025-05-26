package co.edu.unicauca.adminmicroservice.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CoordinatorDecisionDTO {
    private Long decisionId;

    @Column(nullable = true)
    private String coordinatorEmail;

    private String adminEmail;

    private String status;

    private String reason;

    private LocalDateTime decisionDate;

}