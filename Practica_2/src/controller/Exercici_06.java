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
import javafx.scene.control.Button;
import javafx.stage.Stage;
import objects.Producte;
import DB.DatabaseConnection;

public class Exercici_06 {

    @FXML
    private ComboBox<Producte> producteComboBox;

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

    // Mètode per eliminar un producte
    @FXML
    private void eliminarProducte() {
        Producte producteSeleccionat = producteComboBox.getSelectionModel().getSelectedItem();

        if (producteSeleccionat == null) {
            mostrarError("Si us plau, selecciona un producte per eliminar.");
            return;
        }

        try {
            // Primer eliminem els detalls associats a les comandes d'aquest producte
            String deleteDetallsSQL = "DELETE FROM detalls_comanda WHERE id_producte = (SELECT id FROM productes WHERE nom = ?)";
            PreparedStatement pstmtDetalls = connection.prepareStatement(deleteDetallsSQL);
            pstmtDetalls.setString(1, producteSeleccionat.getNom());
            pstmtDetalls.executeUpdate();

            // Ara eliminem el producte
            String deleteProducteSQL = "DELETE FROM productes WHERE nom = ?";
            PreparedStatement pstmtProducte = connection.prepareStatement(deleteProducteSQL);
            pstmtProducte.setString(1, producteSeleccionat.getNom());
            pstmtProducte.executeUpdate();

            producteComboBox.getItems().remove(producteSeleccionat);  // Eliminem el producte del ComboBox
            mostrarMissatge("Producte eliminat correctament!");

        } catch (SQLException e) {
            mostrarError("Error al eliminar el producte: " + e.getMessage());
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
