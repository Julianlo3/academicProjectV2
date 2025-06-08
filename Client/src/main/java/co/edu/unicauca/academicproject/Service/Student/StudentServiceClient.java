package co.edu.unicauca.academicproject.Service.Student;
import co.edu.unicauca.academicproject.entities.Assignment;
import co.edu.unicauca.academicproject.entities.ProjectApplicationRequest;
import co.edu.unicauca.academicproject.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@Service
public class StudentServiceClient {

    @Autowired
    private StudentFeingClient FeignClient;

    public void CreateStudent(Student student,String token) {
        FeignClient.createStudent(student, token);
    }

    public List<Student> GetAllStudents(String token){
        return FeignClient.getAllUser(token);
    }


    public Student getStudentByCode(Long code,String token){
        return FeignClient.getStudentByCode(code, token);
    }

    public void updateStudent(Long code, Student studentRequest){
        FeignClient.updateStudent(code, studentRequest);
    }

    public void deleteStudent(Long code){
        FeignClient.deleteStudent(code);
    }

    public void applyToProject(Long studentCode,Long projectId,String token){
        FeignClient.applyToProject(studentCode, projectId, token);
    }

    public List<Assignment> getAssignmentByStudentCode(Long studentCode, String token){
        return FeignClient.getAssignmentByStudentCode(studentCode, token);
    }
}
