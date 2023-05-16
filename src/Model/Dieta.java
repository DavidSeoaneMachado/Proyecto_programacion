package Model;

public abstract class Dieta {

    private double kcal_totales;
    private double proteinas;
    private int hidratos;
    private int grasas;
    private int TMB;
    private double Factor_Actividad_Poco = 1.2;
    private double Factor_Actividad_Ligero = 1.375;
    private double Factor_Actividad_Moderado = 1.550;
    private double Factor_Actividad_Fuerte = 1.725;
    private double Factor_Actividad_MuyFuerte = 1.9;
    private String volumen;
    private String definicion;
    private String mantenimiento;


    /**
     * Metodo que genera un tipo de dieta en funcion de las caracteristicas del cliente
     * @param cliente ya registrado con determinadas caracteristicas y objetivos
     */
    public int Generar_Tasa_Metabolica_Basal(Perfil_cliente cliente){

        int mujer=1;
        int hombre=2;
        int variable = 0;


switch (variable){
    if (cliente.sexo=mujer){
        TMB=655+(9.6* cliente.getPeso()+(1.8* cliente.getAltura()-(4.7*cliente.getEdad())));
    }
    else (cliente.sexo=hombre){
        TMB=66+(13.7* cliente.getPeso()+(5* cliente.getAltura()-(6.8*cliente.getEdad())));
    }
}
return TMB;
    };

public int Calcular_Hidratos(double peso,double altura, int edad, String FactorActividad){
    //para calcular los hidratos de carbono, tenemos que tener en cuenta los requisitos del cliente ya que dependera si quire una definicion o encontrarse en una etapa de volumen

double Gramos_Hidratos_Carbono;
double factorActividadFisica=0;

switch ( factorActividadFisica){
    case "Poco Ejercicio":
        factorActividadFisica=Factor_Actividad_Poco;
        break;
    case "Ejercicio Ligero":
        factorActividadFisica=Factor_Actividad_Ligero;
    case "Ejercicio Moderado":
        factorActividadFisica=Factor_Actividad_Moderado;
    case "Ejercicio Fuerte":
        factorActividadFisica=Factor_Actividad_Fuerte;
    case "Ejercicio Muy Fuerte":
        factorActividadFisica=Factor_Actividad_MuyFuerte;
        break;
    default:
        System.out.println("No has introducido un campo valido");
}

    return Gramos_Hidratos_Carbono;
}


    public double Calcular_Proteina(Perfil_cliente cliente,String etapa){
   if (etapa == volumen){
       return cliente.getPeso()*1.2; //en volumen consideramos 1.2 gramos de proteina por Kg de peso

   } else if (etapa==definicion) {
       return cliente.getPeso()*1.6;//en volumen consideramos 1.6 gramos de proteina por Kg de peso
   }
   else if (etapa==mantenimiento){
       return cliente.getPeso()*1.1; //en volumen consideramos 1.2 gramos de proteina por Kg de peso
   }


    public int Calcular_Grasas(int tasametabolica){

    }

    public Mostrar_Datos (int hidrato, int prot, int fat) {
    //recoger los resultados de los metodos anteiores y mostrarlos

        System.out.println("Cliente deberia de consumir: x Gr de Hidratos de Carbono, X de Proteina y X de Grasas");
    }


}
