package co.edu.unicauca.coordinatorservice.services;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailNotificationService implements IEmailNotificationService{

    private final JavaMailSender mailSender;

    public EmailNotificationService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void sendProjectStatusChangeEmail(String to, String projectName, String newStatus, String comment, String contactName, String contactLastName, String companyName) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("Estado del Proyecto: " + newStatus);
        message.setText(
                "Estimado/a " + contactName + " " + contactLastName + ",\n\n" +
                        "Le informamos que el proyecto \"" + projectName + "\" registrado por su empresa \"" + companyName + "\" ha sido " +
                        newStatus.toLowerCase() + " por el coordinador académico encargado.\n\n" +
                        "Comentario del coordinador:\n" +
                        comment + "\n\n" +
                        "Agradecemos su participación y compromiso con la formación académica de nuestros estudiantes.\n\n" +
                        "Atentamente,\n" +
                        "Equipo de Gestión Académica\n" +
                        "Universidad Del Cauca"
        );
        mailSender.send(message);
    }
}
