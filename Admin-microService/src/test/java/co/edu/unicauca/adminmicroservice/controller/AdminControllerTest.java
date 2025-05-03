package co.edu.unicauca.adminmicroservice.controller;

import co.edu.unicauca.adminmicroservice.dto.CoordinatorDecisionDTO;
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
import static org.mockito.Mockito.when;

class AdminControllerTest {

    @Mock
    private AdminService adminService;

    @InjectMocks
    private AdminController adminController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void approveCoordinator_ValidRequest_ReturnsApprovedDecision() {
        CoordinatorDecisionDTO requestDto = new CoordinatorDecisionDTO();
        requestDto.setCoordinatorEmail("coord@unicauca.edu.co");

        CoordinatorDecisionDTO responseDto = new CoordinatorDecisionDTO();
        responseDto.setCoordinatorEmail("coord@unicauca.edu.co");
        responseDto.setStatus("APPROVED");

        when(adminService.processDecision(any(CoordinatorDecisionDTO.class))).thenReturn(responseDto);

        ResponseEntity<?> response = adminController.approveCoordinator(requestDto, "admin@unicauca.edu.co");

        assertEquals(HttpStatus.OK, response.getStatusCode());
        CoordinatorDecisionDTO body = (CoordinatorDecisionDTO) response.getBody();
        assertEquals("APPROVED", body.getStatus());
    }

    @Test
    void rejectCoordinator_ValidRequest_ReturnsRejectedDecision() {
        CoordinatorDecisionDTO requestDto = new CoordinatorDecisionDTO();
        requestDto.setCoordinatorEmail("coord@unicauca.edu.co");
        requestDto.setReason("Incomplete documentation");

        CoordinatorDecisionDTO responseDto = new CoordinatorDecisionDTO();
        responseDto.setCoordinatorEmail("coord@unicauca.edu.co");
        responseDto.setStatus("REJECTED");
        responseDto.setReason("Incomplete documentation");

        when(adminService.processDecision(any(CoordinatorDecisionDTO.class))).thenReturn(responseDto);

        ResponseEntity<?> response = adminController.rejectCoordinator(requestDto, "admin@unicauca.edu.co");

        assertEquals(HttpStatus.OK, response.getStatusCode());
        CoordinatorDecisionDTO body = (CoordinatorDecisionDTO) response.getBody();
        assertEquals("REJECTED", body.getStatus());
    }

    @Test
    void getAdminDecisions_ValidAdmin_ReturnsDecisionList() {
        CoordinatorDecisionDTO decisionDto = new CoordinatorDecisionDTO();
        decisionDto.setAdminEmail("admin@unicauca.edu.co");
        List<CoordinatorDecisionDTO> decisions = Collections.singletonList(decisionDto);

        when(adminService.getDecisionsByAdmin("admin@unicauca.edu.co")).thenReturn(decisions);

        ResponseEntity<List<CoordinatorDecisionDTO>> response =
                adminController.getAdminDecisions("admin@unicauca.edu.co");

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().size());
        assertEquals("admin@unicauca.edu.co", response.getBody().get(0).getAdminEmail());
    }
}