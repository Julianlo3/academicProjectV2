/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.academicproject.entities;

public class Coordinator {

    private Long id;
    private String name, phone, email;
    private String programaAcademico;
    private String estadoActual;

    public Coordinator(long code, String name, String phone, String email, String programaAcademico) {
        this.id = code;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.programaAcademico = programaAcademico;
        this.estadoActual = "PENDIENTE";
    }

    public Coordinator() {
    }

    public String getProgramaAcademico() {
        return programaAcademico;
    }

    public void setProgramaAcademico(String programaAcademico) {
        this.programaAcademico = programaAcademico;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEstadoActual() {
        return estadoActual;
    }

    public void setEstadoActual(String estadoActual) {
        this.estadoActual = estadoActual;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getCode() {
        return id;
    }

    public void setCode(long code) {
        this.id = code;
    }
}
