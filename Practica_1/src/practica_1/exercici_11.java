package practica_1;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class exercici_11 {
    public static void main(String[] args) {
        // Arrays de noms i edats
        String[] noms = {"Ana", "Lluís Miquel", "Alícia", "Pere", "Manel", "Andrés", "Julio", "Antoni", "Maria"};
        int[] edats = {14, 15, 13, 15, 16, 12, 16, 14, 13};

        // Nom del fitxer binari
        String filePath = "Exercici_11.dat";

        // Escriure els noms i les edats al fitxer binari
        try (DataOutputStream dataOS = new DataOutputStream(new FileOutputStream(filePath))) {
        	
        	// Comprova que els arrays son iguals
        	if (noms.length != edats.length) {
        		System.out.println("Els arrays no coincideixen.");
        	} else {
        		
        		// Per cada nom del array ves-lo escribint al fitxer juntament amb la edat
        		for (int i = 0; i < noms.length; i++) {
                    dataOS.writeUTF(noms[i]); // Escriure el nom com a cadena amb el metode writeUTF
                    dataOS.writeInt(edats[i]); // Escriure l'edat com a enter amb el metode writeInt
                }
        		
        		dataOS.close(); // Tanca el fitxer
                System.out.println("Ok!");
        	}
        } catch (Exception e) {
            System.out.println("Error.");
        }
    }
}
