package bloque1.tema3;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class parserDOM {
    public static void main(String[] args) {

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            // Validar el documento e ignorar espacios en blanco "sueltos"
            factory.setValidating(true);
            factory.setIgnoringElementContentWhitespace(true);

            DocumentBuilder builder = factory.newDocumentBuilder();

            File file = new File("C:\\Users\\PC117\\Desktop\\Acceso a datos\\AccesoDatos-AntonioLP\\bloque1\\tema3\\fichero.xml");

            Document doc = builder.parse(file);
            doc.getDocumentElement().normalize();

            Element root = doc.getDocumentElement();
            System.out.println("Elemento raíz: " + root.getNodeName());

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}