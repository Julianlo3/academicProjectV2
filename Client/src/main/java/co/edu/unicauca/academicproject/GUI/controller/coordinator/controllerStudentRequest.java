package co.edu.unicauca.academicproject.GUI.controller.coordinator;

import co.edu.unicauca.academicproject.GUI.coordinator.GUIStudentRequest;
import co.edu.unicauca.academicproject.GUI.coordinator.GUIminiRequest;
import co.edu.unicauca.academicproject.Service.Coordinator.CoordinatorServiceClient;
import co.edu.unicauca.academicproject.Service.Student.StudentServiceClient;
import co.edu.unicauca.academicproject.Service.project.ProjectServiceClient;
import co.edu.unicauca.academicproject.controller.CoordinatorController;
import co.edu.unicauca.academicproject.controller.ProjectController;
import co.edu.unicauca.academicproject.controller.StudentController;
import co.edu.unicauca.academicproject.entities.Project;
import co.edu.unicauca.academicproject.entities.ProjectApplicationRequest;
import co.edu.unicauca.academicproject.entities.Student;
import co.edu.unicauca.academicproject.infra.Messages;
import co.edu.unicauca.academicproject.provider.appContextProvider;

import java.awt.*;
import java.util.List;

/**
 * @author lopez
 * @date 6/06/2025
 */
public class controllerStudentRequest {
    private final GUIStudentRequest vista;
    CoordinatorController coordinatorController = new CoordinatorController(appContextProvider.getBean(CoordinatorServiceClient.class));
    ProjectController projectController = new ProjectController(appContextProvider.getBean(ProjectServiceClient.class));
    StudentController studentController = new StudentController(appContextProvider.getBean(StudentServiceClient.class));
    public controllerStudentRequest(GUIStudentRequest vista){
        this.vista = vista;
        vista.getjBtnProcesarSoli().addActionListener(e-> procesarSoli());
        vista.getjPDetalleSolicitud().setVisible(false);
        cargarSolicitudes();
    }

    private void procesarSoli(){
        Long id = Long.valueOf(vista.getjLIDPubli().getText());
        System.out.println("id public" + id);
        try {
            if(vista.getjRBtnRechazarSoli().isSelected()){
                coordinatorController.rejectRequest(id,"bearer " +vista.getToken());
                Messages.showMessageDialog("Rechazado correctamente","Rechazado");
            }
            if(vista.getjRBtnAceptarSoli().isSelected()) {
                coordinatorController.acceptRequest(id,"bearer " +vista.getToken());
                Messages.showMessageDialog("Aceptado correctamente","Aceptado");
            }
        } catch (Exception e) {
            System.out.println("Error al procesar el proceso de solicitud" + e.getMessage());
        }

    }

    private void cargaProyecto(String tituloProyecto,String nombreEstudiante, String nombreEmpresa, String estadoProyecto,Project project,Student student,Long idSolicitud){
        GUIminiRequest  chat = new GUIminiRequest(tituloProyecto, nombreEstudiante, nombreEmpresa,estadoProyecto,idSolicitud);
        chat.getjBtnVerDetalles().addActionListener(e-> cargarDetalles(project,student,idSolicitud));
        chat.setPreferredSize(new Dimension(200,220));
        vista.getjPChat().add(chat);
        vista.getjPChat().revalidate();
        vista.getjPChat().repaint();

    }

    private void cargarDetalles(Project project,Student student,Long idSolicitud){
        try{
            vista.getjFieldTitleProject().setText(project.getName());
            vista.getjTextAreaResumen().setText(project.getSummary());
            vista.getjTextAreaDescripProject().setText(project.getDescription());
            vista.getjTextAreaObjetivos().setText(project.getObjectives());
            vista.getjYearProyecto().setValue(project.getAcademicYear());
            vista.getjSpinTerm().setValue(project.getAcademicTerm());
            vista.getjSpinDuracionMes().setValue(project.getMaxDurationInMonths());
            vista.getjFieldPresupuesto().setText(String.valueOf(project.getBudget()));
            vista.getjLIDPubli().setText(idSolicitud.toString());
            try {
                vista.setjDateChFechaInicio(project.getStartDate().toString());
            }catch (Exception e){
                System.out.println("Error al cargar fecha de inicio del proyecto" + e.getMessage());
            }
            vista.getjLEstudianteSolicitante().setText(student.getName());
            vista.getjLEstadoSolicitud().setText(project.getState());
            vista.getjPDetalleSolicitud().setVisible(true);
        }catch(Exception e){
            System.out.println("Error en cargar detalles "+e.getMessage());
        }
    }

    private void cargarSolicitudes(){
        try {
            List<ProjectApplicationRequest> solicitudes = coordinatorController.getAllRequests("bearer "+vista.getToken());
            System.out.println("# de solis:" + solicitudes.size());

            for (ProjectApplicationRequest solis : solicitudes) {
                System.out.println(solis.getId());
                Project project = projectController.getProjectById(solis.getProjectId(),"bearer "+vista.getToken());
                Student student = studentController.getStudentByCode(solis.getStudentCode(),"bearer "+vista.getToken());
                cargaProyecto(project.getName(), student.getName(), String.valueOf(project.getCompanyNit()),solis.getStatus(),project,student,solis.getId());
            }

        } catch (Exception e) {
            System.out.println("error con las solis " + e.getMessage());
        }

    }
}
