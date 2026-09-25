package bloque1.tema1.ejercicios;
import java.io.*;
public class ejercicio1 {
    public static void main(String[] args) {
       /*   Ejercicio 1 — Copiar texto de un fichero a otro
Crea un programa en Java que copie el contenido de un archivo de texto texto.txt a otro archivo copia.txt, siguiendo estos pasos:

Usar FileReader para leer el archivo de origen, carácter a carácter.
Usar FileWriter para escribir cada carácter leído en el archivo de destino, dentro del mismo bucle.
Cerrar ambos ficheros correctamente al finalizar.
Manejar las excepciones si el archivo de origen no existe o hay un error de lectura/escritura.
Comprueba que el contenido de copia.txt es idéntico al de texto.txt. */
        try{
            //
            FileReader lector = new FileReader("./Bloque1/tema1/ejercicios/texto.txt");
            FileWriter escritor = new FileWriter("./Bloque1/tema1/ejercicios/copia.txt");
            int data;
            while((data = lector.read()) != -1)  {
                escritor.write(data);
            }      
            
            lector.close();
            escritor.close();
            System.out.println("Lectura y escritura completada");
        }catch(Exception e ){
            System.out.println("Error al leer o escribir en el archivo");
        }
    }
}
