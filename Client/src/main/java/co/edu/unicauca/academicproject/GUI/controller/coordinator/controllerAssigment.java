package co.edu.unicauca.academicproject.GUI.controller.coordinator;


import co.edu.unicauca.academicproject.GUI.coordinator.GUIAssigment;
import co.edu.unicauca.academicproject.Service.Company.CompanyServiceClient;
import co.edu.unicauca.academicproject.Service.Coordinator.CoordinatorServiceClient;
import co.edu.unicauca.academicproject.Service.Student.StudentServiceClient;
import co.edu.unicauca.academicproject.Service.project.ProjectServiceClient;
import co.edu.unicauca.academicproject.controller.CompanyController;
import co.edu.unicauca.academicproject.controller.CoordinatorController;
import co.edu.unicauca.academicproject.controller.ProjectController;
import co.edu.unicauca.academicproject.controller.StudentController;
import co.edu.unicauca.academicproject.entities.Project;
import co.edu.unicauca.academicproject.entities.Student;
import co.edu.unicauca.academicproject.provider.appContextProvider;

import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

/**
 * @author lopez
 * @date 4/06/2025
 */
public class controllerAssigment {
    private final GUIAssigment vista;
    private String token;

    StudentController studentController = new StudentController(appContextProvider.getBean(StudentServiceClient.class));
    CoordinatorController coordinatorController = new CoordinatorController(appContextProvider.getBean(CoordinatorServiceClient.class));
    CompanyController companyController = new CompanyController(appContextProvider.getBean(CompanyServiceClient.class));
    ProjectController projectController = new ProjectController(appContextProvider.getBean(ProjectServiceClient.class));

    public controllerAssigment(GUIAssigment vista) {
        this.vista = vista;
        this.token = vista.getToken();
        cargarEstudiantes();
        cargarProyectos();
        vista.getjBtnSaveProject().addActionListener(e-> asignarProyecto());
        vista.getjBtnQuitar().addActionListener(e-> quitarProyecto());
        this.vista.getjTableProjects().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila = vista.getjTableProjects().getSelectedRow();
                if (fila >= 0) {
                    long id = Long.parseLong( vista.getjTableProjects().getValueAt(fila, 0).toString()); // columna 0 es code
                    String nombre = ((String) vista.getjTableProjects().getValueAt(fila, 1));
                    vista.getjLabelNameProject().setText(nombre);
                    System.out.println("Nombre del proyecto seleccionado: " + nombre + " con code: " + id);
                }
            }
        });
        this.vista.getjTableStudent().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila = vista.getjTableStudent().getSelectedRow();
                if (fila >= 0) {
                    long id = Long.parseLong( vista.getjTableStudent().getValueAt(fila, 0).toString()); // columna 0 es code
                    String nombre = ((String) vista.getjTableStudent().getValueAt(fila, 1));
                    vista.getjLStudent().setText(nombre);
                    System.out.println("Nombre del estudiante seleccionado: " + nombre + " con code: " + id);
                }
            }
        });
    }

    private void asignarProyecto() {}

    private void quitarProyecto() {}

    private void cargarEstudiantes() {
        DefaultTableModel modeloStudent = new DefaultTableModel(new String[]{"Codigo", "Nombre", "Telefono", "Email"}, 0);
        try {
            List<Student> students = studentController.getAllStudents("bearer " + vista.getToken());
            if (students != null) {
                modeloStudent.setRowCount(0);

                for (Student student : students) {

                    if (student.getName() != null && student.getCode() != 0) {
                        modeloStudent.addRow(new Object[]{student.getCode(), student.getName(), student.getPhone(), student.getEmail()});
                    }

                }
            }

        } catch (Exception e) {
            System.out.println("Servicio de estudiante no disponible" + e.getMessage());
        }
        vista.getjTableStudent().setModel(modeloStudent);
    }

    private void cargarProyectos() {
        DefaultTableModel modeloProyecto = new DefaultTableModel(new String[]{"Nit Empresa", "Titulo", "Año", "resumen"}, 0);
        try {
            List<Project> projects = projectController.getAllProjects("bearer " + vista.getToken());
            if (projects != null) {
                modeloProyecto.setRowCount(0);

                for (Project proyect : projects) {

                    if (proyect.getName() != null && proyect.getCompanyNit() != 0) {
                        modeloProyecto.addRow(new Object[]{proyect.getCompanyNit(), proyect.getName(), proyect.getAcademicYear(), proyect.getSummary()});
                    }

                }
            }

        } catch (Exception e) {
            System.out.println("Servicio de estudiante no disponible" + e.getMessage());
        }
        vista.getjTableProjects().setModel(modeloProyecto);
    }
}
