package co.edu.unicauca.academicproject.GUI.controller.Admin;


import co.edu.unicauca.academicproject.GUI.admin.GUIUsers;
import co.edu.unicauca.academicproject.Service.Student.StudentServiceClient;
import co.edu.unicauca.academicproject.controller.StudentController;
import co.edu.unicauca.academicproject.entities.Student;
import co.edu.unicauca.academicproject.provider.appContextProvider;

import javax.swing.table.DefaultTableModel;
import java.util.List;

/**
 * @author lopez
 * @date 3/05/2025
 */
public class ControllerUserSystem {
    private final GUIUsers vista;
    StudentController studentController = new StudentController(appContextProvider.getBean(StudentServiceClient.class));

    public ControllerUserSystem(GUIUsers vista) {
        this.vista = vista;
        cargarEstudiantes();
    }

    private void cargarEstudiantes(){
        List<Student> students = studentController.getAllStudents();
        DefaultTableModel modeloStudent = new DefaultTableModel(new String[]{"Codigo", "Nombre", "Telefono", "Email"}, 0);
        if (students!= null){
            modeloStudent.setRowCount(0);

                for (Student student : students) {

                    if (student.getName() != null && student.getCode() != 0) {
                        modeloStudent.addRow(new Object[]{student.getCode(), student.getName(), student.getPhone(), student.getEmail()});
                    }
                    vista.getjTableStudent().setModel(modeloStudent);
                }
        }
    }
}
