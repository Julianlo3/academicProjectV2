/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.gestioncoordinadormicroservice.entities.state;
import co.edu.unicauca.gestioncoordinadormicroservice.entities.Coordinator;


public class Verified implements ICoordinatorState {

    private Coordinator coordi;

    public Verified(Coordinator coordi) {
        this.coordi = coordi;
        this.coordi.setEstadoActual("VERIFICADO");
    }

    @Override
    public Pending solicitarAcceso() {
        //Messages.showMessageDialog("Aprobacion aceptada", "Aceptado");
        return new Pending(coordi);
    }

    @Override
    public Verified verificar() {
        //Messages.showMessageDialog("Usted si tiene acceso al sistema", "Aceptado");
        return new Verified(coordi);
    }

    @Override
    public Rejected rechazar() {
        //Messages.showMessageDialog("No se puede rachazar si el admin te acepto", "Aceptado");
        return new Rejected(coordi);
    }

     @Override
    public String toString() {
        return "VERIFICADO";
    }
}
