/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.academicproject.entities;

/**
 *
 * @author anvig
 */
public class Project {

    private String title;
    private String description;
    private Company company;
    private Student student;
    private String state; // "PROPUESTO", "ASIGNADO", "FINALIZADO"
    private String tituloEmpresa;
    private String nombreEstudiante;

    public String getNombreEstudiante() {
        return nombreEstudiante;
    }

    public void setNombreEstudiante(String nombreEstudiante) {
        this.nombreEstudiante = nombreEstudiante;
    }
    /**
     * Constructor de la clase Project.
     *
     * @param titulo Título del proyecto.
     * @param descripcion Descripción del proyecto.
     * @param empresa Empresa que propone el proyecto.
     */
    public Project() {

    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Project(String titulo, String descripcion, Company empresa) {
        this.title = titulo;
        this.description = descripcion;
        this.company = empresa;
        this.state = "PROPUESTO"; // Estado inicial
    }

    public String getTituloEmpresa() {
        return tituloEmpresa;
    }

    public void setTituloEmpresa(String tituloEmpresa) {
        this.tituloEmpresa = tituloEmpresa;
    }
    
    public Project(String titulo,String descripcion, String tituloEmpresa,String nombreEstudiante,String state){
        this.title = titulo;
        this.description = descripcion;
        this.tituloEmpresa = tituloEmpresa;
        this.nombreEstudiante = nombreEstudiante;
        this.state = state;
    }

    /**
     * Obtiene el título del proyecto.
     *
     * @return Título del proyecto.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Obtiene la descripción del proyecto.
     *
     * @return Descripción del proyecto.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Obtiene la empresa que propuso el proyecto.
     *
     * @return Objeto Company que representa la empresa.
     */
    public Company getCompany() {
        return company;
    }

    /**
     * Obtiene el estudiante asignado al proyecto, si existe.
     *
     * @return Objeto User del estudiante asignado o null si no hay ninguno.
     */
    public Student getStudent() {
        return student;
    }

    /**
     * Obtiene el estado actual del proyecto.
     *
     * @return Estado del proyecto.
     */
    public String getState() {
        return state;
    }

    /**
     * Asigna un estudiante al proyecto y cambia su estado a "ASIGNADO".
     *
     * @param estudiante Usuario con rol de estudiante.
     * @throws IllegalArgumentException si el usuario no es un estudiante.
     */
    public void assignStudent(Student estudiante) {
        this.student = estudiante;
        this.state = "ASIGNADO";
    }

    /**
     * Establece un nuevo título para el proyecto.
     *
     * @param titulo Nuevo título del proyecto.
     */
    public void setTitulo(String titulo) {
        this.title = titulo;
    }

    /**
     * Representación en cadena del proyecto.
     *
     * @return Cadena con información del proyecto.
     */
    @Override
    public String toString() {
        return "Proyecto: " + title + " | Estado: " + state
                + " | Empresa: " + (company != null ? getTituloEmpresa() : "Sin empresa")
                + (student != null ? " | Estudiante: " + student.getName() : "");
    }

}
