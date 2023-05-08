package Model;

public abstract class Dieta {

    private int kcal_totales;
    private int proteinas;
    private int hidratos;
    private int grasas;
    private double Factor_Actividad_Poco = 1.2;
    private double Factor_Actividad_Ligero = 1.375;
    private double Factor_Actividad_Moderado = 1.550;
    private double Factor_Actividad_Fuerte = 1.725;
    private double Factor_Actividad_MuyFuerte = 1.9;




    /**
     * Metodo que genera un tipo de dieta en funcion de las caracteristicas del cliente
     * @param cliente ya registrado con determinadas caracteristicas y objetivos
     */
    public int Generar_Tasa_Metabolica_Basal(Perfil_cliente cliente){
cliente.getPeso();
cliente.getAltura();
cliente.getEdad;
return TMB;
    };

public int Calcular_Hidratos(int tasametabolica){


}

    public int Calcular_Proteina(int tasametabolica){

    }

    public int Calcular_Grasas(int tasametabolica){

    }

    public Mostrar_Datos (int hidrato, int prot, int fat) {
    //recoger los resultados de los metodos anteiores y mostrarlos

        System.out.println("Cliente deberia de consumir: x Gr de Hidratos de Carbono, X de Proteina y X de Grasas");
    }


}
