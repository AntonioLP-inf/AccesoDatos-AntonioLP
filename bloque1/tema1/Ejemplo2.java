package bloque1.tema1;
import java.io.*;

public class Ejemplo2{
    public static void main(String[] args) {
        File fichero0 = new File("./Bloque1/tema1/crearFichero.txt");

        File carpeta = new File("./tema1", "backup");

        carpeta.mkdirs();

        File destino = new File("./tema1/backup/fichero_movido.txt");
        if(fichero0.renameTo(destino)){
        System.out.println("El fichero se a movido correctamente");
        }
        else{
            System.out.println("El fichero no se a podido mover");
        }
    }
}
