/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.academicproject.GUI.controller.Home;

import co.edu.unicauca.academicproject.GUI.GUIHomeWithLog;
import co.edu.unicauca.academicproject.GUI.GUIHomeWithOutLog;
import co.edu.unicauca.academicproject.GUI.GUINewProject;
import co.edu.unicauca.academicproject.GUI.admin.GUIRequestCoordinator;
import co.edu.unicauca.academicproject.GUI.admin.GUIUsers;
import co.edu.unicauca.academicproject.Service.Company.CompanyServiceClient;
import co.edu.unicauca.academicproject.Service.Student.StudentServiceClient;
import co.edu.unicauca.academicproject.Service.project.ProjectServiceClient;
import co.edu.unicauca.academicproject.controller.CompanyController;
import co.edu.unicauca.academicproject.controller.ProjectController;
import co.edu.unicauca.academicproject.controller.StudentController;
import co.edu.unicauca.academicproject.entities.Admin;
import co.edu.unicauca.academicproject.entities.Company;
import co.edu.unicauca.academicproject.entities.Student;
import co.edu.unicauca.academicproject.entities.Project;
import co.edu.unicauca.academicproject.provider.appContextProvider;

import java.awt.CardLayout;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lopez
 */

public class ControllerHomeWithLog {
    CardLayout cardLayout;
    StudentController studentController = new StudentController(appContextProvider.getBean(StudentServiceClient.class));
    CompanyController companyController = new CompanyController(appContextProvider.getBean(CompanyServiceClient.class));
    ProjectController projectController = new ProjectController(appContextProvider.getBean(ProjectServiceClient.class));
    private final GUIHomeWithLog vista;
    private String rol;
    private long code;
    public ControllerHomeWithLog(GUIHomeWithLog vista){
        this.vista = vista;
        this.rol = vista.getRol();
        this.code = vista.getidUser();
        cargarFormRol();
        this.vista.getjBtnGetOut().addActionListener(e -> cerrarSeccion());
        this.vista.getjBtnCoordiSoli().addActionListener(e -> cargarSolicitudesCoordi());
        this.vista.getjBtnUsersSistema().addActionListener(e -> cargarUsuariosSistema());
        this.vista.getjBtnNewPubli().addActionListener(e -> newProject());
        cargarProyectos();
    }

    private void cerrarSeccion(){
        vista.dispose();
        GUIHomeWithOutLog homeWithLog = new GUIHomeWithOutLog();
        homeWithLog.setExtendedState(JFrame.MAXIMIZED_BOTH);
        homeWithLog.setVisible(true);
    }

    private void cargarFormRol(){
        switch (rol) {
            case "Estudiante": cargarformStudent(); break;
            case "Admin": cargarFormAdmin(); break;
            case "Coordinador": cargarFormCoordi(); break;
            case "Empresa": cargarFormEmpresa(); break;
        }
        System.out.println("Rol:" + rol);
    }

    private void cargarformStudent(){
        System.out.println("Cargando opciones de estudiante:");
        cardLayout = (CardLayout) vista.getJPoptions().getLayout();
        cardLayout.show(vista.getJPoptions(),"Estudiante");
        Student student = studentController.getStudentByCode(Long.valueOf(code));
        vista.getLbLogin().setText(student.getName());
    }

    private void cargarFormAdmin(){
        System.out.println("Cargando opciones de administrador:");
        cardLayout = (CardLayout) vista.getJPoptions().getLayout();
        cardLayout.show(vista.getJPoptions(),"Admin");
        vista.getLbLogin().setText(Admin.getInstance().getNombre());
    }

    private void cargarFormCoordi(){
        System.out.println("Cargando opciones de coordinador:");
        cardLayout = (CardLayout) vista.getJPoptions().getLayout();
        cardLayout.show(vista.getJPoptions(),"Coordinador");
        vista.getLbLogin().setText(Admin.getInstance().getNombre());
    }

    private void cargarFormEmpresa(){
        System.out.println("Cargando opciones de empresa:");
        cardLayout = (CardLayout) vista.getJPoptions().getLayout();
        cardLayout.show(vista.getJPoptions(),"Empresa");
        vista.getLbLogin().setText(Admin.getInstance().getNombre());
    }

    private void cargarSolicitudesCoordi(){
        GUIRequestCoordinator requestCoordinator = new GUIRequestCoordinator();
        requestCoordinator.setVisible(true);

    }

    private void cargarUsuariosSistema(){
        GUIUsers usuariosSistema = new GUIUsers();
        usuariosSistema.setVisible(true);
    }

    private void newProject(){
        Company company = companyController.getCompanyByNit(code);
        if (company != null) {
            System.out.println("Datos de la empresa" + company.getNit() + company.getName());
            GUINewProject newProject = new GUINewProject(company);
            newProject.setVisible(true);
        }
        else {
            System.out.println("Error al encontrar empresa");
        }
    }

    private void cargarProyectos(){
        DefaultTableModel modeloProject = new DefaultTableModel(new String[]{"Titulo", "Descripcion", "CompanyNit"}, 0);
        try {
            List<Project> projects = projectController.getAllProjects();
            if (projects != null) {
                modeloProject.setRowCount(0);

                for (Project project : projects) {

                    if (project.getCompanyNit() != null && project.getTitle() != null) {
                        modeloProject.addRow(new Object[]{project.getTitle(), project.getDescription(), project.getCompanyNit()});
                    }

                }
            }
        } catch (Exception e) {
            System.out.println("Servicio de coordinador no disponible" + e.getMessage());
        }
        vista.getjTableProjects().setModel(modeloProject);
    }
}
