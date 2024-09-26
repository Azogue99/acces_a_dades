package practica_1;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class exercici_18 {

    public static void main(String[] args) {
        try {
            // Document XML
            InputSource fileXML = new InputSource("employees.xml");

            // Crear el SAXParser
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            XMLReader processador = saxParser.getXMLReader();

            // Handler per gestionar els esdeveniments SAX
            DefaultHandler handler = new DefaultHandler() {
            	String departmentName = "";
                public void startElement(String uri, String localName, String qName, Attributes attributes) {
                	
                	
                    if (qName.equalsIgnoreCase("department")) {
                        departmentName = attributes.getValue("name");
                        System.out.println("Department: " + departmentName);
                    } else if (qName.equalsIgnoreCase("employee")) {
                        String name = attributes.getValue("name");
                        String position = attributes.getValue("position");
                        String salary = attributes.getValue("salary");
                        System.out.println("\tEmployee: " + name);
                        System.out.println("\tPosition: " + position);
                        System.out.println("\tSalary: " + salary);
                    } else if (qName.equalsIgnoreCase("sub-department")) {
                        String subDepartmentName = attributes.getValue("name");
                        System.out.println("Department: "+ departmentName + " | Sub-department: " + subDepartmentName);
                    }
                }
            };

            // Assignar el handler al processador
            processador.setContentHandler(handler);

            // Parsejar el fitxer XML
            saxParser.parse(fileXML, handler);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
