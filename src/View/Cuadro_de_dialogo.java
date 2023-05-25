package View;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cuadro_de_dialogo extends JDialog {

    private boolean confirmado;

    /**
     * Lanza un cuadro de dialogo para confirmar o no una decision del usuario
     * @param mensaje
     * @return un booleano con la decision del usuario
     */
    public boolean confirmacion_de_decision(String mensaje) {
        setModal(true);
        setTitle("Confirmación");
        setSize(300, 150);
        setLocationRelativeTo(null);

        JLabel label = new JLabel(mensaje);
        label.setHorizontalAlignment(SwingConstants.CENTER);

        JButton yesButton = new JButton("Sí");
        JButton noButton = new JButton("No");

        yesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confirmado = true;
                dispose();
            }
        });

        noButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confirmado = false;
                dispose();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(yesButton);
        buttonPanel.add(noButton);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(label, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        getContentPane().add(mainPanel);

        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setVisible(true);

        return confirmado;
    }

    /**
     * Lanza un cuadro de dialogo para confirmar o no una decision del usuario
     * @param mensaje
     * @return un booleano con la decision del usuario
     */
    public boolean confirmacion_de_decision_2(String mensaje) {
        setModal(true);
        setTitle("Confirmación");
        setSize(1200, 150);
        setLocationRelativeTo(null);

        JLabel label = new JLabel(mensaje);
        label.setHorizontalAlignment(SwingConstants.CENTER);

        JButton yesButton = new JButton("Sí");
        JButton noButton = new JButton("No");

        yesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confirmado = true;
                dispose();
            }
        });

        noButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confirmado = false;
                dispose();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(yesButton);
        buttonPanel.add(noButton);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(label, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        getContentPane().add(mainPanel);

        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setVisible(true);

        return confirmado;
    }

}
