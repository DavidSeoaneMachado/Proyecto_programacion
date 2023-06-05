package View;

import Controller.Controller;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

//Clase que gestiona la vista del planning del cliente compuesto por dieta y rutina de ejercicios//
public class Planning {

    static Controller controlador = new Controller();
    private static JFrame ventana = new JFrame("Planificación");
    private JPanel Header;
    private JLabel etiqueta_custom;
    private JPanel Body;
    private JPanel Footer;
    private JButton volver;
    private JPanel panel1;
    private JLabel etiqueta;
    private JPanel Body2;
    private JLabel custom_comida1;
    private JLabel custom_comida2;
    private JLabel custom_comida3;
    private JLabel custom_comida4;
    private JLabel custom_rutina2;
    private JLabel custom_rutina3;
    private JLabel custom_rutina4;
    private JLabel custom_rutina1;
    private JTable tabla;
    private JTable tabla2;

    public JTable getTabla2() {
        return tabla2;
    }
    public JTable getTabla() {
        return tabla;
    }

    public Planning(){

        etiqueta_custom.setText("Esta es tu planificación actual de dieta y ejercicios, " + controlador.getCliente_sesion_actual().getUsername());
        ArrayList<ArrayList<String>> matriz_dieta =  controlador.leer_ficheros("src/recursos/Fichero_dieta.json");
        ArrayList<ArrayList<String>> matriz_rutina = controlador.leer_ficheros("src/recursos/Fichero_rutina.json");
        ArrayList<String> tips_dieta = controlador.pasar_tips_dieta();
        ArrayList<String> tips_rutina = controlador.pasar_tips_rutina();

        //Personalización de los mensajes de la interfaz según las características del cliente//
        custom_comida1.setText(tips_dieta.get(0));
        custom_comida2.setText(tips_dieta.get(1));
        custom_comida3.setText(tips_dieta.get(2));
        custom_comida4.setText(tips_dieta.get(3));

        custom_rutina1.setText(tips_rutina.get(0));
        custom_rutina2.setText(tips_rutina.get(1));
        custom_rutina3.setText(tips_rutina.get(2));
        custom_rutina4.setText(tips_rutina.get(3));


        //Creación de la tabla Dieta//
        String[] columnNames = {"Desayuno",
                "Comida",
                "Snack/Merienda",
                "Cena"};

        Object[][] comidas = {
                {matriz_dieta.get(0).get(0), matriz_dieta.get(1).get(0), matriz_dieta.get(2).get(0), matriz_dieta.get(3).get(0)},
                {matriz_dieta.get(0).get(1), matriz_dieta.get(1).get(1), matriz_dieta.get(2).get(1), matriz_dieta.get(3).get(1)},
                {matriz_dieta.get(0).get(2), matriz_dieta.get(1).get(2), matriz_dieta.get(2).get(2), matriz_dieta.get(3).get(2)},
                {matriz_dieta.get(0).get(3), matriz_dieta.get(1).get(3), matriz_dieta.get(2).get(3), matriz_dieta.get(3).get(3)},
                {matriz_dieta.get(0).get(4), matriz_dieta.get(1).get(4), matriz_dieta.get(2).get(4), matriz_dieta.get(3).get(4)}

        };

        //Información de la tabla dieta//
        tabla = new JTable(comidas, columnNames);
        JTableHeader cabecera = tabla.getTableHeader();
        cabecera.setPreferredSize(new Dimension(1200,30));

        Body.setLayout(new BorderLayout());
        Body.add(cabecera, BorderLayout.NORTH);
        Body.add(tabla, BorderLayout.CENTER);

        //Centrar los elementos de las celdas//
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < tabla.getColumnCount(); i++) {
            tabla.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        //Creación de la tabla Rutina//
        String[] columnNames2 = {"Día de pecho",
                "Día de espalda",
                "Día de pierna",
                "Día de brazo"};

        Object[][] ejercicios = {
                {matriz_rutina.get(0).get(0), matriz_rutina.get(1).get(0), matriz_rutina.get(2).get(0), matriz_rutina.get(3).get(0)},
                {matriz_rutina.get(0).get(1), matriz_rutina.get(1).get(1), matriz_rutina.get(2).get(1), matriz_rutina.get(3).get(1)},
                {matriz_rutina.get(0).get(2), matriz_rutina.get(1).get(2), matriz_rutina.get(2).get(2), matriz_rutina.get(3).get(2)},
                {matriz_rutina.get(0).get(3), matriz_rutina.get(1).get(3), matriz_rutina.get(2).get(3), matriz_rutina.get(3).get(3)}

        };

        //Información de la tabla rutina//
        tabla2 = new JTable(ejercicios, columnNames2);
        JTableHeader cabecera2 = tabla2.getTableHeader();
        cabecera2.setPreferredSize(new Dimension(1200,30));

        Body2.setLayout(new BorderLayout());
        Body2.add(cabecera2, BorderLayout.NORTH);
        Body2.add(tabla2, BorderLayout.CENTER);

        //Centrar los elementos de las celdas//
        DefaultTableCellRenderer centerRenderer2 = new DefaultTableCellRenderer();
        centerRenderer2.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < tabla2.getColumnCount(); i++) {
            tabla2.getColumnModel().getColumn(i).setCellRenderer(centerRenderer2);
        }

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

    /**
     * Lanza la ventana de la interfaz gráfica e inicializa el constructor de la clase que inicializa los listener de esta interfaz gráfica
     */
    public static void lanzar_ventana(){
        ventana.setContentPane(new Planning().panel1);
        ventana.setBounds(0, 0, 1200, 800);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }
}
