package co.edu.unicauca.coordinatorservice.services;

import co.edu.unicauca.coordinatorservice.infra.client.StudentClient;
import co.edu.unicauca.coordinatorservice.infra.dto.AssignmentRequestDTO;
import org.springframework.stereotype.Service;

@Service
public class StudentService implements IStudentService {

    private final StudentClient studentClient;

    public StudentService(StudentClient studentClient) {
        this.studentClient = studentClient;
    }

    @Override
    public void assignStudent(AssignmentRequestDTO assignmentRequestDTO) throws Exception {
        studentClient.assignStudent(assignmentRequestDTO);
    }

    @Override
    public void unassignAllStudents(Long projectId) throws Exception {
        studentClient.unassignAllStudentsToProject(projectId);
    }


}
