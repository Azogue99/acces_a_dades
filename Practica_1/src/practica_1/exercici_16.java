package practica_1;

import java.io.RandomAccessFile;

public class exercici_16 {
    public static void main(String[] args) {
    	int idTarget = 5; // Identificador a buscar
    	
        String filePath = "Exercici_16.dat"; // Fitxer amb les dades dels empleats

        try (RandomAccessFile raf = new RandomAccessFile(filePath, "r")) {
            raf.seek(0);
            
            // Inicialitzem el id, ja que si el id ens dona que es zero 
            // vol dir que hem arribat al final del fitxer, ho farem 
            // servir per sortir del bucle, igual que el boolean trobat.
            
            int id;
            boolean trobat = false;
            
            do {
            	id = raf.readInt(); // metode readInt
                String cognom = raf.readUTF(); // metode readUTF
                int departament = raf.readInt(); // metode readInt
                double salari = raf.readDouble(); // metode readDouble
                
                if (id == idTarget && id != 0) {
                    System.out.printf("ID: %d, Cognom: %s, Departament: %d, Salari: %.2f\n", id, cognom, departament, salari);
                    trobat = true;
                }
            	
			} while ((raf.getFilePointer() < raf.length()) && !trobat && id != 0);
            
            
            if (!trobat) {
                System.out.println("No existeix l'empleat.");
            }

        } catch (Exception e) {
            System.out.println("Error.");
            e.printStackTrace();
        }
    }
}
