/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.academicproject.GUI.controller.RegisterUser;

import co.edu.unicauca.academicproject.GUI.GUIHomeWithLog;
import co.edu.unicauca.academicproject.GUI.GUIHomeWithOutLog;
import co.edu.unicauca.academicproject.GUI.GUIRegisteredUser;
import co.edu.unicauca.academicproject.Service.Company.CompanyServiceClient;
import co.edu.unicauca.academicproject.Service.Coordinator.CoordinatorServiceClient;
import co.edu.unicauca.academicproject.Service.Student.StudentServiceClient;
import co.edu.unicauca.academicproject.controller.CompanyController;
import co.edu.unicauca.academicproject.controller.CoordinatorController;
import co.edu.unicauca.academicproject.controller.StudentController;
import co.edu.unicauca.academicproject.entities.SectorCompany;
import co.edu.unicauca.academicproject.entities.sectorCoordi;
import co.edu.unicauca.academicproject.infra.Messages;
import co.edu.unicauca.academicproject.provider.appContextProvider;
import co.edu.unicauca.academicproject.security.Users;
import org.json.JSONException;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;


/**
 *
 * @author lopez
 */
public class ControllerRegisterUser {

    private final GUIRegisteredUser vista;
    StudentController studentController = new StudentController(appContextProvider.getBean(StudentServiceClient.class));
    CompanyController companyController = new CompanyController(appContextProvider.getBean(CompanyServiceClient.class));
    CoordinatorController coordinatorController = new CoordinatorController(appContextProvider.getBean(CoordinatorServiceClient.class));


    CardLayout cardLayout;
    Users users = new Users();

    public ControllerRegisterUser(GUIRegisteredUser vista) {
        this.vista = vista;
        this.vista.getjBtnBackSelectUser().addActionListener(e -> volverHomeWithOuLog());
        this.vista.getjBtnSaveStudent().addActionListener(e -> abrirHomeStudent());
        this.vista.getjBtnSaveCompany().addActionListener(e -> abrirHomeCompany());
        this.vista.getjBtnSaveCoordi().addActionListener(e -> abrirHomeCoordi());
        this.vista.getjRbtnCompany().addActionListener(e -> cargarFormCompany());
        this.vista.getjRbtnCoordi().addActionListener(e -> cargarFormCoordi());
        this.vista.getjRbtnStudent().addActionListener(e -> cargarFormStudent());
    }

    private void volverHomeWithOuLog() {
        vista.dispose();
        GUIHomeWithOutLog homeOutLog = new GUIHomeWithOutLog();
        homeOutLog.setExtendedState(JFrame.MAXIMIZED_BOTH);
        homeOutLog.setVisible(true);
    }

    private void abrirHomeStudent() {
        if (saveStudent()) {
            Messages.showMessageDialog("Estudiante registrado", "Registro exitoso");
            Long id = Long.parseLong(vista.getjFieldCodeStudent().getText());
            GUIHomeWithLog homeStudent = new GUIHomeWithLog(id,"student");
            vista.dispose();
            homeStudent.setExtendedState(JFrame.MAXIMIZED_BOTH);
            homeStudent.setVisible(true);
        }
    }

    private void abrirHomeCoordi() {
        if (saveCoordi()) {
            Messages.showMessageDialog("Coordinador registrado", "Registro exitoso");
            Long id = Long.parseLong(vista.getjFieldCodeCoordi().getText());
            GUIHomeWithLog homeCoordi = new GUIHomeWithLog(id,"coordinator");
            vista.dispose();
            homeCoordi.setExtendedState(JFrame.MAXIMIZED_BOTH);
            homeCoordi.setVisible(true);
        }

    }

    private void abrirHomeCompany() {
        if (saveCompany()) {
            Messages.showMessageDialog("Empresa registrada", "Registro exitoso");
            Long id = Long.parseLong(vista.getjFieldNitCompany().getText());
            GUIHomeWithLog homeCompany = new GUIHomeWithLog(id,"company");
            homeCompany.setExtendedState(JFrame.MAXIMIZED_BOTH);
            homeCompany.setVisible(true);
        }

    }

    private void cargarFormStudent() {
        cardLayout = (CardLayout) vista.getjPRolInformation().getLayout();
        cardLayout.show(vista.getjPRolInformation(), "Estudiante");
        cardLayout = (CardLayout) vista.getjPRegisterUser().getLayout();
        cardLayout.show(vista.getjPRegisterUser(), "Estudiante");
    }

    private void cargarFormCompany() {
        cardLayout = (CardLayout) vista.getjPRolInformation().getLayout();
        cardLayout.show(vista.getjPRolInformation(), "Empresa");
        cardLayout = (CardLayout) vista.getjPRegisterUser().getLayout();
        cardLayout.show(vista.getjPRegisterUser(), "Empresa");
        fillSectorsCompany();
    }

    private void cargarFormCoordi() {
        cardLayout = (CardLayout) vista.getjPRolInformation().getLayout();
        cardLayout.show(vista.getjPRolInformation(), "Coordi");
        cardLayout = (CardLayout) vista.getjPRegisterUser().getLayout();
        cardLayout.show(vista.getjPRegisterUser(), "Coordi");
        fillSectorCoordi();
    }

    private void fillSectorsCompany() {
        vista.getjCBSectorCompany().removeAllItems();
        for (SectorCompany sector : SectorCompany.values()) {
            vista.getjCBSectorCompany().addItem(sector.toString());
        }
    }

    private void fillSectorCoordi() {
        vista.getjCBProgramCoordi().removeAllItems();
        for (sectorCoordi sector : sectorCoordi.values()) {
            vista.getjCBProgramCoordi().addItem(sector.toString());
        }
    }

    private boolean saveStudent() {
        long codigo = Long.parseLong(vista.getjFieldCodeStudent().getText());
        String nombre = vista.getjFieldNameStudent().getText();
        long tel = Long.parseLong(vista.getjFieldTelStudent().getText());
        String email = vista.getjFieldEmailStudent().getText();
        String pass = vista.getjFieldPassWordStudent().getText();
        System.out.println("Estudiante"+ codigo + nombre + tel + email);
        try {
            String token = users.obtenerTokenGestionador("creador", "123");
            users.crearUsuarioKeycloak(token, String.valueOf(codigo), pass,"student");
            String token2 = "Bearer " + users.obtenerTokenGestionador("creador", "123");

            studentController.registerStudent(codigo, nombre, tel, email,token2);
            return true;
        } catch (Exception ex) {
            System.err.println("Error inesperado: " + ex.getMessage());
            return false;
        }
    }


    private boolean saveCompany() {
        long nit = Long.parseLong(vista.getjFieldNitCompany().getText());
        String name = vista.getjFieldNameCompany().getText();
        String phone = vista.getjFieldTelCompany().getText();
        String email = vista.getjFieldEmailCompany().getText();
        String pageWeb = vista.getjFieldWebCompany().getText();
        String sector = String.valueOf(SectorCompany.valueOf(vista.getjCBSectorCompany().getSelectedItem().toString()));
        String pass = vista.getjFieldPassWordCompany().getText();
        System.out.println("Empresa"+ sector + pageWeb);
        try {
            String token = users.obtenerTokenGestionador("creador", "123");
            users.crearUsuarioKeycloak(token, String.valueOf(nit), pass,"company");
            String token2 = "Bearer " + users.obtenerTokenGestionador("creador", "123");
            companyController.registerCompany(nit,name,phone,pageWeb,sector,email,token2);
            return true;
        } catch (Exception ex) {
            System.err.println("Error inesperado: " + ex.getMessage());
            return false;
        }

    }

    private boolean saveCoordi() {
        long codigo = Long.parseLong(vista.getjFieldCodeCoordi().getText());
        String name = vista.getjFieldNameCoordi().getText();
        String tel = vista.getjFieldTelCoordi().getText();
        String email = vista.getjFieldEmailCoordi().getText();
        String programa = vista.getjCBProgramCoordi().getSelectedItem().toString();
        String pass = vista.getjFieldPassWordCoordi().getText();
        try {
            String token = users.obtenerTokenGestionador("creador", "123");
            users.crearUsuarioKeycloak(token, String.valueOf(codigo), pass,"coordinator");
            String token2 = "Bearer " + users.obtenerTokenGestionador("creador", "123");
            coordinatorController.registerCoordinator(codigo, name, tel, email, programa, token2);
            return true;
        } catch (Exception ex) {
            System.err.println("Error inesperado: " + ex.getMessage());
            return false;
    }
}
}
