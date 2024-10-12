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
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author esauj
 */
public class SubCategorias {
    
    
     public static void agregarSubCategoria(String id, String categoria, String descripcion) {
        File archivo = new File("subCategorias.txt");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo, true))) {
            // Escribe el nuevo usuario en el archivo
            bw.write(id + "|" + categoria + "|" + descripcion + "|\n");
            bw.flush();
            System.out.println("Sub categoria agregada correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String generarNuevoId(File archivo) {
        int maxId = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            // Leer cada línea del archivo
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split("\\|");
                // Obtener el ID y convertirlo a número entero
                int idActual = Integer.parseInt(partes[0]);
                // Actualizar el valor de maxId si encontramos un ID mayor
                if (idActual > maxId) {
                    maxId = idActual;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Retorna el siguiente ID disponible
        return String.valueOf(maxId + 1);
    }
    
    
      public static void eliminarSubCategoria(String id) {
        // Mostrar un cuadro de diálogo de confirmación
        int confirmacion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que deseas eliminar el registro?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);

        // Si el usuario selecciona "Sí", procedemos con la eliminación
        if (confirmacion == JOptionPane.YES_OPTION) {
            File archivo = new File("subCategorias.txt");
            List<String> subRestantes = new ArrayList<>();

            try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
                String linea;
                // Leer cada línea del archivo
                while ((linea = br.readLine()) != null) {
                    // Dividir la línea en los diferentes valores
                    String[] partes = linea.split("\\|");

                    // Si el ID no coincide, lo agregamos a la lista temporal
                    if (!partes[0].equals(id)) {
                        subRestantes.add(linea);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Escribir los usuarios restantes de nuevo en el archivo
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
                for (String subCategorias : subRestantes) {
                    bw.write(subCategorias);
                    bw.newLine();
                }
                System.out.println("Sub Categoria eliminado correctamente.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Eliminación cancelada.");
        }
    }
    
    
}
