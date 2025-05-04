package co.edu.unicauca.adminmicroservice.Service;

import co.edu.unicauca.adminmicroservice.client.UserServiceClient;
import co.edu.unicauca.adminmicroservice.dto.AdminDTO;
import co.edu.unicauca.adminmicroservice.dto.CoordinatorDecisionDTO;
import co.edu.unicauca.adminmicroservice.entities.Admin;
import co.edu.unicauca.adminmicroservice.entities.AdminDecision;
import co.edu.unicauca.adminmicroservice.exception.AdminNotFoundException;
import co.edu.unicauca.adminmicroservice.exception.InvalidDecisionException;
import co.edu.unicauca.adminmicroservice.repository.AdminDecisionRepository;
import co.edu.unicauca.adminmicroservice.repository.AdminRepository;
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

    // Métodos para gestión de administradores
    @Override
    public List<AdminDTO> getAllAdmins() {
        return adminRepo.findAll().stream()
                .map(this::mapAdminToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AdminDTO getAdminByEmail(String email) {
        Admin admin = adminRepo.findByEmail(email)
                .orElseThrow(() -> new AdminNotFoundException(email));
        return mapAdminToDTO(admin);
    }

    public List<AdminDTO> getAdmins() {
        return adminRepo.findAll().stream()
                .map(this::mapAdminToDTO)
                .collect(Collectors.toList());
    }

    // Métodos para decisiones de coordinadores
    @Override
    @Transactional
    public CoordinatorDecisionDTO processDecision(CoordinatorDecisionDTO decisionDTO) {
        // Validar que el admin existe
        if (!adminRepo.existsByEmail(decisionDTO.getAdminEmail())) {
            throw new AdminNotFoundException(decisionDTO.getAdminEmail());
        }

        // Validar el estado
        if (!"APPROVED".equals(decisionDTO.getStatus()) && !"REJECTED".equals(decisionDTO.getStatus())) {
            throw new IllegalArgumentException("Estado inválido. Use APPROVED o REJECTED");
        }

        // Validar razón para rechazo
        if ("REJECTED".equals(decisionDTO.getStatus()) &&
                (decisionDTO.getReason() == null || decisionDTO.getReason().trim().isEmpty())) {
            throw new InvalidDecisionException("Razón obligatoria para rechazo");
        }

        // Crear y guardar la decisión
        AdminDecision decision = AdminDecision.builder()
                .coordinatorEmail(decisionDTO.getCoordinatorEmail())
                .adminEmail(decisionDTO.getAdminEmail())
                .status(decisionDTO.getStatus())
                .reason(decisionDTO.getReason())
                .decisionDate(LocalDateTime.now())
                .build();

        AdminDecision savedDecision = decisionRepo.save(decision);

        // Actualizar rol si es aprobación
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

    // Métodos de mapeo privados
    private AdminDTO mapAdminToDTO(Admin admin) {
        return AdminDTO.builder()
                .email(admin.getEmail())
                .name(admin.getName())
                .department(admin.getDepartment())
                .build();
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