package co.edu.unicauca.academicproject;

import co.edu.unicauca.academicproject.GUI.GUIHomeWithOutLog;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.cloud.openfeign.EnableFeignClients;

import javax.swing.*;

@SpringBootApplication
@EnableFeignClients(basePackages = "co.edu.unicauca.academicproject.Service")
public class AcademicProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(AcademicProjectApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void iniciarInterfaz(){
        System.setProperty("java.awt.headless", "false");
        SwingUtilities.invokeLater(()-> {
            GUIHomeWithOutLog ventaPrincipal = new GUIHomeWithOutLog();
            ventaPrincipal.setExtendedState(JFrame.MAXIMIZED_BOTH);
            ventaPrincipal.setVisible(true);
            
        });
    }
}
