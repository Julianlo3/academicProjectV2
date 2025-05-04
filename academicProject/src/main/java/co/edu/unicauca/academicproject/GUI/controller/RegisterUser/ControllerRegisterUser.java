/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.academicproject.GUI.controller.RegisterUser;

import co.edu.unicauca.academicproject.GUI.GUIHomeWithLog;
import co.edu.unicauca.academicproject.GUI.GUIHomeWithOutLog;
import co.edu.unicauca.academicproject.GUI.GUIRegisteredUser;
import co.edu.unicauca.academicproject.Service.Student.StudentServiceClient;
import co.edu.unicauca.academicproject.controller.StudentController;
import co.edu.unicauca.academicproject.entities.SectorCompany;
import co.edu.unicauca.academicproject.entities.sectorCoordi;
import co.edu.unicauca.academicproject.provider.appContextProvider;

import java.awt.CardLayout;
import javax.swing.JFrame;

/**
 *
 * @author lopez
 */
public class ControllerRegisterUser {

    private final GUIRegisteredUser vista;
    StudentController studentController = new StudentController(appContextProvider.getBean(StudentServiceClient.class));
    //CompanyController companyController = new CompanyController(appContextProvider.getBean(CompanyServiceClient.class));
    //CoordinatorController coordinatorController = new CoordinatorController(appContextProvider.getBean(CoordinatorServiceClient.class));


    CardLayout cardLayout;

    public ControllerRegisterUser(GUIRegisteredUser vista) {
        this.vista = vista;
        this.vista.getjBtnBackSelectUser().addActionListener(e -> volverHomeWithOuLog());
        this.vista.getjBtnSaveStudent().addActionListener(e -> abrirHomeStudent());
        this.vista.getjBtnSaveCompany().addActionListener(e -> abrirHomeCompany());
        this.vista.getjBtnSaveCoordi().addActionListener(e -> abrirHomeCoordi());
        this.vista.getjRbtnCompany().addActionListener(e -> cargarFormCompany());
        this.vista.getjRbtnCoordi().addActionListener(e -> cargarFormCoordi());
        this.vista.getjRbtnStudent().addActionListener(e -> cargarFormStudent());
        this.vista.getjBtnSaveStudent().addActionListener(e -> saveStudent());
        this.vista.getjBtnSaveCompany().addActionListener(e -> saveCompany());
        this.vista.getjBtnSaveCoordi().addActionListener(e -> saveCoordi());
    }

    private void volverHomeWithOuLog() {
        vista.dispose();
        GUIHomeWithOutLog homeOutLog = new GUIHomeWithOutLog();
        homeOutLog.setExtendedState(JFrame.MAXIMIZED_BOTH);
        homeOutLog.setVisible(true);
    }

    private void abrirHomeStudent() {
        Long id = Long.parseLong(vista.getjFieldCodeStudent().getText());
        GUIHomeWithLog homeStudent = new GUIHomeWithLog(id,"student");
        vista.dispose();
        homeStudent.setExtendedState(JFrame.MAXIMIZED_BOTH);
        homeStudent.setVisible(true);
    }

    private void abrirHomeCoordi() {
        Long id = Long.parseLong(vista.getjFieldCodeCoordi().getText());
        GUIHomeWithLog homeCoordi = new GUIHomeWithLog(id,"coordinator");
        vista.dispose();
        homeCoordi.setExtendedState(JFrame.MAXIMIZED_BOTH);
        homeCoordi.setVisible(true);
    }

    private void abrirHomeCompany() {
        Long id = Long.parseLong(vista.getjFieldNitCompany().getText());
        GUIHomeWithLog homeCompany = new GUIHomeWithLog(id,"company");
        homeCompany.setExtendedState(JFrame.MAXIMIZED_BOTH);
        homeCompany.setVisible(true);
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

    private void saveStudent(){
        long codigo = Long.parseLong(vista.getjFieldCodeStudent().getText());
        System.out.println(codigo);
        String nombre = vista.getjFieldNameStudent().getText();
        System.out.println(nombre);
        long tel = Long.parseLong(vista.getjFieldTelStudent().getText());
        System.out.println(tel);
        String email = vista.getjFieldEmailStudent().getText();
        System.out.println(email);
        String pass = vista.getjFieldPassWordStudent().getText();
        System.out.println(pass);
        studentController.registerStudent(codigo, nombre, tel, email, pass);
    }

    private void saveCompany() {
        String nit = vista.getjFieldNitCompany().getText();
        String name = vista.getjFieldNameCompany().getText();
        String phone = vista.getjFieldTelCompany().getText();
        String email = vista.getjFieldEmailCompany().getText();
        String pageWeb = vista.getjFieldWebCompany().getText();
        SectorCompany sector = SectorCompany.valueOf(vista.getjCBSectorCompany().getSelectedItem().toString());
        String pass = vista.getjFieldPassWordCompany().getText();
        //companyController.registerCompany(nit,name,phone,pageWeb,sector,email,pass);
    }

    private void saveCoordi() {
        String codigo = vista.getjFieldCodeCoordi().getText();
        String name = vista.getjFieldNameCoordi().getText();
        String tel = vista.getjFieldTelCoordi().getText();
        String email = vista.getjFieldEmailCoordi().getText();
        String programa = vista.getjCBProgramCoordi().getSelectedItem().toString();
        String pass = vista.getjFieldPassWordCoordi().getText();
        System.out.println(codigo + " " + name + " " + tel + " " + email + " " + programa + " " + pass );

        //coordinatorController.registerCoordinator(codigo, name, tel, email, programa, pass);
    }
}
