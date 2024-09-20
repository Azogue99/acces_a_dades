package practica_1;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class exercici_14 {
    public static void main(String[] args) {
        // Nom del fitxer binari
        String filePath = "Exercici_14.dat";

        // Llegir i mostrar els objectes Persona del fitxer binari
        try (ObjectInputStream objectIS = new ObjectInputStream(new FileInputStream(filePath))) {
        	        	
            // Llegir la totalitat del fitxer, tancarem el bucle amb un catch > break.
            while (true) {
                try {
                    // Llegir un objecte del fitxer amb el metode readObject i el passem a l'objecte Persona
                    Persona persona = (Persona) objectIS.readObject();
                    
                    // Mostrar la informació de la persona amb els getters.
                    System.out.println("Nom: " + persona.getNom() + " Edat: " + persona.getEdat());
                    
                } catch (Exception e) {
                    // Es la unica manera que tinc de tancar el bucle.
                    break;
                }
            }

        } catch (Exception e) {
            System.out.println("Error.");
            e.printStackTrace();
        }
    }
}
