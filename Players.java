package gamecenter;

import javax.swing.*;
import java.io.*;
import java.util.*;

/**
 * This class is responsible for the start and the end of the program
 * and players number, names and points.
 *
 */
public class Players {

    private String inputStr;
    private String[] namesList;
    private int[] pointsList;
    private int numPlayers;

    public Players() {
        welcomToGameCenter();
    }
    public Players(Players obj2){
        
    }

    /**
     * This method set value for these fields.
     * @param inputStr The value entered by the user in JOptionPane
     * @param numPlayers The number of players
     */
    public void set(String inputStr, int numPlayers) {
        this.inputStr = inputStr;
        this.numPlayers = numPlayers;
    }

    /**
     * This method set value for these fields.
     * @param nameList List of players names.
     * @param pointsList List of players points.
     */
    public void setArray(int[] pointsList, String[] names) {
        namesList = names;
        this.pointsList = pointsList;
        selectionSort();
        toString();
    }

    /**
     * This method return inputStr
     * @return The value entered by the user in JOptionPane
     */
    public String getInputStr() {
        return inputStr;
    }

    /**
     * This method return names list
     * @return List of players names
     */
    public String[] getNamesList() {
        return namesList;
    }

    /**
     * This method return points list
     * @return List of players points
     */
    public int[] getPointsList() {
        return pointsList;
    }

    /**
     * This method return number of players
     *
     * @return The number of players
     */
    public int getNumPlayers() {
        return numPlayers;
    }
    /**
     * This method welcoming
     */
    public void welcomToGameCenter(){
        
    }
    /**
     *
     * This method welcoming to each player
     *
     * @param name The player name
     */
    public void welcome(String name) {
        ImageIcon icon = new ImageIcon("hi1.PNG");
        JOptionPane.showMessageDialog(null, "Hi, " + name,
                "Hi", JOptionPane.PLAIN_MESSAGE, icon);
    }

    /**
     * This method show the menu of games and return the choosing game
     *
     * @return The choosing game
     */
    public String getGame() {
        String menu[] = {"1.Rock Paper Sicssors", "2.Story",
            "3.Tic Tac Toe    Note:need 2 players", "4.Pop Quiz", "5.Hangman"};
        inputStr = (String) JOptionPane.showInputDialog(
                null, "choose game:", "Menu",
                JOptionPane.QUESTION_MESSAGE, null, menu,
                menu[0]);
        return inputStr;
    }
    /**
     * This method ask the user to enter the number of player
     * and return it
     * @return The number of players.
     */
    public int getNumOfPlayers() {
        numPlayers = -1;
        while (numPlayers <= 0) {
            inputStr = JOptionPane.showInputDialog(
                    "How many Players will play in Game Center?");
            //numPlayers = Integer.parseInt(inputStr);
            try {

                numPlayers = Integer.parseInt(inputStr);
                if (numPlayers <= 0) {
                    JOptionPane.showMessageDialog(null,
                            "Invalid input; re-enter again",
                            "TicTacToe", 0);
                    continue;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,
                        "Invalid input; re-enter again",
                        "TicTacToe", 0);
                continue;
            }
        }
        return numPlayers;
    }
    /**
     * This method rank the player according to their points 
     */
    public void selectionSort() {
        int maxIndex;
        int maxValue;
        String maxName;

        for (int startScan = 0; startScan < numPlayers - 1; startScan++) {
            maxIndex = startScan;
            maxValue = pointsList[startScan];
            maxName = namesList[startScan];

            for (int index = startScan + 1; index < numPlayers; index++) {
                if (pointsList[index] > maxValue) {
                    maxValue = pointsList[index];
                    maxIndex = index;
                    maxName = namesList[index];
                }
            }
            pointsList[maxIndex] = pointsList[startScan];
            pointsList[startScan] = maxValue;
            namesList[maxIndex] = namesList[startScan];
            namesList[startScan] = maxName;
        }
    }
    /**
     * This method return the results of each players 
     * @return The results of each players
     */
    public String printDetails() {
        String output = " The result of all players \n Name           Points\n";
        for (int i = 0; i < numPlayers; i++) {
            output = output + namesList[i] + "             " + pointsList[i] + "\n";
        }
        return output;
    }
    /**
     * This method make a file of the results
     * @param date The date of playing
     * @throws IOException 
     */
    public void file(String date) throws IOException {
        //writing text to file
        //open file
        FileWriter fw = new FileWriter("Results.txt", true);
        PrintWriter outputFile = new PrintWriter(fw);
        //edit file
        for (int i = 0; i < numPlayers; i++) {
            outputFile.println(namesList[i] + "   " + pointsList[i]);
        }
        outputFile.println(date);
        outputFile.println(" ");
        //close the file
        outputFile.close();
        
        //Reading file
        //open file for reading
        File file = new File("Results.txt");
        Scanner inputFile = new Scanner(file);
        //reading the file
        while (inputFile.hasNext()) {
            String result = inputFile.nextLine();
            System.out.println(result);
        }
        //close the file
        inputFile.close();
    }

    /**
     * This method show at the end of the program
     */
    public void goodBye() {
        ImageIcon icon = new ImageIcon("bye.PNG");
        JOptionPane.showMessageDialog(null, "",
                "The End", JOptionPane.PLAIN_MESSAGE, icon);
    }

}
