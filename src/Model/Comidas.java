package Model;

import java.util.Random;

public class Comidas {

    //Arrays con las comidas
    String [] desayuno =new String[]{"Claras de huevo","Avena","Tostada integral con jamon serrano y tomate", "Batido de platano, yugurt natural y avena"};
    String [] comida =new String[]{"Arroz con pollo","Patatas con ternera","Boniato con pavo","Salmon con arroz", "Carne picada con pasta"};
    String [] snak_merienda = new String[]{"Tortitas de arroz con jamon serrano", "Tortitas con lomo embuchado", "Yogurt natural y platano", "1/2 piezas de fruta", "100 gramos de pechuga de pavo/pollo"};
    String [] cena =new String[]{"Merluza con ensalada","Marisco","Calamares a la plancha", "Ensalada de atún", "Atún con pasta"};


    public void Escoger_Comida(){
        Random ale = new Random();
        int desayunoAle = ale.nextInt(desayuno.length);
        int comidaAle =ale.nextInt(comida.length);
        int cenaAle=ale.nextInt(cena.length);

        String primeracomida=desayuno[desayunoAle];
        String segundacomida=comida[comidaAle];
        String terceracomida=cena[cenaAle];

    }
}

