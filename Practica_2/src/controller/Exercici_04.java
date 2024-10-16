package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import objects.Producte;
import DB.DatabaseConnection;

public class Exercici_04 {

    @FXML
    private ComboBox<Producte> producteComboBox;

    @FXML
    private TextField preuField;

    private Connection connection;

    @FXML
    private void tornarAlMenu(ActionEvent event) {
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        MainMenu.tornarAlMenuPrincipal(stage);
    }

    // Mètode per inicialitzar la connexió amb la base de dades
    public void initialize() {
        connection = DatabaseConnection.getConnection();
        carregarProductes();

        // Afegir listener per carregar el preu quan es selecciona un producte
        producteComboBox.setOnAction(event -> carregarPreu());
    }

    // Mètode per carregar els productes al ComboBox
    private void carregarProductes() {
        try {
            String query = "SELECT id, nom, preu, id_categoria FROM productes";
            PreparedStatement stmt = connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int idProducte = rs.getInt("id");
                String nomProducte = rs.getString("nom");
                double preuProducte = rs.getDouble("preu");
                String categoriaProducte = rs.getString("id_categoria");

                Producte producte = new Producte(nomProducte, preuProducte, categoriaProducte);
                producteComboBox.getItems().add(producte);
            }
        } catch (SQLException e) {
            mostrarError("Error al carregar els productes: " + e.getMessage());
        }
    }

    // Mètode per carregar el preu del producte seleccionat
    private void carregarPreu() {
        Producte producteSeleccionat = producteComboBox.getSelectionModel().getSelectedItem();
        if (producteSeleccionat != null) {
            preuField.setText(String.valueOf(producteSeleccionat.getPreu()));
        }
    }

    // Mètode per actualitzar el preu del producte
    @FXML
    private void actualitzarPreu() {
        Producte producteSeleccionat = producteComboBox.getSelectionModel().getSelectedItem();
        String nouPreuText = preuField.getText();

        if (producteSeleccionat == null || nouPreuText.isEmpty()) {
            mostrarError("Si us plau, selecciona un producte i introdueix el nou preu.");
            return;
        }

        try {
            double nouPreu = Double.parseDouble(nouPreuText);
            String query = "UPDATE productes SET preu = ? WHERE nom = ?";
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setDouble(1, nouPreu);
            pstmt.setString(2, producteSeleccionat.getNom());
            pstmt.executeUpdate();
            mostrarMissatge("Preu actualitzat correctament!");
        } catch (SQLException e) {
            mostrarError("Error al actualitzar el preu: " + e.getMessage());
        } catch (NumberFormatException e) {
            mostrarError("Si us plau, introdueix un preu vàlid.");
        }
    }

    // Mètode per mostrar missatges d'error
    private void mostrarError(String missatge) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setContentText(missatge);
        alert.showAndWait();
    }

    // Mètode per mostrar missatges informatius
    private void mostrarMissatge(String missatge) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Info");
        alert.setContentText(missatge);
        alert.showAndWait();
    }
}
