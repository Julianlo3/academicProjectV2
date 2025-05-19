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

    @Column(name = "COORDINATOR_EMAIL", nullable = true)
    private String coordinatorEmail;

    @Column(name = "admin_email", nullable = true)
    private String adminEmail;

    @Column(nullable = false)
    private String status;  // "APPROVED" o "REJECTED"

    @Column(nullable = true)
    private String reason;

    @Column(nullable = false)
    @Builder.Default
    private LocalDateTime decisionDate = LocalDateTime.now();
}