package bloque1.tema3.ejercicios.ejercicio1;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.File;

public class MostrarCatalogoBibliotecas {
    public static void main(String[] args) {
        try {
            // 1. Cargar y parsear el fichero XML
            File archivoXML = new File("C:\\Users\\PC117\\Desktop\\Acceso a datos\\AccesoDatos-AntonioLP\\bloque1\\tema3\\ejercicios\\ejercicio1\\catalogo.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(archivoXML);
            
            // Normalizar el documento XML (recomendado)
            doc.getDocumentElement().normalize();

            // 2. Obtener la lista de todos los elementos de biblioteca (ajusta el tag según tu XML, por ejemplo "biblioteca")
            NodeList listaBibliotecas = doc.getElementsByTagName("biblioteca");

            for (int i = 0; i < listaBibliotecas.getLength(); i++) {
                Node nodoBiblioteca = listaBibliotecas.item(i);

                if (nodoBiblioteca.getNodeType() == Node.ELEMENT_NODE) {
                    Element elementoBiblioteca = (Element) nodoBiblioteca;

                    // Obtener nombre de la biblioteca (suponiendo una etiqueta <nombre>)
                    String nombreBiblio = elementoBiblioteca.getElementsByTagName("nombre").item(0).getTextContent();
                    
                    // Obtener el atributo location
                    String ubicacion = elementoBiblioteca.getAttribute("location");

                    // Mostrar cabecera de la biblioteca
                    System.out.println("Biblioteca: " + nombreBiblio + " (" + ubicacion + ")");

                    // Obtener la lista de libros de esta biblioteca
                    NodeList listaLibros = elementoBiblioteca.getElementsByTagName("libro");
                    int totalLibros = listaLibros.getLength();

                    for (int j = 0; j < totalLibros; j++) {
                        Element elementoLibro = (Element) listaLibros.item(j);

                        String titulo = elementoLibro.getElementsByTagName("titulo").item(0).getTextContent();
                        String autor = elementoLibro.getElementsByTagName("autor").item(0).getTextContent();
                        String anio = elementoLibro.getElementsByTagName("anio").item(0).getTextContent();

                        // Formato de salida para cada libro
                        System.out.println("- " + titulo + " (" + autor + ", " + anio + ")");
                    }

                    // Mostrar total de libros
                    System.out.println("Total de libros: " + totalLibros);
                    System.out.println(); // Línea en blanco entre bibliotecas
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}