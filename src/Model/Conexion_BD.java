package Model;
import java.sql.*;

//Clase que gestiona la conexión a la base de datos de MySQL//
public class Conexion_BD {

    /**
     * Metodo que nos permite obtener la conexion hacia la BD
     * static para poder acceder a ella sin necesidad de instanciar nada
     * @return el objeto conexion listo para usarse
     */
    public static Connection GetConexion() {
        Connection conexion = null;
        String url = "jdbc:mysql://localhost:3306/proyecto?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        String usuario = "root";
        String passwd = "admin";
        try {
            conexion = DriverManager.getConnection(url, usuario, passwd);
            System.out.println("Conexión correcta");
            return conexion;
        } catch (SQLException e) {
            System.out.println("Error en la conexión con MySQL");
            System.out.println("Revisa que todo esté bien escrito y funcional");
            System.out.println(e.getLocalizedMessage());
            return  null;
        }
    }

    //Javadoc para los 4 siguientes metodos//
    /**
     * 4 Metodos que nos permiten cerrar los elementos de la conexion
     * static para poder acceder a ellos sin necesidad de instanciar nada
     * @param rs, smtm, smtm, conn -> en cada uno de los 4 será el elemento que queramos cerrar
     */
    public static void close(ResultSet rs) throws SQLException {
        rs.close();
    }

    public static void close(Statement smtm) throws SQLException {
        smtm.close();
    }

    public static void close(PreparedStatement smtm) throws SQLException {
        smtm.close();
    }

    public static void close(Connection conn) throws SQLException{
        conn.close();
    }
}
