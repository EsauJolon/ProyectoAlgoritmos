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

                    // Verificar que el ID comience con "S" y tenga al menos un número
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
            return "S1"; // Retornar "S1" en caso de error
        }

        // Retornar el siguiente ID disponible con una 'S' al inicio
        return "S" + (maxId + 1);
    }

    public static void eliminarEspecificacion(String id) {
        // Mostrar un cuadro de diálogo de confirmación
        int confirmacion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que deseas eliminar el registro?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);

        // Si el usuario selecciona "Sí", procedemos con la eliminación
        if (confirmacion == JOptionPane.YES_OPTION) {
            File archivo = new File("asignarEspecificaciones.txt");
            List<String> espeRestantes = new ArrayList<>(); // Lista para almacenar las líneas que no serán eliminadas

            try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
                String linea;
                // Leer cada línea del archivo
                while ((linea = br.readLine()) != null) {
                    // Dividir la línea en los diferentes valores
                    String[] partes = linea.split("\\|");

                    // Verificar que la línea tenga suficientes partes
                    if (partes.length > 0) {
                        // Comparamos el id obtenido de la tabla con el id de la línea actual (quitando espacios en blanco)
                        if (!partes[0].trim().equals(id.trim())) {
                            // Si los IDs no coinciden, agregamos la línea a la lista de las restantes
                            espeRestantes.add(linea);
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Sobreescribir el archivo con los registros restantes (excluyendo el eliminado)
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
                for (String especificaciones : espeRestantes) {
                    bw.write(especificaciones);
                    bw.newLine();
                }
                System.out.println("Especificación eliminada correctamente.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Eliminación cancelada.");
        }
    }

}
