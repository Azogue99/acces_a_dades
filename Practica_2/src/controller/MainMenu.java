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
    private void carregarExercici2(ActionEvent event) {
        carregarExercici("/view/Exercici_02.fxml", "Practica 2 - Exercici 2", event);
    }

    @FXML
    private void carregarExercici3(ActionEvent event) {
        carregarExercici("/view/Exercici_03.fxml", "Practica 2 - Exercici 3", event);
    }

    @FXML
    private void carregarExercici4(ActionEvent event) {
        carregarExercici("/view/Exercici_04.fxml", "Practica 2 - Exercici 4", event);
    }
    
    @FXML
    private void carregarExercici5(ActionEvent event) {
        carregarExercici("/view/Exercici_05.fxml", "Practica 2 - Exercici 5", event);
    }
    
    @FXML
    private void carregarExercici6(ActionEvent event) {
        carregarExercici("/view/Exercici_06.fxml", "Practica 2 - Exercici 6", event);
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
            stage.setTitle("Practica 2");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
