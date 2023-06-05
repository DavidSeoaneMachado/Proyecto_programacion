package Model;

import Controller.Controller;
import java.util.ArrayList;
import java.util.List;

//Clase que gestiona las comidas de la dieta y los consejos sobre la misma para el cliente//
public class Comidas {
    static Controller controlador = new Controller();

    /**
     * Método que genera las comidas de la dieta entre las disponibles
     * @return un arraylist con las comidas para la dieta
     */
    public static ArrayList<ArrayList<String>> Get_comidas() {

        //Arraylists con las comidas
        ArrayList<String> desayunos = new ArrayList<>(List.of("Claras de huevo", "Avena", "Tostada integral con jamon serrano y tomate", "Batido de platano, yugurt natural y avena", "2 piezas de fruta y zumo natural", "Tortias proteicas con arandanos", "Cereales con frutas", "Avena con proteina y frutas"));
        ArrayList<String> comidas = new ArrayList<>(List.of("Arroz con pollo", "Patatas con ternera", "Boniato con pavo", "Salmon con arroz", "Carne picada con pasta", "Ensalada de atun y pasta", "Ensalada de pechuga de pollo y pasta", "Pechuga de pollo o pavo con patatas cocidas"));
        ArrayList<String> snaks_merienda = new ArrayList<>(List.of("Tortitas de arroz con jamon serrano", "Tortitas con lomo embuchado", "Yogurt natural y platano", "1/2 piezas de fruta", "100 gramos de pechuga de pavo/pollo", "Tostada integral con jamon serrano y tomate", "Batido de platano, yugurt natural y avena", "Nueces con yogur y 1 pieza de fruta"));
        ArrayList<String> cenas = new ArrayList<>(List.of("Merluza con ensalada", "Marisco", "Calamares a la plancha", "Ensalada de atún", "Atún con pasta", "Patatas con ternera", "Boniato con pavo", "Merluza con patata cocida"));

        //Bucle para eliminar de manera aleatoria ciertas comidas y poder generar distintos menus cada ocasión
        for (int i = 0; i < 3; i++) {
            int aleatorio = (int) Math.floor(Math.random() * ((desayunos.size() - 1) - 0 + 1) + 0);
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

    /**
     * Método que genera consejos para la dieta según las características y objetivos del cliente
     * @return arraylist con los consejos
     */
    public static ArrayList<String> Get_tips_dieta() {

        ArrayList<String> tips = new ArrayList<>();

        if (controlador.getCliente_sesion_actual().getTipo_dieta().equals("Mantenimiento")) {
            String tip1 = "-En el desayuno tienes mas libertad. Gestionalo como mejor veas dependiendo de la hora y sin pasarse";
            tips.add(tip1);
            String tip2 = "-En el almuerzo aproximadamente 200-300g de proteína y entre 100-150 de los hidratos acompañantes.";
            tips.add(tip2);
            String tip3 = "-En la merienda lo estipulado. Si tienes mas hambre puedes añadir un par de tortitas de arroz o otra fruta.";
            tips.add(tip3);
            String tip4 = "-En la cena aproximadamente 200-300g de proteína y sobre 100 de los hidratos acompañantes.";
            tips.add(tip4);
        } else if (controlador.getCliente_sesion_actual().getTipo_dieta().equals("Deficit calórico (perder peso)")) {
            String tip1 = "-En el desayuno lo estipulado. Gestionalo como mejor veas y añade extras como tortitas de arroz si tienes hambre";
            tips.add(tip1);
            String tip2 = "-En el almuerzo aproximadamente 200g de proteína y 100g de los hidratos acompañantes.";
            tips.add(tip2);
            String tip3 = "-En la merienda lo estipulado. Si tienes mas hambre puedes añadir un par de tortitas de arroz o otra fruta.";
            tips.add(tip3);
            String tip4 = "-En la cena aproximadamente 200g de proteína y sobre 100 (si puedes algo menos) de los hidratos acompañantes.";
            tips.add(tip4);
        } else if (controlador.getCliente_sesion_actual().getTipo_dieta().equals("Superhabit calórico (ganar peso)")) {
            String tip1 = "-En el desayuno tienes mas libertad para cargar. Gestionalo como mejor veas dependiendo de la hora y teniendo en cuanta que el resto de comidas también va a ser potentes.";
            tips.add(tip1);
            String tip2 = "-En el almuerzo aproximadamente 300-400g de proteína y 200g de los hidratos acompañantes.";
            tips.add(tip2);
            String tip3 = "-En la merienda lo estipulado. Si es antes o inmediatamente después del entrenamiento puedes cargar más.";
            tips.add(tip3);
            String tip4 = "-En la cena aproximadamente 300-350g de proteína y sobre 150-200 (según como te veas) de los hidratos acompañantes.";
            tips.add(tip4);
        }

        return tips;
    }

}