/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.gestioncoordinadormicroservice.entities.state;
import co.edu.unicauca.gestioncoordinadormicroservice.entities.Coordinator;


public class Rejected implements ICoordinatorState {

    private Coordinator coordi;

    public Rejected(Coordinator coordi) {
        this.coordi = coordi;
        this.coordi.setEstadoActual("RECHAZADO");
    }

    @Override
    public Pending solicitarAcceso() {
        //Messages.showMessageDialog("Usted no tiene acceso. Rechazado por el admin", "Sin acceso");
        return new Pending(coordi);
    }

    @Override
    public Verified verificar() {
        //Messages.showMessageDialog("Usted no tiene acceso. Rechazado por el admin", "Sin acceso");
        return new Verified(coordi);
    }

    @Override
    public Rejected rechazar() {
        //Messages.showMessageDialog("Usted no tiene acceso. Rechazado por el admin", "Sin acceso");
        return new Rejected(coordi);
    }

     @Override
    public String toString() {
        return "RECHAZADO";
    }
}
