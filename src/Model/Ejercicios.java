package Model;

import java.util.Random;

public class Ejercicios {
    //creacion de los arrays donde se van a almacenar los ejercicios

    String[] Pecho = new String[]{"Press con Mancuernas", "Press Plano con Barra", "Cruces en Polea Baja", "Press Declinado", "Cruces en Polea Alta"};
    String[] Espalda = new String[]{"Jalon al pecho", "Remo en maquina", "Remo con mancuernas", "Remo en Punta", "Remo en Polea Baja"};
    String[] Pierna = new String[]{"Sentadilla", "Sentadilla Bulgara", "Prensa", "Femoral de Pie", "Femoral Tumbado"};
    String[] Brazo = new String[]{"Curl Biceps Mancuernas", "Curl en Maquina", "Press Frances en Polea", " Flexiones Apoyo Cerrado", "Press con Barra"};

    public void SeleccionarEjercicios() {
        Random EjercicioRandom = new Random();
        int primerejercicio = EjercicioRandom.nextInt(Pecho.length);
        int segundoejercicio = EjercicioRandom.nextInt(Espalda.length);
        int tercerejercicio = EjercicioRandom.nextInt(Pierna.length);

        String ejercicio1 = Pecho[primerejercicio];
        String ejercicio2 = Pecho[segundoejercicio];
        String ejercicio3 = Pecho[tercerejercicio];

        System.out.println("Primer ejercicio  " + ejercicio1);
        System.out.println("Primer ejercicio  " + ejercicio2);
        System.out.println("Primer ejercicio  " + ejercicio3);


    }
}
