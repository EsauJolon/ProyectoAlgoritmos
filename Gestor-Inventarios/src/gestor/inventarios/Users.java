package gestor.inventarios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author esauj
 */
public class Users {

    public static void agregarUsuario(String id, String usuario, String contraseña, String rol) {
        File archivo = new File("users.txt");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo, true))) {
            // Escribe el nuevo usuario en el archivo
            bw.write(id + "|" + usuario + "|" + contraseña + "|" + rol + "|\n");
            bw.flush();
            System.out.println("Usuario agregado correctamente.");
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

    public static void eliminarUsuario(String id) {
        File archivo = new File("users.txt");
        List<String> usuariosRestantes = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            // Leer cada línea del archivo
            while ((linea = br.readLine()) != null) {
                // Dividir la línea en los diferentes valores
                String[] partes = linea.split("\\|");

                // Si el ID no coincide, lo agregamos a la lista temporal
                if (!partes[0].equals(id)) {
                    usuariosRestantes.add(linea);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Escribir los usuarios restantes de nuevo en el archivo
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            for (String usuario : usuariosRestantes) {
                bw.write(usuario);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
