package co.edu.unicauca.academicproject.GUI.controller.coordinator;

import co.edu.unicauca.academicproject.GUI.coordinator.GUIStudentRequest;
import co.edu.unicauca.academicproject.GUI.coordinator.GUIminiRequest;

import javax.swing.*;
import java.awt.*;

/**
 * @author lopez
 * @date 6/06/2025
 */
public class controllerStudentRequest {
    private final GUIStudentRequest vista;

    public controllerStudentRequest(GUIStudentRequest vista){
        this.vista = vista;
        ejemplo();
    }

    private void cargaProyecto(String tituloProyecto, String nombreProyecto, String estadoProyecto){
        JPanel chat = new GUIminiRequest(tituloProyecto,nombreProyecto,estadoProyecto);
        chat.setPreferredSize(new Dimension(200,200));
        vista.getjPChat().add(chat);
        vista.getjPChat().revalidate();
        vista.getjPChat().repaint();
    }

    public void ejemplo(){
        for (int i = 1; i <= 10; i++) {
            cargaProyecto("Proyecto " + i, "Estudiante " + i, "Resumen breve " + i);
        }

    }
}
