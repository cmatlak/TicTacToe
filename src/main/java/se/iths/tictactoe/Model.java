package se.iths.tictactoe;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.Arrays;

public class Model {
    private final IntegerProperty draws = new SimpleIntegerProperty(0);
    private final IntegerProperty xWins = new SimpleIntegerProperty(0);
    private final IntegerProperty oWins = new SimpleIntegerProperty(0);

    private final String[][] gameBoard = new String[3][3];
    private final Button[][] buttons;
    private String currentPlayer = "";


    public Model(Button[][] buttons) {
        this.buttons = buttons;

        initializeGameBoard();
    }

    public String[][] getGameBoard() {
        return gameBoard;
    }
    public int getDraws(){
        return draws.get();
    }
    public IntegerProperty drawsProperty() {
        return draws;
    }
    public void incrementDraws(){
        int currentDraws = getDraws();
        draws.set(currentDraws + 1);
        System.out.println("Draws incremented. new values: " + (currentDraws + 1));
    }

    public IntegerProperty xWinsProperty() {
        return xWins;
    }

    public IntegerProperty oWinsProperty() {
        return oWins;
    }

    public void incrementXWins() {
        xWins.set(xWins.get() + 1);
    }

    public void incrementOWins() {
        oWins.set(oWins.get() + 1);
    }

    public void incrementWins(String player) {
        if (player.equals("X")) {
            incrementXWins();
        } else if (player.equals("O")) {
            incrementOWins();

        }
    }

    private void initializeGameBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                gameBoard[row][col] = "";
            }
        }
    }

    public String getCurrentPlayer() {
        return currentPlayer;
    }

    public void makeMove(int row, int col) {
        if (gameBoard[row][col].isEmpty() && buttons[row][col].getText().isEmpty()) {
            currentPlayer = (currentPlayer.equals("X")) ? "O" : "X";
            gameBoard[row][col] = currentPlayer;
            buttons[row][col].setText(currentPlayer);
            buttons[row][col].setDisable(true);
        }
    }

    public String checkForWinner() {
        String winnerX = checkWinnerForPlayer("X");
        String winnerO = checkWinnerForPlayer("O");

        if (winnerX != null) {
            return winnerX;
        } else return winnerO;
    }

    private String checkWinnerForPlayer(String player) {
        String playerSymbol = player.repeat(3);

        for (int i = 0; i < 3; i++) {
            String horizontalLine = String.join("", gameBoard[i]);
            String verticalLine = String.join("", gameBoard[0][i], gameBoard[1][i], gameBoard[2][i]);

            if (horizontalLine.equals(playerSymbol) || verticalLine.equals(playerSymbol)) {
                return player;
            }
        }

        String diagonal1 = String.join("", gameBoard[0][0], gameBoard[1][1], gameBoard[2][2]);
        String diagonal2 = String.join("", gameBoard[0][2], gameBoard[1][1], gameBoard[2][0]);

        if (diagonal1.equals(playerSymbol) || diagonal2.equals(playerSymbol)) {
            return player;
        }

        return null;
    }

    public String checkGameResult() {

        return checkForWinner();
    }


    public boolean isBoardFull() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (gameBoard[row][col].isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }

    public void resetGame() {
        initializeGameBoard();
        currentPlayer = "";
    }




}