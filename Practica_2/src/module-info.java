module Practica_2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
	requires javafx.graphics;
    
    opens application to javafx.fxml;
    opens controller to javafx.fxml;
    
    exports application;
}
