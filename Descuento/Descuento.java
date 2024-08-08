/*
 * Se importa Locale para que el scanner use el punto como separador decimal.
 * Se importa Scanner para poder leer los datos que ingresa el usuario.
 */
import java.util.Locale;
import java.util.Scanner;

/**
 * La clase Descuento implementa la logica que
 * manipula el precio del articulo haciendole el descuento para luego sumarle el IVA.
 * @link Descuento
 * @author Emanuel Jolón
 * @version 1.0
 * @since 02/08/2024
 * 
 */


public class Descuento{

    /**
     * El metodo devuelve el total a pagar por el articulo y el descuento con
     * los datos proporcionados por el usuario 
     * 
     * @param precio valor total del producto a comprar.
     * @return devuelve el total de dolares a adquirir.
     */    

    public static void main(String[] args) {
     
        /*
         * Se declara la variable scan para poder obtener el valor de
         * del producto a comprar.
         * 
         * se usa tipo double en los datos para poder usar datos con decimales.
         */
        Scanner scan = new Scanner(System.in).useLocale(Locale.US);
		System.out.println("Ingrese el precio del producto:");
		double precio = scan.nextDouble();
        if(precio<=0){
            System.out.println("El precio debe ser mayor a 0");
        }

        /*
         * El descuento se calcula multiplicando el precio por 0.20
        */
        double descuento = precio * 0.20;
        /*
         * El descuento con descuento se calcula restando el precio - descuento.
        */
        double precioD = precio - descuento;
        /*
         * El precio final se calcula multiplicando por 1.12 que es el IVA.
         */
        double precioF = precioD * 1.12;
        
		System.out.println("El precio a pagar por el articulo es de: "+ precioF);
        System.out.println("Su descuento es de: "+ descuento);	

        
    }
}