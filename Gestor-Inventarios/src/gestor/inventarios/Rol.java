/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestor.inventarios;

/**
 *
 * @author esauj
 */


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Rol {
    
     public static void main(String[] args) {
        crearArchivoRoles();
    }
      public static void crearArchivoRoles() {
        File archivo = new File("Roles.txt");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo, true))) {
            // Agregamos el rol "admin" con un ID y descripción
            bw.write("1|admin|\n");
                   bw.write("2|cajero|\n");
            bw.flush();
            System.out.println("Rol 'admin' agregado correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
