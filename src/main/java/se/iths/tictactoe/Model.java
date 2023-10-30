package se.iths.tictactoe;

import java.util.Random;
import java.util.stream.IntStream;

public class Model {
    private final char[][] board = new char[3][3];
   private static final char EMPTY = ' ';
   private static final char HUMAN_PLAYER = 'X';
   private static final char COMP_PLAYER = 'O';

    private char currentPlayer;

    public Model() {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }

        }
    }

    public void makeComputerMove() {
    if (canWin(COMP_PLAYER)){
        makeWinningMove(COMP_PLAYER);
    } else if (canWin (HUMAN_PLAYER)) {
        makeWinningMove(HUMAN_PLAYER);
    }else makeRandomMove();
    }

    private boolean makeHumanMove(int row, int col){
        if (isValidMove(row,col) && board[row][col] == EMPTY){
            board[row][col] = HUMAN_PLAYER;
        return true;
        }
    return false;
    }

    private boolean isValidMove(int row, int col) {
        return row >=0 && col <3 && col >=0 && row <3;
    }

    private void makeRandomMove() {
        Random random = new Random();
            int row,col;
            do {
                row = random.nextInt();
                col = random.nextInt();
            }while (board[row][col] != EMPTY);
            board[row][col] = COMP_PLAYER;
    }

    private boolean makeWinningMove(char player) {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board[row][col] == EMPTY){
                    board[row][col] = player;
                    if (checkWinner() == player){
                        return true;
                    }
                board[row][col] = EMPTY;
                }
                }

            }
            return false;
        }


    private boolean canWin(char player) {
        return false;
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
        }if (isBoardFull()){
            return 'D';
        }
        return ' ';
    }


    private boolean isBoardFull(){
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board[row][col] == EMPTY){
                    return false;
                }

            }
        }
            return true;
    }
}