package co.edu.unicauca.academicproject.GUI.controller.Admin;


import co.edu.unicauca.academicproject.GUI.admin.GUIUsers;
import co.edu.unicauca.academicproject.Service.Coordinator.CoordinatorServiceClient;
import co.edu.unicauca.academicproject.Service.Student.StudentServiceClient;
import co.edu.unicauca.academicproject.controller.CoordinatorController;
import co.edu.unicauca.academicproject.controller.StudentController;
import co.edu.unicauca.academicproject.entities.Coordinator;
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
    CoordinatorController coordinatorController = new CoordinatorController(appContextProvider.getBean(CoordinatorServiceClient.class));

    public ControllerUserSystem(GUIUsers vista) {
        this.vista = vista;
        cargarEstudiantes();
        cargarCoordinadores();
    }

    private void cargarEstudiantes() {
        List<Student> students = studentController.getAllStudents();
        DefaultTableModel modeloStudent = new DefaultTableModel(new String[]{"Codigo", "Nombre", "Telefono", "Email"}, 0);
        if (students != null) {
            modeloStudent.setRowCount(0);

            for (Student student : students) {

                if (student.getName() != null && student.getCode() != 0) {
                    modeloStudent.addRow(new Object[]{student.getCode(), student.getName(), student.getPhone(), student.getEmail()});
                }
                vista.getjTableStudent().setModel(modeloStudent);
            }
        }
    }

    private void cargarCoordinadores() {
        List<Coordinator> coordinators = coordinatorController.getAllCoordinators();
        DefaultTableModel modeloCoordi = new DefaultTableModel(new String[]{"Codigo", "Nombre", "Telefono", "Email", "Estado", "Programa"}, 0);
        if (coordinators != null) {
            modeloCoordi.setRowCount(0);

            for (Coordinator coordinator : coordinators) {

                if (coordinator.getName() != null && coordinator.getCode() != 0) {
                    modeloCoordi.addRow(new Object[]{coordinator.getCode(), coordinator.getName(), coordinator.getPhone(), coordinator.getEmail(), coordinator.getEstadoActual(), coordinator.getProgramaAcademico()});
                }
                vista.getjTableCoordinator().setModel(modeloCoordi);
            }
        }

    }
}
