package practica_1;

import java.io.File;
import java.util.Scanner;

public class exercici_01 {
	public static void main(String[] args) {
		
	      Scanner scanner = new Scanner(System.in);
	        boolean close = false;
	        String fileName;

	        do {
	            System.out.print("Introdueix el nom de l'arxiu (0 per sortir): ");
	            fileName = scanner.nextLine();
	            
	            if (fileName.equals("0")) {
	                close = true;
	                
	            } else {
	                File file = new File(fileName);

	                if (!file.exists()) { // Amb el metode exists comprovem si el fitxer existeix abans de treballar amb ell
	                    System.out.println("L'arxiu no existeix.");
	                    
	                } else if (file.isDirectory()) { // Amb el metode isDirectory verifiquem que no es tracti de un directori
	                    System.out.println("Es tracta d'un directori.");
	                    
	                } else {
	                    System.out.println("Informació del fitxer:");
	                    
	                    // Fem servir el metode getName per obtenir el nom del fitxer
	                    System.out.println("Nom: " + file.getName()); 
	                    
	                    // Fem servir el metode getPath per obtenir la ruta del fitxer
	                    System.out.println("Cami: " + file.getPath()); 
	                    
	                    // Fem servir el metode getAbsolutePath per obtenir la ruta completa del fitxer
	                    System.out.println("Cami absolut: " + file.getAbsolutePath()); 
	                    
	                    // Fem servir el metode canWrite amb una expressio ternaria per determinar si pot escriure.
	                    System.out.println("Es pot escriure: " + (file.canWrite() ? "Si" : "No")); 
	                    
	                    // Fem servir el metode canRead amb una expressio ternaria per determinar si pot llegir.
	                    System.out.println("Es pot llegir: " + (file.canRead() ? "Si" : "No")); 
	                    
	                    // Fem servir el metode length per saber com de gran es el fitxer.
	                    System.out.println("Mida: " + file.length() + " bytes"); 
	                }
	            }
	        } while (!close);

	        scanner.close();
	        System.out.println("Adeu.");

		
		
	}
}
