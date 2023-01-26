/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gamecenter;

import javax.swing.*;
import javax.swing.JOptionPane;
import java.io.*;
import java.util.*;
/**
 *
 * @author Lenovo
 */
public class Players {
    
    private String inputStr;
    private String[] namesList;
    private int[] pointsList;
    private String[] menu;
    private int numPlayers;
    private int input;
    private int MENU = 6;
    
    public Players(){
        
    }
    
    public  void welcom(int i, String name){
        ImageIcon icon = new ImageIcon("hi1.PNG");
            JOptionPane.showMessageDialog(null, "Hi, " + name,
                    "Hi",JOptionPane.PLAIN_MESSAGE,icon);        
    }
    
    public String getGame(){
       
        String menu[] = {"1.Rock Paper Sicssors", "2.Story",
            "3.Tic Tac Toe    Note:need 2 players", "4.Pop Quiz", "6.see result (All players are done)"};
        inputStr = (String)JOptionPane.showInputDialog(
                null, "choose game:", "Menu",
                JOptionPane.QUESTION_MESSAGE, null, menu,
                menu[0]);
       return inputStr;
    }
    
    public int getNumOfPlayers(){
         inputStr = JOptionPane.showInputDialog(
                "How many Players will play in Game Center?");
        numPlayers = Integer.parseInt(inputStr);
        while(numPlayers <= 0){
            JOptionPane.showMessageDialog(null, 
                    "You cann't enter 0, "
                            + "less than 0 or floating point number."
                            + "\nTry again. ", 
                    "Error", 0);
            inputStr = JOptionPane.showInputDialog(
                "How many Players will play in Game Center?");
        numPlayers = Integer.parseInt(inputStr);
        }
        return numPlayers;
    }
    
    public void setArray(int[] points, String[] names){
        pointsList = points;
        namesList = names;
        selectionSort();
        toString();
    }
    
    public void selectionSort(){
        int maxIndex;
        int maxValue;
        String maxName;
        
        for(int startScan = 0; startScan < numPlayers - 1; startScan++){
            maxIndex = startScan;
            maxValue = pointsList[startScan];
            maxName = namesList[startScan];
            
            for(int index = startScan + 1; index < numPlayers; index++){
                if(pointsList[index] > maxValue){
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
    
        public String toString(){
       String output = " The result of all players \n Name           Points\n";
       for(int i = 0; i < numPlayers; i++){
           output = output + namesList[i] + "             " + pointsList[i] + "\n";  
        }  
       return output;
    }
        public void file() throws IOException{
            PrintWriter outputFile = new PrintWriter("Result.txt");
            for(int i = 0; i < numPlayers; i++){
                outputFile.println(namesList[i]+ "   " + pointsList[i] + "\n");
            }
            outputFile.close();
            
            File file = new File("Result.txt");
            Scanner inputFile = new Scanner(file);
            
            while(inputFile.hasNext()){
                String result = inputFile.nextLine();
                System.out.println(result);
            }
            inputFile.close();
        }
    
   // public void setPlayers(){
//        names = new String[numPlayers];
//        //int[] pointsArray = new int[numPlayers];
//        //names of players...
//        for (int i = 0; i < numPlayers; ++i){
//            names[i] = JOptionPane.showInputDialog("Enter the name for player" + (i+1) +":");
        //} 
    //}
    

    
//    public String toString(){
//        
//        String output;
//        return output;
//    }
    
    
    
//    public String printDetails(){
//        return null;
//    }
//    public void file(){
//        
//    }
}
