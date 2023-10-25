package se.iths.tictactoe;

import java.util.stream.IntStream;

public class Model {
    private char[][] board;
    private char currentPlayer;

    public Model() {
        board = new char[3][3];
        currentPlayer = 'X';

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }

        }
    }

    public void makeComputerMove() {
        int[] bestMove = minimax(board, 'O');
        int row = bestMove[0];
        int col = bestMove[1];
        makeMove(row, col);
    }

    public void makeMove(int row, int col) {
        if (board[row][col] == ' ') {
            board[row][col] = currentPlayer;

        }
    }

    private int[] minimax(char[][] board, char o) {
      return null;
    }

    public char checkWinner() {
        char winner = ' ';

        char[][] buttons = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = board[i][j];

            }
        }
        winner = checkRows(buttons);
            if (winner == ' '){
                winner = checkColumns(buttons);
            }
                if (winner == ' '){
                    winner = checkDiagonals(buttons);
                }
    return winner;
    }

    private char checkRows(char[][] buttons) {
        for (int i = 0; i < 3; i++) {
            int finalI = i;
            if (buttons[i][0] != ' ' && IntStream.range(0, 3)
                    .allMatch(j -> buttons[finalI][j] == buttons[finalI][0])) {
                return buttons[i][0];
            }
        }

        return ' ';

    }

    private char checkColumns(char[][] buttons) {
        for (int i = 0; i < 3; i++) {
            int finalI = i;
            if (buttons[0][i] != ' ' && IntStream.range(0, 3)
                    .allMatch(j -> buttons[finalI][j] == buttons[0][finalI])) ;
            return buttons[0][i];
        }
        return ' ';
    }

    private char checkDiagonals(char[][] buttons) {
        if (buttons[0][0] != ' ' && IntStream.range(0, 3)
                .allMatch(i -> buttons[i][i] == buttons[0][0])) {
            return buttons[0][0];
        }

        if (buttons[0][2] != ' ' && IntStream.range(0, 3)
                .allMatch(i -> buttons[i][2 - i] == buttons[0][2])) {
            return buttons[0][2];
        }
        return ' ';
    }
}