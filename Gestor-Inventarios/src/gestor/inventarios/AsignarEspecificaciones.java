/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestor.inventarios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author esauj
 */
public class AsignarEspecificaciones {

    public static void agregarEspecificacion(String id, String producto, String especificacion, String descripcion) {
        File archivo = new File("asignarEspecificaciones.txt");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo, true))) {
            // Escribe el nuevo usuario en el archivo
            bw.write(id + "|" + producto + "|" + especificacion + "|" + descripcion + "|\n");
            bw.flush();
            System.out.println("Producto agregado correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
     public static String generarNuevoId(File archivo) {
        int maxId = 0;

        // Verificar si el archivo existe y no está vacío
        if (!archivo.exists() || archivo.length() == 0) {
            return "S1"; // Primer ID si el archivo no existe o está vacío
        }

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;

            // Leer cada línea del archivo
            while ((linea = br.readLine()) != null) {
                // Dividir la línea en partes utilizando el delimitador "|"
                String[] partes = linea.split("\\|");

                // Verificar que la línea tenga al menos una parte (el ID)
                if (partes.length >= 1) {
                    String id = partes[0].trim();

                    // Verificar que el ID comience con "P" y tenga al menos un número
                    if (id.startsWith("S") && id.length() > 1) {
                        String numeroStr = id.substring(1); // Obtener la parte numérica

                        try {
                            int numero = Integer.parseInt(numeroStr);

                            // Actualizar maxId si el número actual es mayor
                            if (numero > maxId) {
                                maxId = numero;
                            }
                        } catch (NumberFormatException ex) {
                            // Si la parte numérica no es válida, ignorar esta línea
                            System.err.println("ID inválido encontrado: " + id);
                        }
                    } else {
                        // Si el ID no sigue el formato esperado, ignorar esta línea
                        System.err.println("Formato de ID inválido: " + id);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            // En caso de error al leer el archivo, puedes manejarlo según tus necesidades
            // Por ejemplo, podrías lanzar una excepción o retornar un valor predeterminado
            return "S1"; // Retornar "P1" como fallback
        }

        // Retornar el siguiente ID disponible con una 'P' al inicio
        return "S" + (maxId + 1);
    }
    
}
