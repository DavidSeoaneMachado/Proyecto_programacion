package View;

import Controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Editar_perfil {

    Controller controlador = new Controller();
    private static JFrame ventana = new JFrame("Crear perfil");
    private JPanel Header;
    private JPanel Body;
    private JButton confirmarCambiosButton;
    private JPasswordField field_password;
    private JTextField field_nombre;
    private JTextField field_apellido;
    private JTextField field_peso;
    private JTextField field_altura;
    private JTextField field_usuario;
    private JComboBox box_dieta;
    private JComboBox box_experiencia;
    private JPanel Footer;
    private JLabel etiqueta_custom;
    private JButton volverButton;
    private JPanel panel1;

    public Editar_perfil(){
        field_nombre.setText(controlador.getCliente_sesion_actual().getNombre());
        field_apellido.setText(controlador.getCliente_sesion_actual().getApellido());
        field_peso.setText(String.valueOf(controlador.getCliente_sesion_actual().getPeso()));
        field_altura.setText(String.valueOf(controlador.getCliente_sesion_actual().getAltura()));
        field_usuario.setText(controlador.getCliente_sesion_actual().getUsername());
        field_password.setText(controlador.getCliente_sesion_actual().getPassword());
        box_dieta.setSelectedItem(controlador.getCliente_sesion_actual().getTipo_dieta());
        box_experiencia.setSelectedItem(controlador.getCliente_sesion_actual().getExperiencia());

        confirmarCambiosButton.addActionListener(new ActionListener() {
            /**
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                controlador.modificar_cliente(controlador.getCliente_sesion_actual().getIdCliente(), field_nombre.getText(),field_apellido.getText(), Float.parseFloat(field_peso.getText()), Integer.parseInt(field_altura.getText()), (String) box_dieta.getSelectedItem(), (String) box_experiencia.getSelectedItem(), field_usuario.getText(), new String(field_password.getPassword()));
                Menu_principal.lanzar_ventana();
                ventana.dispose();
            }
        });
        volverButton.addActionListener(new ActionListener() {
            /**
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                Menu_principal.lanzar_ventana();
                ventana.dispose();
                System.out.println("No se han realizado cambios.");
            }
        });
    }

    public static void lanzar_ventana(){
        ventana.setContentPane(new Editar_perfil().panel1);
        ventana.setBounds(0, 0, 1200, 800);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);


    }

}
