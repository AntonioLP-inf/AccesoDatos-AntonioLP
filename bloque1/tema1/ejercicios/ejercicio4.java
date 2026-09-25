package bloque1.tema1.ejercicios;

import java.io.*;

public class ejercicio4 {
    /*
     * Ejercicio 4 — Copiar un fichero con buffers
     * Crea un programa que copie el contenido de foto.jpg en foto_copia_buffer.jpg
     * usando buffers, para mejorar la eficiencia frente a una copia byte a byte. El
     * programa debe:
     * 
     * Abrir foto.jpg en modo lectura con BufferedInputStream y
     * foto_copia_buffer.jpg en modo escritura (sobrescribiendo si ya existe)usando
     * BufferedOutputStream.
     * Definir un buffer de lectura/escritura, por ejemplo de 1024 bytes.
     * Mientras haya datos en el origen: leer un bloque en el buffer, escribirlo en
     * el destino, y mostrar por consola un mensaje del tipo Fin copia bloque N.
     * Al terminar, añadir al final un mensaje de "Copia finalizada correctamente."
     * Cerrar ambos ficheros correctamente.
     * Controlar las excepciones si el fichero origen no existe o hay errores de
     * E/S.
     */
    public static void main(String[] args) {
        try {
            // Abrir foto.jpg en modo lectura con BufferedInputStream
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream("./Bloque1/tema1/ejercicios/foto.jpg"));
            // Abrir foto_copia_buffer.jpg en modo escritura con BufferedOutputStream
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("./Bloque1/tema1/ejercicios/foto_copia_buffer.jpg"));

            // Definir un buffer de lectura/escritura de 1024 bytes
            byte[] buffer = new byte[1024];
            int bytesLeidos;
            int bloque = 0;

            // Mientras haya datos en el origen
            while ((bytesLeidos = bis.read(buffer)) != -1) {
                // Escribir el bloque leído en el destino
                bos.write(buffer, 0, bytesLeidos);
                bloque++;
                System.out.println("Fin copia bloque " + bloque);
            }

            // Añadir mensaje de finalización
            System.out.println("Copia finalizada correctamente.");

            // Cerrar ambos ficheros correctamente
            bis.close();
            bos.close();
        } catch (IOException e) {
            System.out.println("Error al leer o escribir en el archivo: " + e.getMessage());
        }
    }
}
