package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Exercici_02 {

    private static final String URL = "jdbc:mysql://localhost:3306/botiga";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    @FXML
    private TextField categoriaNom;

    @FXML
    private Button inserirCategoria;

    @FXML
    private TextField producteNom;

    @FXML
    private TextField productePreu;

    @FXML
    private TextField producteCategoria;

    @FXML
    private Button inserirProducte;

    @FXML
    private TextField clientNom;

    @FXML
    private TextField clientCorreu;

    @FXML
    private Button inserirClient;
    
    @FXML
    private void tornarAlMenu(ActionEvent event) {
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        MainMenu.tornarAlMenuPrincipal(stage);
    }

    @FXML
    public void initialize() {
        inserirCategoria.setOnAction(event -> insertCategories());
        inserirProducte.setOnAction(event -> insertProductes());
        inserirClient.setOnAction(event -> insertClients());
    }
    
    
    // Inserta una nova categoria a la base de dades
    private void insertCategories() {
        String categoria = categoriaNom.getText();
        String sql = "INSERT INTO categories (nom) VALUES (?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, categoria);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Inserta un nou producte a la base de dades
    private void insertProductes() {
        String producte = producteNom.getText();
        String preu = productePreu.getText();
        String categoria = producteCategoria.getText();
        String sql = "INSERT INTO productes (nom, preu, id_categoria) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, producte);
            pstmt.setString(2, preu);
            pstmt.setString(3, categoria);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Inserta un nou client a la base de dades
    private void insertClients() {
        String nom = clientNom.getText();
        String correu = clientCorreu.getText();
        String sql = "INSERT INTO clients (nom, correu) VALUES (?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nom);
            pstmt.setString(2, correu);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
