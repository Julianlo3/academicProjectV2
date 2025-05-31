package co.edu.unicauca.academicproject.GUI.controller.Admin;


import co.edu.unicauca.academicproject.GUI.admin.GUIUsers;
import co.edu.unicauca.academicproject.Service.Company.CompanyServiceClient;
import co.edu.unicauca.academicproject.Service.Coordinator.CoordinatorServiceClient;
import co.edu.unicauca.academicproject.Service.Student.StudentServiceClient;
import co.edu.unicauca.academicproject.controller.CompanyController;
import co.edu.unicauca.academicproject.controller.CoordinatorController;
import co.edu.unicauca.academicproject.controller.StudentController;
import co.edu.unicauca.academicproject.entities.Company;
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
    CompanyController companyController = new CompanyController(appContextProvider.getBean(CompanyServiceClient.class));

    public ControllerUserSystem(GUIUsers vista) {
        this.vista = vista;
        cargarEstudiantes();
        cargarCoordinadores();
        cargarEmpresas();
    }

    private void cargarEstudiantes() {
        DefaultTableModel modeloStudent = new DefaultTableModel(new String[]{"Codigo", "Nombre", "Telefono", "Email"}, 0);
        try {
            List<Student> students = studentController.getAllStudents();
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

    private void cargarCoordinadores() {
        DefaultTableModel modeloCoordi = new DefaultTableModel(new String[]{"Codigo", "Nombre", "Telefono", "Email", "Estado", "Programa"}, 0);
        try {
            List<Coordinator> coordinators = coordinatorController.getAllCoordinators();
            if (coordinators != null) {
                modeloCoordi.setRowCount(0);

                for (Coordinator coordinator : coordinators) {

                    if (coordinator.getName() != null && coordinator.getCode() != 0) {
                        modeloCoordi.addRow(new Object[]{coordinator.getCode(), coordinator.getName(), coordinator.getPhone(), coordinator.getEmail(), coordinator.getEstadoActual(), coordinator.getProgramaAcademico()});
                    }

                }
            }
        } catch (Exception e) {
            System.out.println("Servicio de coordinador no disponible" + e.getMessage());
        }
        vista.getjTableCoordinator().setModel(modeloCoordi);
    }

    private void cargarEmpresas(){
        DefaultTableModel modeloEmpresa = new DefaultTableModel(new String[]{"nit","nombre","sector","email", "phone","website"}, 0);
        try {
            List<Company> companies = companyController.getAllCompanies();
            if (companies != null) {
                modeloEmpresa.setRowCount(0);

                for (Company company : companies) {
                    modeloEmpresa.addRow(new Object[]{company.getNit(),company.getName(),company.getIndustrialSector(),company.getEmail(),company.getContactPhone(),company.getWebsite()});
                }
            }
        } catch (Exception e) {
            System.out.println("Servicio de empresa no disponible" + e.getMessage());
        }
        vista.getjTableCompany().setModel(modeloEmpresa);
    }
}
