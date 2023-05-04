package View;

import javax.swing.*;

public class Menu_principal {
    private JPanel panel1;

    private JPanel header;
    private JPanel body;
    private JPanel footer;
    private JButton button1;

    public void sacarventana(){

        JFrame frame = new JFrame();
        frame.setContentPane(panel1);
        frame.setBounds(0, 0, 1200, 800);
        frame.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
