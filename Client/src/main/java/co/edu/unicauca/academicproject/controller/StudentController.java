package co.edu.unicauca.academicproject.controller;

import co.edu.unicauca.academicproject.Service.Student.StudentServiceClient;
import co.edu.unicauca.academicproject.entities.Assignment;
import co.edu.unicauca.academicproject.entities.ProjectApplicationRequest;
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

    public void registerStudent(long code, String name, long phone, String email,String token) {
        try {
            // Crea un objeto de tipo Student con los datos recibidos
            Student student = new Student(code, name, phone, email);

            // Llama al servicio para guardar el estudiante
            studentServiceClient.CreateStudent(student,token);
            // Muestra un mensaje de éxito
            JOptionPane.showMessageDialog(null, "Estudiante creado con éxito.");
            System.out.println("Estudiante creado: " + student.getName() + student.getCode() + student.getEmail());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al crear estudiante." + e.getMessage());
        }
    }


    public List<Student> getAllStudents(String token){
        return studentServiceClient.GetAllStudents(token);
    }

    public Student getStudentByCode(Long code,String token){
        return studentServiceClient.getStudentByCode(code, token);
    }

    public void applyToProject(long studentCode, long projectCode, String token) {
        try{
            studentServiceClient.applyToProject(studentCode,projectCode,token);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public List<Assignment> getAssignmentByStudentCode(Long studentCode, String token){
        try {
            return studentServiceClient.getAssignmentByStudentCode(studentCode, token);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}



