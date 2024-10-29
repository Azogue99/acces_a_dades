
package main;

import dao.ComandaDAO;
import dao.UsuariDAO;
import models.Comanda;
import models.Usuari;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static final UsuariDAO usuariDAO = new UsuariDAO();
    private static final ComandaDAO comandaDAO = new ComandaDAO();
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
            scanner.nextLine(); // consume newline

            switch (option) {
                case 1 : {
                	addNewUser();
                	break;
                }
                case 2 :{
                	getUserOrders();
                	break;
                }
                case 3 : {
                	updateUserEmail();
                	break;
                }
                case 4 :{
                	deleteOrder();
                	break;
                }
                case 5 : {
                	listAllUsers();
                	break;
                }
                case 0 : {
                    System.out.println("Sortint...");
                    System.exit(0);
                    break;
                }
                default : {
                	System.out.println("Opció invàlida!");
                	break;
                }
            }
        }
    }

    // Method to add a new user
    private static void addNewUser() {
        System.out.print("Introdueix el nom de l'usuari: ");
        String nom = scanner.nextLine();
        System.out.print("Introdueix el correu electrònic de l'usuari: ");
        String correu = scanner.nextLine();
        Usuari usuari = new Usuari(nom, correu);
        usuariDAO.saveUsuari(usuari);
        System.out.println("Usuari afegit correctament.");
    }

    // Method to get orders by user ID
    private static void getUserOrders() {
        System.out.print("Introdueix l'ID de l'usuari: ");
        int userId = scanner.nextInt();
        List<Comanda> comandes = comandaDAO.getComandesByUsuariId(userId);
        if (comandes.isEmpty()) {
            System.out.println("Aquest usuari no té comandes.");
        } else {
            for (Comanda comanda : comandes) {
                System.out.println("Producte: " + comanda.getProducte() +
                        ", Preu: " + comanda.getPreu() +
                        ", Data: " + comanda.getData());
            }
        }
    }

    // Method to update a user's email
    private static void updateUserEmail() {
        System.out.print("Introdueix l'ID de l'usuari: ");
        int userId = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Introdueix el nou correu electrònic: ");
        String newEmail = scanner.nextLine();
        usuariDAO.updateEmail(userId, newEmail);
        System.out.println("Correu electrònic actualitzat correctament.");
    }

    // Method to delete an order by ID
    private static void deleteOrder() {
        System.out.print("Introdueix l'ID de la comanda: ");
        int comandaId = scanner.nextInt();
        comandaDAO.deleteComanda(comandaId);
        System.out.println("Comanda eliminada correctament.");
    }

    // Method to list all users
    private static void listAllUsers() {
        List<Usuari> usuaris = usuariDAO.getAllUsuaris();
        if (usuaris.isEmpty()) {
            System.out.println("No hi ha usuaris registrats.");
        } else {
            for (Usuari usuari : usuaris) {
                System.out.println("Nom: " + usuari.getNom() +
                        ", Correu: " + usuari.getCorreu());
            }
        }
    }
}
