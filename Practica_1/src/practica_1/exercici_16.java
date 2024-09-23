package practica_1;

import java.io.RandomAccessFile;
import java.io.IOException;

public class exercici_16 {
    public static void main(String[] args) {
    	int idTarget = 10; // Identificador a buscar
    	
        String filePath = "Exercici_16.dat"; // Fitxer amb les dades dels empleats

        try (RandomAccessFile raf = new RandomAccessFile(filePath, "r")) {
            boolean trobat = false;
            
            raf.seek(0);
            
            do {
            	int id = raf.readInt(); // metode readInt
                String cognom = raf.readUTF(); // metode readUTF
                int departament = raf.readInt(); // metode readInt
                double salari = raf.readDouble(); // metode readDouble
                
                if (id == idTarget) {
                    System.out.printf("ID: %d, Cognom: %s, Departament: %d, Salari: %.2f\n", id, cognom, departament, salari);
                    trobat = true;
                }
            	
			} while ((raf.getFilePointer() < raf.length()) && !trobat);
            
            
            if (!trobat) {
                System.out.println("No existeix l'empleat.");
            }

        } catch (IOException e) {
            System.out.println("Error.");
            e.printStackTrace();
        }
    }
}
