package practica_1;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.util.ArrayList;

/**
 * Aquesta manera de guardar el fitxer no em permet contar correctament els noms que hi ha
 * Tampoc puc gestionar correctament les iteracions que faig sobre el document
 * He de hardcodejar el numero de noms que hi han al fitxer, aixo no hauria de ser aixi
 * S'HA DE REVISAR AQUESTA RESPOSTA
 */

public class exercici_12v2_alter {
    public static void main(String[] args) {
        // Nom del fitxer binari
        String filePath = "Exercici_11v2_alter.dat";
        int countNoms = 9; // Ho he de fer hard-coded perque funcioni, no he pogut contar nomes noms.

        // Crear els ArrayLists per emmagatzemar noms i edats
        ArrayList<String> noms = new ArrayList<>();
        ArrayList<Integer> edats = new ArrayList<>();

        // Llegir els noms i les edats del fitxer binari
        try (DataInputStream dataIS = new DataInputStream(new FileInputStream(filePath))) {
            
            // Llegir tots els noms primer
            for (int i = 0; i < countNoms; i++) { // Sabem que hi ha 9 noms
                String nom = dataIS.readUTF();  // Llegir el nom
                noms.add(nom);                  // Afegir nom a l'ArrayList
            }

            // Ara llegim les edats
            for (int i = 0; i < countNoms; i++) { // Sabem que hi ha 9 edats
                int edat = dataIS.readInt();   // Llegir l'edat
                edats.add(edat);               // Afegir edat a l'ArrayList
            }

            // Mostrar les dades per pantalla (nom + edat)
            for (int i = 0; i < noms.size(); i++) {
                System.out.println(noms.get(i) + " " + edats.get(i));
            }
            
        } catch (Exception e) {
            System.out.println("Error.");
            e.printStackTrace();
        }
    }
}
