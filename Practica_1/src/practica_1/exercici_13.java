package practica_1;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class exercici_13 {
    public static void main(String[] args) {
    	
        // Arrays de noms i edats
        String[] noms = {"Ana", "Lluís Miquel", "Alícia", "Pere", "Manel", "Andrés", "Julio", "Antoni", "Maria"};
        int[] edats = {14, 15, 13, 15, 16, 12, 16, 14, 13};

        // Nom del fitxer binari
        String filePath = "Exercici_14.dat";

        // Escriure els objectes Persona al fitxer binari
        try (ObjectOutputStream objectOS = new ObjectOutputStream(new FileOutputStream(filePath))) {
            for (int i = 0; i < noms.length; i++) {
            	
                // Crear l'objecte Persona per cada nom i edat
                Persona persona = new Persona(noms[i], edats[i]);
                
                // Escriure l'objecte Persona al fitxer
                objectOS.writeObject(persona); // Fem servir el mètode writeObject per poder guardar directament el objecte al binari.
            }
            System.out.println("Ok!");

        } catch (Exception e) {
            System.out.println("Error.");
        }
    }
}
