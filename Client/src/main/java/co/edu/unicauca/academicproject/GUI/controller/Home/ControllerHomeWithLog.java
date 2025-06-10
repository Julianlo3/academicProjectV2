/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.academicproject.GUI.controller.Home;

import co.edu.unicauca.academicproject.GUI.GUIHomeWithLog;
import co.edu.unicauca.academicproject.GUI.GUIHomeWithOutLog;
import co.edu.unicauca.academicproject.GUI.company.GUIMySolisCompany;
import co.edu.unicauca.academicproject.GUI.company.GUINewProject;
import co.edu.unicauca.academicproject.GUI.admin.GUIRequestCoordinator;
import co.edu.unicauca.academicproject.GUI.admin.GUIUsers;
import co.edu.unicauca.academicproject.GUI.coordinator.GUIAssigment;
import co.edu.unicauca.academicproject.GUI.coordinator.GUIStatistics;
import co.edu.unicauca.academicproject.GUI.coordinator.GUIStudentRequest;
import co.edu.unicauca.academicproject.GUI.student.GUIMySolisStudent;
import co.edu.unicauca.academicproject.GUI.student.GUINominationProject;
import co.edu.unicauca.academicproject.Service.Company.CompanyServiceClient;
import co.edu.unicauca.academicproject.Service.Coordinator.CoordinatorServiceClient;
import co.edu.unicauca.academicproject.Service.Student.StudentServiceClient;
import co.edu.unicauca.academicproject.Service.project.ProjectServiceClient;
import co.edu.unicauca.academicproject.controller.CompanyController;
import co.edu.unicauca.academicproject.controller.CoordinatorController;
import co.edu.unicauca.academicproject.controller.ProjectController;
import co.edu.unicauca.academicproject.controller.StudentController;
import co.edu.unicauca.academicproject.entities.*;
import co.edu.unicauca.academicproject.entities.observer.Observer;
import co.edu.unicauca.academicproject.entities.observer.Sujeto;
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

public class ControllerHomeWithLog implements Observer {
    @Override
    public void actualizar(String mensaje) {
        System.out.println("Actualizando tabla en home con login " + mensaje);
        if(vista.getjButtonQuitF().isVisible()){
            buscarProyectos();
        }
        else {
            cargarProyectos();
        }
    }

    CardLayout cardLayout;
    StudentController studentController = new StudentController(appContextProvider.getBean(StudentServiceClient.class));
    CompanyController companyController = new CompanyController(appContextProvider.getBean(CompanyServiceClient.class));
    ProjectController projectController = new ProjectController(appContextProvider.getBean(ProjectServiceClient.class));
    CoordinatorController coordinatorController = new CoordinatorController(appContextProvider.getBean(CoordinatorServiceClient.class));
    private final GUIHomeWithLog vista;
    private String rol;
    private String code;
    private String token;
    Users user = new Users();

    public ControllerHomeWithLog(GUIHomeWithLog vista, String token,Sujeto sujeto) {
        this.vista = vista;
        this.vista.getjButtonQuitF().setVisible(false);
        sujeto.agregarObservador(this);
        this.token = token;
        this.rol = vista.getRol();
        this.code = vista.getidUser();
        cargarFormRol();
        this.vista.getjBtnGetOut().addActionListener(e -> cerrarSeccion());
        this.vista.getjBtnCoordiSoli().addActionListener(e -> cargarSolicitudesCoordi());
        this.vista.getjBtnUsersSistema().addActionListener(e -> cargarUsuariosSistema());
        this.vista.getjBtnSearch().addActionListener(e -> buscarProyectos());
        this.vista.getjButtonQuitF().addActionListener(e -> quitarFiltro());
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
        this.vista.getjBtnSoliEstudiante().addActionListener(e -> cargarMySolisEstudiante());
        this.vista.getJBtnSolisPubli().addActionListener(e-> abrirPublisCompany());
        this.vista.getjBtnMyPubli().addActionListener(e-> abrirPublisCompany());
        cargarProyectos();
    }

    private void abrirPublisCompany(){
        Sujeto sujeto = new Sujeto();
        GUIMySolisCompany solisCompany = new GUIMySolisCompany(vista.getIdUser(),token,rol,sujeto);
        solisCompany.setVisible(true);
    }

    private void quitarFiltro(){
        vista.getjFieldSearchProyect().setText("");
        vista.getjButtonQuitF().setVisible(false);
        cargarProyectos();
    }

    private void buscarProyectos(){
        vista.getjButtonQuitF().setVisible(true);
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
            System.out.println("Proyecto a buscar:" + vista.getjFieldSearchProyect().getText());
            List<Project> projects = projectController.searchByName(vista.getjFieldSearchProyect().getText(),"Bearer " + token);
            System.out.println("Proyectos encontrados: " + projects.size());
            if (projects != null) {
                modeloProject.setRowCount(0);
                int numero = 0;
                for (Project project : projects) {
                    if (project.getCompanyNit() != 0.0 && project.getName() != null) {
                        String nombreEmpresa = companyController.getCompanyByNit(project.getCompanyNit(),"Bearer " + token).getName();
                        modeloProject.addRow(new Object[]{numero++, project.getStartDate(),nombreEmpresa, project.getName(), project.getSummary()});
                    }
                }
            }

        } catch (Exception e) {
            System.out.println("Servicio de proyecto no disponible" + e.getMessage());
        }
        vista.getjTableProjects().setModel(modeloProject);

    }

    private void cargarMySolisEstudiante(){
        GUIMySolisStudent MySoli = new GUIMySolisStudent(code,token);
        MySoli.setVisible(true);
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
        Sujeto  sujeto = new Sujeto();
        GUIHomeWithOutLog homeWithLog = new GUIHomeWithOutLog(sujeto);
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
        Long code1 = Long.valueOf(code);
        if(coordinatorController.getAllRequestsByStudentCode(code1,"Bearer " + token).isEmpty()){
            vista.getJPoptions().setVisible(false);
        }
        else {
            vista.getJPoptions().setVisible(true);
        }

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
        Coordinator coordinator = coordinatorController.getCoordinatortByCode(Long.valueOf(code),"Bearer " + token);
        vista.getjBtnLoginU().setText(coordinator.getName());
    }

    private void cargarFormEmpresa() {
        vista.getjBtnLoginU().setIcon(new ImageIcon(getClass().getResource("/icon2.0/companyBig.png")));
        System.out.println("Cargando opciones de empresa:");
        cardLayout = (CardLayout) vista.getJPoptions().getLayout();
        cardLayout.show(vista.getJPoptions(), "Empresa");
        Company company = companyController.getCompanyByNit(Long.valueOf(code),"Bearer " + token);
        vista.getjBtnLoginU().setText(company.getName());
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
        if (company != null) {
            System.out.println("Datos de la empresa nit: " + company.getNit() + " Nombre: "+company.getName());
            Sujeto sujeto = new Sujeto();
            GUINewProject newProject = new GUINewProject(company, token,sujeto);
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
                    System.out.println("Proyecto encontrado: " + project.getName() + project.getDescription() + project.getStartDate() + project.getProjectId());
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
            List<Project> projects = projectController.getProjectByState("Approved","Bearer " + token);
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
