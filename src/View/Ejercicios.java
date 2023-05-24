package View;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ejercicios {
    private JPanel Header;
    private JLabel info_label;
    private JLabel info_label_2;
    private JPanel Body;
    private JButton crearDietaButton;
    private JButton volverButton;

    public Ejercicios() {

        //Informacion de la tabla//
        String[] columnNames = {"Desayuno",
                "Comida",
                "Cena",
                "Cantidad aproximada en gramos"};

        Object[][] comidas = {
                {"1º", "Madrí",
                        "4", 2},
                {"2º", "Barsalona",
                        "3", 3},
                {"3º", "Beti",
                        "2", 3},
                {"4º", "Selta",
                        "1", 3},
                {"2º", "Barsalona",
                        "3", 3},
                {"2º", "Barsalona",
                        "3", 3}

        };
        //Informacion de la tabla//

        JTable tabla = new JTable(comidas, columnNames);
        JTableHeader cabecera = tabla.getTableHeader();
        cabecera.setPreferredSize(new Dimension(1200,50));

        Body.setLayout(new BorderLayout());
        Body.add(cabecera, BorderLayout.NORTH);
        Body.add(tabla, BorderLayout.CENTER);

        //Centrar los elementos de las celdas//
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < tabla.getColumnCount(); i++) {
            tabla.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        info_label.setText("Esta es tu dieta de "+ controlador.getCliente_sesion_actual().getTipo_dieta() + " para los proximos 1/2 meses.");

        volverButton.addActionListener(new ActionListener() {
            /**
             * @param e majenador del boton para volver a la ventana anterior
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                Inicio.lanzar_ventana();
                ventana.dispose();
            }
        });
        crearDietaButton.addActionListener(new ActionListener() {
            /**
             * @param e majenador que saca un mensaje por ventana y lo muetra al usuario
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Se ha generado una dieta según tus requisitos");
            }
        });



    }


    /**
     * Lanza la ventana de la interfaz gráfica e inicializa el constructor de la clase
     * inicia los listener de esta interfaz gráfica
     */
    public static void lanzar_ventana(){

        ventana.setContentPane(new Dieta().panel1);
        ventana.setBounds(0, 0, 1200, 800);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);


    }




}
