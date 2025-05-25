package co.edu.unicauca.studentservice.infra.mapper;

import co.edu.unicauca.studentservice.entity.Assignment;
import co.edu.unicauca.studentservice.entity.Student;
import co.edu.unicauca.studentservice.infra.dto.AssignmentRequest;
import org.springframework.stereotype.Component;

@Component
public class AssignmentMapper {

    public AssignmentRequest toDto(Assignment assignment) {
        AssignmentRequest dto = new AssignmentRequest();
        dto.setId(assignment.getId());
        dto.setStudentCode(assignment.getStudent() != null ? assignment.getStudent().getId() : null);
        dto.setProjectId(assignment.getProjectId());
        dto.setDateAssignment(assignment.getDateAssignment());
        return dto;
    }

    public Assignment toEntity(AssignmentRequest dto, Student student) {
        Assignment assignment = new Assignment();
        assignment.setId(dto.getId());
        assignment.setStudent(student);
        assignment.setProjectId(dto.getProjectId());
        // No se establece dateAssignment manualmente, lo gestiona @CreationTimestamp
        return assignment;
    }
}
