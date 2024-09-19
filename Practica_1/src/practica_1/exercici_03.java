package practica_1;

import java.io.FileReader;

public class exercici_03 {
    public static void main(String[] args) {
        
        String filePath = "test.txt"; // Nom del fitxer

        try (FileReader reader = new FileReader(filePath)) { // Creem el FileReader
        	int character;
        	
        	// fem servir el bucle while per llegir tots els caracters, mentres no retorni -1 
        	// ja que es el caracter "null" indicant que s'ha acabat el fitxer.
        	
        	while ((character = reader.read()) != -1) { // fem servir el metode reader.read
                System.out.print((char) character); // passa el valor decimal a (char)
            }
        	
        } catch (Exception e) {
            System.out.println("Error.");
        }
    }
}
