package com.project1.project1.view;

//Imports
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
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

//Class that represents the start screen of the game
public class StartScreen extends Stage implements IImage{
    private VBox root;
    private Scene scene;
    private TextField secretWordTextField;
    private Button playButton;
    private Label errorLabel;

    //Constructor of the class
    public StartScreen() {
        //The root is initialized with its properties
        root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setSpacing(10);
        root.setPadding(new javafx.geometry.Insets(10));
        root.backgroundProperty().setValue(new Background(new BackgroundFill(Color.web("#222436"), null, null)));

        //The scene is initialized with the root and its properties
        scene = new Scene(root, 660, 330);

        //The start screen is initialized
        initStartScreen();
        showStartScreen();
    }

    //Method to initialize the start screen
    private void initStartScreen() {
        setTitle("Miniproyecto 1");
        setResizable(false);
        getIcons().add(new Image(String.valueOf(getClass().getResource("/com/project1/Eclipse Lunar.png"))));
        setScene(scene);
        show();
    }

    //Method to show the start screen
    private void showStartScreen() {
        // The image (same as icon) is shown in the start screen
        Image image = new Image(getClass().getResourceAsStream("/com/project1/Eclipse Lunar.png"));
        showImage(image);

        // Title label
        Label titleLabel = new Label("Bienvenido al juego \"Eclipse Lunar\"");
        titleLabel.setTextFill(Color.WHITE);
        titleLabel.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 16));

        // Secret word label
        Label secretWordLabel = new Label("Digite la palabra secreta");
        secretWordLabel.setTextFill(Color.WHITE);
        secretWordLabel.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 12));

        // Error message label (hidden by default)
        errorLabel = new Label();
        errorLabel.setTextFill(Color.RED);
        errorLabel.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 12));

        // Secret word textfield
        secretWordTextField = new TextField();
        secretWordTextField.setPrefWidth(200);
        secretWordTextField.setMinWidth(150);
        secretWordTextField.setMaxWidth(300);
        secretWordTextField.setAlignment(Pos.CENTER);
        secretWordTextField.backgroundProperty().setValue(new Background(new BackgroundFill(Color.web("#555fa0"), new CornerRadii(5), null)));
        secretWordTextField.setBorder(new Border(new BorderStroke(Color.web("#9e53e2"), BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(2))));
        secretWordTextField.setFont(Font.font("Verdana"));
        secretWordTextField.setStyle("-fx-text-fill: white"); // I don't know is this is allowed but this is the only way I found to change the text color in the textfield

        // Play button (disabled initially)
        playButton = new Button("Iniciar");
        playButton.setBackground(new Background(new BackgroundFill(Color.web("#9e53e2"), new CornerRadii(10), null)));
        playButton.setBorder(new Border(new BorderStroke(Color.web("#9e53e2"), BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(2))));
        playButton.setTextFill(Color.WHITE);
        playButton.setDisable(true); // Disabled by default

        // Real-time validation
        secretWordTextField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (isValidWord(newValue)) {
                    errorLabel.setText(""); // Remove error message
                    playButton.setDisable(false);
                } else {
                    errorLabel.setText("Palabra inválida: solo letras permitidas.");
                    playButton.setDisable(true);
                }
            }
        });

        // Add elements to root
        root.getChildren().addAll(titleLabel, secretWordLabel, secretWordTextField, errorLabel, playButton);
    }

    // Method to validate the secret word (only letters)
    private boolean isValidWord(String word) {
        return word.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ]*+"); // Only allows uppercase letters lowercase letters and vocals with accents.
    }

    public TextField getSecretWordTextField() {
        return secretWordTextField;
    }

    public Button getPlayButton() {
        return playButton;
    }

    public Label getErrorLabel() {
        return errorLabel;
    }

    // Method to show the image
    @Override
    public void showImage(Image image) {
        Label imageLabel = new Label();
        imageLabel.setGraphic(new javafx.scene.image.ImageView(image));
        root.getChildren().add(imageLabel);
    }

    @Override
    public void showImage(Label label, Image image) {}
}
