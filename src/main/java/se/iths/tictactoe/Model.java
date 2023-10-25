//package se.iths.tictactoe;
//
//import javafx.scene.control.Button;
//
//import java.util.Arrays;
//
//
//public class Model {
//private int xWins = 0;
//private int oWins = 0;
//    private String[][] gameBoard = new String[3][3];
//    private Button[][] buttons;
//    private String currentPlayer = "";
//
//    public String[][] getGameBoard() {
//        System.out.println(Arrays.deepToString(gameBoard));
//        return gameBoard;
//    }
//
//    public Model(Button[][] buttons) {
//        this.buttons = buttons;
//        System.out.println(Arrays.deepToString(buttons));
//        for (int row = 0; row < 3; row++) {
//            for (int col = 0; col < 3; col++) {
//                gameBoard[row][col] = "";
//            }
//        }
//    }
//
//    public String getCurrentPlayer() {
//        return currentPlayer;
//    }
//
//    public void makeMove(int row, int col) {
//        System.out.println(Arrays.deepToString(gameBoard));
//        if (gameBoard[row][col].isEmpty() && buttons[row][col].getText().isEmpty()) {
//
//            currentPlayer = (currentPlayer.equals("X")) ? "O" : "X";
//            gameBoard[row][col] = currentPlayer;
//            buttons[row][col].setText(currentPlayer);
//            buttons[row][col].setDisable(true);
//        }
//    }
//    public String checkForWinner() {
//        String winnerX = checkWinnerForPlayer("X");
//        String winnerO = checkWinnerForPlayer("O");
//
//        System.out.println("Winner for X: " + winnerX);
//        System.out.println("Winner for O: " + winnerO);
//
//        if (winnerX != null) {
//            return winnerX;
//        } else if (winnerO != null) {
//            return winnerO;
//        }
//
//        return null;
//    }
//
//
//
//    public String checkWinnerForPlayer(String player) {
//
//        String playerSymbol = player.repeat(3);
//        System.out.println("Player: " + player + ", Player Symbol: " + playerSymbol);
//        for (int i = 0; i < 3; i++) {
//            String horizontalLine = String.join("", gameBoard[i]);
//            String verticalLine = String.join("", gameBoard[0][i] + gameBoard[1][i] + gameBoard[2][i]);
//            System.out.println("Horizontal Line: " + horizontalLine);
//            System.out.println("Vertical Line: " + verticalLine);
//                if (horizontalLine.equals(playerSymbol) || verticalLine.equals(playerSymbol)) {
//                    return player; // Return player as the winner only when three symbols match
//                }
//            }
//
//            String diagonal1 = String.join("", gameBoard[0][0] + gameBoard[1][1] + gameBoard[2][2]);
//            String diagonal2 = String.join("", gameBoard[0][2] + gameBoard[1][1] + gameBoard[2][0]);
//
//            if (diagonal1.equals(playerSymbol) || diagonal2.equals(playerSymbol)) {
//                return player; // Return player as the winner when three symbols match diagonally
//            }
//            return null;
//        }
//        //
////                    String playerSymbol = player.repeat(3);
////        System.out.println("playerSymbol" + playerSymbol);
////            for (int i = 0; i < 3; i++) {
////                String horizontalLine = String.join("", gameBoard[i]);
////                System.out.println("horiz" + Arrays.toString(gameBoard[i]));
////                String verticalLine = String.join("", gameBoard[0][i] + gameBoard[1][i] + gameBoard[2][i]);
////                System.out.println("vert" + Arrays.toString(gameBoard[i]));
////                    if (horizontalLine.equals(playerSymbol) || verticalLine.equals(playerSymbol)) {
////                        System.out.println(player + " wins horizontally or vertically");
////                        System.out.println("player");
////                        return player;
////                    }
////            }
////
////            String diagonal1 = String.join("", gameBoard[0][0] + gameBoard[1][1] + gameBoard[2][2]);
////        System.out.println("diag1" + diagonal1);
////            String diagonal2 = String.join("", gameBoard[0][2] + gameBoard[1][1] + gameBoard[2][0]);
////        System.out.println("daig2" + diagonal2);
////            if (diagonal1.equals(playerSymbol) || diagonal2.equals(playerSymbol)) {
////                System.out.println(player + " wins diagonally");
////                return player;
////            }
////            return null;
////        }
//
// public String checkGameResult(){
//        String winner = checkForWinner();
//     System.out.println("gameboard before: " + Arrays.deepToString(gameBoard));
//        if (winner != null){
//            System.out.println("winner" + winner);
//            System.out.println("gameboard after" + Arrays.deepToString(gameBoard));
//            if (winner.equals("X")){
//                xWins++;
//          return winner;
//
//           } else if (winner.equals("O")) {
//                System.out.println("winner o" + winner);
//                oWins++;
//                return winner;
//           }
//            return winner;
//        }
//         if (isBoardFull()) {
//             System.out.println("draw" + isBoardFull());
//             return null;
//        }
//    return null;
// }
//
//
//
//    public boolean isBoardFull() {
//        for (int row = 0; row < 3; row++) {
//            for (int col = 0; col < 3; col++) {
//                if (gameBoard[row][col].isEmpty()) {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
//
//    public void resetGame() {
//        for (int row = 0; row < 3; row++) {
//            for (int col = 0; col < 3; col++) {
//                gameBoard[row][col] = "";
//            }
//        }
//        currentPlayer = "";
//    }
//
//    public int getXwins() {
//        return xWins;
//    }
//
//    public int getOwins() {
//        return oWins;
//    }
//}
package se.iths.tictactoe;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.Arrays;

public class Model {
    private IntegerProperty draws = new SimpleIntegerProperty(0);
    private IntegerProperty xWins = new SimpleIntegerProperty(0);
    private IntegerProperty oWins = new SimpleIntegerProperty(0);

    private String[][] gameBoard = new String[3][3];
    private Button[][] buttons;
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
        draws.set(getDraws() + 1);
} public boolean isDraw() {
        return isBoardFull() && checkForWinner() == null;
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
        String winner = checkForWinner();

        if (winner != null) {
            return winner;
        }

       return null;
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
        draws.set(0);
    }




}