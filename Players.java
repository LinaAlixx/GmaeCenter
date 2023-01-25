/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gamecenter;

import javax.swing.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Lenovo
 */
public class Players {
    
    private String inputStr;
    private String[] names;
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
            "3.Tic Tac Toe    Note:need 2 players", "6.see result (All players are done)"};
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
        return numPlayers;
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
