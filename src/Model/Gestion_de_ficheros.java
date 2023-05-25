package Model;

import Controller.Controller;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;

public class Gestion_de_ficheros {

    Controller controlador = new Controller();
    HashMap<Integer, String[][]> hashMap = new HashMap<>();

    public void rellenar_ficheros(String[][] matriz_elementos, String nombreArchivo) {

        try (FileReader fileReader = new FileReader(nombreArchivo)) {
            // Leer el fichero json
            Gson gson = new Gson();
            Type type = new TypeToken<HashMap<Integer, String[][]>>() {
            }.getType();
            hashMap = gson.fromJson(fileReader, type);

            // Eliminar la entrada correspondiente al ID del cliente actual
            if (hashMap == null) {
                hashMap = new HashMap<>();
                hashMap.put(controlador.getCliente_sesion_actual().getIdCliente(), matriz_elementos);
            } else if (hashMap.containsKey(controlador.getCliente_sesion_actual().getIdCliente())) {
                hashMap.remove(controlador.getCliente_sesion_actual().getIdCliente());
                System.out.println("Entrada con ID " + controlador.getCliente_sesion_actual().getIdCliente() + " eliminada correctamente.");
                hashMap.put(controlador.getCliente_sesion_actual().getIdCliente(), matriz_elementos);
            } else {
                System.out.println("No se encontró ninguna entrada con ID " + controlador.getCliente_sesion_actual().getIdCliente() + ".");
                hashMap.put(controlador.getCliente_sesion_actual().getIdCliente(), matriz_elementos);
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


    public String[][] lectura_ficheros(String nombreArchivo) {

        String[][] matriz_devuelta;

        try (FileReader fileReader = new FileReader(nombreArchivo)) {
            // Leer el fichero json
            Gson gson = new Gson();
            Type type = new TypeToken<HashMap<Integer, String[][]>>() {
            }.getType();
            hashMap = gson.fromJson(fileReader, type);

            matriz_devuelta = hashMap.get(controlador.getCliente_sesion_actual().getIdCliente());
            System.out.println("Se ha leido el fichero correctamente");
            for (String[] fila : matriz_devuelta) {
                for (String elemento : fila) {
                    System.out.print(elemento + " ");
                }
                System.out.println();
            }
            return matriz_devuelta;

        } catch (IOException e) {
            System.out.println("Error al leer el archivo JSON: " + e.getMessage());
            return null;
        }
    }

    public boolean comprobar_existencia_dieta_rutina(String nombre_fichero) {

        try (FileReader fileReader = new FileReader(nombre_fichero)) {
            // Leer el fichero json
            Gson gson = new Gson();
            Type type = new TypeToken<HashMap<Integer, String[][]>>() {
            }.getType();
            hashMap = gson.fromJson(fileReader, type);
            if (hashMap.containsKey(controlador.getCliente_sesion_actual().getIdCliente())){
                return true;
            } else {
                return false;
            }

        } catch (IOException e) {
            System.out.println("Error al leer el archivo JSON: " + e.getMessage());
           return false;
        }
    }
}
