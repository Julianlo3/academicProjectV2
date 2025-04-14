/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.academicproject.entities;

import co.edu.unicauca.academicproject.state.coordinator.ICoordinatorState;
import co.edu.unicauca.academicproject.state.coordinator.PendienteCoordi;


public class Coordinator {

    private String code, name, phone, email, programaAcademico, password;
    private ICoordinatorState estado;

    public Coordinator() {

    }

    public Coordinator(String code, String name, String phone, String email, String programaAcademico, String password) {
        this.code = code;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.programaAcademico = programaAcademico;
        this.password = password;
        this.estado = new PendienteCoordi(this);
    }

    public ICoordinatorState getEstado() {
        return estado;
    }

    public void setEstado(ICoordinatorState Nuevoestado) {
        System.out.println("Cambiando estado a: " + Nuevoestado.toString());
        this.estado = Nuevoestado;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProgramaAcademico() {
        return programaAcademico;
    }

    public void setProgramaAcademico(String programaAcademico) {
        this.programaAcademico = programaAcademico;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void solicitarAcceso() {
        System.out.println(estado.solicitarAcceso());

    }


}
