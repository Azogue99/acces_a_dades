package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import objects.Producte;
import DB.DatabaseConnection;

public class Exercici_03 {

    @FXML
    private TextField clientIDField;

    @FXML
    private ComboBox<Producte> producteComboBox;

    @FXML
    private TextField quantitatField;

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
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

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


    // Mètode per afegir la comanda i els seus detalls
    @FXML
    private void afegirComanda() {
        String clientIDText = clientIDField.getText();
        String quantitatText = quantitatField.getText();
        Producte producteSeleccionat = producteComboBox.getSelectionModel().getSelectedItem();

        if (clientIDText.isEmpty() || quantitatText.isEmpty() || producteSeleccionat == null) {
            mostrarError("Si us plau, completa tots els camps.");
            return;
        }

        try {
            // Iniciem una transacció
            connection.setAutoCommit(false);

            // Inserir la comanda a la taula `comandes`
            String insertComandaSQL = "INSERT INTO comandes (data_comanda, client_id) VALUES (?, ?)";
            PreparedStatement pstmtComanda = connection.prepareStatement(insertComandaSQL, Statement.RETURN_GENERATED_KEYS);
            pstmtComanda.setDate(1, new Date(System.currentTimeMillis()));
            pstmtComanda.setInt(2, Integer.parseInt(clientIDText));  // Client ID de la interfície
            pstmtComanda.executeUpdate();

            // Recuperar l'ID generat per la nova comanda
            ResultSet rs = pstmtComanda.getGeneratedKeys();
            int idComanda = 0;
            if (rs.next()) {
                idComanda = rs.getInt(1);
            }

            // Inserir els detalls de la comanda a la taula `detalls_comanda`
            String insertDetallsSQL = "INSERT INTO detalls_comanda (id_comanda, id, quantitat) VALUES (?, ?, ?)";
            PreparedStatement pstmtDetalls = connection.prepareStatement(insertDetallsSQL);

            // Afegim els productes associats a la comanda
            pstmtDetalls.setInt(1, idComanda);
            pstmtDetalls.setInt(2, producteSeleccionat.getId());
            pstmtDetalls.setInt(3, Integer.parseInt(quantitatText));
            pstmtDetalls.executeUpdate();

            // Confirmem la transacció
            connection.commit();
            mostrarMissatge("Comanda afegida correctament!");

        } catch (SQLException e) {
            try {
                connection.rollback();  // Revertim els canvis en cas d'error
                mostrarError("Error al afegir la comanda: " + e.getMessage());
            } catch (SQLException rollbackEx) {
                mostrarError("Error al revertir la transacció: " + rollbackEx.getMessage());
            }
        } finally {
            try {
                connection.setAutoCommit(true);  // Tornem a activar l'auto-commit
            } catch (SQLException e) {
                mostrarError("Error al restablir l'auto-commit: " + e.getMessage());
            }
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
