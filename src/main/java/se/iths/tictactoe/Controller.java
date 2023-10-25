package se.iths.tictactoe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private Label draws;
    private Model model;
    private boolean gameEnded = false;
    public TextField scoreBoard;
    @FXML
    private Label xScoreLabel;
    @FXML
    private Label oScoreLabel;
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

    private final Button[][] buttons = new Button[3][3];

    public void setModel(Model model) {
        this.model = model;
        xScoreLabel.textProperty().bind(model.xWinsProperty().asString("X Wins %d"));
        oScoreLabel.textProperty().bind(model.oWinsProperty().asString("O Wins %d"));
        draws.textProperty().bind(model.drawsProperty().asString("Draws %d"));

    }

    @FXML
    public void initialize() {
        model = new Model(buttons);
        setModel(model);
        buttons[0][0] = button00;
        buttons[0][1] = button01;
        buttons[0][2] = button02;
        buttons[1][0] = button10;
        buttons[1][1] = button11;
        buttons[1][2] = button12;
        buttons[2][0] = button20;
        buttons[2][1] = button21;
        buttons[2][2] = button22;
    }

    @FXML
    public void handleButtonClick(ActionEvent actionEvent) {
        if (gameEnded) {
            return;
        }

        Button clickedButton = (Button) actionEvent.getSource();
        int row = Character.getNumericValue(clickedButton.getId().charAt(6));
        int col = Character.getNumericValue(clickedButton.getId().charAt(7));

        model.makeMove(row, col);
        clickedButton.setText(model.getCurrentPlayer());
        clickedButton.setDisable(true);

        String winner = model.checkGameResult();

        if (winner != null) {
           handleWinner(winner);

        } else if (model.isBoardFull()){
            handleDraw();
        }else {
            ComputerPlayer.makeMove(model);
            String computerWinner = model.checkGameResult();

            if (computerWinner != null) {
              handleWinner(computerWinner);

            }else if ( model.isBoardFull()) {
                    handleDraw();

            }

        }
    }


    private void handleWinner(String winner) {
        model.incrementWins(winner);
        scoreBoard.setText(String.format("Winner is: %s", winner));
        gameEnded = true;
    }
    private void handleDraw() {
        scoreBoard.setText("It's a Draw");
        model.incrementDraws();
        gameEnded = true;
    }





    @FXML
    public void handleExitButton() {
        System.exit(0);
    }

    @FXML
    public void handleRestartButton() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
                buttons[i][j].setDisable(false);
            }
        }

        model.resetGame();
        gameEnded = false;
        scoreBoard.setText("");
    }
@FXML
    public void handleRestartAllButton() {
        handleRestartButton();
        model.xWinsProperty().set(0);
        model.oWinsProperty().set(0);
        model.drawsProperty().set(0);
        model.resetGame();

        gameEnded = false;
    }
}