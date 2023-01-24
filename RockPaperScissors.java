/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab00;

import java.util.Random;
import javax.swing.*;
//import java.io.*;

public class RockPaperScissors{
    private int input;
    private String [] options = {"rock", "paper", "scissor"};
  //  private  String playerName;
    private boolean bool = true;
    
    public RockPaperScissors(){
       // playerName = name;
    }
    
    // simple explaination of the game
    public void explainTheGame(){
        JOptionPane.showMessageDialog(null,
                "In this game choose rock, paper or scissors."
                + " Also, the program will choose one of them at random.\n"
                + "Rock cruhes scissors, "
                + "scissor cut paper and paper covers rock.\n"
                + "You will get one point if you win",
                "RockPaperSicssor",2);
    }
    
    //the game
    public void play(){
        //welcome
        JOptionPane.showMessageDialog(null, 
        "* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n" +
        "  Welcome to rock paper scissor game .|^__^|. \n" +
        "* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n",
        "RockPaperScissors", 1);
        
        //we use to make the program choose at random rock, paper or scissors
        Random rand = new Random();
        
        //the player choose rock, paper or scissors
        input = JOptionPane.showOptionDialog(null,
                "Please, choose:",
                "rockPaperScissor", 
                0, 3, null, options, options[0]);
        
        //compare between the program and the player choose and display reslt
        switch(input){
            case 0:
                if(rand.nextInt(3) == 0){
                    JOptionPane.showMessageDialog(null,
                            options[0] + " = " + options[0],
                            "RockPaperScissors", 1);                    
                    JOptionPane.showMessageDialog(null,
                            "It's a draw! Thanks for playing.",
                            "RockPaperScissors", 1);
                    bool = true;
                }                
                else if(rand.nextInt(3) == 1){
                    JOptionPane.showMessageDialog(null,
                            options[0] + " < " + options[1] + 
                            "\npaper covers the rock",
                            "RockPaperScissors", 1);                    
                    JOptionPane.showMessageDialog(null,
                            "The computer win :( Thanks for playing.",
                            "RockPaperScissors", 1);
                    bool = false;
                }
                else{
                    JOptionPane.showMessageDialog(null,
                            options[0] + " > " + options[2] +
                            "\nrock cruhes scissors",
                            "RockPaperScissors", 1);
                    JOptionPane.showMessageDialog(null,
                            "You win ^_^! Thanks for playing.",
                            "RockPaperScissors", 1);
                    bool = true;
                }
                break;
                
            case 1:
                if(rand.nextInt(3) == 0){
                    JOptionPane.showMessageDialog(null,
                            options[1] + " > " + options[0] +
                            "\npaper covers the rock",
                            "RockPaperScissors", 1);
                    JOptionPane.showMessageDialog(null,
                            "You win ^_^! Thanks for playing.",
                            "RockPaperScissors", 1);
                    bool = true;
                }
                else if(rand.nextInt(3) == 1){
                    JOptionPane.showMessageDialog(null,
                            options[1] + " = " + options[1],
                            "RockPaperScissors", 1);
                    JOptionPane.showMessageDialog(null,
                            "It's a draw! Thanks for playing.",
                            "RockPaperScissors", 1); 
                    bool = true;
                }
                else{
                    JOptionPane.showMessageDialog(null,
                            options[1] + " < " + options[2] +
                            "\nscissors cut paper",
                            "RockPaperScissors", 1);
                    JOptionPane.showMessageDialog(null,
                            "The computer win :(\n Thanks for playing.",
                            "RockPaperScissors", 1); 
                    bool = false;
                }
                break;
               
            case 2:
                if(rand.nextInt(3) == 0){
                    JOptionPane.showMessageDialog(null,
                            options[2] + " < " + options[0] +
                            "\nrock cruhes scissors",
                            "RockPaperScissors", 1);
                    JOptionPane.showMessageDialog(null,
                            "The computer win :(\n Thanks for playing.",
                            "RockPaperScissors", 1);
                    bool = false;
                }
                else if(rand.nextInt(3) == 1){
                    JOptionPane.showMessageDialog(null,
                            options[2] + " > " + options[1] +
                            "\nscissors cut paper",
                            "RockPaperScissors", 1);
                    JOptionPane.showMessageDialog(null,
                            "You win^_^! Thanks for playing.",
                            "RockPaperScissors", 1); 
                    bool = true;
                }
                else{
                    JOptionPane.showMessageDialog(null,
                            options[2] + " = " + options[2]);
                    JOptionPane.showMessageDialog(null,
                            "It's a draw! Thanks for playing.",
                            "RockPaperScissors", 1); 
                    bool = true;
                }
                break;               
        }// end of switch               
    }// end of method play
    
//return true if the player won    
    public boolean isWin(){
        return bool;
    }

}



