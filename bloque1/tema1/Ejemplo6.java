package bloque1.tema1;
import java.io.*;

public class Ejemplo6 {
    public static void main(String[] args) {
        try{
            // Crea un objeto RandomAccessFile para leer y escribir en el archivo
            RandomAccessFile file = new RandomAccessFile("./Bloque1/tema1/crearFichero.txt", "rw");

            file.seek(5);// Mueve el puntero del archivo a la posición 5

            // Lee un byte del archivo en la posición actual del puntero
            System.out.println("Posicion antes de leer: " + file.getFilePointer());//escribe 5

            int unbyte = file.read();// Lee un byte del archivo en la posición actual del puntero
            System.out.println("Puntero despues de leer:"+ file.getFilePointer());//escribe 6
            // Convierte el byte leído a un carácter y lo imprime en la consola
            System.out.println((char)unbyte);
            file.write('0');
            System.out.println("Puntero despues de escribir:"+ file.getFilePointer());//escribe 7
        } catch (Exception e){
            //Todo Auto-generated catch block
            e.printStackTrace();

        
        }
    }
}
