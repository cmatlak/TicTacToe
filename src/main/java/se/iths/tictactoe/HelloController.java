package se.iths.tictactoe;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HelloController {
public Button button1;

@FXML
    public Label welcomeText;
    public Label anotherLabel;

private Model model = new Model();
 public void initialize() {
 }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to my hell");
    }
}