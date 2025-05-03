package co.edu.unicauca.adminmicroservice.Service;

import co.edu.unicauca.adminmicroservice.client.UserServiceClient;
import co.edu.unicauca.adminmicroservice.dto.CoordinatorDecisionDTO;
import co.edu.unicauca.adminmicroservice.entities.AdminDecision;
import co.edu.unicauca.adminmicroservice.exception.AdminNotFoundException;
import co.edu.unicauca.adminmicroservice.exception.InvalidDecisionException;
import co.edu.unicauca.adminmicroservice.repository.AdminDecisionRepository;
import co.edu.unicauca.adminmicroservice.repository.AdminRepository;
import co.edu.unicauca.adminmicroservice.ApprovedState;
import co.edu.unicauca.adminmicroservice.DecisionContext;
import co.edu.unicauca.adminmicroservice.RejectedState;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final AdminDecisionRepository decisionRepo;
    private final AdminRepository adminRepo;
    private final UserServiceClient userServiceClient;

    @Override
    @Transactional
    public CoordinatorDecisionDTO processDecision(CoordinatorDecisionDTO decisionDTO) {
        // Validación de admin
        if (!adminRepo.existsByEmail(decisionDTO.getAdminEmail())) {
            throw new AdminNotFoundException(decisionDTO.getAdminEmail());
        }

        // Validación de estado
        if (!"APPROVED".equals(decisionDTO.getStatus()) && !"REJECTED".equals(decisionDTO.getStatus())) {
            throw new IllegalArgumentException("Estado inválido. Use APPROVED o REJECTED");
        }

        // Validación de razón para rechazo
        if ("REJECTED".equals(decisionDTO.getStatus()) &&
                (decisionDTO.getReason() == null || decisionDTO.getReason().trim().isEmpty())) {
            throw new InvalidDecisionException("Razón obligatoria para rechazo");
        }

        // Construir entidad
        AdminDecision decision = AdminDecision.builder()
                .coordinatorEmail(decisionDTO.getCoordinatorEmail())
                .adminEmail(decisionDTO.getAdminEmail())
                .status(decisionDTO.getStatus())
                .reason(decisionDTO.getReason())
                .decisionDate(LocalDateTime.now())
                .build();

        // Guardar y actualizar rol si es aprobado
        AdminDecision savedDecision = decisionRepo.save(decision);

        if ("APPROVED".equals(decisionDTO.getStatus())) {
            userServiceClient.updateUserRole(
                    decisionDTO.getCoordinatorEmail(),
                    "ROLE_COORDINATOR"
            );
        }

        return mapToDTO(savedDecision);
    }

    @Override
    public List<CoordinatorDecisionDTO> getDecisionsByAdmin(String adminEmail) {
        if (!adminRepo.existsByEmail(adminEmail)) {
            throw new AdminNotFoundException(adminEmail);
        }

        return decisionRepo.findByAdminEmail(adminEmail).stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private CoordinatorDecisionDTO mapToDTO(AdminDecision decision) {
        return CoordinatorDecisionDTO.builder()
                .decisionId(decision.getId())
                .coordinatorEmail(decision.getCoordinatorEmail())
                .adminEmail(decision.getAdminEmail())
                .status(decision.getStatus())
                .reason(decision.getReason())
                .decisionDate(decision.getDecisionDate())
                .build();
    }
}