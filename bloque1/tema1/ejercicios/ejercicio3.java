package bloque1.tema1.ejercicios;

import java.io.*;

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
            for (char c = 'A'; c <= 'Z'; c++) {
                escritor.write(c);
            }
            escritor.close();
            
            // Pedir al usuario una posición y un carácter
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Ingrese la posición (0-25) donde desea modificar: ");
            int posicion = Integer.parseInt(reader.readLine());
            System.out.print("Ingrese el carácter que desea escribir: ");
            char nuevoCaracter = (char) reader.read();

            // Usar RandomAccessFile para modificar el contenido
            RandomAccessFile file = new RandomAccessFile("./Bloque1/tema1/ejercicios/datos.txt", "rw");
            file.seek(posicion);
            file.write(nuevoCaracter);
            file.close();

            System.out.println("Modificación completada.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}