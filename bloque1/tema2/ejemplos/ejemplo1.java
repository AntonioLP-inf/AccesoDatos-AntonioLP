
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.io.FileReader;
public class ejemplo1 {
    public static void main(String[] args) {
        try{
            int numero = 123;
            String texto = "Hola mundo";
            
        StreamTokenizer streamTokenizer = new StreamTokenizer(new FileReader("Datos.txt"));
        //Configurar para que el caracter de nueva linea sea interpretado
        streamTokenizer.eolIsSignificant(true);


        while (streamTokenizer.nextToken() != StreamTokenizer.TT_EOF) {
            if (streamTokenizer.ttype == StreamTokenizer.TT_WORD) {
                System.out.println( "Palabra: " + streamTokenizer.sval); // token de tipo palabra
            } else if (streamTokenizer.ttype == StreamTokenizer.TT_NUMBER) {
                System.out.println("Número: " + streamTokenizer.nval); // token de tipo número
            } else if (streamTokenizer.ttype == StreamTokenizer.TT_EOL) {
                System.out.println("Fin de línea"); // fin de línea
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    }
}
