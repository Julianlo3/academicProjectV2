package co.edu.unicauca.academicproject.security;


import co.edu.unicauca.academicproject.infra.Messages;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;

/**
 * @author lopez
 * @date 24/05/2025
 */
public class Users {

    public String obtenerTokenGestionador(String username, String password) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        String body = "client_id=sistema-desktop" +
                "&grant_type=password" +
                "&username=" + URLEncoder.encode(username, StandardCharsets.UTF_8) +
                "&password=" + URLEncoder.encode(password, StandardCharsets.UTF_8);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/realms/sistema/protocol/openid-connect/token"))
                .header("Content-Type", "application/x-www-form-urlencoded")
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        JSONObject json = new JSONObject(response.body());
        System.out.println("Respuesta JSON: " + json.toString());

        return json.getString("access_token");
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

    public void crearUsuarioKeycloak(String tokenGestion, String username, String password,String rol) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        JSONObject userJson = new JSONObject();
        userJson.put("username", username);
        userJson.put("enabled", true);
        userJson.put("emailVerified", false);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/admin/realms/sistema/users"))
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + tokenGestion)
                .POST(HttpRequest.BodyPublishers.ofString(userJson.toString()))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 201) {
            System.out.println("Usuario creado exitosamente");

            String userId = obtenerUserIdPorUsername(tokenGestion, username);
            if (userId != null) {
                asignarPassword(tokenGestion, userId, password);
            } else {
                throw new RuntimeException("Error interno: No se pudo obtener el ID del usuario.");
            }

            asignarRolDeClienteAUsuario(tokenGestion, username,rol);

        } else {
            String body = response.body();

            try {
                JSONObject errorJson = new JSONObject(body);
                if (errorJson.has("errorMessage")) {
                    String msg = errorJson.getString("errorMessage");

                    switch (msg) {
                        case "User exists with same username":
                            Messages.showErrorDialog("Ya existe un usuario con ese nombre de usuario.","Usuario existente");
                            throw new IllegalArgumentException("Ya existe un usuario con ese nombre de usuario.");
                        case "Invalid email":
                            Messages.showErrorDialog("Correo no valido. Ingrese nuevamente.","Correo no valido");
                            throw new IllegalArgumentException("El correo ingresado no es válido.");
                        default:
                            Messages.showErrorDialog("Error inesperado: ."+ msg  ,"Error inesperado");
                            throw new IllegalArgumentException("Error: " + msg);
                    }
                } else {
                    throw new RuntimeException("Error inesperado al crear el usuario: " + body);
                }
            } catch (JSONException ex) {
                throw new RuntimeException("Error inesperado al analizar respuesta: " + body);
            }
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

    public void asignarRolDeClienteAUsuario(String token, String username, String roleName) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        // 1. Obtener el ID del usuario por username
        String userId = obtenerUserIdPorUsername(token, username);
        if (userId == null) {
            throw new RuntimeException("No se pudo obtener el ID del usuario: " + username);
        }
        System.out.println("llego a userid" + userId);
        // 2. Obtener el ID del cliente "sistema-desktop"
        String clientId = obtenerClientId(token, "sistema-desktop");
        if (clientId == null) {
            throw new RuntimeException("No se pudo obtener el ID del cliente");
        }

        System.out.println("llego a clien id" + clientId);
        // 3. Obtener el rol del cliente
        HttpRequest getRoleRequest = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/admin/realms/sistema/clients/" + clientId + "/roles/" + roleName))
                .header("Authorization", "Bearer " + token)
                .GET()
                .build();

        HttpResponse<String> getRoleResponse = client.send(getRoleRequest, HttpResponse.BodyHandlers.ofString());

        if (getRoleResponse.statusCode() != 200) {
            throw new RuntimeException("No se pudo obtener el rol: " + roleName);
        }

        System.out.println("Rol obtenido: " + getRoleResponse.body());

        JSONObject roleJson = new JSONObject(getRoleResponse.body());

        // 4. Asignar el rol al usuario
        JSONArray rolesArray = new JSONArray();
        rolesArray.put(new JSONObject()
                .put("id", roleJson.getString("id"))
                .put("name", roleJson.getString("name")));

        HttpRequest assignRoleRequest = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/admin/realms/sistema/users/" + userId + "/role-mappings/clients/" + clientId))
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(rolesArray.toString()))
                .build();

        HttpResponse<String> assignRoleResponse = client.send(assignRoleRequest, HttpResponse.BodyHandlers.ofString());

        if (assignRoleResponse.statusCode() == 204) {
            System.out.println("Rol asignado exitosamente al usuario.");
        } else {
            throw new RuntimeException("Error al asignar el rol: " + assignRoleResponse.body());
        }
    }

    public String obtenerClientId(String token, String clientId) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/admin/realms/sistema/clients?clientId=" + clientId))
                .header("Authorization", "Bearer " + token)
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String body = response.body();

        System.out.println("Respuesta de Keycloak al buscar clientId: " + body);

        // Verificar si es un array o un error
        if (body.trim().startsWith("[")) {
            JSONArray clients = new JSONArray(body);
            if (clients.length() > 0) {
                return clients.getJSONObject(0).getString("id");
            }
        } else {
            // Es un objeto, probablemente un error
            JSONObject error = new JSONObject(body);
            System.err.println("Error al obtener el cliente: " + error.optString("error", "Respuesta inesperada"));
        }

        return null;
    }


    public boolean validarTokenRegis(String username, String password) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        String body = "grant_type=password"
                + "&client_id=sistema-desktop"
                + "&username=" + username
                + "&password=" + password;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/realms/sistema/protocol/openid-connect/token"))
                .header("Content-Type", "application/x-www-form-urlencoded")
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            System.out.println("Login exitoso. Código: " + response.statusCode());
            return true;
        } else {
            System.out.println("Login fallido. Código: " + response.statusCode());
            return false;
        }
    }

    public String obtenerTokenRegis(String username, String password) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        String body = "grant_type=password"
                + "&client_id=sistema-desktop"
                + "&username=" + username
                + "&password=" + password;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/realms/sistema/protocol/openid-connect/token"))
                .header("Content-Type", "application/x-www-form-urlencoded")
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            JSONObject json = new JSONObject(response.body());
            return json.getString("access_token");
        } else {
            System.out.println("Login fallido. Código: " + response.statusCode());
            return null;
        }
    }

    public List<String> mostrarRoles(String token) {
        DecodedJWT jwt = JWT.decode(token.replace("Bearer ", ""));
        Map<String, Object> resourceAccess = jwt.getClaim("resource_access").asMap();

        if (resourceAccess.containsKey("sistema-desktop")) {
            Map<String, Object> client = (Map<String, Object>) resourceAccess.get("sistema-desktop");
            List<String> clientRoles = (List<String>) client.get("roles");
            System.out.println("Roles del cliente (" + "sistema-desktop" + "): " + clientRoles);
            return clientRoles;
        } else {
            System.out.println("No se encontraron roles para el cliente: " + "sistema-desktop");
            return Collections.emptyList();
        }
    }



}
