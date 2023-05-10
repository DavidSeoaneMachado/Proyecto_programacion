package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class Perfil_clienteDAO implements Perfil {

    private static final String SQL_SELECT = "SELECT id_cliente, nombre, apellido, peso, altura, tipo_dieta, experiencia, username, password FROM clientes where username = ? and password = ?";
    private static final String SQL_INSERT = "INSERT INTO clientes(nombre, apellido, peso, altura, tipo_dieta, experiencia, username, password) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE clientes SET nombre=?, apellido=?, peso=?, altura=?, tipo_dieta=?, experiencia=?, username=?, password=? WHERE id_cliente = ?";
    private static final String SQL_DELETE = "DELETE FROM clientes WHERE id_usuario=?";

    //Metodos implementados de la interfaz Perfil//
    /**
     * Busca un perfil dentro de la base de datos para comprobar si existe y te devuelve un objeto con sus caracteristicas
     * @param user y contraseña del inicio de sesión
     * @return
     */
    @Override
    public Perfil_cliente buscar_perfil(String user, String contraseña) {

        //HashMap<Perfil_cliente, Boolean> resultado_busqueda = new HashMap<>();
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
                cliente_sesion.setTipo_dieta(rs.getString(6));
                cliente_sesion.setExperiencia(rs.getString(7));
                cliente_sesion.setUsername(rs.getString(8));
                cliente_sesion.setPassword(rs.getString(9));
                Conexion_BD.close(stmt);
                return cliente_sesion;
            } else {
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
            stmt.setString(5, perfil.getTipo_dieta());
            stmt.setString(6, perfil.getExperiencia());
            stmt.setString(7, perfil.getUsername());
            stmt.setString(8, perfil.getPassword());

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
     * @param dieta
     * @param experiencia
     * @param username
     * @param password
     * @return el perfil del cliente actualizado con la información que haya cambiado
     */
    @Override
    public Perfil_cliente actualizar_perfil(int id, String nombre, String apellido, double peso, int altura, String dieta, String experiencia, String username, String password) {

        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = Conexion_BD.GetConexion();
            stmt = conn.prepareStatement(SQL_UPDATE);

            stmt.setString(1, nombre);
            stmt.setString(2,apellido);
            stmt.setDouble(3,peso);
            stmt.setInt(4, altura);
            stmt.setString(5, dieta);
            stmt.setString(6, experiencia);
            stmt.setString(7, username);
            stmt.setString(8, password);
            stmt.setInt(9, id);

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
