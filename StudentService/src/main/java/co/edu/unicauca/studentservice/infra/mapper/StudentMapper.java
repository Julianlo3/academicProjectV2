package co.edu.unicauca.studentservice.infra.mapper;

import co.edu.unicauca.studentservice.entity.Student;
import co.edu.unicauca.studentservice.infra.dto.StudentRequest;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    public StudentRequest toDto(Student student) {
        StudentRequest dto = new StudentRequest();
        dto.setId(student.getId());
        dto.setCode(student.getCode());
        dto.setName(student.getName());
        dto.setPhone(student.getPhone());
        dto.setEmail(student.getEmail());
        return dto;
    }

    public Student toEntity(StudentRequest dto) {
        Student student = new Student();
        student.setId(dto.getId());
        student.setCode(dto.getCode());
        student.setName(dto.getName());
        student.setPhone(dto.getPhone());
        student.setEmail(dto.getEmail());
        return student;
    }
}
