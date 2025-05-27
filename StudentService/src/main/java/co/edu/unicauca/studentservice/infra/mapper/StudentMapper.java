package co.edu.unicauca.studentservice.infra.mapper;

import co.edu.unicauca.studentservice.entity.Student;
import co.edu.unicauca.studentservice.infra.dto.StudentDTO;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    public StudentDTO toDto(Student student) {
        return new StudentDTO(
                student.getId(),
                student.getCode(),
                student.getName(),
                student.getPhone(),
                student.getEmail()
        );
    }

    public Student toEntity(StudentDTO dto) {
        return new Student(
                dto.getId(),
                dto.getCode(),
                dto.getName(),
                dto.getPhone(),
                dto.getEmail()
        );
    }
}
