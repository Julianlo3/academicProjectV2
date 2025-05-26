package co.edu.unicauca.gestioncoordinadormicroservice.command;

import co.edu.unicauca.gestioncoordinadormicroservice.services.AssignmentService;

public class AssignStudentCommand implements Command {

    private final Long studentCode;
    private final Long projectCode;
    private final AssignmentService assignmentService;

    public AssignStudentCommand(AssignmentService assignmentService, Long studentCode, Long projectCode) {
        this.assignmentService = assignmentService;
        this.studentCode = studentCode;
        this.projectCode = projectCode;
    }

    @Override
    public void execute() {
        assignmentService.assignStudentToProject(studentCode, projectCode);
    }
}