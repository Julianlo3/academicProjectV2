package co.edu.unicauca.academicproject.controller;

import co.edu.unicauca.academicproject.Service.Student.StudentServiceClient;
import co.edu.unicauca.academicproject.entities.Student;


import javax.swing.*;
import java.util.List;


/**
 * @author lopez
 * @date 14/04/2025
 */

public class StudentController {

    private final StudentServiceClient studentServiceClient;

    public StudentController(StudentServiceClient studentServiceClient) {
        this.studentServiceClient = studentServiceClient;
    }

    public void registerStudent(long code, String name, long phone, String email, String password) {
        try {
            // Crea un objeto de tipo Student con los datos recibidos
            Student student = new Student(code, name, phone, email, password);

            // Llama al servicio para guardar el estudiante
            studentServiceClient.CreateStudent(student);
            // Muestra un mensaje de éxito
            JOptionPane.showMessageDialog(null, "Estudiante creado con éxito.");
            System.out.println("Estudiante creado: " + student.getName() + student.getCode() + student.getEmail());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al crear estudiante.");
        }
    }

    public Student checkStudent(Long code, String password) {
        Student estudiante = studentServiceClient.getStudentByCode(code);
        if (estudiante.getPassword().equals(password)) {
            return estudiante;
        } else {
            return null;
        }
    }

    public List<Student> getAllStudents(){
        return studentServiceClient.GetAllStudents();
    }

    public Student getStudentByCode(Long code){
        return studentServiceClient.getStudentByCode(code);
    }
}



