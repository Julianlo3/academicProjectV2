/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.unicauca.gestionusuariomicroservice.state;


/**
 *
 * @author lopez
 */
public interface ICoordinatorState {
    PendienteCoordi solicitarAcceso();
    VerificadoCoordi verificar();
    RechazadoCoordi rechazar();
}
