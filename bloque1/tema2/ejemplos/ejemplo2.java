
import java.io.FileReader;
import java.io.LineNumberReader;
public class ejemplo2 {
    public static void main(String[] args) {
        try{
            LineNumberReader lineNumberReader = new LineNumberReader(new FileReader("Datos.txt"));
            String linea;

            while ((linea = lineNumberReader.readLine()) != null) {
                System.out.println("Línea " + lineNumberReader.getLineNumber() + ": " + linea);
                System.out.print(linea);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
