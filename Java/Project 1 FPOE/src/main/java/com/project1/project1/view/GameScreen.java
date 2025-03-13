package com.project1.project1.view;

import com.project1.project1.model.GameStage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class GameScreen extends Stage implements IImage {

    private GameStage gameStage;
    private VBox root;
    private HBox hBox;
    private Scene scene;
    private TextField userLetterTextField;
    private Label[] GuessedWordLabel;
    private Label errorLabel;

    public GameScreen(GameStage gameStage) {
        //The root is initialized with its properties
        this.gameStage = gameStage;
        root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setSpacing(10);
        root.setPadding(new javafx.geometry.Insets(10));
        root.backgroundProperty().setValue(new Background(new BackgroundFill(Color.web("#222436"), null, null)));

        //The scene is initialized with the root and its properties
        scene = new Scene(root, 660, 330);

        //
        initGameScreen();
        showGameScreen();
    }

    private void initGameScreen() {
        setTitle("Miniproyecto 1");
        setResizable(false);
        setScene(scene);
        show();
    }

    private void showGameScreen() {
        // Title label
        Label titleLabel = new Label("Eclipse Lunar");
        titleLabel.setTextFill(Color.WHITE);
        titleLabel.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 16));

        // Image Label
        switch (gameStage.GetAttempts()) {
            case 0:
                ShowImage(new Image(getClass().getResourceAsStream("/com/project1/Luna Nueva.png")));
                break;
            case 1:
                ShowImage(new Image(getClass().getResourceAsStream("/com/project1/Luna Menguante.png")));
                break;
            case 2:
                ShowImage(new Image(getClass().getResourceAsStream("/com/project1/Luna Cuarto Menguante.png")));
                break;
            case 3:
                ShowImage(new Image(getClass().getResourceAsStream("/com/project1/Luna Gibosa Menguante.png")));
                break;
            case 4:
                ShowImage(new Image(getClass().getResourceAsStream("/com/project1/Luna Llena.png")));
                break;
            case 5:
                ShowImage(new Image(getClass().getResourceAsStream("/com/project1/Luna Gibosa Creciente.png")));
                break;
            case 6:
                ShowImage(new Image(getClass().getResourceAsStream("/com/project1/Luna Cuarto Creciente.png")));
                break;
            case 7:
                ShowImage(new Image(getClass().getResourceAsStream("/com/project1/Luna Creciente.png")));
                break;
            case 8:
                ShowImage(new Image(getClass().getResourceAsStream("/com/project1/Luna Nueva.png")));
                break;
        }

        //luna nueva, creciente, cuarto creciente, luna
        //gibosa creciente, luna llena, luna gibosa menguante, cuarto menguante y luna
        //menguante

        // HBox to contain GuessedWordLabel
        hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(10);

        // User letter text field
        userLetterTextField = new TextField();
        userLetterTextField.setPromptText("Ingrese una letra");
        userLetterTextField.setMaxWidth(100);

        // Error label
        errorLabel = new Label();
        errorLabel.setTextFill(Color.RED);

        //
        hBox.getChildren().addAll();

        // Adding the title label and the HBox to the root
        root.getChildren().addAll(titleLabel, hBox);
    }


    @Override
    public void ShowImage(Image image) {
        Label imageLabel = new Label();
        imageLabel.setGraphic(new javafx.scene.image.ImageView(image));
        root.getChildren().add(imageLabel);
    }
}
