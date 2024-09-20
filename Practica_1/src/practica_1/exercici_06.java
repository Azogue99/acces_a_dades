package practica_1;

import java.io.FileWriter;

public class exercici_06 {
	public static void main(String[] args) {
		// Nom del fitxer
        String filePath = "Exercici_06.txt";
		
        // Array de cadenes
        String[] arrayCadenes = {
            "Cadena 1",
            "Cadena 2",
            "Cadena 3",
            "Cadena 4"
        };
        
        try (FileWriter writer = new FileWriter(filePath)) { // Obrir el fitxer (es crearà si no existeix)

            // Escriure cada cadena de l'array en el fitxer
            for (String frase : arrayCadenes) {
                writer.write(frase); // Escriure la frase
                writer.write(System.lineSeparator()); // Posa un salt de línia
            }
            
            System.out.println("Ok!");

        } catch (Exception e) {
            System.out.println("Error.");
        }
    }
}
