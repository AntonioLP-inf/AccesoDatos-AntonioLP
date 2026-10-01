package bloque1.tema1.ejercicios;

import java.io.*;

public class ejercicio2 {
    /*
     * Ejercicio 2 — Copiar una imagen y contar bytes con FileInputStream
     * Crea un programa en Java que copie una imagen de un lugar a otro, contando
     * cuántos bytes tiene el archivo, siguiendo estos pasos:
     * 
     * Definir dos rutas: una imagen de origen (por ejemplo foto.jpg) y una de
     * destino (foto_copia.jpg).
     * Usar FileInputStream para leer la imagen de origen byte a byte, y
     * FileOutputStream para escribir cada byte leído en el archivo de destino.
     * Declarar un contador (int contador = 0) que se incremente en cada vuelta del
     * bucle, una por cada byte leído.
     * Al terminar la copia, mostrar por consola el número total de bytes
     * leídos/copiados.
     * Cerrar ambos ficheros correctamente.
     * Manejar las excepciones si el archivo de origen no existe o hay un error de
     * lectura/escritura.
     * Ir al Explorador de Windows, click derecho sobre foto.jpg y sobre
     * foto_copia.jpg → "Propiedades" → comprobar el tamaño en bytes de cada uno.
     * ¿Coincide con el número que ha impreso tu programa?
     * Repite el ejercicio completo, pero cambiando FileInputStream/FileOutputStream
     * por FileReader/FileWriter. Vuelve a comprobar el tamaño de la copia
     * resultante en el Explorador de Windows. ¿Coincide esta vez con el original?
     * ¿Se puede abrir la imagen copiada? ¿Por qué crees que pasa esto?
     */
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("./Bloque1/tema1/ejercicios/foto.jpg");
            FileOutputStream fos = new FileOutputStream("./Bloque1/tema1/ejercicios/foto_copia.jpg");
            int contador = 0;
            int data;
            // Lee y escribe byte a byte hasta que no haya más bytes que leer   
            while ((data = fis.read()) != -1) {
                fos.write(data);
                contador++;
            }
            fis.close();
            fos.close();
            System.out.println("Copia completada. Total de bytes copiados: " + contador);
        } catch (Exception e) {
            System.out.println("Error al leer o escribir en el archivo");
        }
    }
}
