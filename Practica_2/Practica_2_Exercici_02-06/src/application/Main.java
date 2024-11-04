package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


//Classe principal que hereta de Application per crear una aplicacio JavaFX
public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/view/MainMenu.fxml")); 
        stage.setTitle("Practica 2"); 
        stage.setScene(new Scene(root));
        stage.show();
    }


    @Override
    public void stop() throws Exception {
        // Codi per tancar recursos si cal
    }

    // Metode main per iniciar l'aplicació
    public static void main(String[] args) {
        launch(args); // Inicia l'aplicació JavaFX
    }
}