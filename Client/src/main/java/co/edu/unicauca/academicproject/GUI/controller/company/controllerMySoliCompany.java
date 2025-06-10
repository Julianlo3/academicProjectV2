package co.edu.unicauca.academicproject.GUI.controller.company;


import co.edu.unicauca.academicproject.GUI.company.GUIMySolisCompany;
import co.edu.unicauca.academicproject.GUI.coordinator.GUIminiRequest;
import co.edu.unicauca.academicproject.Service.Company.CompanyServiceClient;
import co.edu.unicauca.academicproject.Service.Coordinator.CoordinatorServiceClient;
import co.edu.unicauca.academicproject.Service.project.ProjectServiceClient;
import co.edu.unicauca.academicproject.controller.CompanyController;
import co.edu.unicauca.academicproject.controller.CoordinatorController;
import co.edu.unicauca.academicproject.controller.ProjectController;
import co.edu.unicauca.academicproject.entities.Company;
import co.edu.unicauca.academicproject.entities.Coordinator;
import co.edu.unicauca.academicproject.entities.Project;
import co.edu.unicauca.academicproject.provider.appContextProvider;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lopez
 * @date 9/06/2025
 */
public class controllerMySoliCompany {

    CompanyController companyController = new CompanyController(appContextProvider.getBean(CompanyServiceClient.class));
    ProjectController projectController = new ProjectController(appContextProvider.getBean(ProjectServiceClient.class));
    CoordinatorController coordinatorController = new CoordinatorController(appContextProvider.getBean(CoordinatorServiceClient.class));
    private final GUIMySolisCompany vista;
    private String rol;
    public controllerMySoliCompany(GUIMySolisCompany vista,String rol){
        this.vista = vista;
        this.rol = rol;
        vista.getjPDetalleSolicitud().setVisible(false);
        cargarOpciones();
        cargarDatos();
        this.vista.getjBtnCerrarPubli().addActionListener(e-> cerrarPubli());
        this.vista.getjBtnFiltrar().addActionListener(e-> filtrar());
        this.vista.getjBtnQuitarFiltro().addActionListener(e-> quitarFiltro());
        vista.getjBtnQuitarFiltro().setVisible(false);
        cargarPublis();
    }

    private void quitarFiltro(){
        cargarPublis();
        vista.getjBtnQuitarFiltro().setVisible(false);
    }

    private void filtrar() {
        vista.getjPChat().removeAll();
        int year = vista.getjYear().getValue();
        int periodo = vista.getjSpinPeriodo().getValue();
        String estado = vista.getjCBEstadoProyecto().getSelectedItem().toString();
        try {
            List<Project> publis = projectController.getProjectsFilter(estado,year,periodo,"Bearer " + vista.getToken());
            System.out.println("# de publicaciones:" + publis.size());
            for (Project publi : publis) {
                System.out.println(publi.getName() + publi.getState());
            }

            for (Project publi : publis) {

                Project project = projectController.getProjectById(publi.getProjectId(), "bearer " + vista.getToken());
                cargarPubli(project.getName(), project.getState(),project.getProjectId(),project);
            }

            vista.getjBtnQuitarFiltro().setVisible(true);
        } catch (Exception e) {
            System.out.println("Error en filtrar" + e.getMessage());
        }
    }

    private void cargarOpciones(){
        vista.getjPEstadoPubli().setVisible(rol.equals("coordinator"));
        vista.getjPFiltrar().setVisible(rol.equals("coordinator"));
    }

    private void cerrarPubli() {
        this.vista.dispose();
    }

    private void cargarDatos() {
        System.out.println("Rol acceido:" + rol);
        switch (rol){
            case "coordinator":{
                vista.getjBtnLoginU().setIcon(new ImageIcon(getClass().getResource("/icon2.0/coordiBig.png")));
                vista.getjBtnNewPubli().setText("Solicitudes publicaciones");
                Coordinator coordinator = coordinatorController.getCoordinatortByCode(Long.valueOf(vista.getnitCompany()),"Bearer " + vista.getToken());
                vista.getjBtnLoginU().setText(coordinator.getName());
                break;
            }
            case "company":{
                vista.getjBtnLoginU().setIcon(new ImageIcon(getClass().getResource("/icon2.0/companyBig.png")));
                Company company = companyController.getCompanyByNit(Long.valueOf(vista.getnitCompany()),"Bearer " + vista.getToken());
                vista.getjBtnLoginU().setText(company.getName());
                break;
            }
        }

    }

    private void cargarPublis() {

        try {
            List<Project> publis = new ArrayList<>();

            if(rol.equals("coordinator")){
                publis = projectController.getAllProjects("Bearer " + vista.getToken());
            }
            if(rol.equals("company")){
                publis = projectController.getProjectsByCompany(Long.valueOf(vista.getnitCompany()),"Bearer " + vista.getToken());
            }
            System.out.println("# de publicaciones:" + publis.size());
            for (Project publi : publis) {
                System.out.println(publi.getName() + publi.getState());
            }

            for (Project publi : publis) {

                Project project = projectController.getProjectById(publi.getProjectId(), "bearer " + vista.getToken());
                cargarPubli(project.getName(), project.getState(),project.getProjectId(),project);
            }

        } catch (Exception e) {
            System.out.println("error con las solis " + e.getMessage());
        }
    }

    private void cargarPubli(String tituloProyecto, String estadoProyecto,long idPubli,Project project) {
        GUIminiRequest chat = new GUIminiRequest(tituloProyecto,"no",vista.getjBtnLoginU().getText(),estadoProyecto,idPubli);
        chat.getjBtnVerDetalles().addActionListener(e -> cargarDetalles(project));
        chat.setPreferredSize(new Dimension(200, 220));
        chat.getjLEstudiante().setVisible(false);
        chat.getjLTEmpresa().setVisible(false);
        chat.getjLNombreEmpresa().setVisible(false);
        chat.getjLTEstudiante().setVisible(false);
        vista.getjPChat().add(chat);
        vista.getjPChat().revalidate();
        vista.getjPChat().repaint();
    }

    private void cargarDetalles(Project project) {
        try {
            vista.getjFieldTitleProject().setText(project.getName());
            vista.getjTextAreaResumen().setText(project.getSummary());
            vista.getjTextAreaDescripProject().setText(project.getDescription());
            vista.getjTextAreaObjetivos().setText(project.getObjectives());
            vista.getjYearProyecto().setValue(project.getAcademicYear());
            vista.getjSpinTerm().setValue(project.getAcademicTerm());
            vista.getjSpinDuracionMes().setValue(project.getMaxDurationInMonths());
            vista.getjFieldPresupuesto().setText(String.valueOf(project.getBudget()));
            try {
                vista.setjDateChFechaInicio(project.getStartDate().toString());
            } catch (Exception e) {
                System.out.println("Error al cargar fecha de inicio del proyecto" + e.getMessage());
            }
            vista.getjLEstadoSolicitud().setText(project.getState());
            vista.getjPDetalleSolicitud().setVisible(true);
        } catch (Exception e) {
            System.out.println("Error en cargar detalles " + e.getMessage());
        }
    }
}
