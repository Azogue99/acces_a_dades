package practica_1;

import java.io.DataInputStream;
import java.io.FileInputStream;

public class exercici_12 {
    public static void main(String[] args) {
        // Nom del fitxer binari
        String filePath = "Exercici_11.dat";

        // Llegir els noms i les edats del fitxer binari i mostrar-los per pantalla
        try (DataInputStream dataIS = new DataInputStream(new FileInputStream(filePath))) {
        	
        	// Llegir i mostrar les dades mentre hi hagi informació disponible amb el metode available
        	while (dataIS.available() > 0) {
        		String nom = dataIS.readUTF(); // Llegir un nom amb el metode readUTF
        		int edat = dataIS.readInt();   // Llegir l'edat associada amb el metode readInt
        		System.out.println(nom + " " + edat); // Mostrar nom i edat
        	}

        } catch (Exception e) {
            System.out.println("Error.");
        }
    }
}
