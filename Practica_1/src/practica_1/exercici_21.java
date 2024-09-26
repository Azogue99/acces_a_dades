package practica_1;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

public class exercici_21 {

    public static void main(String[] args) {
        String xmlFilePath = "Exercici_22.xml";
        String xslFilePath = "Exercici_26.xsl";
        String outputHtmlFilePath = "Exercici_21.html";

        generarHTML(xmlFilePath, xslFilePath, outputHtmlFilePath);
    }

    public static void generarHTML(String xmlFilePath, String xslFilePath, String outputHtmlFilePath) {
        try {
            // Crear el transformador factory
            TransformerFactory factory = TransformerFactory.newInstance();
            
            // Carrega el fitxer XSL
            StreamSource xslStream = new StreamSource(new File(xslFilePath));
            
            // Crear el transformador
            Transformer transformer = factory.newTransformer(xslStream);
            
            // Carrega el fitxer XML
            StreamSource xmlStream = new StreamSource(new File(xmlFilePath));
            
            // Estableix el fitxer HTML de sortida
            StreamResult result = new StreamResult(new File(outputHtmlFilePath));
            
            // Transforma el document
            transformer.transform(xmlStream, result);
            
            System.out.println("HTML creat!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
