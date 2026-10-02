package bloque1.tema1.ejercicios;
import java.io.*;
import java.util.Scanner;
import java.util.Random;

public class ejercicio7 {
/*Ejercicio 7 — Consultar un rango de asientos de golpe (RandomAccessFile + bloque)
Seguimos con asientos.txt (20 caracteres, L o C, uno por asiento). En vez de consultar los asientos uno a uno, queremos consultar de golpe un rango completo — por ejemplo, para mostrar en pantalla "la fila A" (asientos 5 al 9) sin hacer 5 lecturas sueltas.

Pide al usuario la posición inicial del rango que quiere consultar (por ejemplo, 5).
Pide al usuario cuántos asientos quiere consultar a partir de ahí (por ejemplo, 5, para ver del 5 al 9).
Usa RandomAccessFile para saltar (seek) a la posición inicial, y leer ese rango de golpe en un array de bytes (read(array, 0, cantidad)).
Muestra por consola el estado de esos asientos, indicando el número de cada uno junto a su estado (L o C).
Cierra el fichero.
Maneja la excepción si hay un error de lectura. */
    public static void main(String[] args) {
       try {
        Scanner sc = new Scanner(System.in);
            System.out.print("Indica la posición inicial del rango: ");
            int posInicial = Integer.parseInt(sc.nextLine());
            System.out.print("Indica cuántos asientos quieres consultar a partir de ahí: ");
            int cantidad = Integer.parseInt(sc.nextLine());

            RandomAccessFile random = new RandomAccessFile("./Bloque1/tema1/ejercicios/asientos.txt", "r");
            random.seek(posInicial);

            byte[] arrayAsientos = new byte[cantidad];
            random.read(arrayAsientos, 0, cantidad);

            System.out.println("Estado de los asientos del rango:");
            for (int i = 0; i < cantidad; i++) {
                System.out.println("Asiento " + (posInicial + i) + ": " + (char) arrayAsientos[i]);
            }

            random.close();
            sc.close();
        

       } catch (Exception e) {
        // TODO: handle exception
       }
    
    }
}

