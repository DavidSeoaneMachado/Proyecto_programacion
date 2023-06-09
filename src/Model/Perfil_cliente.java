package Model;

//Clase que gestiona los objetos cliente y sus atributos//
public class Perfil_cliente {

    //Atributos del cliente//
    private int idCliente;
    private String nombre;
    private String apellido;
    private double peso;
    private int altura;
    private int edad;
    private String sexo;
    private String tipo_dieta;
    private String experiencia;
    private String username;
    private String password;


    public Perfil_cliente() {} //constructor vacio

    public Perfil_cliente(int idCliente) { //constructor para buscar e identificar por id
        this.idCliente = idCliente;
    } //Constructor para identificar por ID

    //Constructor para introducir datos sin el id (nombre, peso...)
    public Perfil_cliente(String nombre, String apellido, double peso, int altura, int edad, String sexo, String tipo_dieta, String experiencia, String username, String password) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.peso = peso;
        this.altura = altura;
        this.edad = edad;
        this.sexo = sexo;
        this.tipo_dieta = tipo_dieta;
        this.experiencia = experiencia;
        this.username = username;
        this.password = password;
    }

    //Constructor para el objeto auxiliar del Metodo de modificar perfil//
    public Perfil_cliente(int idCliente, String nombre, String apellido, double peso, int altura, int edad, String sexo, String tipo_dieta, String experiencia, String username, String password) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.peso = peso;
        this.altura = altura;
        this.edad = edad;
        this.sexo = sexo;
        this.tipo_dieta = tipo_dieta;
        this.experiencia = experiencia;
        this.username = username;
        this.password = password;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    //Fin de los getters/setters //


}
