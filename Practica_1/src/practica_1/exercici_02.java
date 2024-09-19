package practica_1;

import java.io.File;

public class exercici_02 {
    public static void main(String[] args) {
        
        File newFolder = new File("New folder");
        if (newFolder.mkdir()) { // Per crear el nou directori fem servir el metode mkdir
            System.out.println("Directori creat: " + newFolder.getName());
            
        } else {
            System.out.println("El directori ja existeix.");
        }
        
        // creem els fitxers dins el path de la nova carpeta "New Folder"
        File file1 = new File(newFolder, "File1.txt"); 
        File file2 = new File(newFolder, "File2.txt");
        
        try {
        	
        	// Com aquests metodes retornen un boolean comprobem que hagin 
        	// fucnionat fent servir la estructura [if-else] per capturar el 
        	// possible error.
        	
            if (file1.createNewFile()) { // intenta crear el nou fitxer amb el metode createNewFile
                System.out.println("Arxiu creat: " + file1.getName());
            } else { // en cas que no pugui crear es perque ja existeix
                System.out.println("L'arxiu ja existeix: " + file1.getName()); // el metode getName per mostrar el nom
            }
            
            // fem el mateix al file2 que hem fet abans.
            if (file2.createNewFile()) {
                System.out.println("Arxiu creat: " + file2.getName());
            } else {
                System.out.println("L'arxiu ja existeix: " + file2.getName());
            }

            // Canviar el nom de File1.txt a File1 new.txt
            File file1New = new File(newFolder, "File1 new.txt");
            if (file1.renameTo(file1New)) { // Fem servir el metode renameTo per canviar el nom
                System.out.println("Arxiu renombrat a: " + file1New.getName());
            } else {
                System.out.println("Error en renombrar l'arxiu.");
            }

            // Esborrar File2.txt
            if (file2.delete()) { // fem servir el metode delete per esborrar el fitxer
                System.out.println("Arxiu esborrat: " + file2.getName());
            } else {
                System.out.println("Error en esborrar l'arxiu.");
            }
            
        } catch (Exception e) {
            System.out.println("Error.");
        }
    }
}
