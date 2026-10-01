package bloque1.tema1;

import java.io.*;
public class Ejemplo4 {
    public static void main(String[] args) {
        
        try{
        FileReader lector = new FileReader("./Bloque1/tema1/crearFichero.txt");
        int data;
        while((data = lector.read()) != -1)  {
            System.out.println((char)data);
        }      
        
        lector.close();
        System.out.println("Lectura completada");
        
            FileWriter fw = new FileWriter("./Bloque1/tema1/escritura.txt");
            fw.write(((char)data)+"Esto es un ejemplo de escritura");
            fw.close();
            System.out.println("FicheroEscrito correctamente");
        }catch(Exception e ){
            System.out.println("Error al escribir en el archivo");
        }
    }
}
