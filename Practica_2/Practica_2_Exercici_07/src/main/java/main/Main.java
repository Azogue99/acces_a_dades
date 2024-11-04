package main;

import models.Comanda;
import models.Usuari;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Bucle principal del menu de la botiga
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
            scanner.nextLine(); // Consumeix el salt de línia

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
                    System.exit(0); // Surt de l'aplicació
                default:
                    System.out.println("Opció invàlida!"); // Missatge d'error per opcions incorrectes
                    break;
            }
        }
    }

    // Metode per afegir un nou usuari
    private static void addNewUser() {
        System.out.print("Introdueix el nom de l'usuari: ");
        String nom = scanner.nextLine();
        System.out.print("Introdueix el correu electrònic de l'usuari: ");
        String correu = scanner.nextLine();
        Usuari usuari = new Usuari(nom, correu);
        usuari.saveUsuari(usuari); // Guarda el nou usuari a la base de dades
        System.out.println("Usuari afegit correctament.");
    }

    // Metode per obtenir les comandes d'un usuari per ID
    private static void getUserOrders() {
        System.out.print("Introdueix l'ID de l'usuari: ");
        int userId = scanner.nextInt();
        scanner.nextLine(); // Consumeix el salt de línia
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

    // Metode per actualitzar el correu d'un usuari
    private static void updateUserEmail() {
        System.out.print("Introdueix l'ID de l'usuari: ");
        int userId = scanner.nextInt();
        scanner.nextLine(); // Consumeix el salt de línia
        System.out.print("Introdueix el nou correu electrònic: ");
        String newEmail = scanner.nextLine();
        Usuari usuari = new Usuari();
        usuari.updateEmail(userId, newEmail); // Actualitza el correu electrònic de l'usuari
        System.out.println("Correu electrònic actualitzat correctament.");
    }

    // Metode per eliminar una comanda per ID
    private static void deleteOrder() {
        System.out.print("Introdueix l'ID de la comanda: ");
        int comandaId = scanner.nextInt();
        scanner.nextLine(); // Consumeix el salt de línia
        Comanda comanda = new Comanda();
        comanda.deleteComanda(comandaId); // Elimina la comanda de la base de dades
        System.out.println("Comanda eliminada correctament.");
    }

    // Metode per llistar tots els usuaris
    private static void listAllUsers() {
        Usuari usuari = new Usuari();
        List<Usuari> usuaris = usuari.getAllUsuaris();
        if (usuaris.isEmpty()) {
            System.out.println("No hi ha usuaris registrats."); // Missatge si no hi ha usuaris
        } else {
            for (Usuari u : usuaris) {
                System.out.println("Nom: " + u.getNom() + ", Correu: " + u.getCorreu());
            }
        }
    }
}
