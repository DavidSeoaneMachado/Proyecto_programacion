package View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Inicio {
    private JButton crearPerfilButton;
    private JButton iniciarSesiónButton;
    private JPanel Inicio;
    private JPanel Header;
    private JPanel Body;
    private JPanel Footer;
    private JButton salirButton;

    /**
     * Constructor del entorno gráfico del inicio de la aplicacion
     * llama al metodo que tendrá los listener de esta interfaz gráfica
     */
    public Inicio() {
        activar_listeners();
    }

    public void lanzar_ventana() {

        JFrame ventana = new JFrame("Verdanks Fiteness");
        ventana.setContentPane(Inicio);
        ventana.setBounds(0, 0, 1200, 800);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);

    }

    private void activar_listeners() {


    }
}
