import java.io.*;


    //Ejemplo de accseso aleatorio o directo 
    public class Ejemplo7 {
        public static void main(String[] args) {
            try{
                // Crea un objeto RandomAccessFile para leer y escribir en el archivo
                 RandomAccessFile file = new RandomAccessFile("./Bloque1/tema1/crearFichero.txt", "r");

            file.seek(5); // saltamos directamente a la posición 5, sin leer lo anterior

            byte[] arrayBytes = new byte[5]; //declaras array de bytes de 5 posiciones
            file.read(arrayBytes, 0, 5);  // leemos 5 bytes de golpe, desde ahí
            // Imprime el contenido del array de bytes antes de leer del archivo
            System.out.println("Bytes leídos: " + arrayBytes.length);
            // Imprime el contenido del array de bytes antes de leer del archivo
            System.out.println("Puntero DESPUÉS del read: " + file.getFilePointer());
            // Imprime el contenido del array de bytes antes de leer del archivo
            System.out.println("\nArray DESPUÉS de leer (ya relleno con datos del fichero):");
            // Recorre el array de bytes y muestra su contenido en la consola
            for (int i = 0; i < arrayBytes.length; i++) {
             // Imprime el contenido del array de bytes antes de leer del archivo
                System.out.println("  arrayBytes[" + i + "] = " + arrayBytes[i] + " -> '" + (char) arrayBytes[i] + "'");
            }

            file.close();
            // Cierra el archivo
            } catch (IOException e) {
                e.printStackTrace();
                // Maneja cualquier excepción de entrada/salida que pueda ocurrir
 }
}
}

