package View;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.security.PublicKey;

public class Planing {
    private JPanel Header;
    private JPanel Body;
    private JButton descargarDietaButton;
    private JButton volverButton;

    public Planing() {
/*


        if (controlador.getCliente_sesion_actual().getTipo_dieta()=="Superhabit"){
            etiqueta_custom1 .setText( "Vas a ir al fallo en todas las series y descansar entre 3-4 minutos entre serie");
        } else if (controlador.getCliente_sesion_actual().getTipo_dieta()=="Superhabit") {
            etiqueta_custom1.setText( "Vas a ir casi al fallo en todas las series y descansar entre 3-4 minutos entre serie");
        } else if (){

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







    }

}
