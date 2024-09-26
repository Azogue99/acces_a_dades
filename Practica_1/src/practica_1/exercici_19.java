package practica_1;

import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class exercici_19 {
    public static void main(String[] args) {
    	String inputFilePath = "employees.xml";
        String outputFilePath = "updated_employees.xml";
    	
        try {
            // Crear el DocumentBuilder
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            
            // Llegir el fitxer XML
            Document doc = dBuilder.parse(new File(inputFilePath));
            doc.getDocumentElement().normalize();
            
            // Mostrar el contingut original del fitxer XML
            System.out.println("Contingut original:");
            mostrarEmpleats(doc);
            System.out.println("-----------------");
            
            // Actualitzar l'empleat amb ID 3
            actualitzarEmpleat(doc, 3, "Senior Security Analyst", "65000");
            
            // Esborrar l'empleat amb ID 4
            esborrarEmpleat(doc, 4);
            
            // Guardar el fitxer actualitzat
            guardarDocument(doc, outputFilePath);
            
            // Mostrar el contingut actualitzat del fitxer XML
            System.out.println("-----------------");
            System.out.println("Contingut després de les actualitzacions:");
            mostrarEmpleats(doc);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Funció per mostrar tots els empleats del fitxer XML
    public static void mostrarEmpleats(Document doc) {
    	int ID = 1;
        NodeList departments = doc.getElementsByTagName("department");
        for (int i = 0; i < departments.getLength(); i++) {
            Node departmentNode = departments.item(i);
            Element departmentElement = (Element) departmentNode;
            NodeList employees = departmentElement.getElementsByTagName("employee");
            for (int j = 0; j < employees.getLength(); j++) {
                Element employee = (Element) employees.item(j);
                System.out.println("ID: " + ID + ", Nom: " + employee.getAttribute("name") +
                                   ", Posició: " + employee.getAttribute("position") +
                                   ", Salari: " + employee.getAttribute("salary"));
                ID++;
            }
        }
    }
    
    public static String findIDofEmployee(Document doc, int id) {
        NodeList employeeList = doc.getElementsByTagName("employee");
        if (id > 0 && id <= employeeList.getLength()) {
            Node employeeNode = employeeList.item(id - 1);
            if (employeeNode.getNodeType() == Node.ELEMENT_NODE) {
                Element employeeElement = (Element) employeeNode;
                return employeeElement.getAttribute("name");
            }
        }
        return null;
    }

    // Funció per actualitzar el salari i la posició d'un empleat
    public static void actualitzarEmpleat(Document doc, int id, String newPosition, String newSalary) {
    	String name = findIDofEmployee(doc, id);
    	System.out.println("> Actualitzant: " + id + " " + name + " | Nova posicio: " + newPosition + " | Nou salari: " + newSalary);
        NodeList employees = doc.getElementsByTagName("employee");
        for (int i = 0; i < employees.getLength(); i++) {
            Element employee = (Element) employees.item(i);
            if (employee.getAttribute("name").equals(name)) {
                employee.setAttribute("position", newPosition);
                employee.setAttribute("salary", newSalary);
            }
        }
    }

    // Funció per esborrar un empleat del fitxer XML
    public static void esborrarEmpleat(Document doc, int id) {
    	String name = findIDofEmployee(doc, id);
    	System.out.println("> Eliminant: " + id + " " + name);
        NodeList employees = doc.getElementsByTagName("employee");
        for (int i = 0; i < employees.getLength(); i++) {
            Element employee = (Element) employees.item(i);
            if (employee.getAttribute("name").equals(name)) {
                employee.getParentNode().removeChild(employee);
            }
        }
    }

    // Funció per guardar el document XML actualitzat
    public static void guardarDocument(Document doc, String filePath) {
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(filePath));
            transformer.transform(source, result);
            
            System.out.println("> Guardant el document: " + filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
}
