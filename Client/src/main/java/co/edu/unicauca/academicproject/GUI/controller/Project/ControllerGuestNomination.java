package co.edu.unicauca.academicproject.GUI.controller.Project;


import co.edu.unicauca.academicproject.GUI.student.GUINominationProject;
import co.edu.unicauca.academicproject.Service.Student.StudentServiceClient;
import co.edu.unicauca.academicproject.Service.project.ProjectServiceClient;
import co.edu.unicauca.academicproject.controller.ProjectController;
import co.edu.unicauca.academicproject.controller.StudentController;
import co.edu.unicauca.academicproject.entities.Project;
import co.edu.unicauca.academicproject.infra.Messages;
import co.edu.unicauca.academicproject.provider.appContextProvider;
import co.edu.unicauca.academicproject.security.Users;

import java.awt.*;

/**
 * @author lopez
 * @date 30/05/2025
 */
public class ControllerGuestNomination {
    private final GUINominationProject vista;
    StudentController studentController = new StudentController(appContextProvider.getBean(StudentServiceClient.class));
    //ProjectController projectController = new ProjectController(appContextProvider.getBean(ProjectServiceClient.class));
    String rol ="";
    String token;
    public ControllerGuestNomination(GUINominationProject vista){
        this.vista = vista;
        rol = vista.getRol();
        this.token = vista.getToken();
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
            try{
                long idProyecto = vista.getProject().getprojectId();
                studentController.applyToProject(Long.parseLong(vista.getCodeStudent()),idProyecto,"Bearer " + vista.getToken());
                Messages.showMessageDialog("Solicitud enviadad correctamente","Solicitud enviada");
            }catch (Exception e){
                System.out.println("Error al cargar solicitud" + e.getMessage());
            }
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
