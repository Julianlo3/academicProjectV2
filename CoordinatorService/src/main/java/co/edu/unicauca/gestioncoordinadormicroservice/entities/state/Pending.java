/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.gestioncoordinadormicroservice.entities.state;
import co.edu.unicauca.gestioncoordinadormicroservice.entities.Coordinator;

public class Pending implements ICoordinatorState {

    private Coordinator coordi;

    public Pending(Coordinator coordinador) {
        this.coordi = coordinador;
    }

    @Override
    public Pending solicitarAcceso() {
        //Messages.showMessageDialog("Aprobacion para el admin enviada", "En espera");
        return this;
    }

    @Override
    public Verified verificar() {
        //Messages.showMessageDialog("El admin te acepto ois", "Aceptado");
        System.out.println("Te vamos a pasar el estado de ");
        return new Verified(coordi);
    }

    @Override
    public Rejected rechazar() {
        //Messages.showMessageDialog("Usted no puede acceso. Rechazado por el admin", "Sin acceso");
        return new Rejected(coordi);
    }

    @Override
    public String toString() {
        return "PENDIENTE";
    }
}
