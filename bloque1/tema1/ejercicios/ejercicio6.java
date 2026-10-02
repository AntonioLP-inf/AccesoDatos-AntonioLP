package bloque1.tema1.ejercicios;
import java.io.*;
import java.util.Scanner;
public class ejercicio6 {
    public static void main(String[] args) {
        /*
         * Ejercicio 6 — Reserva de asientos de cine (RandomAccessFile)
         * Contexto: el fichero asientos.txt ya existe y contiene 20 caracteres L
         * seguidos, uno por cada asiento de la sala (asientos numerados del 0 al 19,
         * todos libres):
         * 
         * LLLLLLLLLLLLLLLLLLLL
         * 
         * Pide al usuario el número de asiento que quiere comprar (0-19).
         * Si el número está fuera de ese rango, avisa de que ese asiento no existe/no
         * está disponible.
         * Si el asiento existe, comprueba su estado actual: si ya está comprado (C),
         * avisa de que ya está ocupado; si está libre (L), cámbialo a C usando
         * RandomAccessFile.
         * Cierra el fichero.
         * Maneja la excepción si se produce un error de lectura/escritura.
         */
        try {
            // Pide al usuario el número de asiento que quiere comprar (0-19).
            java.util.Scanner sc = new java.util.Scanner(System.in);
            System.out.print("Indica el número de asiento que quieres comprar (0-19): ");
            int asiento = Integer.parseInt(sc.nextLine());

            // Comprueba si el número está fuera de ese rango
            if (asiento < 0 || asiento > 19) {
                System.out.println("Ese asiento no existe/no está disponible.");
                return;
            }

            // Abre el fichero asientos.txt en modo lectura/escritura
            java.io.RandomAccessFile random = new java.io.RandomAccessFile("./Bloque1/tema1/ejercicios/asientos.txt", "rw");

            // Posiciona el puntero en la posición del asiento indicado
            random.seek(asiento);

            // Lee el estado actual del asiento
            char estado = (char) random.readByte();

            // Comprueba su estado actual
            if (estado == 'C') {
                System.out.println("Ese asiento ya está ocupado.");
            } else if (estado == 'L') {
                // Cambia el estado a C usando RandomAccessFile
                random.seek(asiento);
                random.writeByte('C');
                System.out.println("Asiento reservado correctamente.");
            }

            // Cierra el fichero
            random.close();

        } catch (Exception e) {
            System.out.println("Error al procesar el archivo: " + e.getMessage());}

    }
}
