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
public class Productos {

    public static void agregarProducto(String id, String Nombre, String Descripcion, String Categoria, String sub, double precio, int stock) {
        File archivo = new File("productos.txt");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo, true))) {
            // Escribe el nuevo usuario en el archivo
            bw.write(id + "|" + Nombre + "|" + Descripcion + "|" + Categoria + "|" + sub + "|" + precio + "|" + stock + "|\n");
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
            return "P1"; // Primer ID si el archivo no existe o está vacío
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
                    if (id.startsWith("P") && id.length() > 1) {
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
            return "P1"; // Retornar "P1" como fallback
        }

        // Retornar el siguiente ID disponible con una 'P' al inicio
        return "P" + (maxId + 1);
    }

    public static void editarProducto(String idEditar, String nuevoNombre, String nuevaDescripcion,
            String nuevaCategoria, String nuevaSub, String nuevoPrecio, String nuevoStock) {

        // Mostrar alerta de confirmación
        int opcion = JOptionPane.showConfirmDialog(null,
                "¿Está seguro que desea editar el registro con ID " + idEditar + "?",
                "Confirmar Edición", JOptionPane.YES_NO_OPTION);

        if (opcion != JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "Edición cancelada.");
            return;
        }

        // Primero editamos el archivo de productos
        File archivoProductos = new File("productos.txt");
        List<String> productosActualizados = new ArrayList<>();
        String nombreAntiguo = "";

        try (BufferedReader br = new BufferedReader(new FileReader(archivoProductos))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split("\\|");

                // Si el ID coincide, actualizamos los datos y guardamos el nombre antiguo
                if (datos[0].equals(idEditar)) {
                    nombreAntiguo = datos[1]; // Guardamos el nombre antiguo
                    productosActualizados.add(idEditar + "|" + nuevoNombre + "|" + nuevaDescripcion + "|"
                            + nuevaCategoria + "|" + nuevaSub + "|" + nuevoPrecio + "|" + nuevoStock + "|");
                } else {
                    productosActualizados.add(linea);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al leer productos.txt", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Sobrescribir el archivo productos.txt
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivoProductos))) {
            for (String producto : productosActualizados) {
                bw.write(producto + "\n");
            }
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al escribir en productos.txt", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Ahora actualizamos asignarEspecificaciones.txt si el nombre coincide
        File archivoEspecificaciones = new File("asignarEspecificaciones.txt");
        List<String> especificacionesActualizadas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivoEspecificaciones))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split("\\|");

                // Verificar si la línea tiene al menos 4 campos y si el nombre coincide con el antiguo
                if (datos.length >= 4 && datos[1].equals(nombreAntiguo)) {
                    // Actualizar la línea con el nuevo nombre
                    especificacionesActualizadas.add(
                            datos[0] + "|" + nuevoNombre + "|" + datos[2] + "|" + datos[3] + "|"
                    );
                } else {
                    // Mantener la línea sin cambios si no coincide
                    especificacionesActualizadas.add(linea);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al leer asignarEspecificaciones.txt", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Sobrescribir el archivo asignarEspecificaciones.txt
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivoEspecificaciones))) {
            for (String especificacion : especificacionesActualizadas) {
                bw.write(especificacion + "\n");
            }
            bw.flush();
            JOptionPane.showMessageDialog(null, "Producto y especificaciones actualizados correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al escribir en asignarEspecificaciones.txt", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void eliminarProducto(String id) {
        // Mostrar un cuadro de diálogo de confirmación
        int confirmacion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que deseas eliminar el producto?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);

        // Si el usuario selecciona "Sí", procedemos con la eliminación
        if (confirmacion == JOptionPane.YES_OPTION) {
            File archivo = new File("productos.txt");
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
                System.out.println("Usuario eliminado correctamente.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Eliminación cancelada.");
        }
    }

}
