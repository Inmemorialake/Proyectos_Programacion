package com.project1.project1.view;

/**
 * Class that represents the game screen of the game
 * @autor: Inmemorialake (2416541)
 */

//Imports
import com.project1.project1.model.GameStage;
import javafx.geometry.Insets;
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

public class GameScreen extends Stage implements IImage {

    private GameStage gameStage;
    private VBox root;
    private HBox hBox;
    private Scene scene;
    private TextField userLetterTextField;
    private Label[] guessedWordLabel;
    private Label errorLabel;
    private Label phaseLabel;
    private Label ImageLabel;
    private Label attemptsLabel;
    private String moonPhase;
    private Image moonImage;
    private Button helpButton;


    /**
     * Constructor of the class
     * @param gameStage The game stage
     */
    public GameScreen(GameStage gameStage) {
        //The root is initialized with its properties
        this.gameStage = gameStage;
        root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setSpacing(10);
        root.setPadding(new Insets(10));
        root.backgroundProperty().setValue(new Background(new BackgroundFill(Color.web("#222436"), null, null)));

        //The scene is initialized with the root and its properties
        scene = new Scene(root, 800, 400);

        //The phase of the moon is set
        setPhase();

        //The game screen is initialized
        initGameScreen();

        //The game screen is shown
        showGameScreen();
    }

    /**
     * Method to initialize the game screen
     */
    private void initGameScreen() {
        setTitle("Miniproyecto 1");
        setResizable(false);
        getIcons().add(new Image(String.valueOf(getClass().getResource("/com/project1/Eclipse Lunar.png"))));
        setScene(scene);
        show();
    }

    /**
     * Method to show the game screen
     */
    private void showGameScreen() {
        // Title label
        Label titleLabel = new Label("Eclipse Lunar");
        titleLabel.setTextFill(Color.web("#9e53e2"));
        titleLabel.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 24));
        root.getChildren().add(titleLabel);

        //Label that show the phase of the moon
        phaseLabel = new Label(moonPhase);
        phaseLabel.setTextFill(Color.web("#9e53e2"));
        phaseLabel.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 16));
        phaseLabel.setPadding(new Insets(10, 10, 10, 10));
        root.getChildren().add(phaseLabel);

        //Image label
        ImageLabel = new Label();
        showImage(ImageLabel, moonImage);
        root.getChildren().add(ImageLabel);

        // Attempts label
        attemptsLabel = new Label("Intentos: " + gameStage.getAttempts());
        attemptsLabel.setTextFill(Color.web("#9e53e2"));
        attemptsLabel.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 16));
        root.getChildren().add(attemptsLabel);

        // User letter label
        Label userLetterLabel = new Label("Digite una letra");
        userLetterLabel.setTextFill(Color.web("#9e53e2"));
        userLetterLabel.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 16));
        root.getChildren().add(userLetterLabel);

        // HBox to contain GuessedWordLabel
        hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(10);
        hBox.setPadding(new Insets(10, 10, 10, 10));
        hBox.minHeight(400);

        // Help button
        helpButton = new Button("Ayuda");
        helpButton.setBackground(new Background(new BackgroundFill(Color.web("#9e53e2"), new CornerRadii(10), null)));
        helpButton.setBorder(new Border(new BorderStroke(Color.web("#9e53e2"), BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(2))));
        helpButton.setTextFill(Color.WHITE);
        hBox.getChildren().add(helpButton);

        // Guessed word label
        guessedWordLabel = new Label[gameStage.getSecretWord().length()];
        for (int i = 0; i < gameStage.getSecretWord().length(); i++) {
            guessedWordLabel[i] = new Label("  ");
            guessedWordLabel[i].setTextFill(Color.WHITE);
            guessedWordLabel[i].setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 16));
            guessedWordLabel[i].setBorder(new Border(new BorderStroke(Color.web("#9e53e2"), BorderStrokeStyle.SOLID, new CornerRadii(0), new BorderWidths(0, 0, 2, 0))));
            guessedWordLabel[i].setAlignment(Pos.CENTER);
            guessedWordLabel[i].setMinWidth(30);
            hBox.getChildren().add(guessedWordLabel[i]);
        }

        // Add HBox to root
        root.getChildren().add(hBox);

        // User letter text field configuration (please kill me)
        userLetterTextField = new TextField();
        userLetterTextField.setPrefWidth(30);
        userLetterTextField.setMinWidth(30);
        userLetterTextField.setMaxWidth(50);
        userLetterTextField.setAlignment(Pos.CENTER);
        userLetterTextField.backgroundProperty().setValue(new Background(new BackgroundFill(Color.web("#555fa0"), new CornerRadii(5), null)));
        userLetterTextField.setBorder(new Border(new BorderStroke(Color.web("#9e53e2"), BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(2))));
        userLetterTextField.setFont(Font.font("Verdana"));
        userLetterTextField.setStyle("-fx-text-fill: #FFF"); // I don't know is this is allowed but this is the only way I found to change the text color in the textfield
        root.getChildren().add(userLetterTextField);



        // Error label
        errorLabel = new Label();
        errorLabel.setTextFill(Color.RED);
        errorLabel.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 14));
        root.getChildren().add(errorLabel);
    }

    /**
     * Method to show the image
     * @param image The image to show
     */

    @Override
    public void showImage(Image image) {};

    @Override
    public void showImage(Label label, Image image) {
        label.setGraphic(new javafx.scene.image.ImageView(image));
    }

    /**
     * Method to set the phase of the moon
     */
    public void setPhase(){
        switch (gameStage.getAttempts()){
            case 0:
                moonPhase = "Luna Nueva";
                moonImage = new Image(String.valueOf(getClass().getResource("/com/project1/Luna Nueva.png")));
                break;
            case 1:
                moonPhase = "Luna Menguante";
                moonImage = new Image(String.valueOf(getClass().getResource("/com/project1/Luna Menguante.png")));
                break;
            case 2:
                moonPhase = "Cuarto Menguante";
                moonImage = new Image(String.valueOf(getClass().getResource("/com/project1/Luna Cuarto Menguante.png")));
                break;
            case 3:
                moonPhase = "Luna Gibosa Menguante";
                moonImage = new Image(String.valueOf(getClass().getResource("/com/project1/Luna Gibosa Menguante.png")));
                break;
            case 4:
                moonPhase = "Luna Llena";
                moonImage = new Image(String.valueOf(getClass().getResource("/com/project1/Luna Llena.png")));
                break;
            case 5:
                moonPhase = "Luna Gibosa Creciente";
                moonImage = new Image(String.valueOf(getClass().getResource("/com/project1/Luna Gibosa Creciente.png")));
                break;
            case 6:
                moonPhase = "Cuarto Creciente";
                moonImage = new Image(String.valueOf(getClass().getResource("/com/project1/Luna Cuarto Creciente.png")));
                break;
            case 7:
                moonPhase = "Luna Creciente";
                moonImage = new Image(String.valueOf(getClass().getResource("/com/project1/Luna Creciente.png")));
                break;
            case 8:
                moonPhase = "Luna Nueva";
                moonImage = new Image(String.valueOf(getClass().getResource("/com/project1/Luna Nueva.png")));
                break;
            default:
                moonPhase = "No deberias estar viendo esto, si por algun motivo se muestra en pantalla recuerde muy bien que hizo," +
                            " comuniquese con el propio y empiece a rezar (hablar con el propio a quien el propio le habla)";
                moonImage = new Image(String.valueOf(getClass().getResource("/com/project1/Eclipse Lunar.png")));
        }
    }

    /**
     * Method to update the game screen
     */
    public void updateGameScreen() {
        for (int i = 0; i < gameStage.getSecretWord().length(); i++) {
            if (gameStage.getLetterFound()[i]) {
                guessedWordLabel[i].setText(String.valueOf(gameStage.getSecretWord().charAt(i)));
            } else {
                guessedWordLabel[i].setText(" ");
            }
        }
        userLetterTextField.clear();
        errorLabel.setText("");

        if (gameStage.isGameOver()) {
            showGameOver();
        }

        setPhase();
        showImage(ImageLabel, moonImage);
        phaseLabel.setText(moonPhase);
        attemptsLabel.setText("Intentos: " + gameStage.getAttempts());

    }

    /**
     * Method to show the game over
     */
    public void showGameOver() {
        if (gameStage.isWordGuessed()) {
            errorLabel.setText("¡Felicidades! Has adivinado la palabra secreta");
            errorLabel.setTextFill(Color.GREEN);
        } else {
            errorLabel.setText("¡Lo siento! Has perdido. La palabra secreta era: " + gameStage.getSecretWord());
        }
        userLetterTextField.setDisable(true);
    }

    public Button getHelpButton() {
        return helpButton;
    }

    public Label[] getWordLabel() {
        return guessedWordLabel;
    }

    public TextField getUserLetterTextField() {
        return userLetterTextField;
    }

    public Label getErrorLabel() {
        return errorLabel;
    }

}
