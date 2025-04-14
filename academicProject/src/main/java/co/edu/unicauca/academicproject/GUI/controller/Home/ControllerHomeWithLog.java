/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.academicproject.GUI.controller.Home;

import co.edu.unicauca.academicproject.GUI.GUIHomeWithLog;
import co.edu.unicauca.academicproject.GUI.GUIHomeWithOutLog;
import javax.swing.JFrame;

/**
 *
 * @author lopez
 */
public class ControllerHomeWithLog {
    private final GUIHomeWithLog vista;
    
    public ControllerHomeWithLog(GUIHomeWithLog vista){
        this.vista = vista;
        this.vista.getjBtnGetOut().addActionListener(e -> cerrarSeccion());
    }
    
    private void cerrarSeccion(){
        vista.dispose();
        GUIHomeWithOutLog homeWithLog = new GUIHomeWithOutLog();
        homeWithLog.setExtendedState(JFrame.MAXIMIZED_BOTH);
        homeWithLog.setVisible(true);
    }
}
