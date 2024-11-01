package main;

import models.Comanda;
import models.Usuari;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n---- Botiga Senzilla ----");
            System.out.println("1. Inserir nou usuari");
            System.out.println("2. Consultar comandes d'un usuari");
            System.out.println("3. Modificar correu d'un usuari");
            System.out.println("4. Eliminar una comanda");
            System.out.println("5. Llistar tots els usuaris");
            System.out.println("0. Sortir");
            System.out.print("Selecciona una opció: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    addNewUser();
                    break;
                case 2:
                    getUserOrders();
                    break;
                case 3:
                    updateUserEmail();
                    break;
                case 4:
                    deleteOrder();
                    break;
                case 5:
                    listAllUsers();
                    break;
                case 0:
                    System.out.println("Sortint...");
                    System.exit(0);
                default:
                    System.out.println("Opció invàlida!");
                    break;
            }
        }
    }

    // Mètode per afegir un nou usuari
    private static void addNewUser() {
        System.out.print("Introdueix el nom de l'usuari: ");
        String nom = scanner.nextLine();
        System.out.print("Introdueix el correu electrònic de l'usuari: ");
        String correu = scanner.nextLine();
        Usuari usuari = new Usuari(nom, correu);
        usuari.saveUsuari(usuari);
        System.out.println("Usuari afegit correctament.");
    }

    // Mètode per obtenir les comandes d'un usuari per ID
    private static void getUserOrders() {
        System.out.print("Introdueix l'ID de l'usuari: ");
        int userId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        Comanda comanda = new Comanda();
        List<Comanda> comandes = comanda.getComandesByUsuariId(userId);
        if (comandes.isEmpty()) {
            System.out.println("Aquest usuari no té comandes.");
        } else {
            for (Comanda c : comandes) {
                System.out.println("Producte: " + c.getProducte() +
                                   ", Preu: " + c.getPreu() +
                                   ", Data: " + c.getData());
            }
        }
    }

    // Mètode per actualitzar el correu d'un usuari
    private static void updateUserEmail() {
        System.out.print("Introdueix l'ID de l'usuari: ");
        int userId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Introdueix el nou correu electrònic: ");
        String newEmail = scanner.nextLine();
        Usuari usuari = new Usuari();
        usuari.updateEmail(userId, newEmail);
        System.out.println("Correu electrònic actualitzat correctament.");
    }

    // Mètode per eliminar una comanda per ID
    private static void deleteOrder() {
        System.out.print("Introdueix l'ID de la comanda: ");
        int comandaId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        Comanda comanda = new Comanda();
        comanda.deleteComanda(comandaId);
        System.out.println("Comanda eliminada correctament.");
    }

    // Mètode per llistar tots els usuaris
    private static void listAllUsers() {
        Usuari usuari = new Usuari();
        List<Usuari> usuaris = usuari.getAllUsuaris();
        if (usuaris.isEmpty()) {
            System.out.println("No hi ha usuaris registrats.");
        } else {
            for (Usuari u : usuaris) {
                System.out.println("Nom: " + u.getNom() + ", Correu: " + u.getCorreu());
            }
        }
    }
}
