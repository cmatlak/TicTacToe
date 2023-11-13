package se.iths.tictactoe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


class ModelTest {



    @Test
    public void testMakeMove() {


            Model model = new Model();

            // Testa för ett legalt drag
            model.makeMove(0, 0); // X
            assertEquals("X", model.getGameBoard()[0][0]);

            // Testa ett olagligt drag
            model.makeMove(0, 0); // Bör ej tillåta

            // Säkerställ att brickan förblev densamma efter försök till olagligt drag
            assertEquals("X", model.getGameBoard()[0][0]);
        }


    @Test
    public void testCheckForWinner() {
        Model model = new Model();

        String[][] gameBoard = model.getGameBoard();

        // Testa en horisontell seger för spelare X
        gameBoard[0][0] = "X";
        gameBoard[0][1] = "X";
        gameBoard[0][2] = "X";
        assertEquals("X", model.checkForWinner());

        // Testa en vertikal seger för spelare O
        model.resetGame(); // Nollställ spelet
        gameBoard[0][0] = "O";
        gameBoard[1][0] = "O";
        gameBoard[2][0] = "O";
        assertEquals("O", model.checkForWinner());

        // Testa en seger för spelare X i diagonalen
        model.resetGame(); // Nollställ spelet
        gameBoard[0][0] = "X";
        gameBoard[1][1] = "X";
        gameBoard[2][2] = "X";
        assertEquals("X", model.checkForWinner());

        // Testa en seger för spelare O i den andra diagonalen
        model.resetGame(); // Nollställ spelet
        gameBoard[0][2] = "O";
        gameBoard[1][1] = "O";
        gameBoard[2][0] = "O";
        assertEquals("O", model.checkForWinner());

        // Testa vidare scenarion för olika fall av ingen vinnare
        model.resetGame(); // Nollställ spelet
        gameBoard[0][0] = "X";
        gameBoard[0][1] = "X";
        assertNull(model.checkForWinner());
    }
}






