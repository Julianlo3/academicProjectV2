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
import co.edu.unicauca.academicproject.entities.CreateProjectComment;
import co.edu.unicauca.academicproject.entities.Project;
import co.edu.unicauca.academicproject.entities.observer.Observer;
import co.edu.unicauca.academicproject.entities.observer.Sujeto;
import co.edu.unicauca.academicproject.infra.Messages;
import co.edu.unicauca.academicproject.provider.appContextProvider;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lopez
 * @date 9/06/2025
 */
public class controllerMySoliCompany implements Observer {

    CompanyController companyController = new CompanyController(appContextProvider.getBean(CompanyServiceClient.class));
    ProjectController projectController = new ProjectController(appContextProvider.getBean(ProjectServiceClient.class));
    CoordinatorController coordinatorController = new CoordinatorController(appContextProvider.getBean(CoordinatorServiceClient.class));
    private final GUIMySolisCompany vista;
    private String rol;
    public controllerMySoliCompany(GUIMySolisCompany vista,String rol,Sujeto sujeto) {
        this.vista = vista;
        this.rol = rol;
        sujeto.agregarObservador(this);
        vista.getjPDetalleSolicitud().setVisible(false);
        cargarOpciones();
        cargarDatos();
        this.vista.getjBtnCerrarPubli().addActionListener(e-> cerrarPubli());
        this.vista.getjBtnFiltrar().addActionListener(e-> filtrar());
        this.vista.getjBtnQuitarFiltro().addActionListener(e-> quitarFiltro());
        this.vista.getjBtnCambiarEstado().addActionListener(e-> cambiarEstado());
        vista.getjBtnQuitarFiltro().setVisible(false);
        cargarPublis();
    }
    Project projectActualizado = new Project();

    private void cambiarEstado(){
        Long idProyecto = Long.valueOf(vista.getjLIDProyecto().getText());
        Long coordinatorCode = coordinatorController.getCoordinatortByCode(Long.valueOf(vista.getnitCompany()),"Bearer " + vista.getToken()).getCode();
        CreateProjectComment projectComment = new CreateProjectComment(coordinatorCode,vista.getjTextAreaComentarioProye().getText());

        if(vista.getjRbtnAceptarPro().isSelected()){
            try {
                coordinatorController.approveProject(idProyecto,projectComment,"Bearer " + vista.getToken());
                Messages.showMessageDialog("Proyecto aprobado","Aprobado");

                actualizar("Actualizando vista chats");
            }catch (Exception e){
                System.out.println("error epa" + e.getMessage());
            }
        }
        if(vista.getjRbtnRechazarProye().isSelected()){
            try {
                coordinatorController.rejectProject(idProyecto,projectComment,"Bearer " + vista.getToken());
                Messages.showMessageDialog("Proyecto rechazado","Rechazado");
                actualizar("Actualizando vista chats");
            }catch (Exception e){
                System.out.println("error epa" + e.getMessage());
            }
        }
        if (vista.getjRbtnCompletarProye().isSelected()) {
            try {
                coordinatorController.completeProject(idProyecto,"Bearer " + vista.getToken());
                Messages.showConfirmDialog("Proyecto aprobado","Aprobado");
                actualizar("Actualizando vista chats");
            }catch (Exception e){
                System.out.println("error epa" + e.getMessage());
            }
        }
        vista.getjPDetalleSolicitud().setVisible(false);
        actualizar("Actualizando vista chats");
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
            projectActualizado = project;
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
            vista.getjLIDProyecto().setText(String.valueOf(project.getProjectId()));

            vista.getjRbtnAceptarPro().setVisible(false);
            vista.getjRbtnRechazarProye().setVisible(false);
            vista.getjRbtnCompletarProye().setVisible(false);
            vista.getjScrollPanelComen().setVisible(false);
            vista.getjBtnCambiarEstado().setVisible(false);

            System.out.println("EL estado cargado es: " + project.getState());

            if(project.getState().equals("Assigned")){
                vista.getjRbtnCompletarProye().setVisible(true);
                vista.getjBtnCambiarEstado().setVisible(true);
            }
            if(project.getState().equals("Received")){
                vista.getjRbtnRechazarProye().setVisible(true);
                vista.getjRbtnAceptarPro().setVisible(true);
                vista.getjScrollPanelComen().setVisible(true);
                vista.getjBtnCambiarEstado().setVisible(true);
            }

            vista.getjPDetalleSolicitud().setVisible(true);
        } catch (Exception e) {
            System.out.println("Error en cargar detalles " + e.getMessage());
        }
    }

    @Override
    public void actualizar(String mensaje) {
        System.out.println("Actualizando en proyectos coordinador o empresa" + mensaje);
        if(vista.getjBtnQuitarFiltro().isVisible()){
            filtrar();
        }
        else{
            cargarPublis();
        }
    }
}
