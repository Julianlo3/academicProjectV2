package co.edu.unicauca.academicproject.GUI.controller.Project;


import co.edu.unicauca.academicproject.GUI.company.GUINewProject;
import co.edu.unicauca.academicproject.Service.Company.CompanyServiceClient;
import co.edu.unicauca.academicproject.Service.project.ProjectServiceClient;
import co.edu.unicauca.academicproject.controller.CompanyController;
import co.edu.unicauca.academicproject.controller.ProjectController;
import co.edu.unicauca.academicproject.entities.AcademicTerm;
import co.edu.unicauca.academicproject.entities.Company;
import co.edu.unicauca.academicproject.provider.appContextProvider;

import javax.swing.*;

/**
 * @author lopez
 * @date 5/05/2025
 */
public class ControllerNewProject {
    private final GUINewProject vista;
    ProjectController projectController = new ProjectController(appContextProvider.getBean(ProjectServiceClient.class));
    public ControllerNewProject(GUINewProject vista) {
        this.vista = vista;
        this.vista.getjBtnPubliProject().addActionListener(e -> publicar());
        loadAcademidTerms();
    }

    private void publicar(){
    try {
        String title = this.vista.getTitleProject();
        String descripcion = this.vista.getDescriptionProject();
        String company = String.valueOf(this.vista.getCompany().getNit());
        System.out.println("Datos del proyecto:" + title + descripcion + "nit"+ company);
        projectController.crearProyecto(title, descripcion, company);
        JOptionPane.showMessageDialog(null, "Proyecto publicado con éxito.");
    }catch (Exception e){
        System.out.println("Error al publicar proyecto" + e.getMessage());
    }
    }

    private void loadAcademidTerms(){
        this.vista.getAcademicTerm().removeAllItems();
        for (AcademicTerm term : AcademicTerm.values() ) {
            vista.getAcademicTerm().addItem(term.toString());
        }
    }

}
