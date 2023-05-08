package Controller;

import Model.Perfil_cliente;
import Model.Perfil_clienteDAO;
import View.Inicio;



public class Controller {

    static Perfil_cliente cliente;
    static Perfil_clienteDAO perfilClienteDAO = new Perfil_clienteDAO();

    public static void main(String[] args) {

        Inicio.lanzar_ventana();

    }

    /**
     * Metodo que conecta la peticion de la vista para crear un perfil y el model
     * @param nombre, apellido, peso... que ha introducido el cliente
     * @return el objeto generado con los datos introducidos
     */
    public Perfil_cliente enviar_perfil_creado(String nombre, String apellido, double peso, int altura, String dieta, String experiencia, String username, String password) {
        cliente = new Perfil_cliente(nombre, apellido, peso, altura, dieta, experiencia, username, password );
        perfilClienteDAO.generar_perfil(cliente);
        return cliente;
    }

    /**
     * Metodo que conecta la peticion de la vista de iniciar sesion con los datos contenidos en el model
     * @param user
     * @param password
     * @return la funcion del model que retorna el objeto del usuario que quiere iniciar sesión
     */
    public Perfil_cliente inicio_sesion(String user, String password){
        cliente = perfilClienteDAO.buscar_perfil(user, password);
        return perfilClienteDAO.buscar_perfil(user, password);
    }

    /**
     * Metodo que tras iniciar sesion o crear perfil nos permite acceder al cliente para llevar a cabo gestiones dentro de la aplicación
     * @return el cliente con toda su información
     */
    public Perfil_cliente getCliente_sesion_actual(){
        return cliente;
    }



}
