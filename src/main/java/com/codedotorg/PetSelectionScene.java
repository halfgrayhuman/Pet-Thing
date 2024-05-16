package com.codedotorg;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javafx.scene.image.ImageView; // Add missing import statement
import javafx.scene.image.Image; // Add missing import statement

public class PetSelectionScene extends PetApp {

    /** The name of the pet provided by the user */
    private String petName;

    /** The type of pet chosen by the user */
    private String petType;

    /**
     * This class represents a scene for selecting a pet. It extends the Scene class and
     * provides a constructor for initializing the pet name and type.
     */
    public PetSelectionScene(Stage window, int width, int height) {
        super(window, width, height);

        petName = "";
        petType = "";
    }

    /**
     * This method starts the application by creating a VBox layout for pet selection
     * and setting it as the scene to be displayed.
     */
    public void startApp() {
        VBox petSelectionLayout = createPetSelectionLayout();
        setAndShowScene(petSelectionLayout);
    }

    /**
     * Sets petName to the name entered by the user
     */
    public void setPetName(String name) {
        petName = name;

        

    }

    /**
     * Sets petType to the type of pet chosen by the user
     */
    public void setPetType(String type) {
        petType = type;



    }

    /**
     * Creates the main layout for the PetSelection scene
     * 
     */

    public VBox createPetSelectionLayout() {
        VBox petSelectionLayout = new VBox(20);
        petSelectionLayout.setAlignment(Pos.CENTER);

        HBox imageLayout = new HBox(20);
        imageLayout.setAlignment(Pos.CENTER);

        ImageView dogImageView = createPetImage("/happy_dog.png");
        ImageView catImageView = createPetImage("/happy_cat.png");

        dogImageView.setOnMouseClicked(event -> {
            setPetType("Dog");
        });
        catImageView.setOnMouseClicked(event -> {
            setPetType("Cat");
        });

        imageLayout.getChildren().addAll(dogImageView, catImageView); // Add dog and cat ImageView to imageLayout

        TextField petNameInput = new TextField();
        petNameInput.setPromptText("Enter pet name");

        petNameInput.textProperty().addListener((observable, oldValue, newValue) -> {
            setPetName(newValue);
        });

        Button submitButton = createSubmitButton();

        petSelectionLayout.getChildren().addAll(imageLayout, petNameInput, submitButton);

        return petSelectionLayout;
    }
    /**
     * Creates the layout for the buttons in the PetSelection scene
     *
     * @return the HBox layout for the buttons
     */
    public HBox createButtonLayout() {
        HBox buttonLayout = new HBox(20);
        buttonLayout.setAlignment(Pos.CENTER);

        Button submitButton = createSubmitButton();

        buttonLayout.getChildren().addAll(submitButton);

        return buttonLayout;
    }

    public ImageView createPetImage(String imageName) {
        if (imageName == null || imageName.isEmpty()) {
            return new ImageView(); // Return an empty ImageView if the image name is null or empty
        }
        
        ImageView petImage = new ImageView(new Image(getClass().getResourceAsStream(imageName)));
        petImage.setFitWidth(200);
        petImage.setFitHeight(200);
        petImage.setPreserveRatio(true);
        petImage.setSmooth(true);
        
        return petImage;

    }
    public Button createSubmitButton() {
        Button submitButton = new Button("Submit");
        submitButton.setOnAction(e -> {
            if (!petName.isEmpty() && !petType.isEmpty()) {
                MainScene mainScene = new MainScene(super.getWindow(), super.getWidth(), super.getHeight(), petName, petType);
                mainScene.showMainScene();
            }
        });
        return submitButton;
    }
}
