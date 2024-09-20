package practica_1;

import java.io.PrintWriter;

public class exercici_09 {
    public static void main(String[] args) {
        // Contingut que es vol escriure al fitxer
        String frase = "Fila número: ";
        int numeroInicial = 1;
        int numeroFinal = 10;

        // Nom del fitxer
        String filePath = "Exercici_09.txt";
        
        // Fent servir el PrintWritter
        try (PrintWriter writer = new PrintWriter(filePath)) { // Obrir el fitxer (es crearà si no existeix) 
            for (int i = numeroInicial; i <= numeroFinal; i++) {
                writer.print(frase); // Escriure la frase (no faig servir el LN per no afegir el salt de linia)
                writer.println(String.format("%02d", i)); // Escriure el número en format de 2 digits
                // Com fem servir el printLN afegeix la LiNea al final de la frase, per tant no cal afegir-la
            }

            System.out.println("Ok!");

        } catch (Exception e) {
            System.out.println("Error.");
        }
    }
}
