package co.edu.unicauca.studentservice.repository;

import co.edu.unicauca.studentservice.entity.Project;
import co.edu.unicauca.studentservice.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner{
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public void run(String... args) throws Exception {
        Student student = new Student(1L, 123456789L, "Anderson", 987654321L, "anderson@unicauca.com", "123456");
        studentRepository.save(student);

        Project project = new Project(1L, "Project 1", "Description of project 1", "ASSIGNED");
        projectRepository.save(project);

    }


}
