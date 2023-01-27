
package gamecenter;

import java.io.*;
import javax.swing.*;

public class GameCenter {

    public static void main(String[] args) throws IOException{
        
        int numPlayers;
        String inputStr;
        int points;
        int input;
        int again = 0;
        String[] options = {"Yes", "No"};
        String[] names;
        int[] pointsList;
        
        Players play = new Players();
        //show welcom to users
        //play.welcome();

        //information about us and this project
        ContactUs student1 = new ContactUs("Ahad Alqahtani", "2113641", "2113641@uj.edu.sa");
        ContactUs student2 = new ContactUs("Lina Ali", "2216609", "2216609@uj.edu.sa");

        AboutUs info = new AboutUs("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tGame Center",
                "\nThis program was made to help people, mostly children, to improve\n" +
                        "their problem-solving skills by playing fun games."
                        + "\n\nThis is a project for the Object Oriented Programming course.",
                "Dr. Ibtihal Al-Saqqaf", student1, student2);

  //      info.describe();
//        info.showStudent1();
//        info.showStudent2();

        
        //numbsrs of players
        numPlayers = play.getNumOfPlayers();

        //two lists for names and points
        names = new String[numPlayers];
        pointsList = new int[numPlayers];
        
        //names of players
        int i;
        for (i = 0; i < numPlayers; ++i) {
            names[i] = JOptionPane.showInputDialog(
                    "Enter the name for player" + (i + 1) + ":");
        }
        
        //
        for (int j = 0; j < numPlayers; ++j) {
            points = 0;
            play.welcom(j, names[j]);
            again = 0;
            //
            while (again == 0) {
                //choosing game
                inputStr = play.getGame();
                switch (inputStr) {
                    
                    case "1.Rock Paper Sicssors":
                        RockPaperScissors game1 = new RockPaperScissors(names[j]);
                        game1.explainTheGame();
                        game1.play();
                        if (game1.isWin()) {
                            ++points;
                        }
                        System.out.println(game1.toString());
                        break;

                    case "2.Story":
                        Story game2 = new Story(names[j]);
                        game2.explainTheGame();
                        game2.tomSawer();
                        points += game2.quizAndPoints();
                        System.out.println(game2.toString());
                        break;

                    case "3.Tic Tac Toe    Note:need 2 players":
                        if (numPlayers == 1) {
                            JOptionPane.showMessageDialog(null,
                                    "You cann't play it alone ",
                                    "Error", 0);
                            break;
                        }
                        inputStr = (String) JOptionPane.showInputDialog(
                                null, "choose player:", "Players",
                                JOptionPane.QUESTION_MESSAGE, null, names,
                                names[0]);

                        if (inputStr.equals(names[j])) {
                            JOptionPane.showMessageDialog(null,
                                    "You cann't play against yourself ",
                                    "Error", 0);
                            break;
                        }

                        TicTacToe game3 = new TicTacToe();
                        game3.setPlayers(names[j], inputStr);
                        game3.explainTheGame();
                        game3.play();
                        System.out.println(game3.toString());
                        if (game3.checkWinner().equals(names[j])) {
                            points += 6;
                        } else if (game3.checkWinner().equals("draw")) {
                            points += 3;
                            for (i = 0; i < numPlayers; i++) {
                                if (game3.checkWinner().equals(names[i])) {
                                    pointsList[i] += 3;
                                }
                            }
                        } else {
                            for (i = 0; i < numPlayers; i++) {
                                if (game3.checkWinner().equals(names[i])) {
                                    pointsList[i] += 6;
                                }
                            }
                        }
                        break;
                        
                    case "4.Pop Quiz":
                        Quiz game4 = new Quiz(names[j]);
                        points += game4.PopQuiz();
                        System.out.println(game4.toString());
                        break;
                        
                    case "5.Hangman":
                        Hangman game5 = new Hangman();
                        
                        points += game5.points();
                        System.out.println(game5.toString(names[j]));
                        break;

                }
                pointsList[j] += points;

                again = JOptionPane.showOptionDialog(null,
                        "You want to play in game center again? ", "Again",
                        0, 3, null,
                        options, options[0]);
            }
        }
        
        play.setArray(pointsList, names);
        String output = play.printDetails();
        play.file();
        JOptionPane.showMessageDialog(null,output, "results",1);
        info.describe();
        info.showStudent1();
        info.showStudent2();
        play.goodBye();
        System.exit(0);
    }

}
