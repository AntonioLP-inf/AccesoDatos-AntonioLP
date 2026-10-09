package bloque1.tema3.ejercicios.ejercicio2;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.File;

public class RecorrerColeccionDOM {
    public static void main(String[] args) {
        int totalUnidadesGlobal = 0;
        int totalEjercitos = 0;

        try {
            // 1. Cargar y parsear el fichero XML
            File archivoXML = new File("miniaturas.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(archivoXML);
            
            // Normalizar el documento XML
            doc.getDocumentElement().normalize();

            // 2. Obtener la lista de elementos del primer nivel (<ejercito>)
            NodeList listaEjercitos = doc.getElementsByTagName("ejercito");
            totalEjercitos = listaEjercitos.getLength();

            for (int i = 0; i < totalEjercitos; i++) {
                Node nodoEjercito = listaEjercitos.item(i);

                if (nodoEjercito.getNodeType() == Node.ELEMENT_NODE) {
                    Element elementoEjercito = (Element) nodoEjercito;

                    // Obtener atributo identificativo y nombre interno
                    String faccionAttr = elementoEjercito.getAttribute("faccion");
                    String nombreEjercito = elementoEjercito.getElementsByTagName("nombre").item(0).getTextContent();

                    System.out.println("Ejército: " + nombreEjercito + " (Facción: " + faccionAttr + ")");

                    // Obtener la lista de elementos hijos (<unidad>)
                    NodeList listaUnidades = elementoEjercito.getElementsByTagName("unidad");
                    int totalUnidadesEjercito = listaUnidades.getLength();
                    totalUnidadesGlobal += totalUnidadesEjercito;

                    for (int j = 0; j < totalUnidadesEjercito; j++) {
                        Element elementoUnidad = (Element) listaUnidades.item(j);

                        // Obtener los 3 campos con texto de cada hijo
                        String nombreUnidad = elementoUnidad.getElementsByTagName("nombreUnidad").item(0).getTextContent();
                        String tipo = elementoUnidad.getElementsByTagName("tipo").item(0).getTextContent();
                        String puntos = elementoUnidad.getElementsByTagName("puntos").item(0).getTextContent();

                        // Formato de salida para cada hijo
                        System.out.println("  - " + nombreUnidad + " [Tipo: " + tipo + ", Puntos: " + puntos + "]");
                    }

                    // Mostrar total de hijos para este elemento de primer nivel
                    System.out.println("Total de unidades en este ejército: " + totalUnidadesEjercito);
                    System.out.println(); // Línea en blanco para separar
                }
            }

            // 3. Resumen global al final del programa
            System.out.println("=== RESUMEN GLOBAL ===");
            System.out.println("Total de ejércitos recorridos: " + totalEjercitos);
            System.out.println("Total de unidades registradas: " + totalUnidadesGlobal);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}