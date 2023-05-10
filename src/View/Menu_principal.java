package View;

import Controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu_principal {

    static Controller controlador = new Controller();
    private static JFrame ventana = new JFrame("Menu principal");
    private JPanel panel1;
    private JPanel Header;
    private JButton nuevaDietaButton;
    private JButton nuevoEntrenamientoButton;
    private JButton verPlanningActualButton;
    private JButton descargarPlanningButton;
    private JPanel Body;
    private JPanel Footer;
    private JButton editarPerfilButton;
    private JButton salirButton;
    private JLabel etiqueta_custom;

    /**
     * Constructor del entorno gráfico del menu principal
     * llama al metodo que tendrá los listener de esta interfaz gráfica
     */
    public Menu_principal() {

        //Frase personalizada para el usuario en el header del menu principal//
        String texto_etiqueta = "Bienvenid@ " + controlador.getCliente_sesion_actual().getUsername() + ". ¿Que deseas hacer?";
        etiqueta_custom.setText(texto_etiqueta);
        nuevaDietaButton.addActionListener(new ActionListener() {
            /**
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        nuevoEntrenamientoButton.addActionListener(new ActionListener() {
            /**
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        verPlanningActualButton.addActionListener(new ActionListener() {
            /**
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        descargarPlanningButton.addActionListener(new ActionListener() {
            /**
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        editarPerfilButton.addActionListener(new ActionListener() {
            /**
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                Editar_perfil.lanzar_ventana();
                ventana.dispose();
            }
        });
        salirButton.addActionListener(new ActionListener() {
            /**
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    /**
     * Lanza la ventana de la interfaz grafica con una configuracion determinada e iniciando el constructor de la clase, lo que activa los listeners
     */
    public static void lanzar_ventana(){
        ventana.setContentPane(new Menu_principal().panel1);
        ventana.setBounds(0, 0, 1200, 800);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }


}
