//package se.iths.tictactoe;
//
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.control.TextField;
//
//
//public class Controller {
//    @FXML
//    private TextField scoreBoard;
//    @FXML
//    private Label oScoreLabel;
//    @FXML
//    private Label xScoreLabel;
//    @FXML
//    private Button ResetButton;
//    @FXML
//    private Button exitButton;
//    @FXML
//    private Button button00;
//    @FXML
//    private Button button01;
//    @FXML
//    private Button button02;
//    @FXML
//    private Button button10;
//    @FXML
//    private Button button11;
//    @FXML
//    private Button button12;
//    @FXML
//    private Button button20;
//    @FXML
//    private Button button21;
//    @FXML
//    private Button button22;
//
//    private final Button[][] buttons = new Button[3][3];
//    private final Model model = new Model(buttons);
//    private boolean gameEnded = false;
//
//    public void initialize() {
//        System.out.println("initialized");
//        xScoreLabel.setText("X Wins: 0");
//        oScoreLabel.setText("O wins: 0");
//        buttons[0][0] = button00;
//        buttons[0][1] = button01;
//        buttons[0][2] = button02;
//        buttons[1][0] = button10;
//        buttons[1][1] = button11;
//        buttons[1][2] = button12;
//        buttons[2][0] = button20;
//        buttons[2][1] = button21;
//        buttons[2][2] = button22;
//    }
//
//
//    public void handleButtonClick(ActionEvent actionEvent) {
//        System.out.println("Handle button clicked");
//        if (gameEnded)  return; {
//            Button clickedButton = (Button) actionEvent.getSource();
//
//            clickedButton.setDisable(true);
//            int row = Character
//                    .getNumericValue(clickedButton
//                            .getId()
//                            .charAt(6));
//            int col = Character
//                    .getNumericValue(clickedButton
//                            .getId()
//                            .charAt(7));
//            System.out.println(" clicked" + row + col);
//
//            model.makeMove(row, col);
//            System.out.println("player" + model.getCurrentPlayer());
//            clickedButton
//                    .setText(model
//                            .getCurrentPlayer());
//            String winner = model
//                    .checkGameResult();
//            System.out.println("gameresult" + model.checkGameResult());
//            boardUpdate(winner);
//            System.out.println("make move" + row + col);
//            if (winner != null && !model.isBoardFull()) {
//               gameEnded = true;
//                System.out.println("board" + model.isBoardFull());
//            } else {
//                ComputerPlayer.makeMove(model);
//                System.out.println("comp" );
//                String computerWinner = model.checkGameResult();
//                System.out.println("check" + model.checkForWinner());
//                boardUpdate(computerWinner);
//
//                if (computerWinner != null || model.isBoardFull()) {
//                    gameEnded = true;
//                }
//                System.out.println("last check " + winner);
//            }
//
//        }
//    }
//
//    public void boardUpdate(String result) {
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//
//            xScoreLabel.setText("X wins: " + model.getXwins());
//            oScoreLabel.setText("O wins: " + model.getOwins());
//
//        }
//        //if (result != null) {
//
//        }
//    }
//
//
//    public void handleExitButton(ActionEvent actionEvent) {
//        System.exit(0);
//    }
//
//    public void handleRestartButton(ActionEvent actionEvent) {
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//                buttons[i][j].setText("");
//                buttons[i][j].setDisable(false);
//
//            }
//
//        }
//        model.resetGame();
//        scoreBoard.setText("");
//        gameEnded = false;
//
//    }
//}
package se.iths.tictactoe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private Label draws;
    @FXML
    private Button resetAll;
    @FXML
    private Button ResetButton;
    @FXML
    private Button exitButton;
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
            model.incrementWins(winner);
            scoreBoard.setText("Winner is: " + winner);
            gameEnded = true;

        } else if (model.isBoardFull()){
            scoreBoard.setText("It´s a draw");
            gameEnded = true;
        }else {
            ComputerPlayer.makeMove(model);
            String computerWinner = model.checkGameResult();

            if (computerWinner != null) {
                model.incrementWins(computerWinner);
            scoreBoard.setText("Winner is: " + computerWinner);
            gameEnded = true;
            }else if ( model.isDraw()) {
                scoreBoard.setText("It´s a Draw");
                 model.incrementDraws();
                gameEnded = true;
            }

        }
    }

    @FXML
    public void handleExitButton(ActionEvent actionEvent) {
        System.exit(0);
    }

    @FXML
    public void handleRestartButton(ActionEvent actionEvent) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
                buttons[i][j].setDisable(false);
            }
        }

        model.resetGame();
        gameEnded = false;
        scoreBoard.setText(" ");
    }

    public void handleRestartAllButton(ActionEvent actionEvent) {
        handleRestartButton(actionEvent);
        model.xWinsProperty().set(0);
        model.oWinsProperty().set(0);
        model.resetGame();
        model.getDraws();
        gameEnded = false;
    }
}