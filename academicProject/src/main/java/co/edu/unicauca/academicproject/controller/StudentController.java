package co.edu.unicauca.academicproject.controller;

import co.edu.unicauca.academicproject.Service.StudentServiceClient;
import co.edu.unicauca.academicproject.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;


import javax.swing.*;


/**
 * @author lopez
 * @date 14/04/2025
 */

public class StudentController {

    private final StudentServiceClient studentServiceClient;

    public StudentController(StudentServiceClient studentServiceClient) {
        this.studentServiceClient = studentServiceClient;
    }


    public void registerUser(String code, String name, String phone, String email, String password) {
        try {
            // Crea un objeto de tipo Student con los datos recibidos
            Student student = new Student(code, name, phone, email, password);

            // Llama al servicio para guardar el estudiante
            studentServiceClient.CreateStudent(student);

            // Muestra un mensaje de éxito
            JOptionPane.showMessageDialog(null, "Estudiante creado con éxito.");
        } catch (Exception e) {
            // Si ocurre un error, muestra un mensaje de error
            JOptionPane.showMessageDialog(null, "Error al crear estudiante.");
        }
    }
    }



