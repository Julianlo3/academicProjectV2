/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.gestioncoordinadormicroservice.state;
import co.edu.unicauca.gestioncoordinadormicroservice.entities.Coordinator;


public class RechazadoCoordi implements ICoordinatorState {

    private Coordinator coordi;

    public RechazadoCoordi(Coordinator coordi) {
        this.coordi = coordi;
        this.coordi.setEstadoActual("RECHAZADO");
    }

    @Override
    public PendienteCoordi solicitarAcceso() {
        //Messages.showMessageDialog("Usted no tiene acceso. Rechazado por el admin", "Sin acceso");
        return new PendienteCoordi(coordi);
    }

    @Override
    public VerificadoCoordi verificar() {
        //Messages.showMessageDialog("Usted no tiene acceso. Rechazado por el admin", "Sin acceso");
        return new VerificadoCoordi(coordi);
    }

    @Override
    public RechazadoCoordi rechazar() {
        //Messages.showMessageDialog("Usted no tiene acceso. Rechazado por el admin", "Sin acceso");
        return new RechazadoCoordi(coordi);
    }

     @Override
    public String toString() {
        return "RECHAZADO";
    }
}
