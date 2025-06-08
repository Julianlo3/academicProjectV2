package co.edu.unicauca.academicproject.GUI.controller.student;


import co.edu.unicauca.academicproject.GUI.coordinator.GUIminiRequest;
import co.edu.unicauca.academicproject.GUI.student.GUIMySolisStudent;
import co.edu.unicauca.academicproject.Service.Student.StudentServiceClient;
import co.edu.unicauca.academicproject.Service.project.ProjectServiceClient;
import co.edu.unicauca.academicproject.controller.ProjectController;
import co.edu.unicauca.academicproject.controller.StudentController;
import co.edu.unicauca.academicproject.entities.Assignment;
import co.edu.unicauca.academicproject.entities.Project;
import co.edu.unicauca.academicproject.entities.ProjectApplicationRequest;
import co.edu.unicauca.academicproject.entities.Student;
import co.edu.unicauca.academicproject.provider.appContextProvider;

import java.awt.*;
import java.util.List;

/**
 * @author lopez
 * @date 8/06/2025
 */
public class ControllerMySolisStudent {
    private final GUIMySolisStudent vista;
    StudentController studentController = new StudentController(appContextProvider.getBean(StudentServiceClient.class));
    ProjectController projectController = new ProjectController(appContextProvider.getBean(ProjectServiceClient.class));
    public ControllerMySolisStudent(GUIMySolisStudent vista) {
        this.vista = vista;
        cargarSolicitudes();
    }

    private void cargarSolicitudes(){
        try {
            long studentCode = Long.parseLong(vista.getStudentCode());
            List<Assignment> solicitudes = studentController.getAssignmentByStudentCode(studentCode,"bearer "+vista.getToken());
            System.out.println("# de solis:" + solicitudes.size());
            for (Assignment solicitud : solicitudes) {
                System.out.println(solicitud.getStudent().getName() + solicitud.getId() + solicitud.getProjectId());
            }

            for (Assignment solis : solicitudes) {

                Project project = projectController.getProjectById(solis.getProjectId(),"bearer "+vista.getToken());
                Student student = studentController.getStudentByCode(studentCode,"bearer "+vista.getToken());
                cargaProyecto(project.getName(), student.getName(), String.valueOf(project.getCompanyNit()),"epa",project,student,solis.getProjectId());
            }

        } catch (Exception e) {
            System.out.println("error con las solis " + e.getMessage());
        }
    }

    private void cargaProyecto(String tituloProyecto,String nombreEstudiante, String nombreEmpresa, String estadoProyecto,Project project,Student student,Long idSolicitud){
        GUIminiRequest chat = new GUIminiRequest(tituloProyecto, nombreEstudiante, nombreEmpresa,estadoProyecto,idSolicitud);
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
            vista.getjYear().setValue(project.getAcademicYear());
            vista.getjSpinPeriodo().setValue(project.getAcademicTerm());
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
}
