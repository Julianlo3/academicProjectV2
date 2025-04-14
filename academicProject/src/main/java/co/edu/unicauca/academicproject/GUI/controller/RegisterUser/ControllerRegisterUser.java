/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.academicproject.GUI.controller.RegisterUser;

import co.edu.unicauca.academicproject.GUI.GUIHomeWithLog;
import co.edu.unicauca.academicproject.GUI.GUIHomeWithOutLog;
import co.edu.unicauca.academicproject.GUI.GUIRegisteredUser;
import co.edu.unicauca.academicproject.Service.StudentServiceClient;
import co.edu.unicauca.academicproject.entities.SectorCompany;
import co.edu.unicauca.academicproject.entities.Student;
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
    StudentServiceClient studentServiceClient = appContextProvider.getBean(StudentServiceClient.class);

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
    }

    private void volverHomeWithOuLog() {
        vista.dispose();
        GUIHomeWithOutLog homeOutLog = new GUIHomeWithOutLog();
        homeOutLog.setExtendedState(JFrame.MAXIMIZED_BOTH);
        homeOutLog.setVisible(true);
    }

    private void abrirHomeStudent() {
        vista.dispose();
        GUIHomeWithLog homeStudent = new GUIHomeWithLog();
        homeStudent.setExtendedState(JFrame.MAXIMIZED_BOTH);
        homeStudent.setVisible(true);
    }

    private void abrirHomeCoordi() {
        vista.dispose();
        GUIHomeWithLog homeCoordi = new GUIHomeWithLog();
        homeCoordi.setExtendedState(JFrame.MAXIMIZED_BOTH);
        homeCoordi.setVisible(true);
    }

    private void abrirHomeCompany() {
        vista.dispose();
        GUIHomeWithLog homeCompany = new GUIHomeWithLog();
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
        String codigo = vista.getjFieldCodeStudent().getText();
        System.out.println(codigo);
        String nombre = vista.getjFieldNameStudent().getText();
        System.out.println(nombre);
        String tel = vista.getjFieldTelStudent().getText();
        System.out.println(tel);
        String email = vista.getjFieldEmailStudent().getText();
        System.out.println(email);
        String pass = vista.getjFieldPassWordStudent().getText();
        System.out.println(pass);
        Student estudiante = new Student(codigo, nombre, tel, email, pass);
        studentServiceClient.CreateStudent(estudiante);
    }
}
