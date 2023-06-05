package Controller;

import View.Menu_principal;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

public class Observer_Experiencia implements Observer {

    /**
     * Método que recibe el cambio realizado y llama a la vista para que informe del mismo
     * @param o   the observable object.
     * @param arg an argument passed to the {@code notifyObservers}
     *            method.
     */
    @Override
    public void update(Observable o, Object arg) {

        String nueva_experiencia = (String) arg;
        Menu_principal.mostrar_cambio_observer(nueva_experiencia);
    }
}
