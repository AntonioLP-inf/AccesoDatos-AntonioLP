package bloque1.tema1.ejercicios;

import java.io.*;
import java.util.Scanner;
import java.util.Random;
import java.util.RandomAccess;



public class ejercicio3 {
    /*
     * Ejercicio 3 — Modificar datos en un archivo de texto
     * Crea un programa en Java que permita modificar el contenido de un archivo de
     * texto llamado datos.txt, siguiendo estos pasos:
     * 
     * Escribir el abecedario en el fichero mediante FileWriter.
     * Pedir al usuario una posición (entero) del archivo donde quiere modificar.
     * Pedir al usuario el carácter que quiere escribir en esa posición.
     * Usar RandomAccessFile para posicionarse en esa posición y sobrescribir el
     * contenido.
     * Cerrar el archivo correctamente.
     * Manejar las excepciones si el archivo no existe, la posición es inválida, o
     * hay un error de lectura/escritura.
     */
    public static void main(String[] args) {
        try {
            // Escribir el abecedario en el fichero mediante FileWriter
            FileWriter escritor = new FileWriter("./Bloque1/tema1/ejercicios/datos.txt");
            String abecedario = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            escritor.write(abecedario);
            escritor.close();
            // Pedir al usuario una posición y un carácter para modificar
            Scanner sc = new Scanner(System.in);
            // Pedir al usuario una posición (entero) del archivo donde quiere modificar.
            System.out.print("Indica la posicion: ");
            int pos = Integer.parseInt(sc.nextLine());
            // Pedir al usuario el carácter que quiere escribir en esa posición.
            System.out.print("Indica el caracter: ");
            char caracter = sc.nextLine().charAt(0); // Tomamos el primer carácter de la línea ingresada
            // Usar RandomAccessFile para posicionarse en esa posición y sobrescribir el contenido.
            RandomAccessFile random = new RandomAccessFile("./Bloque1/tema1/ejercicios/datos.txt", "rw");
            // Posicionarse en la posición indicada
            random.seek(pos);
            // Sobrescribir el contenido con el nuevo carácter
            random.writeChar(caracter);
            // Cerrar el archivo correctamente
            random.close();

            System.out.println("Modificación completada correctamente.");
            sc.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}