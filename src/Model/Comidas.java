package Model;

import java.util.Random;

public class Comidas {
    //Arrays con las comidas

    String[] desayuno = new String[]{"Claras de huevo", "Avena", "Tostada integral con jamon serrano y tomate"};
    String[] comida = new String[]{"Arroz con pollo", "Patatas con ternera", "Boniato con pavo"};
    String[] cena = new String[]{"Merluza con ensalada", "Marisco", "Calamares a la plancha"};

    public void Escoger_Comida() {
        //Se recoge de forma aleatoria una comida de cada lista de comidas

        Random ale = new Random();
        int desayunoAle = ale.nextInt(desayuno.length);
        int comidaAle = ale.nextInt(comida.length);
        int cenaAle = ale.nextInt(cena.length);

        String primeracomida = desayuno[desayunoAle];
        String segundacomida = comida[comidaAle];
        String terceracomida = cena[cenaAle];

        System.out.println("Primera comida del dia: " + primeracomida);
        System.out.println("Primera comida del dia: " + segundacomida);
        System.out.println("Primera comida del dia: " + terceracomida);
    }

    public static void main(String[] args) {
        Comidas comidas = new Comidas();
        comidas.Escoger_Comida();
    }
}
