package co.edu.unicauca.academicproject.GUI.controller.coordinator;


import co.edu.unicauca.academicproject.GUI.coordinator.GUIAssigment;
import co.edu.unicauca.academicproject.GUI.coordinator.GUIminiRequest;

/**
 * @author lopez
 * @date 6/06/2025
 */
public class controllerminiRequest {
    private final GUIminiRequest vista;

    public controllerminiRequest(GUIminiRequest vista) {
        this.vista = vista;
        setDatos(vista.getTituloProyecto(),vista.getNombreProyecto(),vista.getEstadoProyecto());
    }

    public void setDatos(String tituloProyecto,String nombreEmpresa,String estado){
        vista.setjLTituloProyecto(tituloProyecto);
        vista.setjLNombreEmpresa(nombreEmpresa);
        vista.setjLEstadoProyecto(estado);
    }
}
