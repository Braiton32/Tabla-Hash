import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TablaHash {
    // Método que procesa el archivo y realiza todas las operaciones
    public static void procesarArchivo(String archivoLectura, String archivoEscritura) {
        // Esto sera la tabla hash para almacenar los nombres
        HashMap<Integer, String> tabla = new HashMap<>();

        // Aqui lee el ar chivo y cargara los nombres al HashMap
        try (BufferedReader lector = new BufferedReader(new FileReader(archivoLectura))) {
            String texto;
            int contador = 1;
            
            while ((texto = lector.readLine()) != null) {
                tabla.put(contador, texto.trim());
                contador++;
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
            return;
        }

         // Aqui mostrara el HashMap sin ordenar
        System.out.println("Datos originales en la tabla Hash:");
        for (Map.Entry<Integer, String> item : tabla.entrySet()) {
            System.out.println("ID " + item.getKey() + ": " + item.getValue());
        }
        
        // Y ordenara los valores de la HashTable
        ArrayList<String> lista = new ArrayList<>(tabla.values());
        Collections.sort(lista);
        
        // Y por ultimo mostrara los resultados ordenados
        System.out.println("\n Datos ordenados alfabéticamente:");
        for (String valor : lista) {
            System.out.println(valor);
        }

         // Aqui guardara los nombres ordenados en un nuevo archivo
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(archivoEscritura))) {
            for (String valor : lista) {
                escritor.write(valor);
                escritor.newLine(); // salto de línea
            }
            System.out.println("\n Archivo generado exitosamente: " + archivoEscritura);
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo ordenado: " + e.getMessage());
        }
    }
}
