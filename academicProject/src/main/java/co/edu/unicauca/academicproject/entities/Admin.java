/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.academicproject.entities;

/**
 *
 * @author anvig
 */
public class Admin {

    private String nombre;
    private String codigo;
    private String password;

    
    // -- Se usa singleton 
    private static Admin instance;

    private Admin() {
    }

    public static Admin getInstance() {
        if (instance == null) {
            instance = new Admin();
        }
        return instance;
    }

    // Métodos para inicializar los datos del administrador
    public void setAdminData(String nombre, String codigo, String password) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.password = password;
    }

    // Métodos para obtener la información del admin
    public String getNombre() {
        return nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
