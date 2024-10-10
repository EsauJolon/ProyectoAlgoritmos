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
public class Categorias {

    public static void agregarCategoria(String id, String Nombre, String Descripcion) {
        File archivo = new File("categorias.txt");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo, true))) {
            // Escribe el nuevo usuario en el archivo
            bw.write(id + "|" + Nombre + "|" + Descripcion + "|\n");
            bw.flush();
            System.out.println("Categoria agregadas correctamente.");
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
    
     public static void eliminarCategoria(String id) {
        // Mostrar un cuadro de diálogo de confirmación
        int confirmacion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que deseas eliminar esta categoria?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);

        // Si el usuario selecciona "Sí", procedemos con la eliminación
        if (confirmacion == JOptionPane.YES_OPTION) {
            File archivo = new File("categorias.txt");
            List<String> categoriasRestantes = new ArrayList<>();

            try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
                String linea;
                // Leer cada línea del archivo
                while ((linea = br.readLine()) != null) {
                    // Dividir la línea en los diferentes valores
                    String[] partes = linea.split("\\|");

                    // Si el ID no coincide, lo agregamos a la lista temporal
                    if (!partes[0].equals(id)) {
                        categoriasRestantes.add(linea);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Escribir los usuarios restantes de nuevo en el archivo
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
                for (String categoria : categoriasRestantes) {
                    bw.write(categoria);
                    bw.newLine();
                }
                System.out.println("Categoria eliminada correctamente.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Eliminación cancelada.");
        }
    }

    
        public static void editarCategoria(String idEditar, String nuevoNombre, String nuevaDescripcion) {
        File archivo = new File("categorias.txt");
        List<String> categoriasActualizadas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split("\\|");

                // Si el ID coincide con el que deseamos editar
                if (datos[0].equals(idEditar)) {
                    // Reemplazar los datos del usuario
                    categoriasActualizadas.add(idEditar + "|" + nuevoNombre + "|" + nuevaDescripcion + "|");
                } else {
                    // Si no coincide, mantener el usuario actual
                    categoriasActualizadas.add(linea);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Sobrescribir el archivo con los usuarios actualizados
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            for (String categoria : categoriasActualizadas) {
                bw.write(categoria + "\n");
            }
            bw.flush();
            System.out.println("categoria editada correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
     
     

}
