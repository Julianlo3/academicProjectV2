package co.edu.unicauca.adminmicroservice.service;

import co.edu.unicauca.adminmicroservice.Service.AdminServiceImpl;
import co.edu.unicauca.adminmicroservice.client.UserServiceClient;
import co.edu.unicauca.adminmicroservice.dto.CoordinatorDecisionDTO;
import co.edu.unicauca.adminmicroservice.entities.AdminDecision;
import co.edu.unicauca.adminmicroservice.exception.AdminNotFoundException;
import co.edu.unicauca.adminmicroservice.exception.InvalidDecisionException;
import co.edu.unicauca.adminmicroservice.repository.AdminDecisionRepository;
import co.edu.unicauca.adminmicroservice.repository.AdminRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class AdminServiceImplTest {

    @Mock
    private AdminDecisionRepository decisionRepo;

    @Mock
    private AdminRepository adminRepo;

    @Mock
    private UserServiceClient userServiceClient;

    @InjectMocks
    private AdminServiceImpl adminService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void processDecision_Approved_Success() {
        CoordinatorDecisionDTO dto = new CoordinatorDecisionDTO();
        dto.setAdminEmail("admin@unicauca.edu.co");
        dto.setCoordinatorEmail("coord@unicauca.edu.co");
        dto.setStatus("APPROVED");

        when(adminRepo.existsByEmail("admin@unicauca.edu.co")).thenReturn(true);
        when(decisionRepo.save(any(AdminDecision.class))).thenAnswer(invocation -> {
            AdminDecision decision = invocation.getArgument(0);
            decision.setId(1L); // Simulate saved entity with ID
            return decision;
        });

        CoordinatorDecisionDTO result = adminService.processDecision(dto);

        assertNotNull(result);
        assertEquals("APPROVED", result.getStatus());
        verify(userServiceClient).updateUserRole("coord@unicauca.edu.co", "ROLE_COORDINATOR");
    }

    @Test
    void processDecision_RejectedWithReason_Success() {
        CoordinatorDecisionDTO dto = new CoordinatorDecisionDTO();
        dto.setAdminEmail("admin@unicauca.edu.co");
        dto.setCoordinatorEmail("coord@unicauca.edu.co");
        dto.setStatus("REJECTED");
        dto.setReason("Valid reason");

        when(adminRepo.existsByEmail("admin@unicauca.edu.co")).thenReturn(true);
        when(decisionRepo.save(any(AdminDecision.class))).thenAnswer(invocation -> {
            AdminDecision decision = invocation.getArgument(0);
            decision.setId(1L); // Simulate saved entity with ID
            return decision;
        });

        assertDoesNotThrow(() -> {
            CoordinatorDecisionDTO result = adminService.processDecision(dto);
            assertEquals("REJECTED", result.getStatus());
        });
    }

    @Test
    void processDecision_RejectedWithoutReason_ThrowsException() {
        CoordinatorDecisionDTO dto = new CoordinatorDecisionDTO();
        dto.setAdminEmail("admin@unicauca.edu.co");
        dto.setCoordinatorEmail("coord@unicauca.edu.co");
        dto.setStatus("REJECTED");
        dto.setReason(null);

        when(adminRepo.existsByEmail("admin@unicauca.edu.co")).thenReturn(true);

        assertThrows(InvalidDecisionException.class, () -> adminService.processDecision(dto));
    }

    @Test
    void processDecision_AdminNotFound_ThrowsException() {
        CoordinatorDecisionDTO dto = new CoordinatorDecisionDTO();
        dto.setAdminEmail("nonexistent@unicauca.edu.co");

        when(adminRepo.existsByEmail("nonexistent@unicauca.edu.co")).thenReturn(false);

        assertThrows(AdminNotFoundException.class, () -> adminService.processDecision(dto));
    }

    @Test
    void getDecisionsByAdmin_ValidAdmin_ReturnsDecisions() {
        AdminDecision decision = AdminDecision.builder()
                .id(1L)
                .adminEmail("admin@unicauca.edu.co")
                .coordinatorEmail("coord@unicauca.edu.co")
                .status("APPROVED")
                .decisionDate(LocalDateTime.now())
                .build();

        when(adminRepo.existsByEmail("admin@unicauca.edu.co")).thenReturn(true);
        when(decisionRepo.findByAdminEmail("admin@unicauca.edu.co"))
                .thenReturn(List.of(decision));

        List<CoordinatorDecisionDTO> result = adminService.getDecisionsByAdmin("admin@unicauca.edu.co");

        assertEquals(1, result.size());
        assertEquals("admin@unicauca.edu.co", result.get(0).getAdminEmail());
    }
}