package com.codedotorg;

import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args) {
        launch();
    }

    public void start(Stage primaryStage) {
        // PetApp virtualPet = new PetApp(primaryStage, 500, 500);
        PetSelectionScene petSelectionScene = new PetSelectionScene(primaryStage, 500, 500);
        petSelectionScene.startApp();
        
        // virtualPet.startApp("Fido", "Dog");
    }

}