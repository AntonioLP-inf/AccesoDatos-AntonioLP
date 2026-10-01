package bloque1.tema1;
import java.io.File;
import java.io.*;

public class Ejemplo1 {
    public static void main(String[] args) {
        try{
            File fichero = new File("./Bloque1/tema1/crearFichero.txt");
            if (fichero.createNewFile()) {
                System.out.print("Fichero creado: " + fichero.getName());
            } else{
                System.out.println("Error al crear el fichero ");
            }
        }catch(Exception e){
            System.out.print("Ze rompio || " + e.getMessage());
        }
    }
}
