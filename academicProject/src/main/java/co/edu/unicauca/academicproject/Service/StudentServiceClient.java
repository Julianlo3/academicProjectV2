package co.edu.unicauca.academicproject.Service;
import co.edu.unicauca.academicproject.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceClient {

    @Autowired
    private GestionUsuarioFeignClient FeignClient;


    public void CreateStudent(Student student) {
        FeignClient.createStudent(student);
    }


}
