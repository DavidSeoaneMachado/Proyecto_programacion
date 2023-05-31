package Model;

import java.util.ArrayList;
import java.util.List;

public class Comidas {
    public static ArrayList<ArrayList<String>> Get_comidas() {

        //Arraylists con las comidas
        ArrayList<String> desayunos = new ArrayList<>(List.of("Claras de huevo", "Avena", "Tostada integral con jamon serrano y tomate", "Batido de platano, yugurt natural y avena", "2 piezas de fruta y zumo natural", "Tortias proteicas con arandanos", "Cereales con frutas", "Avena con proteina y frutas"));
        ArrayList<String> comidas = new ArrayList<>(List.of("Arroz con pollo", "Patatas con ternera", "Boniato con pavo", "Salmon con arroz", "Carne picada con pasta", "Ensalada de atun y pasta", "Ensalada de pechuga de pollo y pasta", "Pechuga de pollo o pavo con patatas cocidas"));
        ArrayList<String> snaks_merienda = new ArrayList<>(List.of("Tortitas de arroz con jamon serrano", "Tortitas con lomo embuchado", "Yogurt natural y platano", "1/2 piezas de fruta", "100 gramos de pechuga de pavo/pollo", "Tostada integral con jamon serrano y tomate", "Batido de platano, yugurt natural y avena", "Nueces con yogur y 1 pieza de fruta"));
        ArrayList<String> cenas = new ArrayList<>(List.of("Merluza con ensalada", "Marisco", "Calamares a la plancha", "Ensalada de atún", "Atún con pasta", "Patatas con ternera", "Boniato con pavo", "Merluza con patata cocida"));

        for (int i=0; i<3; i++){
            int aleatorio = (int)Math.floor(Math.random()*((desayunos.size()-1)-0+1)+0);
            desayunos.remove(aleatorio);
            comidas.remove(aleatorio);
            snaks_merienda.remove(aleatorio);
            cenas.remove(aleatorio);
        }

        //Añadimos las comidas elegidas a la matriz resultante
        ArrayList<ArrayList<String>> matriz_comidas = new ArrayList<>();
        matriz_comidas.add(desayunos);
        matriz_comidas.add(comidas);
        matriz_comidas.add(snaks_merienda);
        matriz_comidas.add(cenas);

        return matriz_comidas;

    }

}