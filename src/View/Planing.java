package View;

import Controller.Controller;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.PublicKey;

public class Planing {

    static Controller controlador = new Controller();
    private static JFrame salida = new JFrame("Planing");


    private JPanel Header;
    private JPanel Body;
    private JButton descargarDietaButton;
    private JButton volverButton;

    public Planing() {

/*
        if (controlador.getCliente_sesion_actual().getTipo_dieta()=="Superhabit"){
            etiqueta_custom1 .setText( "Vas a ejercitarte al fallo, con series pesadas en todas las series y descansar entre 3-4 minutos entre serie");
        } else if (controlador.getCliente_sesion_actual().getTipo_dieta()=="Mantenimiento") {
            etiqueta_custom1.setText( "Todos los ejercicios se harán entre 15-20 repeticiones y un descanso de 1-2 minutos");
        } else if (controlador.getCliente_sesion_actual().getTipo_dieta()=="Déficit")  {
            etiqueta_custom1.setText( "En todos los ejercicios procura centrarte en el propio del músculo, 12-15 repeticiones y descanso máximo de 1 minuto");
        }
        else(controlador.getCliente_sesion_actual().getTipo_dieta()=="aire"{
            System.out.println("No has usado una de las opciones ofrecidas.");
            }
        }
*/

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

descargarDietaButton.addActionListener(new ActionListener() {
    /**
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "Planing Descargado");
        Menu_principal.lanzar_ventana();
        salida.dispose();

    }
});


    }

}
