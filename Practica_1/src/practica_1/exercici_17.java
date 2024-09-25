package practica_1;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.io.File;


public class exercici_17 {
    public static void main(String[] args) {
        try {
        	// Crea el DocumentBuilder
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            // Crea el document
            Document doc = dBuilder.newDocument();
            
            // Omple el document
            fillDocument(doc);

            // Transforma el document
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            
            // Guardar el fitxer XML
            StreamResult result = new StreamResult(new File("company.xml"));
            DOMSource source = new DOMSource(doc);
            transformer.transform(source, result);

            System.out.println("Ok!");

        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }
    }

	// Funció per afegir un empleat al departament
	private static void addEmployee(Document doc, Element department, String name, String position, String salary) {
	    Element employee = doc.createElement("employee");
	    employee.setAttribute("name", name);
	    employee.setAttribute("position", position);
	    employee.setAttribute("salary", salary);
	    department.appendChild(employee);
	}
	
	// Funcio per omplir el document
	private static Document fillDocument(Document doc) {
		// Crear el node arrel <company>
        Element company = doc.createElement("company");
        doc.appendChild(company);

        // Crear el departament IT
        Element departmentIT = doc.createElement("department");
        departmentIT.setAttribute("name", "IT");
        company.appendChild(departmentIT);

        // Afegir empleats al departament IT
        addEmployee(doc, departmentIT, "Alice", "Developer", "50000");
        addEmployee(doc, departmentIT, "Bob", "SysAdmin", "45000");

        // Afegir sub-department Security dins del departament IT
        Element subDepartmentSecurity = doc.createElement("sub-department");
        subDepartmentSecurity.setAttribute("name", "Security");
        departmentIT.appendChild(subDepartmentSecurity);

        // Afegir empleat al sub-department Security
        addEmployee(doc, subDepartmentSecurity, "Charlie", "Security Analyst", "55000");

        // Crear el departament HR
        Element departmentHR = doc.createElement("department");
        departmentHR.setAttribute("name", "HR");
        company.appendChild(departmentHR);

        // Afegir empleats al departament HR
        addEmployee(doc, departmentHR, "Dana", "HR Manager", "60000");
        addEmployee(doc, departmentHR, "Eve", "Recruiter", "40000");
        
        return doc;
	}
}
