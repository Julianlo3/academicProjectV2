/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.academicproject.state.coordinator;

import co.edu.unicauca.academicproject.entities.Coordinator;






/**
 *
 * @author lopez
 */
public class PendienteCoordi implements ICoordinatorState {

    private Coordinator coordi;

    public PendienteCoordi(Coordinator coordinador) {
        this.coordi = coordinador;
    }

    @Override
    public PendienteCoordi solicitarAcceso() {
        //Messages.showMessageDialog("Aprobacion para el admin enviada", "En espera");
        return this;
    }

    @Override
    public VerificadoCoordi verificar() {
        //Messages.showMessageDialog("El admin te acepto ois", "Aceptado");
        System.out.println("Te vamos a pasar el estado de ");
        return new VerificadoCoordi(coordi);
    }

    @Override
    public RechazadoCoordi rechazar() {
        //Messages.showMessageDialog("Usted no puede acceso. Rechazado por el admin", "Sin acceso");
        return new RechazadoCoordi(coordi);
    }

    @Override
    public String toString() {
        return "PENDIENTE";
    }
}
