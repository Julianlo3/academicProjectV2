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
import co.edu.unicauca.academicproject.entities.observer.Sujeto;
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
    Sujeto sujeto = new Sujeto();

    CardLayout cardLayout;
    Users users = new Users();

    public ControllerRegisterUser(GUIRegisteredUser vista) {
        this.vista = vista;
        cargarFormStudent();
        this.vista.getjRbtnStudent().setSelected(true);
        this.vista.getjBtnBackSelectUser().addActionListener(e -> volverHomeWithOuLog());
        this.vista.getjBtnSaveStudent().addActionListener(e -> abrirHomeStudent());
        this.vista.getjBtnSaveCompany().addActionListener(e -> abrirHomeCompany());
        this.vista.getjBtnSaveCoordi().addActionListener(e -> abrirHomeCoordi());
        this.vista.getjRbtnCompany().addActionListener(e -> cargarFormCompany());
        this.vista.getjRbtnCoordi().addActionListener(e -> cargarFormCoordi());
        this.vista.getjRbtnStudent().addActionListener(e -> cargarFormStudent());
        this.vista.getjCheckSeePassCompany().addActionListener(e -> verClaveCompany());
        this.vista.getjCheckSeePassCoordi().addActionListener(e -> verClaveCoordi());
        this.vista.getjCheckSeePassStudent().addActionListener(e -> verClaveStudent());
    }

    private void volverHomeWithOuLog() {
       Sujeto sujeto = new Sujeto();
        GUIHomeWithOutLog homeOutLog = new GUIHomeWithOutLog(sujeto);
        homeOutLog.setExtendedState(JFrame.MAXIMIZED_BOTH);
        homeOutLog.setVisible(true);
         vista.dispose();
    }

    private void verClaveCompany(){
        if(vista.getjCheckSeePassCompany().isSelected()){
            vista.getjFieldPassWordCompany().setEchoChar((char)0);
        }else{
            vista.getjFieldPassWordCompany().setEchoChar('*');
        }
    }

    private void verClaveCoordi(){
        if(vista.getjCheckSeePassCoordi().isSelected()){
            vista.getjFieldPassWordCoordi().setEchoChar((char)0);
        }else{
            vista.getjFieldPassWordCoordi().setEchoChar('*');
        }
    }
    private void verClaveStudent(){
        if(vista.getjCheckSeePassStudent().isSelected()){
            vista.getjFieldPassWordStudent().setEchoChar((char)0);
        }else{
            vista.getjFieldPassWordStudent().setEchoChar('*');
        }
    }

    private void abrirHomeStudent() {
        try {
            if (saveStudent()) {
                Messages.showMessageDialog("Estudiante registrado", "Registro exitoso");
                String id = vista.getjFieldCodeStudent().getText();
                GUIHomeWithLog homeStudent = new GUIHomeWithLog(id,"student", String.valueOf(users.obtenerTokenRegis(vista.getjFieldCodeStudent().getText(), (vista.getjFieldPassWordStudent().getText()))),sujeto);
                homeStudent.setExtendedState(JFrame.MAXIMIZED_BOTH);
                homeStudent.setVisible(true);
                vista.dispose();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    private void abrirHomeCoordi() {
        try{
            if (saveCoordi()) {
                Messages.showMessageDialog("Coordinador registrado", "Registro exitoso");
                String id = vista.getjFieldCodeCoordi().getText();
                GUIHomeWithLog homeCoordi = new GUIHomeWithLog(id,"coordinator",String.valueOf(users.obtenerTokenRegis(vista.getjFieldCodeCoordi().getText(), (vista.getjFieldPassWordCoordi().getText()))),sujeto);
                homeCoordi.setExtendedState(JFrame.MAXIMIZED_BOTH);
                homeCoordi.setVisible(true);
                vista.dispose();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void abrirHomeCompany(){
       try {
           if (saveCompany()) {
               Messages.showMessageDialog("Empresa registrada", "Registro exitoso");
               String id = vista.getjFieldNitCompany().getText();
               GUIHomeWithLog homeCompany = new GUIHomeWithLog(id,"company",String.valueOf(users.obtenerTokenRegis(vista.getjFieldNitCompany().getText(), (vista.getjFieldPassWordCompany().getText()))),sujeto);
               homeCompany.setExtendedState(JFrame.MAXIMIZED_BOTH);
               homeCompany.setVisible(true);
               vista.dispose();
           }
       } catch (Exception e) {
           throw new RuntimeException(e);
       }
    }

    private void cargarFormStudent() {
        vista.getjCheckSeePassStudent().setSelected(false);
        verClaveStudent();
        vista.getjLTittleNewUser().setIcon(new ImageIcon(getClass().getResource("/icon2.0/estudianteBig.png")));
        cardLayout = (CardLayout) vista.getjPRolInformation().getLayout();
        cardLayout.show(vista.getjPRolInformation(), "Estudiante");
        cardLayout = (CardLayout) vista.getjPRegisterUser().getLayout();
        cardLayout.show(vista.getjPRegisterUser(), "Estudiante");
    }

    private void cargarFormCompany() {
        vista.getjCheckSeePassCompany().setSelected(false);
        verClaveCompany();
        vista.getjLTittleNewUser().setIcon(new ImageIcon(getClass().getResource("/icon2.0/companyBig.png")));
        cardLayout = (CardLayout) vista.getjPRolInformation().getLayout();
        cardLayout.show(vista.getjPRolInformation(), "Empresa");
        cardLayout = (CardLayout) vista.getjPRegisterUser().getLayout();
        cardLayout.show(vista.getjPRegisterUser(), "Empresa");
        fillSectorsCompany();
    }

    private void cargarFormCoordi() {
        vista.getjCheckSeePassCoordi().setSelected(false);
        verClaveCoordi();
        vista.getjLTittleNewUser().setIcon(new ImageIcon(getClass().getResource("/icon2.0/coordiBig.png")));
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
        String nombreAse = vista.getjFieldNombreAse().getText();
        String apellidoAse = vista.getjFieldApellidoAse().getText();
        String puesto = vista.getjFielPuestoAse().getText();
        System.out.println("Empresa"+ sector + pageWeb);
        try {
            String token = users.obtenerTokenGestionador("creador", "123");
            users.crearUsuarioKeycloak(token, String.valueOf(nit), pass,"company");
            String token2 = "Bearer " + users.obtenerTokenGestionador("creador", "123");
            companyController.registerCompany(nit,name,pageWeb,email,phone,nombreAse,apellidoAse,puesto,sector,token2);
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
