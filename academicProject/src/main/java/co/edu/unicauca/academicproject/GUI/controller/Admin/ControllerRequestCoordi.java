package co.edu.unicauca.academicproject.GUI.controller.Admin;


import co.edu.unicauca.academicproject.GUI.admin.GUIRequestCoordinator;
import co.edu.unicauca.academicproject.Service.Admin.AdminServiceClient;
import co.edu.unicauca.academicproject.Service.Coordinator.CoordinatorServiceClient;
import co.edu.unicauca.academicproject.controller.AdminController;
import co.edu.unicauca.academicproject.controller.CoordinatorController;
import co.edu.unicauca.academicproject.entities.Coordinator;
import co.edu.unicauca.academicproject.provider.appContextProvider;

import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

/**
 * @author lopez
 * @date 3/05/2025
 */
public class ControllerRequestCoordi {

    private final GUIRequestCoordinator vista;
    CoordinatorController coordinatorController = new CoordinatorController(appContextProvider.getBean(CoordinatorServiceClient.class));
    AdminController adminController = new AdminController(appContextProvider.getBean(AdminServiceClient.class));
    private long id;
    private String nombre;
    public ControllerRequestCoordi(GUIRequestCoordinator vista) {
        this.vista = vista;
        cargarHistorialCoordinadores();
        cargarSolicitudesCoordinadores();
        this.vista.getBtnProcesarSoli().addActionListener(e -> procesarSoli());

        this.vista.getTableSoliCoordi().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila = vista.getTableSoliCoordi().getSelectedRow();
                if (fila >= 0) {
                    id = Long.parseLong( vista.getTableSoliCoordi().getValueAt(fila, 0).toString()); // columna 0 es code
                    nombre = ((String) vista.getTableSoliCoordi().getValueAt(fila, 1));
                    vista.getLabelNameCoordi().setText(nombre);
                    System.out.println("Nombre del coordinador seleccionado: " + nombre + " con code: " + id);
                }
            }
        });
    }



    private void cargarHistorialCoordinadores() {
        DefaultTableModel modeloCoordi = new DefaultTableModel(new String[]{"Codigo", "Nombre", "Telefono", "Email", "Estado", "Programa"}, 0);
        try {
            List<Coordinator> coordinators = coordinatorController.getAllCoordinators();
            if (coordinators != null ) {
                modeloCoordi.setRowCount(0);

                for (Coordinator coordinator : coordinators) {

                    if (coordinator.getName() != null && coordinator.getCode() != 0 && !coordinator.getEstadoActual().equals("PENDIENTE")) {
                        modeloCoordi.addRow(new Object[]{coordinator.getCode(), coordinator.getName(), coordinator.getPhone(), coordinator.getEmail(), coordinator.getEstadoActual(), coordinator.getProgramaAcademico()});
                    }

                }
            }
        } catch (Exception e) {
            System.out.println("Servicio de coordinador no disponible" + e.getMessage());
        }
        vista.getTableHistoryCoordi().setModel(modeloCoordi);
    }

    private void cargarSolicitudesCoordinadores() {
        DefaultTableModel modeloCoordi = new DefaultTableModel(new String[]{"Codigo", "Nombre", "Telefono", "Email", "Estado", "Programa"}, 0);
        try {
            List<Coordinator> coordinators = coordinatorController.getAllCoordinators();
            if (coordinators != null ) {
                modeloCoordi.setRowCount(0);

                for (Coordinator coordinator : coordinators) {

                    if (coordinator.getName() != null && coordinator.getCode() != 0 && coordinator.getEstadoActual().equals("PENDIENTE")) {
                        modeloCoordi.addRow(new Object[]{coordinator.getCode(), coordinator.getName(), coordinator.getPhone(), coordinator.getEmail(), coordinator.getEstadoActual(), coordinator.getProgramaAcademico()});
                    }

                }
            }
        } catch (Exception e) {
            System.out.println("Servicio de coordinador no disponible" + e.getMessage());
        }
        vista.getTableSoliCoordi().setModel(modeloCoordi);
    }

    public void procesarSoli(){
        if(this.vista.getRBtnAceptar().isSelected()){
            Coordinator coordinator = coordinatorController.getCoordinatortByCode(id);
            System.out.println(coordinator.getName() + coordinator.getCode() + coordinator.getEmail() + coordinator.getPhone() + coordinator.getEstadoActual() + coordinator.getProgramaAcademico());
            adminController.aceptarCoordi(coordinator);
        }
    }
}
