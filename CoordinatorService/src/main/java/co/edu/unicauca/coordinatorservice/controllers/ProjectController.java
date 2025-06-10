package co.edu.unicauca.coordinatorservice.controllers;

import co.edu.unicauca.coordinatorservice.command.Command;
import co.edu.unicauca.coordinatorservice.command.CommandInvoker;
import co.edu.unicauca.coordinatorservice.command.EvaluateProjectCommand;
import co.edu.unicauca.coordinatorservice.infra.client.CompanyClient;
import co.edu.unicauca.coordinatorservice.infra.client.ProjectClient;
import co.edu.unicauca.coordinatorservice.infra.dto.CreateProjectCommentDTO;
import co.edu.unicauca.coordinatorservice.services.EmailNotificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/coordinator/project")
public class ProjectController {

    private final ProjectClient projectClient;
    private final CompanyClient companyClient;

    private final EmailNotificationService emailNotificationService;

    public ProjectController(ProjectClient projectClient, CompanyClient companyClient, EmailNotificationService emailNotificationService) {
        this.projectClient = projectClient;
        this.companyClient = companyClient;
        this.emailNotificationService = emailNotificationService;
    }

    @PutMapping("/{id}/approve")
    @PreAuthorize("hasRole('coordinator')")
    public ResponseEntity<Void> approveProject(@PathVariable Long id, @RequestBody CreateProjectCommentDTO dto) throws Exception {
        Command command = new EvaluateProjectCommand(
                id,
                "Aprobado",
                dto,
                projectClient,
                companyClient,
                emailNotificationService
        );

        CommandInvoker commandInvoker = new CommandInvoker();
        commandInvoker.addCommand(command);

        commandInvoker.executeCommands();
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/reject")
    @PreAuthorize("hasRole('coordinator')")
    public ResponseEntity<Void> rejectProject(@PathVariable Long id, @RequestBody CreateProjectCommentDTO dto) throws Exception {
        Command command = new EvaluateProjectCommand(
                id,
                "Rechazado",
                dto,
                projectClient,
                companyClient,
                emailNotificationService
        );

        CommandInvoker commandInvoker = new CommandInvoker();
        commandInvoker.addCommand(command);

        commandInvoker.executeCommands();
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/assign")
    @PreAuthorize("hasRole('coordinator')")
    public ResponseEntity<Void> assignProject(@PathVariable Long id) throws Exception {
        projectClient.assignProject(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/complete")
    @PreAuthorize("hasRole('coordinator')")
    public ResponseEntity<Void> completeProject(@PathVariable Long id) throws Exception {
        projectClient.completeProject(id);
        return ResponseEntity.ok().build();
    }

}
