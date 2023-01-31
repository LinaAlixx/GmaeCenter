
package gamecenter;

import javax.swing.*;

public class Story {    
    private String name;
    /**
     * This constructor initializes the names of players and call two methods.
     * explainTheGame method and play method
     * @param name The player name.
     */
    public Story(String name){
        this.name = name;
        explainTheGame();
        tomSawer();
    }
    /**
     * the copy constructor initializes the object as
     * a copy of another TicTacToe object.
     * @param obj2 The object to copy.
     */
    public Story(Story obj2){
        name = obj2.name;
    }
    /**
     * This method est value for this field
     * @param name The player name
     */
    public void setName(String name){
        this.name = name;
    }
    /**
     * This method return player name
     * @return Player name.
     */
    public String getName(){
        return name;
    }
    /**
     * This method give simple explanation of the game
     */
    public void explainTheGame(){
        JOptionPane.showMessageDialog(null, 
                "in this game you will read the story "
                        + "and anwser the questions\n"
                        + "and you will get one point for each questions", 
                "Story", 2);
    }
    /**
     * This method show Tom Sawer story
     */
    public void tomSawer(){
        
        //All images we use in the story
        ImageIcon image1 = new ImageIcon("story1.PNG");
        ImageIcon image2 = new ImageIcon("story22.JPG");
        ImageIcon image3 = new ImageIcon("story33.JPG");
        ImageIcon image4 = new ImageIcon("story44.JPG");
        ImageIcon image5 = new ImageIcon("story55.JPG");
        //welcome
        JOptionPane.showMessageDialog(null, 
                "* * * * * * * * * * * * * * * * * * * * * * * * \n" +
                "  TOM SAWYER STORY .|^__^|. \n" +
                "* * * * * * * * * * * * * * * * * * * * * * * * \n"
                , "Story", 1);
        //Part1
        JOptionPane.showMessageDialog(null,
                        "\"I know you didn't go to school tody\" "
                        + "said Aunt Polly, \"and that's not Okay."
                        + " Tomorrow you are going to paint the fence.\"\n"
                        + "\"But tomorrow is Saturday. It's my time to play!\""
                        + "said Tom.\n"
                        + "Anut Polly was determind."
                        + " She wanted to teach Tom a lesson.",
                        "story", JOptionPane.PLAIN_MESSAGE,
                        image1);
        //Part2
        JOptionPane.showMessageDialog(null,
                "Saturday come, and it was beautiful sunny day."
                        + " He look at the fence thoughtfully.\n"
                        + "Thirty yards of fence nine feet high!! "
                        + "It seem to him that life wasn't worth living",
                "story",JOptionPane.PLAIN_MESSAGE,image2);
        //Part3
        JOptionPane.showMessageDialog(null,
                "Ben came dancing out  of the gate with red apple. "
                    + "Tom had an idea.\n"
                    + "He took the brush and went calmly to work.\n"
                    + "\" What? Do you like it? \"asked Ben.\n"
                    + "Tom answered,\" Like it? I love it! "
                    + "It's not every day that a boy"
                    + " gets to paint a fence \".\n"
                    + "\"I say, Tom, let me paint a little\" Ben said.\n"
                    + "\"No, no, I cann't. My anut said only I could do that."
                    + "\" said Tom.\n"
                    + "\" Come on, Tom. I'll give you my apple!\" Ben Said.",
                     "story",
                     JOptionPane.PLAIN_MESSAGE,image3);
        //Part4
        JOptionPane.showMessageDialog(null,
                "A little later, Jon walked by. "
                    + "\" Hello Tom. What are you doing?\"\n"
                    + "Tom said, \" Hi Jon. I'am having a great time painting"
                    + "the fance.\"\n"
                    + "\" Can I paint? \" asked Jon.\n"
                    + "\"  My anut said only I could paint the fence. I was "
                    + "nice enough to let Ben try, "
                    + "But now I want to paint again \" \n"
                    + "\" Please, Tom. jast a little."
                    + " I'll give you my marbles\"\n ","story",
                    JOptionPane.PLAIN_MESSAGE,image4);
        //Part5
        JOptionPane.showMessageDialog(null,
                "By the end of the day, many of Tom's friends had helped"
                    + "paint the fence.\n"
                    + "Tom tricked them all into thinking it was fun.\n"
                    + "Tom said to himself that life "
                    + "was worth living after all.\n"
                    + "He had discover great law of human behaviour:\n"
                    + "in order to make a man or boy desire a thing,\n "
                    + "it is only necessary to make"
                    + " the thing difficult to obtain", "story",
                    JOptionPane.PLAIN_MESSAGE, image5);
    }
    /**
     * simple quiz and points for the quiz and return the points
     * @return The points.
     */
    public int quizAndPoints(){
        int points = 0;//one point for each right anwser
        int input;//the player answer
        //options for each question
        String[] options1 = {"Apple", "Marbles", "Bull"};
        String[] options2 = {"Yes", "No"};
        String[] options3 = {"He wanted to that", "He didn't go to school",
                             "He did bad in exam"};
        //the question num1
        input = JOptionPane.showOptionDialog(null, 
                "What does Ben give Tom to "
                + "let him paint the fence?", "Story",
                0, 3, null,
                options1, options1[0]);
        //check the answer        
        if(input == 0){
            ++points;
            
        }
        //the question num2
        input = JOptionPane.showOptionDialog(null, 
                "Does Tom paint the fence? ", "Story",
                0, 3, null,
                options2, options2[0]);  
        //check the answer
        if(input == 1){
            ++points;
        }
        //the question num3
        input = JOptionPane.showOptionDialog(null, 
                "Why does Tom have to paint the fence?"
                        + "\nbecause...", "Story",
                0, 3, null, 
                options3, options3[0]);
        //check the answer        
        if(input == 1){
            ++points;
        }            
        
        return points;
    }
    /**
     * toString method  
     * @return return motivational phrase with the name of player
     *
     */
    public String toString(){
        return ("Done from the game2. Good job, " + name);
    }
}
