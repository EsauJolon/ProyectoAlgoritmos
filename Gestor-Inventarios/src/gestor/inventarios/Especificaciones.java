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
public class Especificaciones {

    public static void agregarEspecificacion(String id, String nombre, String descripcion, String tipo) {
        File archivo = new File("especificaciones.txt");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo, true))) {
            // Escribe el nuevo usuario en el archivo
            bw.write(id + "|" + nombre + "|" + descripcion + "|" + tipo + "|\n");
            bw.flush();
            System.out.println("especificacion agregada correctamente.");
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

    public static void eliminarEspecificacion(String id) {
        // Mostrar un cuadro de diálogo de confirmación
        int confirmacion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que deseas eliminar el registro?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);

        // Si el usuario selecciona "Sí", procedemos con la eliminación
        if (confirmacion == JOptionPane.YES_OPTION) {
            File archivo = new File("especificaciones.txt");
            List<String> espeRestantes = new ArrayList<>();

            try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
                String linea;
                // Leer cada línea del archivo
                while ((linea = br.readLine()) != null) {
                    // Dividir la línea en los diferentes valores
                    String[] partes = linea.split("\\|");

                    // Si el ID no coincide, lo agregamos a la lista temporal
                    if (!partes[0].equals(id)) {
                        espeRestantes.add(linea);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Escribir los usuarios restantes de nuevo en el archivo
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
                for (String especificaciones : espeRestantes) {
                    bw.write(especificaciones);
                    bw.newLine();
                }
                System.out.println("Especificacion eliminada correctamente.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Eliminación cancelada.");
        }
    }

    public static boolean editarEspecificacion(String idEditar, String nuevoNombre,
            String nuevaDescripcion, String nuevaCategoria) {

        File archivo = new File("especificaciones.txt");
        List<String> especificacionesActualizadas = new ArrayList<>();
        boolean registroEncontrado = false;

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split("\\|");

                if (datos[0].equals(idEditar)) {
                    // Si el ID coincide, actualizamos los datos
                    especificacionesActualizadas.add(idEditar + "|" + nuevoNombre + "|"
                            + nuevaDescripcion + "|" + nuevaCategoria + "|");
                    registroEncontrado = true;  // Indicar que se encontró el registro
                } else {
                    // Si no coincide, mantener el registro sin cambios
                    especificacionesActualizadas.add(linea);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;  // Retornar false si ocurre un error al leer el archivo
        }

        // Sobrescribir el archivo con los datos actualizados
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            for (String especificacion : especificacionesActualizadas) {
                bw.write(especificacion + "\n");
            }
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
            return false;  // Retornar false si ocurre un error al escribir el archivo
        }

        return registroEncontrado;  // Retornar true si la edición fue exitosa
    }

}
