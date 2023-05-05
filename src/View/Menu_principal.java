package View;

import javax.swing.*;

public class Menu_principal {
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

    /**
     * Constructor del entorno gráfico del menu principal
     * llama al metodo que tendrá los listener de esta interfaz gráfica
     */
    public Menu_principal() {

        activar_listeners();

    }

    public void lanzar_ventana(){

        JFrame ventana = new JFrame("Verdanks Fiteness");
        ventana.setContentPane(new Menu_principal().panel1);
        ventana.setBounds(0, 0, 1200, 800);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }

    private void activar_listeners() {


    }
}
