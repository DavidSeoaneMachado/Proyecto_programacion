package View;

import Controller.Controller;

import javax.swing.*;
import java.awt.event.*;

public class Crear_perfil {

    static Controller controlador = new Controller();
    private static JFrame ventana = new JFrame("Crear perfil");
    private JPanel Header;
    private JPanel Body;
    private JButton crearUsuarioButton;
    private JPasswordField field_password;
    private JTextField field_nombre;
    private JPanel Footer;
    private JButton salirButton;
    private JComboBox box_dieta;
    private JPanel panel1;
    private JButton Volver;
    private JTextField field_apellido;
    private JTextField field_peso;
    private JTextField field_altura;
    private JComboBox box_experiencia;
    private JTextField field_usuario;
    private JLabel edad;
    private JTextField field_edad;

    public Crear_perfil() {

        crearUsuarioButton.addActionListener(new ActionListener() {
            /**
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                controlador.enviar_perfil_creado(field_nombre.getText(),field_apellido.getText(), Float.parseFloat(field_peso.getText()), Integer.parseInt(field_altura.getText()), Integer.parseInt(field_edad.getText()),  (String) box_dieta.getSelectedItem(), (String) box_experiencia.getSelectedItem(), field_usuario.getText(), new String(field_password.getPassword()));
                Menu_principal.lanzar_ventana();
                ventana.dispose();
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
     * Lanza la ventana de la interfaz gráfica con una configuracion determinada e iniciando el constructor de la clase, lo que activa los listeners
     */
    public static void lanzar_ventana(){
        ventana.setContentPane(new Crear_perfil().panel1);
        ventana.setBounds(0, 0, 1200, 800);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }
}
