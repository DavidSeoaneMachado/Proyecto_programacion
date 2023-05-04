package Model;

public class Perfil_cliente {

    //Atributos del cliente//
    private int idCliente;
    private String username;
    private String password;
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

    public Perfil_cliente(String username, String password, String nombre, String apellido, double peso,
                          int altura, String tipo_dieta, String experiencia) {
        this.username = username;
        this.password = password;
        this.nombre = nombre;
        this.apellido = apellido;
        this.peso = peso;
        this.altura = altura;
        this.tipo_dieta = tipo_dieta;
        this.experiencia = experiencia;
    }


    //ToString para poder ver los objetos de la clase//
    @Override
    public String toString() {
        return "Perfil_cliente{" +
                "idCliente=" + idCliente +
                ", username='" + username + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", peso=" + peso +
                ", altura=" + altura +
                ", tipo_dieta='" + tipo_dieta + '\'' +
                ", experiencia='" + experiencia + '\'' +
                '}';
    }

    //Getters y setters//
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
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


}
