/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.academicproject.GUI.controller.Login;

import co.edu.unicauca.academicproject.GUI.GUIHomeWithLog;
import co.edu.unicauca.academicproject.GUI.GUIHomeWithOutLog;
import co.edu.unicauca.academicproject.GUI.GUILogin;
import co.edu.unicauca.academicproject.GUI.GUIRegisteredUser;
import co.edu.unicauca.academicproject.Service.Coordinator.CoordinatorServiceClient;
import co.edu.unicauca.academicproject.Service.Student.StudentServiceClient;
import co.edu.unicauca.academicproject.controller.CoordinatorController;
import co.edu.unicauca.academicproject.controller.StudentController;
import co.edu.unicauca.academicproject.entities.Admin;
import co.edu.unicauca.academicproject.entities.Coordinator;
import co.edu.unicauca.academicproject.entities.Student;
import co.edu.unicauca.academicproject.provider.appContextProvider;

import javax.swing.*;

/**
 *
 * @author lopez
 */
public class ControllerLogin {
    private final GUILogin vista;
    
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
        Long userName = Long.valueOf(vista.getFieldUserName().getText());
        String pass = vista.getPasswordUser().getText();
        System.out.println("Datos del form:" +userName + " " + pass);
        switch (cargarRol()) {
            case "Estudiante":
                StudentController studentController = new StudentController(appContextProvider.getBean(StudentServiceClient.class));
                Student student = studentController.checkStudent(userName, pass);
                if(student != null){
                    GUIHomeWithLog homeStudent = new GUIHomeWithLog(student.getCode(),cargarRol());
                    homeStudent.setVisible(true);
                    vista.dispose();
                }
                else {
                    JOptionPane.showMessageDialog(null, "Error. Revisar clave");
                }
                break;
            case "Admin":
                String codigo = Admin.getInstance().getCodigo();
                String password = Admin.getInstance().getPassword();
                System.out.println("Datos del admin:"+codigo + " " + password);
                if (codigo.equals(userName.toString()) && password.equals(pass)) {
                    GUIHomeWithLog homeAdmin = new GUIHomeWithLog((long)(1),cargarRol());
                    homeAdmin.setVisible(true);
                    vista.dispose();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Error. Revisar clave");
                }
                break;

            case "Coordinador":
                CoordinatorController coordinatorController = new CoordinatorController(appContextProvider.getBean(CoordinatorServiceClient.class));
                Coordinator coordinator = coordinatorController.checkCoordi(userName, pass);
                if (coordinator != null) {
                    GUIHomeWithLog homeCoordi = new GUIHomeWithLog(coordinator.getCode(),cargarRol());
                    homeCoordi.setVisible(true);
                    vista.dispose();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Error. Revisar clave");
                }
                break;

            default:
                throw new AssertionError();
        }
    }
}
