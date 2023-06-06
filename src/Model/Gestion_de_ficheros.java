package Model;

import Controller.Controller;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;

//Clase que gestiona la escritura y lectura de ficheros//
public class Gestion_de_ficheros {

    Controller controlador = new Controller();
    HashMap<Integer, ArrayList<ArrayList<String>>> hashMap = new HashMap<>();

    /**
     * Metodo que lee el fichero, pasa la información a un Hashmap, añade o sustituye la nueva rutina o dieta generada para el usuario y vuelve a escribir toda la info en el fichero JSON
     * @param matriz_elementos
     * @param nombreArchivo
     */
    public void rellenar_ficheros(ArrayList<ArrayList<String>> matriz_elementos, String nombreArchivo) {

        try (FileReader fileReader = new FileReader(nombreArchivo)) {
            // Leer el fichero json
            Gson gson = new Gson();

            //El método getType() de la clase TypeToken (de la libreria Gson) se utiliza para obtener el objeto Type que representa el tipo de datos especificado.//
            Type type = new TypeToken<HashMap<Integer,  ArrayList<ArrayList<String>>>>() {
            }.getType();
            //se usa el objeto Type para especificar el tipo de objeto que se va a deserializar//
            hashMap = gson.fromJson(fileReader, type);

            // Eliminar la entrada correspondiente al ID del cliente actual si la hay
            if (hashMap == null) {
                hashMap = new HashMap<>();
                hashMap.put(controlador.getCliente_sesion_actual().getIdCliente(), matriz_elementos);
                System.out.println("Se ha añadido la dieta/rutina");
            } else if (hashMap.containsKey(controlador.getCliente_sesion_actual().getIdCliente())) {
                hashMap.remove(controlador.getCliente_sesion_actual().getIdCliente());
                System.out.println("Entrada con ID " + controlador.getCliente_sesion_actual().getIdCliente() + " eliminada correctamente.");
                hashMap.put(controlador.getCliente_sesion_actual().getIdCliente(), matriz_elementos);
                System.out.println("Se ha sustituido la dieta/rutina");
            } else {
                System.out.println("No se encontró ninguna entrada previa con ID " + controlador.getCliente_sesion_actual().getIdCliente() + ".");
                hashMap.put(controlador.getCliente_sesion_actual().getIdCliente(), matriz_elementos);
                System.out.println("Se ha añadido la dieta/rutina");
            }

            // Escribir el HashMap actualizado en el archivo JSON
            try (FileWriter fileWriter = new FileWriter(nombreArchivo)) {
                gson.toJson(hashMap, fileWriter);
                System.out.println("Archivo JSON actualizado correctamente.");
            } catch (IOException e) {
                System.out.println("Error al escribir el archivo JSON: " + e.getMessage());
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo JSON: " + e.getMessage());
        }
    }

    /**
     * Método que lee el fichero y devuelve la rutina o dieta según el archivo enviado por parámetros
     * @param nombreArchivo
     * @return una matriz
     */
    public ArrayList<ArrayList<String>> lectura_ficheros(String nombreArchivo) {

        ArrayList<ArrayList<String>> matriz_devuelta;

        try (FileReader fileReader = new FileReader(nombreArchivo)) {
            // Leer el fichero json
            Gson gson = new Gson();
            Type type = new TypeToken<HashMap<Integer, ArrayList<ArrayList<String>>>>() {
            }.getType();
            hashMap = gson.fromJson(fileReader, type);

            matriz_devuelta = hashMap.get(controlador.getCliente_sesion_actual().getIdCliente());
            return matriz_devuelta;

        } catch (IOException e) {
            System.out.println("Error al leer el archivo JSON: " + e.getMessage());
            return null;
        }
    }

    /**
     * Método que lee el fichero y comprueba la existencia de rutina y dieta para activar los botones de ver planning y descargar planning
     * @param nombre_fichero
     * @return un booleano
     */
    public boolean comprobar_existencia_dieta_rutina(String nombre_fichero) {

        //InputStream inputStream = getClass().getResourceAsStream(nombre_fichero);
        //try (InputStreamReader inputStreamReader = new InputStreamReader(inputStream)) {

        try (FileReader fileReader = new FileReader(nombre_fichero)) { //esta forma de inicializar los recursos dentro del paréntesis garantiza que se cierren
            // correctamente al finalizar el bloque, sin necesidad de utilizar un bloque finally.

            // Leemos el fichero json y pasamos us contenido a un Hashmap//
            Gson gson = new Gson();
            Type type = new TypeToken<HashMap<Integer, String[][]>>() {
            }.getType();
            hashMap = gson.fromJson(fileReader, type);
            //comprobamos si el Hashmap (y por lo tanto el fichero) tiene una clave asociada al cliente//
            if (hashMap==null){
                return false;
            } else if (hashMap.containsKey(controlador.getCliente_sesion_actual().getIdCliente())){
                return true;
            }else {
                return false;
            }

        } catch (IOException e) {
            System.out.println("Error al leer el archivo JSON: " + e.getMessage());
           return false;
        }
    }
}
