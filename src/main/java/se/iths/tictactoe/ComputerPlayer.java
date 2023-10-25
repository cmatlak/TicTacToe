package se.iths.tictactoe;

import java.util.Random;

public class ComputerPlayer {
    public static void makeMove(Model model) {
        String[][] gameBoard = model.getGameBoard();
        Random random = new Random();

        if (model.isBoardFull()) {
            return;
        }
        int row, col;

        do {
            row = random.nextInt(3);
            col = random.nextInt(3);
        } while (!gameBoard[row][col].isEmpty());
        model.makeMove(row, col);
    }

}
