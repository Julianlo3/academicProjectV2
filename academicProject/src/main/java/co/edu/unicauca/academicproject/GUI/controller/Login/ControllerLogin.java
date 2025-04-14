/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.academicproject.GUI.controller.Login;

import co.edu.unicauca.academicproject.GUI.GUIHomeWithOutLog;
import co.edu.unicauca.academicproject.GUI.GUILogin;
import co.edu.unicauca.academicproject.GUI.GUIRegisteredUser;
import javax.swing.JFrame;

/**
 *
 * @author lopez
 */
public class ControllerLogin {
    private final GUILogin vista;
    
    public ControllerLogin(GUILogin vista){
        this.vista = vista;
        this.vista.getjBtnBackHomeWithLogin().addActionListener(e -> volverHome());
        this.vista.getjBtnNewUser().addActionListener(e -> abrirNewUser());
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
}
