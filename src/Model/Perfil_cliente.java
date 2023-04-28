package Model;

public class Perfil_cliente implements Perfil {

    //Atributos del cliente (puede que tambien los usemos para la BD)
    private int idCliente;
    private String nombre;
    private String apellido;
    private double peso;
    private int altura;


    public Perfil_cliente() {} //constructor vacio

    public Perfil_cliente(int idCliente) { //constructor para buscar e identificar por id
        this.idCliente = idCliente;
    } //Constructor para identificar por ID


    //Constructor para introducir datos (nombre, peso...)


    //ToString para poder ver los objetos de la clase//


    //Getters y setters//


    ///////////

    //Metodos implementados de la interfaz Model.Perfil//
    /**
     * @param perfil
     * @return
     */
    @Override
    public Perfil_cliente generar_perfil(Perfil_cliente perfil) {
        return null;
    }

    /**
     * @param perfil
     * @return
     */
    @Override
    public Perfil_cliente actualizar_perfil(Perfil_cliente perfil) {
        return null;
    }

    /**
     * @param perfil
     * @return
     */
    @Override
    public boolean eliminar_perfil(Perfil_cliente perfil) {
        return false;
    }
    /////////////
}
