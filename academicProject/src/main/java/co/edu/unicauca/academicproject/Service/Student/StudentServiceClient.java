package co.edu.unicauca.academicproject.Service.Student;
import co.edu.unicauca.academicproject.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceClient {

    @Autowired
    private StudentFeingClient FeignClient;

    public void CreateStudent(Student student) {
        FeignClient.createStudent(student);
    }

    public List<Student> GetAllStudents(){
        return FeignClient.getAllUser();
    }


    public Student getStudentByCode(Long code){
        return FeignClient.getStudentByCode(code);
    }

    public void updateStudent(Long code, Student studentRequest){
        FeignClient.updateStudent(code, studentRequest);
    }

    public void deleteStudent(Long code){
        FeignClient.deleteStudent(code);
    }
}
