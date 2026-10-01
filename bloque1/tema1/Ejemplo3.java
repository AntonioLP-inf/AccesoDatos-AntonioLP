package bloque1.tema1;
import java.io.*;

public class Ejemplo3 {
    public static void main(String[] args) {
        String nombreCarpeta = "NuevaCarpeta";

        File carpeta = new File(".\\tema1", nombreCarpeta);

        if (carpeta.exists()) {
            System.out.println("La carpeta " + carpeta.getName());
            
        }else{
            carpeta.mkdirs();
            System.out.println("La carpeta " + carpeta.getName());
            System.out.println("Ruta absoluta " + carpeta.getAbsolutePath());
            System.out.println("Ruta relativa");
        }
    }
}
