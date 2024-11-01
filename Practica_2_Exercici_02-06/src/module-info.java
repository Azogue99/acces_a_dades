module Practica_2 {
	// JavaFX
    requires javafx.controls;
    requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.base;
	
	// Java SQL
	requires java.sql;
    
    opens application to javafx.fxml;
    opens controller to javafx.fxml;
    opens objects to javafx.base;
    
    exports application;
    exports controller;
    exports objects;
}
