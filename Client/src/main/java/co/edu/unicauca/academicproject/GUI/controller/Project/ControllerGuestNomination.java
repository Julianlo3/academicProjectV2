package co.edu.unicauca.academicproject.GUI.controller.Project;


import co.edu.unicauca.academicproject.GUI.student.GUINominationProject;
import co.edu.unicauca.academicproject.entities.Project;

import java.awt.*;

/**
 * @author lopez
 * @date 30/05/2025
 */
public class ControllerGuestNomination {
    private final GUINominationProject vista;

    public ControllerGuestNomination(GUINominationProject vista){
        this.vista = vista;
        cargarInfoProject();
        cambiarColor();
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

    public void cambiarColor(){
        vista.getjSpinTerm().setForeground(Color.black);
        vista.getjSpinDuracionMes().setForeground(Color.black);
        vista.getjYearProyecto().setForeground(Color.black);
    }
}
