package co.edu.unicauca.academicproject.GUI.controller.coordinator;


import co.edu.unicauca.academicproject.GUI.coordinator.GUIAssigment;
import co.edu.unicauca.academicproject.GUI.coordinator.GUIminiRequest;

import java.awt.*;

/**
 * @author lopez
 * @date 6/06/2025
 */
public class controllerminiRequest {
    private final GUIminiRequest vista;

    public controllerminiRequest(GUIminiRequest vista) {
        this.vista = vista;
        vista.getjBtnVerDetalles().addActionListener(e-> verDetalles());
        setDatos(vista.getTituloProyecto(),vista.getNombreLEstudiante(),vista.getNombreProyecto(),vista.getEstadoProyecto());
    }

    public void setDatos(String tituloProyecto,String nombreEstudiante,String nombreEmpresa,String estado){
        vista.setjLTituloProyecto(tituloProyecto);
        vista.setjLEstudiante(nombreEstudiante);
        vista.setjLNombreEmpresa(nombreEmpresa);
        vista.setjLEstadoProyecto(estado);
        colorearEstado();
    }

    public void verDetalles(){
    }

    public void colorearEstado(){
        String estado = vista.getEstadoProyecto();
        System.out.println("estado: "+estado);
        switch (estado){
            case "ACCEPTED": vista.getjLEstadoProyecto().setBackground(Color.GREEN);break;

            case "PENDING": vista.getjLEstadoProyecto().setBackground(Color.yellow); break;

            case "COMPLETED": vista.getjLEstadoProyecto().setBackground(Color.GRAY);break;

            case "REJECTED": vista.getjLEstadoProyecto().setBackground(Color.RED);break;

        }
    }
}
