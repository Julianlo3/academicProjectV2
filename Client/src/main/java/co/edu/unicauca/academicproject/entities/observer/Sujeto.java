package co.edu.unicauca.academicproject.entities.observer;


import java.util.ArrayList;
import java.util.List;

/**
 * @author lopez
 * @date 9/06/2025
 */
public class Sujeto {
    public static List<Observer> observadores = new ArrayList<>();

    public void agregarObservador(Observer o) {
        observadores.add(o);
    }

    public void eliminarObservador(Observer o) {
        observadores.remove(o);
    }

    public void notificar(String mensaje) {
        for (Observer o : observadores) {
            o.actualizar(mensaje);
        }
    }
}
