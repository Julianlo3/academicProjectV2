/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.academicproject.GUI.controller.Login;

import co.edu.unicauca.academicproject.GUI.GUIHomeWithLog;
import co.edu.unicauca.academicproject.GUI.GUIHomeWithOutLog;
import co.edu.unicauca.academicproject.GUI.GUILogin;
import co.edu.unicauca.academicproject.GUI.GUIRegisteredUser;
import co.edu.unicauca.academicproject.Service.Company.CompanyServiceClient;
import co.edu.unicauca.academicproject.Service.Coordinator.CoordinatorServiceClient;
import co.edu.unicauca.academicproject.Service.Student.StudentServiceClient;
import co.edu.unicauca.academicproject.controller.CompanyController;
import co.edu.unicauca.academicproject.controller.CoordinatorController;
import co.edu.unicauca.academicproject.controller.StudentController;
import co.edu.unicauca.academicproject.entities.Admin;
import co.edu.unicauca.academicproject.entities.Company;
import co.edu.unicauca.academicproject.entities.Coordinator;
import co.edu.unicauca.academicproject.entities.Student;
import co.edu.unicauca.academicproject.provider.appContextProvider;
import co.edu.unicauca.academicproject.security.Users;

import javax.swing.*;

/**
 *
 * @author lopez
 */
public class ControllerLogin {
    private final GUILogin vista;
    Users user = new Users();
    public ControllerLogin(GUILogin vista){
        this.vista = vista;
        cargarRol();
        this.vista.getjBtnBackHomeWithLogin().addActionListener(e -> volverHome());
        this.vista.getjBtnNewUser().addActionListener(e -> abrirNewUser());
        this.vista.getCBRol().addActionListener(e -> cargarRol());
        this.vista.getBtnLogin().addActionListener(e -> checkUser());
    }
    
    private void volverHome(){
        vista.dispose();
        GUIHomeWithOutLog home = new GUIHomeWithOutLog();
        home.setExtendedState(JFrame.MAXIMIZED_BOTH);
        home.setVisible(true);
    }
    
    private void abrirNewUser(){
        vista.dispose();
        GUIRegisteredUser newUser = new GUIRegisteredUser();
        newUser.setExtendedState(JFrame.MAXIMIZED_BOTH);
        newUser.setVisible(true);
    }
    
    private String cargarRol(){
        String rol =vista.getCBRol().getSelectedItem().toString();
        System.out.println("Rol seleccionado" + rol);
        return rol;
    }
    
    private void checkUser(){
        String userName = vista.getFieldUserName().getText();
        String pass = vista.getPasswordUser().getText();
        System.out.println("Datos del form:" +userName + " " + pass);
        try {
            if(user.validarTokenRegis(userName, pass)){
                System.out.println("Usuario registrado");
                vista.dispose();
                GUIHomeWithLog home = new GUIHomeWithLog(userName,cargarRol(),user.obtenerTokenRegis(userName, pass));
                home.setVisible(true);
            }
        } catch (Exception e) {
            System.out.println("Error al obtener token de usuario registrado" + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
