package View;

import Controller.Controller;
import Model.Perfil_cliente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class Inicio_sesion {

    Controller controlador = new Controller();
    private static JFrame ventana = new JFrame("Inicio de sesión");
    private JPanel Header;
    private JPanel Footer;
    private JButton salirButton;
    private JPanel Body;
    private JButton iniciarSesiónButton;
    private JPasswordField passwordField1;
    private JTextField textField1;
    private JPanel panel1;
    private JButton Volver;

    public Inicio_sesion() {

        iniciarSesiónButton.addActionListener(new ActionListener() {
            /**
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {

                if (controlador.inicio_sesion(textField1.getText(), new String(passwordField1.getPassword()))!=null){
                    Menu_principal.lanzar_ventana();
                    ventana.dispose();
                    System.out.println("Sesión iniciada con exito");
                }
            }
        });
        Volver.addActionListener(new ActionListener() {
            /**
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                Inicio.lanzar_ventana();
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

    /**
     * Lanza la ventana de la interfaz grafica con una configuracion determinada e iniciando el constructor de la clase, lo que activa los listeners
     */
    public static void lanzar_ventana(){
        ventana.setContentPane(new Inicio_sesion().panel1);
        ventana.setBounds(0, 0, 1200, 800);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }


}
