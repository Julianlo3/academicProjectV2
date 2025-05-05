package co.edu.unicauca.adminmicroservice.controller;

import co.edu.unicauca.adminmicroservice.dto.CoordinatorDecisionDTO;
import co.edu.unicauca.adminmicroservice.Service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/admin/coordinators")
@RequiredArgsConstructor
public class CoordinatorController {

    private final AdminService adminService;

    @PostMapping("/approve")
    public ResponseEntity<?> approveCoordinator(
            @RequestBody CoordinatorDecisionDTO decisionDTO) {

        decisionDTO.setStatus("APPROVED");

        CoordinatorDecisionDTO response = adminService.processDecision(decisionDTO);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/reject")
    public ResponseEntity<?> rejectCoordinator(
            @Valid @RequestBody CoordinatorDecisionDTO decisionDTO,
            @RequestHeader("X-Admin-Email") String adminEmail) {

        adminService.getAdminByEmail(adminEmail);
        decisionDTO.setAdminEmail(adminEmail);
        decisionDTO.setStatus("REJECTED");

        CoordinatorDecisionDTO response = adminService.processDecision(decisionDTO);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/decisions")
    public ResponseEntity<List<CoordinatorDecisionDTO>> getAdminDecisions(
            @RequestHeader("X-Admin-Email") String adminEmail) {
        adminService.getAdminByEmail(adminEmail);
        return ResponseEntity.ok(adminService.getDecisionsByAdmin(adminEmail));
    }
}