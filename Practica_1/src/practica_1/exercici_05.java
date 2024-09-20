package practica_1;

import java.io.FileWriter;

public class exercici_05 {
	public static void main(String[] args) {
        String text = "Aquest és el text que es vol escriure en el fitxer.";
        String filePath = "Exercici_05.txt";

        try (FileWriter writer = new FileWriter(filePath)) { // Obrir el fitxer (es crearà si no existeix)
            
            // Escriure la cadena caràcter a caràcter
            for (int i = 0; i < text.length(); i++) {
                writer.write(text.charAt(i)); // Imprimeix el caracter a la posicio que es troba.
            }            
            writer.write('*'); // Escriure l'asterisc al final

            System.out.println("Ok!");

        } catch (Exception e) {
            System.out.println("Error.");
        }
    }

}
