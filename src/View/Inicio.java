package View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Inicio {

    private static JFrame ventana = new JFrame("Verdanks Fiteness");

    private JButton crearPerfilButton;
    private JButton iniciarSesiónButton;
    private JPanel Inicio;
    private JPanel Header;
    private JPanel Body;
    private JPanel Footer;
    private JButton salirButton;

    /**
     * Constructor del entorno gráfico del inicio de la aplicacion
     * inicia los listener de esta interfaz gráfica
     */
    public Inicio() {

        crearPerfilButton.addActionListener(new ActionListener() {
            /**
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                Crear_perfil.lanzar_ventana();
                ventana.dispose();
            }
        });
        iniciarSesiónButton.addActionListener(new ActionListener() {
            /**
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                Inicio_sesion.lanzar_ventana();
                ventana.dispose();
            }
        });
        salirButton.addActionListener(new ActionListener() {
            /**
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public static void lanzar_ventana() {

        ventana.setContentPane(new Inicio().Inicio);
        ventana.setBounds(0, 0, 1200, 800);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);


    }
}
