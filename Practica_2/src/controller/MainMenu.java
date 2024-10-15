package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;

public class MainMenu {

    @FXML
    private void carregarExercici1(ActionEvent event) {
        carregarExercici("/view/Exercici_01.fxml", "Practica 2 - Exercici 1", event);
    }

    @FXML
    private void carregarExercici2(ActionEvent event) {
        carregarExercici("/view/Exercici_02.fxml", "Practica 2 - Exercici 2", event);
    }

    @FXML
    private void carregarExercici3(ActionEvent event) {
        carregarExercici("/view/Exercici_03.fxml", "Practica 2 - Exercici 3", event);
    }

    private void carregarExercici(String fxmlPath, String title, ActionEvent event) {
        try {
            // Obtenim l'stage actual des de l'event
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource(fxmlPath));
            stage.setTitle(title);
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void tornarAlMenuPrincipal(Stage stage) {
        try {
            Parent root = FXMLLoader.load(MainMenu.class.getResource("/view/MainMenu.fxml"));
            stage.setScene(new Scene(root));
            stage.setTitle("Practica 2 - Main Menu");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
