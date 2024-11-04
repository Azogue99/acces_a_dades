package main;

import models.Autor;
import models.Llibre;
import models.Prestec;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Bucle principal per gestionar el menú de la biblioteca
        while (true) {
            System.out.println("\n---- Biblioteca ----");
            System.out.println("1. Inserir nou autor");
            System.out.println("2. Inserir nou llibre");
            System.out.println("3. Registrar prestec");
            System.out.println("4. Consultar llibres per autor");
            System.out.println("5. Consultar prestecs per usuari");
            System.out.println("6. Modificar llibre");
            System.out.println("7. Eliminar autor");
            System.out.println("8. Eliminar llibre");
            System.out.println("9. Eliminar prestec");
            System.out.println("0. Sortir");
            System.out.print("Selecciona una opcio: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consumeix el salt de linia

            switch (option) {
                case 1:
                    addNewAuthor();
                    break;
                case 2:
                    addNewBook();
                    break;
                case 3:
                    registerLoan();
                    break;
                case 4:
                    getBooksByAuthor();
                    break;
                case 5:
                    getLoansByUser();
                    break;
                case 6:
                    updateBook();
                    break;
                case 7:
                    deleteAuthor();
                    break;
                case 8:
                    deleteBook();
                    break;
                case 9:
                    deleteLoan();
                    break;
                case 0:
                    System.out.println("Sortint...");
                    System.exit(0); // Surt de l'aplicacio
                default:
                    System.out.println("Opcio invalida!");
            }
        }
    }

    // Metode per inserir un nou autor
    private static void addNewAuthor() {
        System.out.print("Introdueix el nom de l'autor: ");
        String nom = scanner.nextLine();
        System.out.print("Introdueix la nacionalitat de l'autor: ");
        String nacionalitat = scanner.nextLine();
        Autor autor = new Autor(nom, nacionalitat);
        autor.save(); // Guarda l'autor a la base de dades
        System.out.println("Autor afegit correctament.");
    }

    // Metode per inserir un nou llibre
    private static void addNewBook() {
        System.out.print("Introdueix el titol del llibre: ");
        String titol = scanner.nextLine();
        System.out.print("Introdueix l'any de publicacio: ");
        int anyPublicacio = scanner.nextInt();
        scanner.nextLine(); // Consumeix el salt de linia
        System.out.print("Introdueix l'ID de l'autor: ");
        int autorId = scanner.nextInt();
        scanner.nextLine(); // Consumeix el salt de linia
        Autor autor = Autor.findById(autorId);
        if (autor != null) {
            Llibre llibre = new Llibre(titol, anyPublicacio, autor);
            llibre.save(); // Guarda el llibre a la base de dades
            System.out.println("Llibre afegit correctament.");
        } else {
            System.out.println("Autor no trobat.");
        }
    }

    // Metode per registrar un prestec
    private static void registerLoan() {
        System.out.print("Introdueix l'ID del llibre: ");
        int llibreId = scanner.nextInt();
        scanner.nextLine(); // Consumeix el salt de linia
        System.out.print("Introdueix el nom de l'usuari: ");
        String usuari = scanner.nextLine();
        System.out.print("Introdueix la data de prestec (YYYY-MM-DD): ");
        String dataPrestecStr = scanner.nextLine();
        Date dataPrestec = java.sql.Date.valueOf(dataPrestecStr);
        Llibre llibre = Llibre.findById(llibreId);
        if (llibre != null) {
            Prestec prestec = new Prestec(llibre, usuari, dataPrestec, null);
            prestec.save(); // Guarda el prestec a la base de dades
            System.out.println("Prestec registrat correctament.");
        } else {
            System.out.println("Llibre no trobat.");
        }
    }

    // Metode per consultar llibres per autor
    private static void getBooksByAuthor() {
        System.out.print("Introdueix l'ID de l'autor: ");
        int autorId = scanner.nextInt();
        scanner.nextLine(); // Consumeix el salt de linia
        Autor autor = Autor.findById(autorId);
        if (autor != null) {
            List<Llibre> llibres = Llibre.findByAuthor(autor);
            if (!llibres.isEmpty()) {
                for (Llibre llibre : llibres) {
                    System.out.println("Titol: " + llibre.getTitol() + ", Any: " + llibre.getAnyPublicacio());
                }
            } else {
                System.out.println("No s'han trobat llibres per aquest autor.");
            }
        } else {
            System.out.println("Autor no trobat.");
        }
    }

    // Metode per consultar prestecs per usuari
    private static void getLoansByUser() {
        System.out.print("Introdueix el nom de l'usuari: ");
        String usuari = scanner.nextLine();
        List<Prestec> prestecs = Prestec.findByUser(usuari);
        if (!prestecs.isEmpty()) {
            for (Prestec prestec : prestecs) {
                System.out.println("Llibre: " + prestec.getLlibre().getTitol() +
                                   ", Data de prestec: " + prestec.getDataPrestec() +
                                   ", Data de devolucio: " + prestec.getDataDevolucio());
            }
        } else {
            System.out.println("No s'han trobat prestecs per aquest usuari.");
        }
    }

    // Metode per actualitzar un llibre
    private static void updateBook() {
        System.out.print("Introdueix l'ID del llibre: ");
        int llibreId = scanner.nextInt();
        scanner.nextLine(); // Consumeix el salt de linia
        Llibre llibre = Llibre.findById(llibreId);
        if (llibre != null) {
            System.out.print("Introdueix el nou titol del llibre: ");
            String nouTitol = scanner.nextLine();
            llibre.setTitol(nouTitol); // Actualitza el titol del llibre
            llibre.update(); // Guarda els canvis
            System.out.println("Llibre actualitzat correctament.");
        } else {
            System.out.println("Llibre no trobat.");
        }
    }

    // Metode per eliminar un autor
    private static void deleteAuthor() {
        System.out.print("Introdueix l'ID de l'autor: ");
        int autorId = scanner.nextInt();
        scanner.nextLine(); // Consumeix el salt de linia
        Autor autor = Autor.findById(autorId);
        if (autor != null) {
            autor.delete(); // Elimina l'autor de la base de dades
            System.out.println("Autor eliminat correctament.");
        } else {
            System.out.println("Autor no trobat.");
        }
    }

    // Metode per eliminar un llibre
    private static void deleteBook() {
        System.out.print("Introdueix l'ID del llibre: ");
        int llibreId = scanner.nextInt();
        scanner.nextLine(); // Consumeix el salt de linia
        Llibre llibre = Llibre.findById(llibreId);
        if (llibre != null) {
            llibre.delete(); // Elimina el llibre de la base de dades
            System.out.println("Llibre eliminat correctament.");
        } else {
            System.out.println("Llibre no trobat.");
        }
    }

    // Metode per eliminar un prestec
    private static void deleteLoan() {
        System.out.print("Introdueix l'ID del prestec: ");
        int prestecId = scanner.nextInt();
        scanner.nextLine(); // Consumeix el salt de linia
        Prestec prestec = Prestec.findById(prestecId);
        if (prestec != null) {
            prestec.delete(); // Elimina el prestec de la base de dades
            System.out.println("Prestec eliminat correctament.");
        } else {
            System.out.println("Prestec no trobat.");
        }
    }
}