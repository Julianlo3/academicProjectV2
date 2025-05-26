package co.edu.unicauca.academicproject.GUI.controller.Home;

import co.edu.unicauca.academicproject.GUI.GUIHomeWithOutLog;
import co.edu.unicauca.academicproject.GUI.GUILogin;

import co.edu.unicauca.academicproject.GUI.GUIRegisteredUser;
import co.edu.unicauca.academicproject.Service.project.ProjectServiceClient;
import co.edu.unicauca.academicproject.controller.ProjectController;
import co.edu.unicauca.academicproject.entities.Project;
import co.edu.unicauca.academicproject.provider.appContextProvider;



import java.util.List;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/**
 * @author lopez
 * @date 12/04/2025
 */
public class ControllerHomeWithOutLog {

    private final GUIHomeWithOutLog vista;
    ProjectController projectController = new ProjectController(appContextProvider.getBean(ProjectServiceClient.class));
    public ControllerHomeWithOutLog(GUIHomeWithOutLog vista) {
        this.vista = vista;
        this.vista.getjBtnLoginU().addActionListener(e -> abrirLogin());
        this.vista.getjBtnNewUser().addActionListener(e -> abrirRegistroU());
        cargarProyectos();
    }

    private void abrirLogin() {
        vista.dispose();
        GUILogin login = new GUILogin();
        login.setExtendedState(JFrame.MAXIMIZED_BOTH);
        login.setVisible(true);
    }

    private void abrirRegistroU() {
        vista.dispose();
        GUIRegisteredUser registerU = new GUIRegisteredUser();
        registerU.setExtendedState(JFrame.MAXIMIZED_BOTH);
        registerU.setVisible(true);
    }

    private void cargarProyectos(){
        DefaultTableModel modeloProject = new DefaultTableModel(new String[]{"Titulo", "Descripcion", "CompanyNit"}, 0);
        try {
            List<Project> projects = projectController.getAllProjects();
            if (projects != null) {
                modeloProject.setRowCount(0);

                for (Project project : projects) {

                    if (project.getCompanyNit() != null && project.getTitle() != null) {
                        modeloProject.addRow(new Object[]{project.getTitle(), project.getDescription(), project.getCompanyNit()});
                    }

                }
            }
        } catch (Exception e) {
            System.out.println("Servicio de coordinador no disponible" + e.getMessage());
        }
        vista.getjTableProjects().setModel(modeloProject);
    }
    }


