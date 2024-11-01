package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import objects.Producte;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Exercici_03 {

    @FXML
    private ComboBox<String> categoriaComboBox;

    @FXML
    private TableView<Producte> productesTableView;

    @FXML
    private TableColumn<Producte, String> nomColumn;

    @FXML
    private TableColumn<Producte, Double> preuColumn;

    // Constructor
    public Exercici_03() {
        // Iniciem la connexió amb la base de dades si cal
    }
    
    @FXML
    private void tornarAlMenu(ActionEvent event) {
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        MainMenu.tornarAlMenuPrincipal(stage);
    }

    @FXML
    public void initialize() {
        // Inicialitzem les columnes del TableView
        nomColumn.setCellValueFactory(new PropertyValueFactory<>("nom"));
        preuColumn.setCellValueFactory(new PropertyValueFactory<>("preu"));

        // Carregar categories al ComboBox
        carregarCategories();
    }

    private void carregarCategories() {
        // Carregar les categories a partir de la base de dades
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/botiga", "root", "")) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT nom FROM categories");
            while (rs.next()) {
                categoriaComboBox.getItems().add(rs.getString("nom"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void consultarProductes() {
        String selectedCategory = categoriaComboBox.getSelectionModel().getSelectedItem();
        if (selectedCategory != null) {
            productesTableView.getItems().clear(); // Esborra la taula abans de carregar nous productes
            List<Producte> productes = obtenirProductes(selectedCategory);
            productesTableView.getItems().addAll(productes);
        }
    }

    private List<Producte> obtenirProductes(String categoria) {
        List<Producte> productes = new ArrayList<>();
        String query = "SELECT p.nom AS nom, p.preu AS preu, c.nom AS categoria FROM productes p " +
                       "JOIN categories c ON p.id_categoria = c.id WHERE c.nom = ?";
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/botiga", "root", "");
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, categoria);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Producte producte = new Producte(rs.getString("nom"), rs.getDouble("preu"), rs.getString("categoria"));
                productes.add(producte);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productes;
    }
}
