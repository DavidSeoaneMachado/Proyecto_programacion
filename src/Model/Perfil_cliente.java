package Model;

public class Perfil_cliente implements Perfil {

    //Atributos del cliente//
    private int idCliente;
    private String nombre;
    private String apellido;
    private double peso;
    private int altura;
    private String tipo_dieta;
    private String experiencia;



    public Perfil_cliente() {} //constructor vacio

    public Perfil_cliente(int idCliente) { //constructor para buscar e identificar por id
        this.idCliente = idCliente;
    } //Constructor para identificar por ID

    //Constructor para introducir datos sin el id (nombre, peso...)
    public Perfil_cliente(String nombre, String apellido, double peso, int altura, String tipo_dieta, String experiencia) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.peso = peso;
        this.altura = altura;
        this.tipo_dieta = tipo_dieta;
        this.experiencia = experiencia;
    }

    //ToString para poder ver los objetos de la clase//


    //Getters y setters//
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public String getTipo_dieta() {
        return tipo_dieta;
    }

    public void setTipo_dieta(String tipo_dieta) {
        this.tipo_dieta = tipo_dieta;
    }

    public String getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }
    //Fin de los getters/setters //

    //Metodos implementados de la interfaz Model.Perfil//
    /**
     * Genera un nuevo perfil de cliente
     * @param perfil
     * @return
     */
    @Override
    public Perfil_cliente generar_perfil(Perfil_cliente perfil) {

        //POR IMPLEMENTAR//
        return null;
    }

    /**
     * Actualiza/modifica los datos de un perfil
     * @param perfil
     * @return
     */
    @Override
    public Perfil_cliente actualizar_perfil(Perfil_cliente perfil) {

        //POR IMPLEMENTAR//
        return null;
    }

    /**
     * Elimina un perfil de cliente
     * @param perfil
     * @return
     */
    @Override
    public boolean eliminar_perfil(Perfil_cliente perfil) {

        //POR IMPLEMENTAR//
        return false;
    }
    //Fin de los metodos de la interfaz//
}
