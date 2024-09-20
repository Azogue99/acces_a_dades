package practica_1;

import java.io.FileWriter;

public class exercici_08 {
	public static void main(String[] args) {
		// Contingut que es vol escriure al fitxer
        String frase = "Fila número: ";
        int numeroInicial = 1;
        int numeroFinal = 10;

        // Nom del fitxer
        String filePath = "Exercici_08.txt";

        try (FileWriter writer = new FileWriter(filePath)) { // Obrir el fitxer (es crearà si no existeix)
        	for (int i = numeroInicial; i <= numeroFinal; i++) {
        		writer.write(frase); // Escriure la frase
        		writer.write(String.format("%02d", i)); // Escriu el numero en format de 2 digits
                writer.write(System.lineSeparator()); // Posa un salt de línia
        	}

            System.out.println("Ok!");

        } catch (Exception e) {
            System.out.println("Error.");
        }
    }
}
