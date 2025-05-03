package co.edu.unicauca.adminmicroservice.dto;

import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CoordinatorDecisionDTO {
    private Long decisionId;

    @NotBlank(message = "El email del coordinador es obligatorio")
    @Email(message = "El email del coordinador debe ser válido")
    private String coordinatorEmail;

    private String adminEmail;

   private String status;

    private String reason;

    private LocalDateTime decisionDate;

    @AssertTrue(message = "La razón es obligatoria cuando se rechaza")
    private boolean isReasonValid() {
        return !"REJECTED".equals(status) || (reason != null && !reason.trim().isEmpty());
    }
    }