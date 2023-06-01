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
     *
     * @param cliente ya registrado con determinadas caracteristicas y objetivos
     */
    public int Generar_Tasa_Metabolica_Basal(Perfil_cliente cliente) {

        switch (cliente.getSexo()) {
            case mujer:
                TMB = (int) (655 + (9.6 * cliente.getPeso() + (1.8 * cliente.getAltura() - (4.7 * cliente.getEdad()))));
                break;
            case hombre:
                TMB = (int) (66 + (13.7 * cliente.getPeso() + (5 * cliente.getAltura() - (6.8 * cliente.getEdad()))));
                break;
            default:
                // Manejar el caso en el que el sexo no esté definido correctamente
                break;
        }
        return TMB;
    }
        /**
         * Metodo que calcula los hidratos de carbono a consumir en funcion de las caracteristicas del cliente
         * @param FactorActividad, peso ya registrado con determinadas caracteristicas y objetivos
         */
        public int Calcular_Hidratos(int tasa, double peso, String FactorActividad) {
            // Para calcular los hidratos de carbono, debemos tener en cuenta los requisitos del cliente,
            // dependiendo de si desea definición o una etapa de volumen
            tasa = TMB;
            int Gramos_Hidratos_Carbono = 0;
            double factorActividadFisica = 0;

            switch (FactorActividad) {
                case "Poco Ejercicio":
                    factorActividadFisica = Factor_Actividad_Poco;
                    break;
                case "Ejercicio Ligero":
                    factorActividadFisica = Factor_Actividad_Ligero;
                    break;
                case "Ejercicio Moderado":
                    factorActividadFisica = Factor_Actividad_Moderado;
                    break;
                case "Ejercicio Fuerte":
                    factorActividadFisica = Factor_Actividad_Fuerte;
                    break;
                case "Ejercicio Muy Fuerte":
                    factorActividadFisica = Factor_Actividad_MuyFuerte;
                    break;
                default:
                    System.out.println("No has introducido un campo válido");
                    break;
            }

            Gramos_Hidratos_Carbono = (int) (tasa * factorActividadFisica);
            return Gramos_Hidratos_Carbono;
        }

        /**
         * Metodo que calcula las proteinas a consumir en funcion de las caracteristicas del cliente
         * @param cliente, etapa ya registrado con determinadas caracteristicas y objetivos
         */
        public double Calcular_Proteina (Perfil_cliente cliente, String etapa){

            double proteina = 0;

            if (etapa.equals(volumen)) {
                proteina = cliente.getPeso() * 1.2;
                // En volumen, se considera 1.2 gramos de proteína por Kg de peso
            } else if (etapa.equals(definicion)) {
                proteina = cliente.getPeso() * 1.6;
                // En definición, se considera 1.6 gramos de proteína por Kg de peso
            } else if (etapa.equals(mantenimiento)) {
                proteina = cliente.getPeso() * 1.1;
                // En mantenimiento, se considera 1.1 gramos de proteína por Kg de peso
            }
            return proteina;
        }
        /**
         * Metodo que calcula las grasas a consumir en funcion de las caracteristicas del cliente
         * @param cliente, etapa ya registrado con determinadas caracteristicas y objetivos
         */
        public int Calcular_Grasas (Perfil_cliente cliente, String etapa){

            int grasas = 0;
            if (etapa.equals(volumen)) {
                grasas = (int) (cliente.getPeso() * 0.8);
                // En volumen, se toma 0.8 gramos de grasas por Kg de peso
            } else if (etapa.equals(definicion)) {
                grasas = (int) (cliente.getPeso() * 0.9);
                // En definición, se toma 0.9 gramos de grasas por Kg de peso
            } else if (etapa.equals(mantenimiento)) {
                grasas = (int) (cliente.getPeso() * 0.7);
                // En mantenimiento, se toma 0.7 gramos de grasas por Kg de peso
            }
            return grasas;

        }
    /**
     * Metodo que recoge todos los datos ofrecidos de los metodos anteriores y se los muestra al usuario
     * @param cliente, etapa, factorActividad para enviar un mensaje al usuario
     */
    public void Mostrar_Datos(Perfil_cliente cliente, String etapa, String factorActividad) {
        int tasa = Generar_Tasa_Metabolica_Basal(cliente);
        int hidrato = Calcular_Hidratos(tasa, cliente.getPeso(), factorActividad);
        double prot = Calcular_Proteina(cliente, etapa);
        int fat = Calcular_Grasas(cliente, etapa);

        System.out.println("El cliente debería consumir:");
        System.out.println(hidrato + " gramos de Hidratos de Carbono");
        System.out.println(prot + " gramos de Proteína");
        System.out.println(fat + " gramos de Grasas");
    }
}