package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Inicio {

    public static void generar_ventana_inicio(){

        //Creamos el la ventana//
        JFrame ventana = new JFrame();
        ventana.setBounds(0, 0, 1200, 800);
        ventana.setTitle("Fitness | Inicio");
        ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Creamos el layout y se los asignamos a la ventana//
        GridLayout grid = new GridLayout(3, 0);
        grid.setHgap(30);
        grid.setVgap(10);
        ventana.setLayout(grid);

        //Primer elemento de la venatana Inicio//
        JPanel header = new JPanel();
        header.setLayout(new GridLayout(5, 0));
        //Etiqueta superior//
        JLabel etiqueta = new JLabel();
        etiqueta.setText("...Fitness");
        JLabel etiqueta2 = new JLabel();
        etiqueta2.setText("¿Quieres alcanzar tu mejor estado fisico y crear habitos saludables? ...Fitness es lo que estabas buscando.");
        header.add(etiqueta);
        header.add(etiqueta2);
        etiqueta.setHorizontalAlignment(JLabel.CENTER);
        etiqueta2.setHorizontalAlignment(JLabel.CENTER);

        //Segundo elemento de la venatana Inicio//
        JPanel body = new JPanel();
        body.setLayout(new FlowLayout());
        //Boton 1//
        JButton boton = new JButton();
        boton.setLabel("Crear perfil/cuenta");
        boton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        //Boton 2//
        JButton boton2 = new JButton();
        boton2.setLabel("Iniciar sesión");
        boton2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        body.add(boton);
        body.add(boton2);

        //Tercer elemento de la ventana Inicio//
        JPanel footer = new JPanel();
        footer.setLayout(new FlowLayout());
        //Boton//
        JButton boton_salir = new JButton();
        boton_salir.setLabel("Salir");
        boton_salir.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        //Funcionalidad: salir//
        boton_salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        footer.add(boton_salir);



        //Añadimos los elementos a la ventana Inicio//
        ventana.add(header);
        ventana.add(body);
        ventana.add(footer);

        //Hacemos visble la ventana//
        ventana.setVisible(true);
    }

}
