package View;

import Controller.Controller;
import Model.Comidas;
import Model.Ejercicios;
import Model.Gestion_de_ficheros;
import Model.Perfil_clienteDAO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu_principal {

    static Gestion_de_ficheros gestionDeFicheros = new Gestion_de_ficheros();
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
    private JButton eliminar;
    private JButton cerrarSesiónButton;

    /**
     * Constructor del entorno gráfico del menu principal
     * llama al metodo que tendrá los listener de esta interfaz gráfica
     */
    public Menu_principal() {

        //Frase personalizada para el usuario en el header del menu principal//
        String texto_etiqueta = "Bienvenid@ " + controlador.getCliente_sesion_actual().getUsername() + ". ¿Que deseas hacer?";
        etiqueta_custom.setText(texto_etiqueta);

        if (gestionDeFicheros.comprobar_existencia_dieta_rutina("src/recursos/Fichero_dieta.json") == false || gestionDeFicheros.comprobar_existencia_dieta_rutina("src/recursos/Fichero_rutina.json") == false) {
            verPlanningActualButton.setEnabled(false);
            descargarPlanningButton.setEnabled(false);
        }
        nuevaDietaButton.addActionListener(new ActionListener() {
            /**
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                Cuadro_de_dialogo dialogo = new Cuadro_de_dialogo();
                boolean aux = dialogo.confirmacion_de_decision_2("Se generará una nueva dieta con los siguientes datos: \n Objetivo " +
                        "(" + controlador.getCliente_sesion_actual().getTipo_dieta() + ") , Experiencia en el gimansio (" + controlador.getCliente_sesion_actual().getExperiencia() + ") " +
                        " Peso (" + controlador.getCliente_sesion_actual().getPeso() + "). ¿Estas de acuerdo?");
                if (aux == true) {
                    //añadir metodo de nueva rutina de ejercicios//
                    controlador.escribir_ficheros(Comidas.Get_comidas(), "src/recursos/Fichero_dieta.json");
                    JOptionPane.showMessageDialog(null, "Se ha generado una nueva dieta.");
                }

                //comprobación de si el cleinte tiene tanto dieta como rutina para activar los botones de Ver planning y Descargar planning
                if (gestionDeFicheros.comprobar_existencia_dieta_rutina("src/recursos/Fichero_dieta.json") == false || gestionDeFicheros.comprobar_existencia_dieta_rutina("src/recursos/Fichero_rutina.json") == false) {
                    verPlanningActualButton.setEnabled(false);
                    descargarPlanningButton.setEnabled(false);
                }
            }
        });
        nuevoEntrenamientoButton.addActionListener(new ActionListener() {
            /**
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                Cuadro_de_dialogo dialogo = new Cuadro_de_dialogo();
                boolean aux = dialogo.confirmacion_de_decision_2("Se generará un nuevo entrenamiento con los siguientes datos: \n Objetivo " +
                        "(" + controlador.getCliente_sesion_actual().getTipo_dieta() + ") , Experiencia en el gimansio (" + controlador.getCliente_sesion_actual().getExperiencia() + ") " +
                        " Peso (" + controlador.getCliente_sesion_actual().getPeso() + "). ¿Estas de acuerdo?");
                if (aux == true) {
                    //añadir metodo de nueva rutina de ejercicios//
                    controlador.escribir_ficheros(Ejercicios.Get_ejercicios(), "src/recursos/Fichero_rutina.json");
                    JOptionPane.showMessageDialog(null, "Se ha generado una nueva rutina de ejercicios.");
                }

                //comprobación de si el cleinte tiene tanto dieta como rutina para activar los botones de Ver planning y Descargar planning
                if (gestionDeFicheros.comprobar_existencia_dieta_rutina("src/recursos/Fichero_dieta.json") == false || gestionDeFicheros.comprobar_existencia_dieta_rutina("src/recursos/Fichero_rutina.json") == false) {
                    verPlanningActualButton.setEnabled(false);
                    descargarPlanningButton.setEnabled(false);
                }
            }
        });
        verPlanningActualButton.addActionListener(new ActionListener() {
            /**
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                Planning.lanzar_ventana();
                ventana.dispose();
            }
        });
        descargarPlanningButton.addActionListener(new ActionListener() {
            /**
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
               if (controlador.generar_pdf()== true){
                   JOptionPane.showMessageDialog(null,"Se ha generado tu PDF correctamente");
               } else {
                   JOptionPane.showMessageDialog(null,"Error en la generación de PDF");
               }

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
                System.exit(0);
            }
        });
        eliminar.addActionListener(new ActionListener() {
            /**
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                Cuadro_de_dialogo dialogo = new Cuadro_de_dialogo();
                if (dialogo.confirmacion_de_decision("¿Seguro que deseas eliminar tu perfil?")) {
                    controlador.eliminar_cliente(controlador.getCliente_sesion_actual().getIdCliente());
                    JOptionPane.showMessageDialog(null, "Tu perfil ha sido eliminado. Volverás a la pantalla de Inicio");
                    Inicio.lanzar_ventana();
                    ventana.dispose();
                } else {
                    System.out.println("No se ha eliminado el perfil");
                }

            }
        });
        cerrarSesiónButton.addActionListener(new ActionListener() {
            /**
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                Inicio.lanzar_ventana();
                ventana.dispose();
            }
        });


    }

    /**
     * Lanza la ventana de la interfaz gráfica e inicializa el constructor de la clase
     * inicia los listener de esta interfaz gráfica
     */
    public static void lanzar_ventana() {
        ventana.setContentPane(new Menu_principal().panel1);
        ventana.setBounds(0, 0, 1200, 800);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);

    }

    /**
     * Método perteneciente al patron Observer que informa al cliente del cambio en su experiencia.
     * @param nueva_experiencia
     */
    public static void mostrar_cambio_observer(String nueva_experiencia) {

        JOptionPane.showMessageDialog(null, controlador.getCliente_sesion_actual().getUsername() + ", tu nivel de experiencia ha cambiado a: " + nueva_experiencia);
    }


}
