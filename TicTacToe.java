package gamecenter;

import java.util.Arrays;
import java.util.InputMismatchException;
import javax.swing.JOptionPane;

/**
 * This class is TicTacToe game
 *
 */

public class TicTacToe {

    private String player1;
    private String player2;
    private String[] board;
    private String turn;
    private String winner;

    /**
     * This constructor initializes the names of players and call two methods.
     * explainTheGame method and play method
     * @param player1 The name of first player
     * @param player2 The name of second player
     */
    public TicTacToe(String player1, String player2) {
        this.player1 = player1;
        this.player2 = player2;
        explainTheGame();
        play();
    }
    /**
     * the copy constructor initializes the object as
     * a copy of another TicTacToe object.
     * @param obj2 The object to copy.
     */
    public TicTacToe(TicTacToe obj2) {
        player1 = obj2.player1;
        player2 = obj2.player2;
        board = obj2.board;
        turn = obj2.turn;
        board = obj2.board;
    }
    /**
     * This method set a value for each field.
     *
     * @param user1 The first player name
     * @param user2 The second player name
     */
    public void setPlayers(String user1, String user2) {
        player1 = user1; //two players will play this game
        player2 = user2;
    }

    /**
     * This method set a value for each field.
     *
     * @param board Board of the game
     * @param turn determines the X or O turn
     * @param winner The winner of the game
     */
    public void set(String[] board, String turn, String winner) {
        this.board = board;
        this.turn = turn;
        this.winner = winner;
    }

    /**
     * This method return the name of the first player
     * @return The name of the first player
     */
    public String getPlayer1() {
        return player1;
    }
     /**
     * This method return the name of the second player
     * @return The name of the second player
     */
    public String getPlayer2() {
        return player2;
    }
    /**
     * This method return board of the game
     * @return Board of the game
     */
    public String[] getBoard() {
        return board;
    }
    /**
     *  This method return the turn (X or O)
     * @return The turn  of X or O 
     */
    public String getTurn() {
        return turn;
    }
    /**
     * This method return the winner of the game
     * @return The winner of the game.
     */
    public String getWinner() {
        return winner;
    }

    /**
     * This method give simple explanation of the game
     */
    public void explainTheGame() {
        JOptionPane.showMessageDialog(null,
                "In this game you we will play against each other. One will be X"
                + "and other will be O.\n"
                + "There are 9 places to put the mark in.\n"
                + "The first Player get 3 of his/her mark in row(up,"
                + " down, across orr diagonlly) is winner.\n"
                + "The winner get 6 points.\n"
                + "If they are tied, each one will get 3 points.",
                "TicTacToe", 2);
    }
    /**
     * This method check the winner and return the winner
     * @return The winner in the game.
     */
    public String checkWinner() {
        for (int a = 0; a < 8; a++) {
            String line = null;
            //All cases of win
            switch (a) {
                case 0:
                    line = board[0] + board[1] + board[2];
                    break;
                case 1:
                    line = board[3] + board[4] + board[5];
                    break;
                case 2:
                    line = board[6] + board[7] + board[8];
                    break;
                case 3:
                    line = board[0] + board[3] + board[6];
                    break;
                case 4:
                    line = board[1] + board[4] + board[7];
                    break;
                case 5:
                    line = board[2] + board[5] + board[8];
                    break;
                case 6:
                    line = board[0] + board[4] + board[8];
                    break;
                case 7:
                    line = board[2] + board[4] + board[6];
                    break;
            }
            //For X winner
            if (line.equals("XXX")) {
                return player1;
            } //For O winner
            else if (line.equals("OOO")) {
                return player2;
            }
        }

        for (int a = 0; a < 9; a++) {
            if (Arrays.asList(board).contains(
                    String.valueOf(a + 1))) {
                break;
            } else if (a == 8) {
                return "draw";
            }
        }
        return null;  //no winner and no draw (sitll playing)*           
    }
    /**
     * This method print the board for playing
     */    
    public void printBoard() {
        String output = String.format(
                "| %s | %s | %s |\n"
                + "-------------\n"
                + "| %s | %s | %s |\n"
                + "-------------\n"
                + "| %s | %s | %s |\n",
                board[0], board[1], board[2], board[3],
                board[4], board[5], board[6], board[7], board[8]);

        JOptionPane.showMessageDialog(null, output,
                "TicTacToe", 1);

    }
    /**
     * This method play the game
     */
    public void play() {
        board = new String[9];
        turn = "X";
        winner = null;

        for (int a = 0; a < 9; a++) {
            board[a] = String.valueOf(a + 1);
        }
        //welcome
        JOptionPane.showMessageDialog(null,
                "* * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n"
                + "*  Welcome to Tic Tac Toe game |^__^|.  *\n"
                + "* * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n",
                "TicTacToe", 1);
        printBoard();//calling printBoard

        JOptionPane.showMessageDialog(null,
                "X will play first.",
                "TicTacToe", 1);
        JOptionPane.showMessageDialog(null,
                "X is " + player1 + " and O is " + player2,
                "TicTacToe", 1);

        while (winner == null) {
            int numInput;
            String input;
            input = JOptionPane.showInputDialog(
                    turn + "'s turn; enter a slot number to place "
                    + turn + " in:");
            numInput = Integer.parseInt(input);

            // Exception handling.
            // numInput will take input from user like from 1 to 9.
            // If it is not in range from 1 to 9.
            // then it will show you an error "Invalid input."
            try {

                numInput = Integer.parseInt(input);
                if (!(numInput > 0 && numInput <= 9)) {
                    JOptionPane.showMessageDialog(null,
                            "Invalid input; re-enter slot number:",
                            "TicTacToe", 0);
                    continue;
                }
            } catch (InputMismatchException e) {
                JOptionPane.showMessageDialog(null,
                        "Invalid input; re-enter slot number:",
                        "TicTacToe", 0);
                continue;
            }

            // This game has two player x and O.
            // Here is the logic to decide the turn.
            if (board[numInput - 1].equals(
                    String.valueOf(numInput))) {
                board[numInput - 1] = turn;

                if (turn.equals("X")) {
                    turn = "O";
                } else {
                    turn = "X";
                }

                printBoard();
                winner = checkWinner();
                // To enter the X Or O at the exact place on board.            
            } else {
                JOptionPane.showMessageDialog(null,
                        "Slot already taken; re-enter slot number:",
                        "TicTacToe", 0);
            }
        }

        // If no one win or lose from both player x and O.
        // then here is the logic to print "draw".
        if (winner.equalsIgnoreCase("draw")) {
            JOptionPane.showMessageDialog(null,
                    "It's a draw! Thanks for playing.",
                    "TicTacToe", 1);
        } // For winner -to display Congratulations! message.
        else {
            JOptionPane.showMessageDialog(null,
                    "Congratulations! " + winner
                    + "'s have won! Thanks for playing.",
                    "TicTacToe", 1);
        }

    }
    /**
     * toString method  
     * @return return motivational phrase with the name of player
     *
     */
    public String toString() {
        return ("Done from the game3. Good job, "
                + player1 + " and " + player2);
    }
}
