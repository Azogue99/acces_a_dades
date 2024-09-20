package practica_1;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class exercici_11v2_alter {
    public static void main(String[] args) {
        // Arrays de noms i edats
        String[] noms = {"Ana", "Lluís Miquel", "Alícia", "Pere", "Manel", "Andrés", "Julio", "Antoni", "Maria"};
        int[] edats = {14, 15, 13, 15, 16, 12, 16, 14, 13};

        // Nom del fitxer binari
        String filePath = "Exercici_11v2_alter.dat";

        // Escriure els noms i les edats al fitxer binari
        try (DataOutputStream dataOS = new DataOutputStream(new FileOutputStream(filePath))) {
    		// Per cada nom del array escriu-lo al fitxer
    		for (int i = 0; i < noms.length; i++) {
                dataOS.writeUTF(noms[i]); // Escriure el nom com a cadena amb el metode writeUTF
            }
    		
    		// Per cada edat del array escriu-lo al fitxer
    		for (int i = 0; i < noms.length; i++) {
                dataOS.writeInt(edats[i]); // Escriure l'edat com a enter amb el metode writeInt
            }
    		
    		dataOS.close(); // Tanca el fitxer
            System.out.println("Ok!");
            
        } catch (Exception e) {
            System.out.println("Error.");
        }
    }
}
