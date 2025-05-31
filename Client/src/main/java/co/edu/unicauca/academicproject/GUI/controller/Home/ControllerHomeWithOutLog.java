package co.edu.unicauca.academicproject.GUI.controller.Home;

import co.edu.unicauca.academicproject.GUI.GUIHomeWithOutLog;
import co.edu.unicauca.academicproject.GUI.GUILogin;

import co.edu.unicauca.academicproject.GUI.GUIRegisteredUser;
import co.edu.unicauca.academicproject.GUI.student.GUINominationProject;
import co.edu.unicauca.academicproject.Service.project.ProjectServiceClient;
import co.edu.unicauca.academicproject.controller.ProjectController;
import co.edu.unicauca.academicproject.entities.Project;
import co.edu.unicauca.academicproject.provider.appContextProvider;
import co.edu.unicauca.academicproject.security.Users;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
    Users user = new Users();

    public ControllerHomeWithOutLog(GUIHomeWithOutLog vista) {
        this.vista = vista;
        cargarProyectos();
        this.vista.getjBtnLoginU().addActionListener(e -> abrirLogin());
        this.vista.getjBtnNewUser().addActionListener(e -> abrirRegistroU());
        this.vista.getjTableProjects().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                abrirProyecto();
            }
        });
    }

    private void abrirProyecto() {
        int fila = vista.getjTableProjects().getSelectedRow();
        System.out.println("Fila seleccionada: " + fila);
        if (fila >= 0) {
            String name = vista.getjTableProjects().getValueAt(fila, 3).toString(); // columna 0 es
            System.out.println("Proyecto seleccionado: " + name);
            try {
                String token = user.obtenerTokenRegis("guest", "123");
                System.out.println("Token: " + token);
                Project project = projectController.getProjectByName(name, "Bearer " + token);
                System.out.println("Proyecto encontrado: " + project.getName() + project.getDescription() + project.getStartDate());
                GUINominationProject newNomination = new GUINominationProject(project, token,"guest");
                newNomination.setVisible(true);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
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
            List<Project> projects = projectController.getAllProjects("Bearer " + token);
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
