/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.academicproject.GUI.controller.Home;

import co.edu.unicauca.academicproject.GUI.GUIHomeWithLog;
import co.edu.unicauca.academicproject.GUI.GUIHomeWithOutLog;
import co.edu.unicauca.academicproject.GUI.company.GUINewProject;
import co.edu.unicauca.academicproject.GUI.admin.GUIRequestCoordinator;
import co.edu.unicauca.academicproject.GUI.admin.GUIUsers;
import co.edu.unicauca.academicproject.GUI.coordinator.GUIAssigment;
import co.edu.unicauca.academicproject.GUI.coordinator.GUIStatistics;
import co.edu.unicauca.academicproject.GUI.coordinator.GUIStudentRequest;
import co.edu.unicauca.academicproject.GUI.student.GUINominationProject;
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
import co.edu.unicauca.academicproject.security.Users;

import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.*;
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
    private String code;
    private String token;
    Users user = new Users();

    public ControllerHomeWithLog(GUIHomeWithLog vista, String token) {
        this.vista = vista;
        this.token = token;
        this.rol = vista.getRol();
        this.code = vista.getidUser();
        cargarFormRol();
        this.vista.getjBtnGetOut().addActionListener(e -> cerrarSeccion());
        this.vista.getjBtnCoordiSoli().addActionListener(e -> cargarSolicitudesCoordi());
        this.vista.getjBtnUsersSistema().addActionListener(e -> cargarUsuariosSistema());
        this.vista.getjBtnNewPubli().addActionListener(e -> newProject());
        this.vista.getjTableProjects().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                abrirProyecto();
            }
        });
        this.vista.getjBtnAsignar().addActionListener(e -> abrirAsignar());
        this.vista.getJBtnEstadisticas().addActionListener(e -> abrirEstadisticas());
        this.vista.getjBtnSolicitudes().addActionListener(e -> cargarSolicitudesEstudiante());
        cargarProyectos();
    }

    private void cargarSolicitudesEstudiante() {
        GUIStudentRequest studentRequest = new GUIStudentRequest(token);
        studentRequest.setVisible(true);
    }

    private void abrirEstadisticas(){
        GUIStatistics estadisticas = new GUIStatistics(token);
        estadisticas.setVisible(true);
    }

    private void abrirAsignar() {
        GUIAssigment asignar = new GUIAssigment(token);
        asignar.setVisible(true);
    }

    private void cerrarSeccion() {
        vista.dispose();
        GUIHomeWithOutLog homeWithLog = new GUIHomeWithOutLog();
        homeWithLog.setExtendedState(JFrame.MAXIMIZED_BOTH);
        homeWithLog.setVisible(true);
    }

    private void cargarFormRol() {
        switch (rol) {
            case "student":
                cargarformStudent();
                break;
            case "admin":
                cargarFormAdmin();
                break;
            case "coordinator":
                cargarFormCoordi();
                break;
            case "company":
                cargarFormEmpresa();
                break;
        }
        System.out.println("Rol:" + rol);
    }

    private void cargarformStudent() {
        vista.getjBtnLoginU().setIcon(new ImageIcon(getClass().getResource("/icon2.0/estudianteBig.png")));
        System.out.println("Cargando opciones de estudiante:");
        cardLayout = (CardLayout) vista.getJPoptions().getLayout();
        cardLayout.show(vista.getJPoptions(), "Estudiante");
        System.out.println("token pasado" + token);
        System.out.println("code pasado " + code);
        Student student = studentController.getStudentByCode(Long.valueOf(code), "Bearer " + token);
        vista.getJPoptions().setVisible(false);
        vista.getjBtnLoginU().setText(student.getName());
    }

    private void cargarFormAdmin() {
        vista.getjBtnLoginU().setIcon(new ImageIcon(getClass().getResource("/icon2.0/adminBig.png")));
        System.out.println("Cargando opciones de administrador:");
        cardLayout = (CardLayout) vista.getJPoptions().getLayout();
        cardLayout.show(vista.getJPoptions(), "Admin");
        vista.getjBtnLoginU().setText(Admin.getInstance().getNombre());
    }

    private void cargarFormCoordi() {
        vista.getjBtnLoginU().setIcon(new ImageIcon(getClass().getResource("/icon2.0/coordiBig.png")));
        System.out.println("Cargando opciones de coordinador:");
        cardLayout = (CardLayout) vista.getJPoptions().getLayout();
        cardLayout.show(vista.getJPoptions(), "Coordinador");
        vista.getjBtnLoginU().setText(Admin.getInstance().getNombre());
    }

    private void cargarFormEmpresa() {
        vista.getjBtnLoginU().setIcon(new ImageIcon(getClass().getResource("/icon2.0/companyBig.png")));
        System.out.println("Cargando opciones de empresa:");
        cardLayout = (CardLayout) vista.getJPoptions().getLayout();
        cardLayout.show(vista.getJPoptions(), "Empresa");
        vista.getjBtnLoginU().setText(Admin.getInstance().getNombre());
    }

    private void cargarSolicitudesCoordi() {
        GUIRequestCoordinator requestCoordinator = new GUIRequestCoordinator(token);
        requestCoordinator.setVisible(true);

    }

    private void cargarUsuariosSistema() {
        GUIUsers usuariosSistema = new GUIUsers(token);
        usuariosSistema.setVisible(true);
    }

    private void newProject() {
        System.out.println("Cargando opciones de empresa:" + "con token" + token);
        Company company = companyController.getCompanyByNit(Long.valueOf(code), "Bearer " + token);
        System.out.println("Empresa encontrada" + company.getNit());
        if (company != null) {
            System.out.println("Datos de la empresa" + company.getNit() + company.getName());
            GUINewProject newProject = new GUINewProject(company, token);
            newProject.setVisible(true);
        } else {
            System.out.println("Error al encontrar empresa");
        }
    }

    private void abrirProyecto() {
        int fila = vista.getjTableProjects().getSelectedRow();
        System.out.println("Fila seleccionada: " + fila);
        if (fila >= 0) {
            String name = vista.getjTableProjects().getValueAt(fila, 3).toString(); // columna 0 es
            System.out.println("Proyecto seleccionado: " + name);
            try {
                if (rol.equals("student")) {
                    System.out.println("Token: " + token);
                    Project project = projectController.getProjectByName(name, "Bearer " + token);
                    System.out.println("Proyecto encontrado: " + project.getName() + project.getDescription() + project.getStartDate());
                    GUINominationProject newNomination = new GUINominationProject(project, token, rol,vista.getidUser());
                    newNomination.setVisible(true);
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void cargarProyectos() {
        String token = "";
        try {
            token = user.obtenerTokenRegis("guest", "123");
            System.out.println("Token: " + token);
        } catch (Exception e) {
            System.out.println("Error al obtener token de invitado" + e.getMessage());
            throw new RuntimeException(e);
        }

        DefaultTableModel modeloProject = new DefaultTableModel(new String[]{"#", "Fecha inicio", "Nombre empresa", "Titulo proyecto", "Resumen"}, 0);
        try {
            List<Project> projects = projectController.getAllProjects("Bearer " + token);
            System.out.println("Proyectos encontrados: " + projects.size());
            if (projects != null) {
                modeloProject.setRowCount(0);
                int numero = 0;
                for (Project project : projects) {

                    if (project.getCompanyNit() != 0.0 && project.getName() != null) {
                        modeloProject.addRow(new Object[]{numero++, project.getStartDate(), project.getCompanyNit(), project.getName(), project.getSummary()});
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Servicio de proyecto no disponible" + e.getMessage());
        }
        vista.getjTableProjects().setModel(modeloProject);
    }
}
