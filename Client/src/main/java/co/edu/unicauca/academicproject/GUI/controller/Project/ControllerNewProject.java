package co.edu.unicauca.academicproject.GUI.controller.Project;


import co.edu.unicauca.academicproject.GUI.company.GUINewProject;
import co.edu.unicauca.academicproject.Service.project.ProjectServiceClient;
import co.edu.unicauca.academicproject.controller.ProjectController;
import co.edu.unicauca.academicproject.entities.observer.Observer;
import co.edu.unicauca.academicproject.entities.observer.Sujeto;
import co.edu.unicauca.academicproject.infra.Messages;
import co.edu.unicauca.academicproject.provider.appContextProvider;

import javax.swing.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 * @author lopez
 * @date 5/05/2025
 */
public class ControllerNewProject implements Observer {
    @Override
    public void actualizar(String mensaje) {
        System.out.println("Actualizando desde new project");
    }

    private final GUINewProject vista;
    ProjectController projectController = new ProjectController(appContextProvider.getBean(ProjectServiceClient.class));
    Sujeto sujeto;
    public ControllerNewProject(GUINewProject vista, Sujeto sujeto) {
        this.vista = vista;
        this.sujeto = sujeto;
        cargarDatosEmpresa();
        this.vista.getjBtnPubliProject().addActionListener(e -> publicar());
    }

    private void cargarDatosEmpresa() {
        vista.getjBtnLoginU().setText(vista.getCompany().getName());
        vista.getjBtnLoginU().setIcon(new ImageIcon(getClass().getResource("/icon2.0/companyBig.png")));
    }

    private void publicar(){
    try {
        String name = vista.getTitleProject();
        String summary = vista.getResumenProject();
        String objectives = vista.getObjetivos();
        String descripcion = vista.getDescriptionProject();
        int duracionMes = vista.getDuracionMes().getValue();
        Date startDate = vista.getFechaProyecto().getDate();
        LocalDate localStartDate = startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        String rawPresupuesto = vista.getPresupuesto().getText();
        System.out.println("Presupuesto ingresado (raw): " + rawPresupuesto);
        String presupuestoLimpio = rawPresupuesto.replace(".", "").replace(",", ".").trim();
        BigDecimal buget = new BigDecimal(presupuestoLimpio);
        int academicYear = vista.getAnio().getValue();
        int academicTerm = vista.getTerm().getValue();
        Long companyNit = Long.valueOf(vista.getCompany().getNit());
        projectController.crearProyecto(companyNit,name,summary,objectives,descripcion,duracionMes,localStartDate,buget,academicYear,academicTerm,"Bearer " + vista.getToken());
        sujeto.notificar("Nuevo proyecto");
        Messages.showMessageDialog("Proyecto publicado con éxito", "Proyecto publicado con éxito.");

    }catch (Exception e){
        System.out.println("Error al publicar proyecto" + e.getMessage());
    }
    }

}
