package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import objects.Client;
import objects.Comanda;
import objects.Producte;
import DB.DatabaseConnection;

public class Exercici_04 {

    @FXML
    private ComboBox<Client> clientComboBox;

    @FXML
    private ComboBox<Comanda> comandaComboBox;

    @FXML
    private ComboBox<Producte> producteComboBox;

    @FXML
    private TextField quantitatField;

    private Connection connection;

    // Inicialitza el controlador i carrega clients i productes
    @FXML
    private void initialize() {
        connection = DatabaseConnection.getConnection();
        carregarClients();
        carregarProductes();

        // Afegeix un listener al ComboBox de clients
        clientComboBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                carregarComandes();
            }
        });
    }

    // Carrega la llista de clients des de la base de dades al ComboBox
    private void carregarClients() {
        String query = "SELECT id, nom FROM clients";
        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Client client = new Client(rs.getInt("id"), rs.getString("nom"));
                clientComboBox.getItems().add(client);
            }
        } catch (SQLException e) {
            mostrarError("Error al carregar els clients: " + e.getMessage());
        }
    }
    
    // Carrega la llista de productes des de la base de dades al ComboBox
    private void carregarProductes() {
        String query = "SELECT id, nom, preu, id_categoria FROM productes";
        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Producte producte = new Producte(rs.getString("nom"), rs.getDouble("preu"), rs.getString("id_categoria"));
                producte.setId(rs.getInt("id"));
                producteComboBox.getItems().add(producte);
            }
        } catch (SQLException e) {
            mostrarError("Error al carregar els productes: " + e.getMessage());
        }
    }
    
    // Crea una nova comanda per al client seleccionat
    @FXML
    private void afegirComanda(ActionEvent event) {
        Client clientSeleccionat = clientComboBox.getSelectionModel().getSelectedItem();
        if (clientSeleccionat == null) {
            mostrarError("Selecciona un client per crear una nova comanda.");
            return;
        }
        try {
            String insertComandaSQL = "INSERT INTO comandes (id_client) VALUES (?)";
            PreparedStatement pstmt = connection.prepareStatement(insertComandaSQL);
            pstmt.setInt(1, clientSeleccionat.getId());
            pstmt.executeUpdate();
            mostrarMissatge("Nova comanda creada per a l'usuari: " + clientSeleccionat.getNom());
            carregarComandes();
            
        } catch (SQLException e) {
            mostrarError("Error al crear la comanda: " + e.getMessage());
        }
    }
    
    // Carrega les comandes associades al client seleccionat
    private void carregarComandes() {
        Client clientSeleccionat = clientComboBox.getSelectionModel().getSelectedItem();
        if (clientSeleccionat == null) {
            return;
        }
        String query = "SELECT id FROM comandes WHERE id_client = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, clientSeleccionat.getId());
            try (ResultSet rs = stmt.executeQuery()) {
                comandaComboBox.getItems().clear();
                while (rs.next()) {
                    Comanda comanda = new Comanda(rs.getInt("id"));
                    comandaComboBox.getItems().add(comanda);
                }
            }
        } catch (SQLException e) {
            mostrarError("Error al carregar les comandes: " + e.getMessage());
        }
    }

    // Afegeix un producte a la comanda seleccionada amb la quantitat especificada
    @FXML
    private void afegirProducteComanda(ActionEvent event) {
        Comanda comandaSeleccionada = comandaComboBox.getSelectionModel().getSelectedItem();
        Producte producteSeleccionat = producteComboBox.getSelectionModel().getSelectedItem();
        String quantitatText = quantitatField.getText();
        
        if (comandaSeleccionada == null || producteSeleccionat == null || quantitatText.isEmpty()) {
            mostrarError("Selecciona una comanda, un producte i introdueix la quantitat.");
            return;
        }

        try {
            int quantitat = Integer.parseInt(quantitatText);
            String insertDetallsSQL = "INSERT INTO detalls_comanda (id_comanda, id_producte, quantitat) VALUES (?, ?, ?)";
            PreparedStatement pstmt = connection.prepareStatement(insertDetallsSQL);
            pstmt.setInt(1, comandaSeleccionada.getId());
            pstmt.setInt(2, producteSeleccionat.getId());
            pstmt.setInt(3, quantitat);
            pstmt.executeUpdate();
            mostrarMissatge("Producte afegit a la comanda correctament.");
        } catch (NumberFormatException e) {
            mostrarError("La quantitat ha de ser un número.");
        } catch (SQLException e) {
            mostrarError("Error al afegir el producte a la comanda: " + e.getMessage());
        }
    }

    // Mostra un missatge d'error amb un Alert
    private void mostrarError(String missatge) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setContentText(missatge);
        alert.showAndWait();
    }
    
    // Mostra un missatge d'informació amb un Alert
    private void mostrarMissatge(String missatge) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Info");
        alert.setContentText(missatge);
        alert.showAndWait();
    }

    // Torna al menú principal
    @FXML
    private void tornarAlMenu(ActionEvent event) {
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        MainMenu.tornarAlMenuPrincipal(stage);
    }
}
