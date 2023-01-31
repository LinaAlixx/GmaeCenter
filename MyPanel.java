
package gamecenter;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class MyPanel extends JPanel implements ActionListener{
    final int PANEL_WIDTH = 640;
    final int PANEL_HIGHT = 480;
    Image enemy;
    Image backgroundImage;
    Timer timer;
    int xVelocity = 1;
   // int yVelocity = 1;
    int x = 10;
    int y = -10;
    
    MyPanel(){
       this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HIGHT));
       this.setBackground(Color.black);
       enemy = new ImageIcon("m1.png").getImage();
       backgroundImage = new ImageIcon("game1.png").getImage();
       timer = new Timer(10, this);
       timer.start();
       
    }
    public void paint(Graphics g){
       super.paint(g);// paint back ground
       Graphics2D g2D = (Graphics2D)g;
       g2D.drawImage(backgroundImage, 0, 0, null);
       g2D.drawImage(enemy, x, y, null);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(x >= PANEL_WIDTH - enemy.getWidth(null) || x<0){
            xVelocity = xVelocity * -1;
        }
        x = x + xVelocity;
        repaint();
        //MyFrame.dispatchEvent(new WindowEvent(MyFrame, WindowEven.WINDOW_CLOSING));
    }
    //jButton1.addActionListener(new ActionListener())
}
