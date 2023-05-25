package View;

import Controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Planning {

    static Controller controlador = new Controller();
    private static JFrame ventana = new JFrame("Planificación");
    private JPanel Header;
    private JLabel etiqueta_custom;
    private JPanel Body;
    private JPanel Footer;
    private JButton volver;
    private JPanel panel1;

    public Planning(){

        etiqueta_custom.setText("Esta es tu planificación de dieta y ejercicios, " + controlador.getCliente_sesion_actual().getUsername());
        String[][] matriz_aux =  controlador.leer_ficheros("Fichero_dieta.json");
        String[][] matriz_aux_2 = controlador.leer_ficheros("Fichero_rutina.json");

        volver.addActionListener(new ActionListener() {
            /**
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                Menu_principal.lanzar_ventana();
                ventana.dispose();
            }
        });
    }

    public static void lanzar_ventana(){
        ventana.setContentPane(new Planning().panel1);
        ventana.setBounds(0, 0, 1200, 800);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }
}
