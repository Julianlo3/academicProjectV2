package co.edu.unicauca.coordinatorservice.command;

import co.edu.unicauca.coordinatorservice.infra.client.CompanyClient;
import co.edu.unicauca.coordinatorservice.infra.client.ProjectClient;
import co.edu.unicauca.coordinatorservice.infra.dto.CompanyDTO;
import co.edu.unicauca.coordinatorservice.infra.dto.CreateProjectCommentDTO;
import co.edu.unicauca.coordinatorservice.infra.dto.ProjectDTO;
import co.edu.unicauca.coordinatorservice.services.EmailNotificationService;

public class EvaluateProjectCommand implements Command {

    private final Long projectId;
    private final String newState;
    private final CreateProjectCommentDTO comment;

    private final ProjectClient projectClient;
    private final CompanyClient companyClient;
    private final EmailNotificationService emailService;

    public EvaluateProjectCommand(Long projectId,
                                  String newState,
                                  CreateProjectCommentDTO comment,
                                  ProjectClient projectClient,
                                  CompanyClient companyClient,
                                  EmailNotificationService emailService) {
        this.projectId = projectId;
        this.newState = newState;
        this.comment = comment;
        this.projectClient = projectClient;
        this.companyClient = companyClient;
        this.emailService = emailService;
    }

    @Override
    public void execute() {
        // 1. Obtener datos del proyecto desde project-service
        ProjectDTO project = projectClient.getProjectById(projectId).getBody();

        // 2. Obtener datos de la empresa desde company-service
        CompanyDTO company = companyClient.getCompanyByNit(project.getCompanyNit()).getBody();


        // 3. Enviar la peticion de aprovar o rechazar el proyecto
        if(newState.equals("Aprobado")) {
            projectClient.approveProject(projectId, comment);
        } else if(newState.equals("Rechazado")) {
            projectClient.rejectProject(projectId, comment);
        } else {
            throw new IllegalArgumentException("Invalid state: " + newState);
        }

        // 4. Enviar email de notificación
        emailService.sendProjectStatusChangeEmail(
                company.getEmail(),
                project.getName(),
                newState,
                comment.getComment(),
                company.getContactName(),
                company.getContactLastName(),
                company.getName()
        );
    }
}