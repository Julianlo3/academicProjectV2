package co.edu.unicauca.adminmicroservice.entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "admin_decisions")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdminDecision {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String coordinatorEmail;

    @Column(nullable = false)
    private String adminEmail;

    @Column(nullable = false)
    private String status;  // "APPROVED" o "REJECTED"

    private String reason;

    @Column(nullable = false)
    @Builder.Default
    private LocalDateTime decisionDate = LocalDateTime.now();
}