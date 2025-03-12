package com.project1.project1.view;

//Imports
import com.project1.project1.controller.StageController;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

//Class that represents the start screen of the game
public class StartScreen extends Stage {
    private VBox root;
    private Scene scene;
    private TextField secretWordTextField;
    private Button playButton;
    private StageController stageController;

    //Constructor of the class
    public StartScreen() {
        //The root are initialized with his properties
        root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setSpacing(10);
        root.setPadding(new javafx.geometry.Insets(10));
        root.backgroundProperty().setValue(new javafx.scene.layout.Background(new javafx.scene.layout.BackgroundFill(Color.web("#222436"), null, null)));

        scene = new Scene(root, 660, 330);

        initStartScreen();
        showStartScreen();
        initController();
    }

    //Method to initialize the start screen
    private void initStartScreen() {
        //The title of the game is shown in the start screen
        setTitle("Miniproyecto 1");

        //The stage is set as not resizable
        setResizable(false);

        //The icon of the game is set
        getIcons().add(new Image(String.valueOf(getClass().getResource("/com/project1/Eclipse Lunar.png"))));

        //The scene is set in the stage
        setScene(scene);

        //The stage is shown
        show();
    }

    private void showStartScreen() {
        //The image (same as icon) is shown in the start screen
        Image image = new Image(getClass().getResourceAsStream("/com/project1/Eclipse Lunar.png"));
        ShowImage(image);

        //The title of the game is shown in the start screen and styled
        Label titleLabel = new Label("Bienvenido al juego \"Eclipse Lunar\"");
        titleLabel.setTextFill(Color.WHITE);
        titleLabel.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 16));

        //The label for the user instructions who are shown in the start screen and styled
        Label secretWordLabel = new Label("Digite la palabra secreta");
        secretWordLabel.setTextFill(Color.WHITE);
        secretWordLabel.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 12));

        //The textfield for the secret word is shown in the start screen and styled
        secretWordTextField = new TextField();
        secretWordTextField.setPrefWidth(200);
        secretWordTextField.setMinWidth(150);
        secretWordTextField.setMaxWidth(300);
        secretWordTextField.backgroundProperty().setValue(new Background(new BackgroundFill(Color.web("#d2daeb"), new CornerRadii(5), null)));
        secretWordTextField.setBorder(new Border(new BorderStroke(Color.web("#8ea2cc"), BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(2))));

        //The button to start the game is shown in the start screen
        //todo Set the button to be disabled when the textfield is empty
        //todo Style the button
        playButton = new Button("Iniciar");

        //The elements are added to the root
        root.getChildren().addAll(titleLabel, secretWordLabel,secretWordTextField, playButton);
    }

    //Method to show an image in the start screen
    private void ShowImage(Image image) {
        Label imageLabel = new Label();
        imageLabel.setGraphic(new javafx.scene.image.ImageView(image));
        root.getChildren().add(imageLabel);
    }

    //Method to initialize the controller
    public void initController() {
        stageController = new StageController(playButton, secretWordTextField);
    }
}
