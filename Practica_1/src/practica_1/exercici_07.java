package practica_1;

import java.io.BufferedReader;
import java.io.FileReader;

public class exercici_07 {
	public static void main(String[] args) {
		// Nom del fitxer a llegir
        String filePath = "Exercici_06.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String linea;

            // Llegir línia a línia i mostrar-les per pantalla
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }

        } catch (Exception e) {
            System.out.println("Error.");
        }
    }
}
