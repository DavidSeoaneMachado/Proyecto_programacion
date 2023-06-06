package Model;

import Controller.Controller;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Observable;

//Clase que gestiona los metodos de la interfaz Perfil y las sentencias y consultas con la BD//
public class Perfil_clienteDAO extends Observable implements Perfil {

    static Controller controlador = new Controller();
    private static final String SQL_SELECT = "SELECT id_cliente, nombre, apellido, peso, altura, edad, sexo, tipo_dieta, experiencia, username, password FROM clientes where username = ? and password = ?";
    private static final String SQL_INSERT = "INSERT INTO clientes(nombre, apellido, peso, altura, edad,sexo, tipo_dieta, experiencia, username, password) VALUES(?, ?, ?, ?,?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE clientes SET nombre=?, apellido=?, peso=?, altura=?, edad=?, sexo=?, tipo_dieta=?, experiencia=?, username=?, password=? WHERE id_cliente = ?";
    private static final String SQL_DELETE = "DELETE FROM clientes WHERE id_cliente=?";

    //Metodos implementados de la interfaz Perfil//

    /**
     * Busca un perfil dentro de la base de datos para comprobar si existe y te devuelve un objeto con sus caracteristicas
     *
     * @param user y contraseña del inicio de sesión
     * @return
     */
    @Override
    public Perfil_cliente buscar_perfil(String user, String contraseña) {

        Perfil_cliente cliente_sesion = new Perfil_cliente();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = Conexion_BD.GetConexion();
            stmt = conn.prepareStatement(SQL_SELECT);
            stmt.setString(1, user);
            stmt.setString(2, contraseña);
            rs = stmt.executeQuery();

            if (rs.next()) { //si hay al menos un solo resultado es que existe el usuario//

                cliente_sesion.setIdCliente(rs.getInt(1));
                cliente_sesion.setNombre(rs.getString(2));
                cliente_sesion.setApellido(rs.getString(3));
                cliente_sesion.setPeso(rs.getDouble(4));
                cliente_sesion.setAltura(rs.getInt(5));
                cliente_sesion.setEdad(rs.getInt(6));
                cliente_sesion.setSexo(rs.getString(7));
                cliente_sesion.setTipo_dieta(rs.getString(8));
                cliente_sesion.setExperiencia(rs.getString(9));
                cliente_sesion.setUsername(rs.getString(10));
                cliente_sesion.setPassword(rs.getString(11));
                Conexion_BD.close(stmt);
                return cliente_sesion;
            } else {
                System.out.println("No se han encontrado clientes con esos datos");
                return null;
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            return null;
        }
    }

    /**
     * Genera un nuevo perfil de cliente y lo guarda en la BD
     * @param perfil
     * @return
     */
    @Override
    public Perfil_cliente generar_perfil(Perfil_cliente perfil) {

        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = Conexion_BD.GetConexion();
            stmt = conn.prepareStatement(SQL_INSERT);

            stmt.setString(1, perfil.getNombre());
            stmt.setString(2, perfil.getApellido());
            stmt.setDouble(3, perfil.getPeso());
            stmt.setInt(4, perfil.getAltura());
            stmt.setInt(5, perfil.getEdad());
            stmt.setString(6, perfil.getSexo());
            stmt.setString(7, perfil.getTipo_dieta());
            stmt.setString(8, perfil.getExperiencia());
            stmt.setString(9, perfil.getUsername());
            stmt.setString(10, perfil.getPassword());

            System.out.println("ejecutando query:" + SQL_INSERT);
            stmt.executeUpdate();
            Conexion_BD.close(stmt);
            System.out.println("Perfil creado");
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return perfil;
    }

    /**
     * Actualiza/modifica los datos de un perfil
     * @param id
     * @param nombre
     * @param apellido
     * @param peso
     * @param altura
     * @param edad
     * @param dieta
     * @param experiencia
     * @param username
     * @param password
     * @return el perfil del cliente actualizado con la información que haya cambiado
     */
    @Override
    public Perfil_cliente actualizar_perfil(int id, String nombre, String apellido, double peso, int altura, int edad, String sexo, String dieta, String experiencia, String username, String password) {

        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = Conexion_BD.GetConexion();
            stmt = conn.prepareStatement(SQL_UPDATE);

            stmt.setString(1, nombre);
            stmt.setString(2, apellido);
            stmt.setDouble(3, peso);
            stmt.setInt(4, altura);
            stmt.setInt(5, edad);
            stmt.setString(6, sexo);
            stmt.setString(7, dieta);
            stmt.setString(8, experiencia);
            stmt.setString(9, username);
            stmt.setString(10, password);
            stmt.setInt(11, id);

            System.out.println("ejecutando query:" + SQL_UPDATE);
            stmt.executeUpdate();
            Conexion_BD.close(stmt);
            System.out.println("Perfil modificado");
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }

        return null;
    }

    /**
     * Elimina un perfil de cliente
     *
     * @param id
     * @return un booleano que indica el exito o no de la eliminación
     */
    @Override
    public boolean eliminar_perfil(int id) {

        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = Conexion_BD.GetConexion();
            stmt = conn.prepareStatement(SQL_DELETE);

            stmt.setInt(1, id);

            System.out.println("ejecutando query:" + SQL_DELETE);
            stmt.executeUpdate();
            Conexion_BD.close(stmt);
            System.out.println("Perfil de cliente eliminado");
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            return false;
        }
    }

    /**
     * Busca el nombre de usuario que quiere introducir el nuevo cliente para comprobar si ya existe
     *
     * @param username
     * @return un booleano que indica si existe o no el nombre de usuario
     */
    public boolean comprobar_user(String username) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = Conexion_BD.GetConexion();
            stmt = conn.prepareStatement("SELECT * from clientes where username = ?");
            stmt.setString(1, username);
            rs = stmt.executeQuery();

            if (rs.next()) { //si hay al menos un solo resultado es que existe el usuario//
                Conexion_BD.close(stmt);
                return true;
            } else {
                System.out.println("El username introducido por el cliente ya existe");
                return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            return false;
        }
    }
    //Fin de los metodos de la interfaz//

    /**
     * Metodo perteneciente al patron Observer que ejecuta el cambio en el nivel de experiencia del cliente.
     * @param cambio
     * @return el cambio realizado
     */
    public String metodo_cambios_observer(String cambio) {

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = Conexion_BD.GetConexion();
            stmt = conn.prepareStatement("UPDATE clientes SET experiencia=? WHERE id_cliente = ?");

            stmt.setString(1, cambio);
            stmt.setInt(2, controlador.getCliente_sesion_actual().getIdCliente());

            System.out.println("ejecutando query:" + "UPDATE clientes SET experiencia=? WHERE id_cliente = ?");
            stmt.executeUpdate();
            Conexion_BD.close(stmt);
            System.out.println("Experiencia actualizada");

            // anotamos el cambio y lo notificamos
            setChanged();
            notifyObservers(cambio);

            return cambio;
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            return null;
        }
    }

}
