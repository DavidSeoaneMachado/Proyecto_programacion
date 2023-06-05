package View;

import Controller.Controller;
import Model.Perfil_cliente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Clase que gestiona la vista de modificación de un perfil de cliente//
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
    private JTextField field_edad;
    private JLabel edad;
    private JComboBox box_sexo;

    public Editar_perfil(){

        field_nombre.setText(controlador.getCliente_sesion_actual().getNombre());
        field_apellido.setText(controlador.getCliente_sesion_actual().getApellido());
        field_peso.setText(String.valueOf(controlador.getCliente_sesion_actual().getPeso()));
        field_altura.setText(String.valueOf(controlador.getCliente_sesion_actual().getAltura()));
        field_edad.setText(String.valueOf(controlador.getCliente_sesion_actual().getEdad()));
        field_usuario.setText(controlador.getCliente_sesion_actual().getUsername());
        field_password.setText(controlador.getCliente_sesion_actual().getPassword());
        box_sexo.setSelectedItem(controlador.getCliente_sesion_actual().getSexo());
        box_dieta.setSelectedItem(controlador.getCliente_sesion_actual().getTipo_dieta());
        box_experiencia.setSelectedItem(controlador.getCliente_sesion_actual().getExperiencia());

        confirmarCambiosButton.addActionListener(new ActionListener() {
            /**
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                Perfil_cliente aux = new Perfil_cliente();
                Perfil_cliente aux2 = new Perfil_cliente();
                aux = controlador.getCliente_sesion_actual();
                controlador.modificar_cliente(controlador.getCliente_sesion_actual().getIdCliente(), field_nombre.getText(),field_apellido.getText(), Float.parseFloat(field_peso.getText()), Integer.parseInt(field_altura.getText()), Integer.parseInt(field_edad.getText()), (String) box_sexo.getSelectedItem(), (String) box_dieta.getSelectedItem(), (String) box_experiencia.getSelectedItem(), field_usuario.getText(),String.valueOf(field_password.getPassword()) /*Tambien podria ser new String*/);
                aux2 = controlador.getCliente_sesion_actual();

                if (controlador.cambios_perfil(aux, aux2)){
                    JOptionPane.showMessageDialog(null, "Cambios confirmados y guardados");
                } else {
                    JOptionPane.showMessageDialog(null, "No se ha realizado ningún cambio");
                }
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

    /**
     * Lanza la ventana de la interfaz gráfica e inicializa el constructor de la clase
     * inicia los listener de esta interfaz gráfica
     */
    public static void lanzar_ventana(){
        ventana.setContentPane(new Editar_perfil().panel1);
        ventana.setBounds(0, 0, 1200, 800);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);


    }
}
