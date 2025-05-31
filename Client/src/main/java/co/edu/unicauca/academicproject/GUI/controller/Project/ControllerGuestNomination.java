package co.edu.unicauca.academicproject.GUI.controller.Project;


import co.edu.unicauca.academicproject.GUI.student.GUINominationProject;
import co.edu.unicauca.academicproject.entities.Project;
import co.edu.unicauca.academicproject.infra.Messages;

import java.awt.*;

/**
 * @author lopez
 * @date 30/05/2025
 */
public class ControllerGuestNomination {
    private final GUINominationProject vista;

    String rol ="";
    public ControllerGuestNomination(GUINominationProject vista){
        this.vista = vista;
        rol = vista.getRol();
        System.out.println("Rol en nominacion: " + rol);
        cargarInfoProject();
        cargarOpciones();
        this.vista.getjBtnSolicitar().addActionListener(e -> mensajeRegistro());
    }

    private void cargarInfoProject(){
        System.out.println("Cargando información del proyecto");
        Project project = vista.getProject();
        vista.setjFieldTitleProject(project.getName());
        vista.setjTextAreaDescripProject(project.getDescription());
        vista.setjYearProyecto(project.getAcademicYear());
        vista.setjSpinTerm(project.getAcademicTerm());
        vista.setjTextAreaResumen(project.getSummary());
        vista.setjTextAreaObjetivos(project.getObjectives());
        vista.setjSpinDuracionMes(project.getMaxDurationInMonths());
        try {
            vista.setjDateChFechaInicio(project.getStartDate().toString());
        }catch (Exception e){
            System.out.println("Error al cargar fecha de inicio del proyecto" + e.getMessage());
        }

        System.out.println("Fecha "+ project.getStartDate().toString() );
        vista.setjFieldPresupuesto(project.getBudget().toString());
    }

    private void mensajeRegistro(){
        if(rol.equals("guest")) {
            Messages.showMessageDialog("Necesita estar registrado para enviar solicitudes","No registrado.");
        }
        else if (rol.equals("student")){
            Messages.showMessageDialog("Tu solicitud fue enviada","Enviado.");
        }
    }

    private void cargarOpciones(){

        if(rol.equals("guest")) {
            vista.getjBtnSolicitar().setBackground(Color.gray);
        }
        else if (rol.equals("student")){
            vista.getjBtnSolicitar().setBackground(Color.red);
            }

        }

}
