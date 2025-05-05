package co.edu.unicauca.academicproject.GUI.controller.Home;

import co.edu.unicauca.academicproject.GUI.GUIHomeWithOutLog;
import co.edu.unicauca.academicproject.GUI.GUILogin;
import co.edu.unicauca.academicproject.GUI.GUIRegisteredUser;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;

/**
 * @author lopez
 * @date 12/04/2025
 */
public class ControllerHomeWithOutLog {

    private final GUIHomeWithOutLog vista;

    public ControllerHomeWithOutLog(GUIHomeWithOutLog vista) {
        this.vista = vista;
        this.vista.getjBtnLoginU().addActionListener(e -> abrirLogin());
        this.vista.getjBtnNewUser().addActionListener(e -> abrirRegistroU());
        this.vista.getLbLogin().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                abrirLogin();
            }
        });
        this.vista.getLbNewUser().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                abrirRegistroU();
            }
        });
    }

    private void abrirLogin() {
        vista.dispose();
        GUILogin login = new GUILogin();
        login.setExtendedState(JFrame.MAXIMIZED_BOTH);
        login.setVisible(true);
    }

    private void abrirRegistroU() {
        vista.dispose();
        GUIRegisteredUser registerU = new GUIRegisteredUser();
        registerU.setExtendedState(JFrame.MAXIMIZED_BOTH);
        registerU.setVisible(true);
    }

    private void cargarProyectos(){

    }

}
