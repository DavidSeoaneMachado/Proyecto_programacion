package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Perfil_clienteDAO implements Perfil {

    private static final String SQL_SELECT = "SELECT id_cliente, username, password, nombre, apellido, peso, altura, tipo_dieta, experiencia FROM clientes where username = ? and password = ?";
    private static final String SQL_INSERT = "INSERT INTO clientes(username, password, nombre, apellido, peso, altura, tipo_dieta, experiencia) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE clientes SET username=?, password=?, nombre=?, apellido=?, peso=?, altura=?, tipo_dieta=?, experiencia=? WHERE id_cliente = ?";
    private static final String SQL_DELETE = "DELETE FROM clientes WHERE id_usuario=?";

    //Metodos implementados de la interfaz Perfil//

    /**
     * Busca un perfil dentro de la base de datos y lo corrobora con la lista de clientes
     *
     * @param user y contraseña del inicio de sesión
     * @return
     */
    @Override
    public Perfil_cliente buscar_perfil(String user, String contraseña) {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        ArrayList<Perfil_cliente> lista_clientes = new ArrayList<>();
        Perfil_cliente cliente45 = new Perfil_cliente();

        try {
            conn = Conexion_BD.GetConexion();
            stmt = conn.prepareStatement(SQL_SELECT);
            stmt.setString(1, user);
            stmt.setString(2, contraseña);
            rs = stmt.executeQuery();

            if (rs.next()) {
                for (Perfil_cliente cliente : lista_clientes) {
                    if (cliente.getIdCliente() == rs.getInt("id_cliente")) {
                        Conexion_BD.close(stmt);
                        Conexion_BD.close(rs);
                        return cliente;
                    } else { //Si existe en la BD deberia existir en el arraylist de clientes
                        return null;
                    }
                }
            } else {
                return null;
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            return null;
        }
        return null; //Ver que no da null siempre//
    }

    /**
     * Genera un nuevo perfil de cliente y lo guarda en la BD
     *
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
            stmt.setString(1, perfil.getUsername());
            stmt.setString(2, perfil.getPassword());
            stmt.setString(3, perfil.getNombre());
            stmt.setString(4, perfil.getApellido());
            stmt.setDouble(5, perfil.getPeso());
            stmt.setInt(6, perfil.getAltura());
            stmt.setString(7, perfil.getTipo_dieta());
            stmt.setString(8, perfil.getExperiencia());

            System.out.println("ejecutando query:" + SQL_INSERT);
            stmt.executeUpdate();
            Conexion_BD.close(stmt);
            Conexion_BD.close(conn);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            //Si quiero cerrar los elementos aqui me pide que maneje una excepcion//
            /*Conexion_BD.close(stmt);
            Conexion_BD.close(conn);*/
        }
        return perfil;
    }

    /**
     * Actualiza/modifica los datos de un perfil
     *
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
