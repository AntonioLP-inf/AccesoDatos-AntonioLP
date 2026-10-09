package bloque1.tema3;
import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.helpers.DefaultHandler;

public class parserSAX {
    public static void main(String[] args) {

        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            factory.setValidating(true);
            SAXParser saxParser = factory.newSAXParser();
            File file = new File("C:\\Users\\PC117\\Desktop\\Acceso a datos\\AccesoDatos-AntonioLP\\bloque1\\tema3\\fichero.xml");
            saxParser.parse(file, new DefaultHandler());

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}