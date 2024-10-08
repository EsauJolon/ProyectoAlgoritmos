/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gestor.inventarios;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author esauj
 */
public class GestorInventarios {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
          crearArchivoUsuarios();
    }
    
     public static void crearArchivoUsuarios() {
        // Archivo llamado 'users.txt' en el directorio actual
        File f = new File("users.txt");

        try {
            // Creamos un FileWriter para escribir en el archivo
            FileWriter fw = new FileWriter(f);
            // Creamos un BufferedWriter para optimizar la escritura
            BufferedWriter bw = new BufferedWriter(fw);

            // Escribimos el registro de usuario
            bw.write("1|admin|123|\n");
            bw.write("1|esau|123|\n");
            // Cerramos el BufferedWriter
            bw.close();

            System.out.println("Archivo 'users.txt' creado exitosamente.");

        } catch (IOException ex) {
            Logger.getLogger(GestorInventarios.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al crear el archivo.");
        }
    }
    
}
