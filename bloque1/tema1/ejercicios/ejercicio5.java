package bloque1.tema1.ejercicios;
import java.io.*;
public class ejercicio5 {
    /*Ejercicio 5 — Copiar un archivo binario (imagen)
Copiar ficheros grandes (por ejemplo, un log de un servidor) es una tarea habitual. Este ejercicio compara, con datos reales, por qué se usa buffer en la práctica.

Copia un fichero (usa uno que pese al menos varios MB — una imagen grande o un vídeo corto sirven) usando FileInputStream/FileOutputStream, leyendo byte a byte (sin buffer).
Copia el mismo fichero, pero usando BufferedInputStream/BufferedOutputStream, leyendo con un array de 4096 bytes.
En los dos casos, mide el tiempo que tarda la copia con System.currentTimeMillis() (antes y después de copiar, y calculando la diferencia).
Compara los tiempos por consola y comprueba que el tamaño de las dos copias coincide con el original. */
public static void main(String[] args) {
        // Implementación del ejercicio 5
        // Aquí puedes agregar el código para copiar un archivo binario y medir los tiempos de copia
        try{
            // Copia sin buffer
            FileInputStream fis = new FileInputStream("./Bloque1/tema1/ejercicios/foto.jpg");
            FileOutputStream fos = new FileOutputStream("./Bloque1/tema1/ejercicios/foto_copia_sin_buffer.jpg");
            // Medir el tiempo de copia sin buffer
            long startTime = System.currentTimeMillis();
         
            //hacemos un bucle while para leer los bytes del archivo de entrada y escribirlos en el archivo de salida
               int byteLeido;
               int contador = 0;
               while((byteLeido = fis.read()) != -1) {
                fos.write(byteLeido);
                contador++;
            }
            System.out.println("Bytes copiados sin buffer: " + contador);
            long endTime = System.currentTimeMillis();
            System.out.println("Tiempo de copia sin buffer: " + (endTime - startTime) + " ms");
            fis.close();
            fos.close();
            //-----------------------------------------------------------------------------------------------------
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream("./Bloque1/tema1/ejercicios/foto.jpg"));
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("./Bloque1/tema1/ejercicios/foto_copia_con_buffer.jpg"));
            startTime = System.currentTimeMillis();
            byte[] buffer = new byte[4096];
            int bytesLeidos;
            while((bytesLeidos = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesLeidos);
            }
            endTime = System.currentTimeMillis();
            System.out.println("Tiempo de copia con buffer: " + (endTime - startTime) + " ms");

            bis.close();
            bos.close();
        } catch (IOException e) {
            System.out.println("Error al leer o escribir en el archivo: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error al leer o escribir en el archivo");
        }
    }
}
