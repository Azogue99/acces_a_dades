package practica_1;

import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class exercici_10 {
    public static void main(String[] args) {
    	// Contingut que es vol escriure al fitxer
    	int firstNum = -5;
    	int lastNum = 100;
    	
        // Nom del fitxer binari
        String filePath = "Exercise10.dat";

        // Escriure els números sencers de l'1 al 100 en el fitxer binari
        try (DataOutputStream dataOS = new DataOutputStream(new FileOutputStream(filePath))) {
            for (int i = firstNum; i <= lastNum; i++) {
            	dataOS.writeInt(i); // Escriure cada número com a int
            }
            System.out.println("Ok!");

        } catch (Exception e) {
            System.out.println("Error en escriptura.");
        }

        // Llegir els números del fitxer binari i mostrar-los per pantalla
        try (DataInputStream dataIS = new DataInputStream(new FileInputStream(filePath))) {
        	
        	while (dataIS.available() > 0) { // Comprova que existeix un altre numero
        		int num = dataIS.readInt(); // Llegeix l'enter
        		System.out.println(num);
			}
        	
        } catch (Exception e) {
            System.out.println("Error en lectura.");
            e.printStackTrace();
        }
    }
}
