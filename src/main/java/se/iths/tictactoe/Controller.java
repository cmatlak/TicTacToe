package se.iths.tictactoe;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {
    private Model model = new Model();
@FXML
private Button button00;
@FXML
private Button button01;
@FXML
private Button button02;
@FXML
private Button button10;
@FXML
private Button button11;
@FXML
private Button button12;
@FXML
private Button button20;
@FXML
private Button button21;
@FXML
private Button button22;

private StringProperty currentPlayer = new SimpleStringProperty("X");

    public void handleButtonClick(ActionEvent actionEvent) {
Button clickedButton = (Button) actionEvent.getSource();

if (clickedButton.getText().isEmpty()){
    clickedButton.setText(currentPlayer.get());
    currentPlayer.set(currentPlayer.get().equals("X") ? "O":"X");
}
    }

    public void initialize() {
button00.textProperty().bind(currentPlayer);
button01.textProperty().bind(currentPlayer);
button02.textProperty().bind(currentPlayer);
button10.textProperty().bind(currentPlayer);
button11.textProperty().bind(currentPlayer);
button12.textProperty().bind(currentPlayer);
button20.textProperty().bind(currentPlayer);
button21.textProperty().bind(currentPlayer);
button22.textProperty().bind(currentPlayer);
    }
}
