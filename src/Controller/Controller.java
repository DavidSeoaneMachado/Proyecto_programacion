package Controller;

import Model.*;
import View.Inicio;
import View.Planning;

import java.util.ArrayList;


public class Controller {
    static Perfil_cliente cliente;
    static Perfil_clienteDAO perfilClienteDAO = new Perfil_clienteDAO();
    static Gestion_de_ficheros gestionDeFicheros = new Gestion_de_ficheros();
    static Observer_Experiencia observerExperiencia = new Observer_Experiencia();

    public static void main(String[] args) {

        Inicio.lanzar_ventana();
    }

    /**
     * Metodo que conecta la peticion de la vista para crear un perfil y el model
     *
     * @param nombre, apellido, peso... que ha introducido el cliente
     * @return el objeto generado con los datos introducidos
     */
    public Perfil_cliente enviar_perfil_creado(String nombre, String apellido, double peso, int altura, int edad, String sexo, String dieta, String experiencia, String username, String password) {
        cliente = new Perfil_cliente(nombre, apellido, peso, altura, edad, sexo, dieta, experiencia, username, password);
        perfilClienteDAO.generar_perfil(cliente);
        return cliente;
    }

    /**
     * Metodo que conecta la peticion de la vista de iniciar sesion con los datos contenidos en el model
     *
     * @param user
     * @param password
     * @return la funcion del model que retorna el objeto del usuario que quiere iniciar sesión
     */
    public Perfil_cliente inicio_sesion(String user, String password) {
        cliente = perfilClienteDAO.buscar_perfil(user, password);
        return perfilClienteDAO.buscar_perfil(user, password);
    }

    /**
     * Metodo que tras iniciar sesion o crear perfil nos permite acceder al cliente para llevar a cabo gestiones dentro de la aplicación
     *
     * @return el cliente con toda su información
     */
    public Perfil_cliente getCliente_sesion_actual() {
        return cliente;
    }

    /**
     * Metodo que conecta la peticion de la vista de actualizar datos del cliente con el model
     *
     * @return el cliente con toda su información
     */
    public Perfil_cliente modificar_cliente(int id_cliente, String nombre, String apellido, double peso, int altura, int edad, String sexo, String dieta, String experiencia, String username, String password) {
        Perfil_cliente auxiliar = new Perfil_cliente(id_cliente, nombre, apellido, peso, altura, edad, sexo, dieta, experiencia, username, password);
        cliente = auxiliar;
        return perfilClienteDAO.actualizar_perfil(id_cliente, nombre, apellido, peso, altura, edad, sexo, dieta, experiencia, username, password);
    }

    /**
     * Metodo que conecta la peticion de la vista de eliminar un cliente de la BD
     * @param id
     * @return el cliente con toda su información
     */
    public boolean eliminar_cliente(int id) {
        return perfilClienteDAO.eliminar_perfil(id);
    }

    /**
     * Metodo que conecta la peticion de la vista de buscar un username de la BD
     *
     * @param username
     * @return un booleano para confirmar si existe o no el username
     */
    public boolean comprobar_user_c(String username) {
        return perfilClienteDAO.comprobar_user(username);
    }

    /**
     * Metodo que comprueba si el cliente ha realizado cambios en la opción Editar Perfil comparando dos objetos auxiliares
     * @param perfil1
     * @param perfil2
     * @return un booleano que informa de si ha habido cambios en el perfil o no
     */
    public boolean cambios_perfil(Perfil_cliente perfil1, Perfil_cliente perfil2) {
        if (perfil1.getNombre().equals(perfil2.getNombre()) &&
                perfil1.getApellido().equals(perfil2.getApellido()) &&
                perfil1.getPeso() == perfil2.getPeso() &&
                perfil1.getAltura() == perfil2.getAltura() &&
                perfil1.getEdad() == perfil2.getEdad() &&
                perfil1.getSexo().equals(perfil2.getSexo()) &&
                perfil1.getTipo_dieta().equals(perfil2.getTipo_dieta()) &&
                perfil1.getExperiencia().equals(perfil2.getExperiencia()) &&
                perfil1.getUsername().equals(perfil2.getUsername()) &&
                perfil1.getPassword().equals(perfil2.getPassword())) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Metodo que conecta la peticion del cliente de imprimir un PDF con su rutina y dieta personal
     * @return un booleano que refleja si ha habido errores
     */
    public boolean generar_pdf(){
        Planning planning = new Planning();
        Generador_PDF generador = new Generador_PDF();
        return generador.generar_pdf(planning.getTabla(), planning.getTabla2());
    }

    /**
     * Método que busca en el fichero JSON y sustituye la dieta o rutina existente (o no) por la nueva
     * @param arraylist_elementos
     * @param nombre_fichero
     */
    public void escribir_ficheros(ArrayList<ArrayList<String>> arraylist_elementos, String nombre_fichero){
        gestionDeFicheros.rellenar_ficheros(arraylist_elementos,nombre_fichero);
    };

    /**
     * Método que devuelve una matriz con la dieta o rutina de ejercicios del cliente que ha iniciado sesión
     * @param nombreArchivo
     * @return
     */
    public ArrayList<ArrayList<String>> leer_ficheros(String nombreArchivo){
        return gestionDeFicheros.lectura_ficheros(nombreArchivo);
    }

    /**
     * Método que es llamado después de que en Inicio_Sesion se lance la ventana del Menu_Principal e inicia el proceso del patron Observer para cambiar el nivel de experinecia del cliente
     * En este caso se envia la variable a la que va a cambiar la experiencia de manera "forzada", ya que no hay manera de determinar cuanto tiempo lleva el cliente usando la app.
     * Este cambio se ejecutará siempre cuando se inicie sesión por parte de un usuario.
     */
    public void cambio_observer(){

        //añadimos el observer de los cambios//
        perfilClienteDAO.addObserver(observerExperiencia);
        String experiencia_nueva = "Veterano del Gym";
        //lamamos al metodo que comienza el proceso y realiza el cambio de la BD//
        perfilClienteDAO.metodo_cambios_observer(experiencia_nueva);

    }

    /**
     *
     */
    public ArrayList<String> pasar_tips_rutina(){
        return Ejercicios.Get_tips_rutina();
    }

    /**
     *
     */
    public ArrayList<String> pasar_tips_dieta(){
        return Comidas.Get_tips_dieta();
    }

}

