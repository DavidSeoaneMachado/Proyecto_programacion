package Model;

import java.util.HashMap;

public interface Perfil {

    public Perfil_cliente buscar_perfil(String user, String contraseña);
    public  Perfil_cliente generar_perfil(Perfil_cliente perfil);
    public Perfil_cliente actualizar_perfil(int id, String nombre, String apellido, double peso, int altura, int edad, String dieta, String experiencia, String username, String password);
    public boolean eliminar_perfil(int id);



}
