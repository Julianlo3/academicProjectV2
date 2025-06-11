package co.edu.unicauca.coordinatorservice.services;

public interface IEmailNotificationService {
    void sendProjectStatusChangeEmail(String to, String projectName, String newStatus, String comment, String contactName, String contactLastName, String companyName);
}
