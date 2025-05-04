package co.edu.unicauca.adminmicroservice.controller;

import co.edu.unicauca.adminmicroservice.dto.CoordinatorDecisionDTO;
import co.edu.unicauca.adminmicroservice.exception.AdminNotFoundException;
import co.edu.unicauca.adminmicroservice.Service.AdminService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class CoordinatorControllerTest {

    @Mock
    private AdminService adminService;

    @InjectMocks
    private CoordinatorController coordinatorController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void approveCoordinator_ValidRequest_ReturnsApprovedDecision() {
        // Arrange
        CoordinatorDecisionDTO requestDto = new CoordinatorDecisionDTO();
        requestDto.setCoordinatorEmail("coord@unicauca.edu.co");

        CoordinatorDecisionDTO responseDto = new CoordinatorDecisionDTO();
        responseDto.setCoordinatorEmail("coord@unicauca.edu.co");
        responseDto.setStatus("APPROVED");
        responseDto.setAdminEmail("admin@unicauca.edu.co");

        when(adminService.processDecision(any(CoordinatorDecisionDTO.class))).thenReturn(responseDto);

        // Act
        ResponseEntity<?> response = coordinatorController.approveCoordinator(
                requestDto,
                "admin@unicauca.edu.co"
        );

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("APPROVED", ((CoordinatorDecisionDTO) response.getBody()).getStatus());
        verify(adminService).processDecision(any(CoordinatorDecisionDTO.class));
    }

    @Test
    void rejectCoordinator_ValidRequest_ReturnsRejectedDecision() {
        // Arrange
        CoordinatorDecisionDTO requestDto = new CoordinatorDecisionDTO();
        requestDto.setCoordinatorEmail("coord@unicauca.edu.co");
        requestDto.setReason("Documentación incompleta");

        CoordinatorDecisionDTO responseDto = new CoordinatorDecisionDTO();
        responseDto.setCoordinatorEmail("coord@unicauca.edu.co");
        responseDto.setStatus("REJECTED");
        responseDto.setReason("Documentación incompleta");
        responseDto.setAdminEmail("admin@unicauca.edu.co");

        when(adminService.processDecision(any(CoordinatorDecisionDTO.class))).thenReturn(responseDto);

        // Act
        ResponseEntity<?> response = coordinatorController.rejectCoordinator(
                requestDto,
                "admin@unicauca.edu.co"
        );

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("REJECTED", ((CoordinatorDecisionDTO) response.getBody()).getStatus());
        verify(adminService).processDecision(any(CoordinatorDecisionDTO.class));
    }

    @Test
    void getAdminDecisions_ValidAdmin_ReturnsDecisionList() {
        // Arrange
        String adminEmail = "admin@unicauca.edu.co";
        CoordinatorDecisionDTO decisionDto = new CoordinatorDecisionDTO();
        decisionDto.setAdminEmail(adminEmail);
        List<CoordinatorDecisionDTO> decisions = Collections.singletonList(decisionDto);

        when(adminService.getDecisionsByAdmin(adminEmail)).thenReturn(decisions);

        // Act
        ResponseEntity<List<CoordinatorDecisionDTO>> response =
                coordinatorController.getAdminDecisions(adminEmail);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(1, response.getBody().size());
        assertEquals(adminEmail, response.getBody().get(0).getAdminEmail());
        verify(adminService).getDecisionsByAdmin(adminEmail);
    }

    @Test
    void approveCoordinator_AdminNotFound_ThrowsException() {
        // Arrange
        CoordinatorDecisionDTO requestDto = new CoordinatorDecisionDTO();
        requestDto.setCoordinatorEmail("coord@unicauca.edu.co");

        when(adminService.processDecision(any(CoordinatorDecisionDTO.class)))
                .thenThrow(new AdminNotFoundException("admin@unicauca.edu.co"));

        // Act & Assert
        assertThrows(AdminNotFoundException.class, () -> {
            coordinatorController.approveCoordinator(
                    requestDto,
                    "admin@unicauca.edu.co"
            );
        });
    }
}