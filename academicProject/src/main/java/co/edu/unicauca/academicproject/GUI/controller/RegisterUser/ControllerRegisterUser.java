/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.academicproject.GUI.controller.RegisterUser;

import co.edu.unicauca.academicproject.GUI.GUIHomeWithLog;
import co.edu.unicauca.academicproject.GUI.GUIHomeWithOutLog;
import co.edu.unicauca.academicproject.GUI.GUIRegisteredUser;
import co.edu.unicauca.academicproject.Service.Company.CompanyServiceClient;
import co.edu.unicauca.academicproject.Service.Coordinator.CoordinatorServiceClient;
import co.edu.unicauca.academicproject.Service.Student.StudentServiceClient;
import co.edu.unicauca.academicproject.controller.CompanyController;
import co.edu.unicauca.academicproject.controller.CoordinatorController;
import co.edu.unicauca.academicproject.controller.StudentController;
import co.edu.unicauca.academicproject.entities.SectorCompany;
import co.edu.unicauca.academicproject.entities.sectorCoordi;
import co.edu.unicauca.academicproject.provider.appContextProvider;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
/**
 *
 * @author lopez
 */
public class ControllerRegisterUser {

    private final GUIRegisteredUser vista;
    StudentController studentController = new StudentController(appContextProvider.getBean(StudentServiceClient.class));
    CompanyController companyController = new CompanyController(appContextProvider.getBean(CompanyServiceClient.class));
    CoordinatorController coordinatorController = new CoordinatorController(appContextProvider.getBean(CoordinatorServiceClient.class));


    CardLayout cardLayout;

    public ControllerRegisterUser(GUIRegisteredUser vista) {
        this.vista = vista;
        this.vista.getjBtnBackSelectUser().addActionListener(e -> volverHomeWithOuLog());
        this.vista.getjBtnSaveStudent().addActionListener(e -> abrirHomeStudent());
        this.vista.getjBtnSaveCompany().addActionListener(e -> abrirHomeCompany());
        this.vista.getjBtnSaveCoordi().addActionListener(e -> abrirHomeCoordi());
        this.vista.getjRbtnCompany().addActionListener(e -> cargarFormCompany());
        this.vista.getjRbtnCoordi().addActionListener(e -> cargarFormCoordi());
        this.vista.getjRbtnStudent().addActionListener(e -> cargarFormStudent());
        this.vista.getjBtnSaveStudent().addActionListener(e -> {
            try {
                saveStudent();
            } catch (IOException | InterruptedException ex) {
                System.out.println(ex.getMessage());
                throw new RuntimeException(ex);
            }
        });
        this.vista.getjBtnSaveCompany().addActionListener(e -> saveCompany());
        this.vista.getjBtnSaveCoordi().addActionListener(e -> saveCoordi());
    }

    private void volverHomeWithOuLog() {
        vista.dispose();
        GUIHomeWithOutLog homeOutLog = new GUIHomeWithOutLog();
        homeOutLog.setExtendedState(JFrame.MAXIMIZED_BOTH);
        homeOutLog.setVisible(true);
    }

    private void abrirHomeStudent() {
        Long id = Long.parseLong(vista.getjFieldCodeStudent().getText());
        GUIHomeWithLog homeStudent = new GUIHomeWithLog(id,"student");
        vista.dispose();
        homeStudent.setExtendedState(JFrame.MAXIMIZED_BOTH);
        homeStudent.setVisible(true);
    }

    private void abrirHomeCoordi() {
        Long id = Long.parseLong(vista.getjFieldCodeCoordi().getText());
        GUIHomeWithLog homeCoordi = new GUIHomeWithLog(id,"coordinator");
        vista.dispose();
        homeCoordi.setExtendedState(JFrame.MAXIMIZED_BOTH);
        homeCoordi.setVisible(true);
    }

    private void abrirHomeCompany() {
        Long id = Long.parseLong(vista.getjFieldNitCompany().getText());
        GUIHomeWithLog homeCompany = new GUIHomeWithLog(id,"company");
        homeCompany.setExtendedState(JFrame.MAXIMIZED_BOTH);
        homeCompany.setVisible(true);
    }

    private void cargarFormStudent() {
        cardLayout = (CardLayout) vista.getjPRolInformation().getLayout();
        cardLayout.show(vista.getjPRolInformation(), "Estudiante");
        cardLayout = (CardLayout) vista.getjPRegisterUser().getLayout();
        cardLayout.show(vista.getjPRegisterUser(), "Estudiante");
    }

    private void cargarFormCompany() {
        cardLayout = (CardLayout) vista.getjPRolInformation().getLayout();
        cardLayout.show(vista.getjPRolInformation(), "Empresa");
        cardLayout = (CardLayout) vista.getjPRegisterUser().getLayout();
        cardLayout.show(vista.getjPRegisterUser(), "Empresa");
        fillSectorsCompany();
    }

    private void cargarFormCoordi() {
        cardLayout = (CardLayout) vista.getjPRolInformation().getLayout();
        cardLayout.show(vista.getjPRolInformation(), "Coordi");
        cardLayout = (CardLayout) vista.getjPRegisterUser().getLayout();
        cardLayout.show(vista.getjPRegisterUser(), "Coordi");
        fillSectorCoordi();
    }

    private void fillSectorsCompany() {
        vista.getjCBSectorCompany().removeAllItems();
        for (SectorCompany sector : SectorCompany.values()) {
            vista.getjCBSectorCompany().addItem(sector.toString());
        }
    }

    private void fillSectorCoordi() {
        vista.getjCBProgramCoordi().removeAllItems();
        for (sectorCoordi sector : sectorCoordi.values()) {
            vista.getjCBProgramCoordi().addItem(sector.toString());
        }
    }

    private void saveStudent() throws IOException, InterruptedException {
        long codigo = Long.parseLong(vista.getjFieldCodeStudent().getText());
        System.out.println(codigo);
        String nombre = vista.getjFieldNameStudent().getText();
        System.out.println(nombre);
        long tel = Long.parseLong(vista.getjFieldTelStudent().getText());
        System.out.println(tel);
        String email = vista.getjFieldEmailStudent().getText();
        System.out.println(email);
        String pass = vista.getjFieldPassWordStudent().getText();
        System.out.println(pass);
        String token = obtenerTokenAdmin();
        System.out.println(token);
        crearUsuarioKeycloak(token, String.valueOf(codigo), pass);
        studentController.registerStudent(codigo, nombre, tel, email, pass);
    }

    private void saveCompany() {
        long nit = Long.parseLong(vista.getjFieldNitCompany().getText());
        String name = vista.getjFieldNameCompany().getText();
        String phone = vista.getjFieldTelCompany().getText();
        String email = vista.getjFieldEmailCompany().getText();
        String pageWeb = vista.getjFieldWebCompany().getText();
        String sector = String.valueOf(SectorCompany.valueOf(vista.getjCBSectorCompany().getSelectedItem().toString()));
        String pass = vista.getjFieldPassWordCompany().getText();
        System.out.println("Empresa"+ sector + pageWeb);
        companyController.registerCompany(nit,name,phone,pageWeb,sector,email,pass);
    }

    private void saveCoordi() {
        long codigo = Long.parseLong(vista.getjFieldCodeCoordi().getText());
        String name = vista.getjFieldNameCoordi().getText();
        String tel = vista.getjFieldTelCoordi().getText();
        String email = vista.getjFieldEmailCoordi().getText();
        String programa = vista.getjCBProgramCoordi().getSelectedItem().toString();
        String pass = vista.getjFieldPassWordCoordi().getText();
        coordinatorController.registerCoordinator(codigo, name, tel, email, programa, pass);
    }

    public static String obtenerToken(String username, String password) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        System.out.println("Obteniendo token");
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8080/realms/sistema/protocol/openid-connect/token")).header("Content-Type", "application/x-www-form-urlencoded").POST(HttpRequest.BodyPublishers.ofString("client_id=sistema-desktop&grant_type=password&username=" + username + "&password=" + password)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        JSONObject json = new JSONObject(response.body());
        System.out.println("Respuesta JSON: " + json.toString());

        return json.getString("access_token");
    }

    public static String llamarServicio(String token, String url) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).header("Authorization", "Bearer " + token).GET().build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public static String obtenerTokenAdmin() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/realms/master/protocol/openid-connect/token"))
                .header("Content-Type", "application/x-www-form-urlencoded")
                .POST(HttpRequest.BodyPublishers.ofString(
                        "client_id=admin-cli" +
                                "&grant_type=password" +
                                "&username=admin" +
                                "&password=admin")) // cambia por la clave real de tu admin
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        JSONObject json = new JSONObject(response.body());

        if (json.has("access_token")) {
            return json.getString("access_token");
        } else {
            throw new RuntimeException("Error al obtener token de administrador: " + json.toString());
        }
    }

    public void crearUsuarioKeycloak(String tokenAdmin, String username, String password) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        // Crear JSON del nuevo usuario
        JSONObject userJson = new JSONObject();
        userJson.put("username", username);
        userJson.put("enabled", true);  // Activar el usuario
        userJson.put("emailVerified", false);  // Si no usas email, lo puedes marcar como no verificado

        // Crear el usuario
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/admin/realms/sistema/users"))
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + tokenAdmin)
                .POST(HttpRequest.BodyPublishers.ofString(userJson.toString()))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 201) {
            System.out.println("Usuario creado exitosamente");

            // Buscar el ID del usuario recién creado (por username)
            String userId = obtenerUserIdPorUsername(tokenAdmin, username);
            if (userId != null) {
                asignarPassword(tokenAdmin, userId, password);
            } else {
                System.out.println("Error: No se pudo obtener el ID del usuario.");
            }

        } else {
            System.out.println("Error al crear usuario: " + response.body());
        }
    }


    public void asignarPassword(String tokenAdmin, String userId, String password) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        JSONObject credentialJson = new JSONObject();
        credentialJson.put("type", "password");
        credentialJson.put("value", password);
        credentialJson.put("temporary", false);

        JSONObject payload = new JSONObject();
        payload.put("type", "password");
        payload.put("value", password);
        payload.put("temporary", false);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/admin/realms/sistema/users/" + userId + "/reset-password"))
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + tokenAdmin)
                .PUT(HttpRequest.BodyPublishers.ofString(payload.toString()))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 204) {
            System.out.println("Contraseña asignada correctamente");
        } else {
            System.out.println("Error al asignar contraseña: " + response.body());
        }
    }


    public String obtenerUserIdPorUsername(String tokenAdmin, String username) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/admin/realms/sistema/users?username=" + username))
                .header("Authorization", "Bearer " + tokenAdmin)
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            JSONArray users = new JSONArray(response.body());
            if (users.length() > 0) {
                return users.getJSONObject(0).getString("id");
            }
        }
        return null;
    }


}
