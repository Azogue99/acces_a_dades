package practica_1;

import java.io.RandomAccessFile;

public class exercici_15 {
    public static void main(String[] args) {
        // Dades dels empleats
        String[] cognoms = {"Güllich", "Usobiaga", "Bereciartu", "Rébuffat", "Cassin", "Andrada", "Iglesias"};
        int[] departaments = {10, 20, 10, 10, 30, 30, 20};
        double[] salaris = {1000.45, 2400.60, 3000.0, 1500.56, 2200.0, 1435.87, 2000.0};
        
        String filePath = "Exercici_16.dat"; // Nom del fitxer
        
        try (RandomAccessFile raf = new RandomAccessFile(filePath, "rw")) {
            // Escriure les dades dels empleats al fitxer
            for (int i = 0; i < cognoms.length; i++) {
                raf.writeInt(i + 1); // metode writeInt
                raf.writeUTF(cognoms[i]); // metode writeUTF
                raf.writeInt(departaments[i]); // metode writeInt
                raf.writeDouble(salaris[i]); // metode writeDouble
            }

            System.out.println("Ok!");

            // Tornar al principi del fitxer per llegir les dades
            raf.seek(0);

            // Llegir les dades dels empleats
            for (int i = 0; i < cognoms.length; i++) {
                int id = raf.readInt(); // metode readInt
                String cognom = raf.readUTF(); // metode readUTF
                int departament = raf.readInt(); // metode readInt
                double salari = raf.readDouble(); // metode readDouble

                // Mostrar la informació llegida
                System.out.printf("ID: %d, Cognom: %s, Departament: %d, Salari: %.2f\n", id, cognom, departament, salari);
            }

        } catch (Exception e) {
            System.out.println("Error.");
        }
    }
}
