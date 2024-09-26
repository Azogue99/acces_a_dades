package practica_1;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class exercici_20 {
    public static void main(String[] args) {
        
    	String inputFilePath = "employees_20.xml"; // Fitxer XML a llegir
    	String elementTarget = "empleat"; // Etiqueta que volem buscar
        
        try {
            // Crear el DocumentBuilder
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            
            // Llegir el fitxer XML
            Document doc = dBuilder.parse(new File(inputFilePath));
            doc.getDocumentElement().normalize();
            
            // Comptar el nombre d'emplaçaments
            NodeList employeeList = doc.getElementsByTagName(elementTarget);
            int count = employeeList.getLength();
            
            // Mostrar el resultat
            System.out.println("Nombre d'emplacaments (elements <" + elementTarget + ">): " + count);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
