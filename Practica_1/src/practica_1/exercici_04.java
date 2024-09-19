package practica_1;

import java.io.RandomAccessFile;

public class exercici_04 {
    public static void main(String[] args) {
        
        String filePath = "test.txt"; // Nom del fitxer
        int countChars = 20;

        try (RandomAccessFile raf = new RandomAccessFile(filePath, "r")) { // Obre el fitxer d'acces random nomes lectura
        	
        	raf.seek(0); // Ves a la posició zero del fitxer
        	
        	do {
        		byte[] bytes = new byte[countChars]; // Crea un nou buffer de memoria buit per cada iteracio (amb 20 bytes/chars)
        		
        		raf.read(bytes); // Omple el buffer de memoria amb la propietat read
        		
        		System.out.println(new String(bytes)); // Mostra per pantalla els caracters d'aquesta iteració
        		System.out.println("----------"); // Fes una linia separadora.
        		
			} while (raf.getFilePointer() < raf.length()); // Fes aixo mentres el pointer no hagi arribat al final del fitxer.
        	
        	raf.close(); // Tanca l'arxiu
        	
        } catch (Exception e) {
            System.out.println("Error.");
        }
    }
}


// Cal tenir en compte que els caracters amb accents ocupen dos bytes.