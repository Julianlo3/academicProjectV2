/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.academicproject.GUI.controller.Home;

import co.edu.unicauca.academicproject.GUI.GUIHomeWithLog;
import co.edu.unicauca.academicproject.GUI.GUIHomeWithOutLog;
import co.edu.unicauca.academicproject.GUI.admin.GUIRequestCoordinator;
import co.edu.unicauca.academicproject.GUI.admin.GUIUsers;
import co.edu.unicauca.academicproject.Service.Student.StudentServiceClient;
import co.edu.unicauca.academicproject.controller.StudentController;
import co.edu.unicauca.academicproject.entities.Admin;
import co.edu.unicauca.academicproject.entities.Student;
import co.edu.unicauca.academicproject.provider.appContextProvider;

import java.awt.CardLayout;
import javax.swing.JFrame;

/**
 *
 * @author lopez
 */

public class ControllerHomeWithLog {
    CardLayout cardLayout;
    StudentController studentController = new StudentController(appContextProvider.getBean(StudentServiceClient.class));
    private final GUIHomeWithLog vista;
    private String rol;
    private long code;
    public ControllerHomeWithLog(GUIHomeWithLog vista){
        this.vista = vista;
        this.rol = vista.getRol();
        this.code = vista.getidUser();
        cargarFormRol();
        this.vista.getjBtnGetOut().addActionListener(e -> cerrarSeccion());
        this.vista.getjBtnCoordiSoli().addActionListener(e -> cargarSolicitudesCoordi());
        this.vista.getjBtnUsersSistema().addActionListener(e -> cargarUsuariosSistema());
    }
    
    private void cerrarSeccion(){
        vista.dispose();
        GUIHomeWithOutLog homeWithLog = new GUIHomeWithOutLog();
        homeWithLog.setExtendedState(JFrame.MAXIMIZED_BOTH);
        homeWithLog.setVisible(true);
    }

    private void cargarFormRol(){
        switch (rol) {
            case "Estudiante": cargarformStudent(); break;
            case "Admin": cargarFormAdmin(); break;
            case "Coordinador": cargarFormCoordi(); break;
        }
        System.out.println("Rol:" + rol);
    }
    
    private void cargarformStudent(){
        System.out.println("Cargando opciones de estudiante:");
        cardLayout = (CardLayout) vista.getJPoptions().getLayout();
        cardLayout.show(vista.getJPoptions(),"Estudiante");
        Student student = studentController.getStudentByCode(Long.valueOf(code));
        vista.getLbLogin().setText(student.getName());
    }
    
    private void cargarFormAdmin(){
        System.out.println("Cargando opciones de administrador:");
        cardLayout = (CardLayout) vista.getJPoptions().getLayout();
        cardLayout.show(vista.getJPoptions(),"Admin");
        vista.getLbLogin().setText(Admin.getInstance().getNombre());
    }

    private void cargarFormCoordi(){
        System.out.println("Cargando opciones de coordinador:");
        cardLayout = (CardLayout) vista.getJPoptions().getLayout();
        cardLayout.show(vista.getJPoptions(),"Coordi");
        vista.getLbLogin().setText(Admin.getInstance().getNombre());
    }

    private void cargarSolicitudesCoordi(){
        GUIRequestCoordinator requestCoordinator = new GUIRequestCoordinator();
        requestCoordinator.setVisible(true);
        
    }

    private void cargarUsuariosSistema(){
        GUIUsers usuariosSistema = new GUIUsers();
        usuariosSistema.setVisible(true);
    }
}
