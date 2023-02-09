package DemoGame;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePlay extends JPanel implements ActionListener, KeyListener {
    private boolean play=false;
    private int totalBrick=21;
    private Timer timer;
    private int delay=8;
    private int ballposX=120;
    private int ballposY=350;
    private int ballXdir=-1;
    private int ballYdir=-2;
    private int playerX=350;

    //Constructor
    public GamePlay(){
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(true);
        timer=new Timer(delay,this);
        timer.start();
    }
    public void paint(Graphics g)
    {
        //black canvas
        g.setColor(Color.black);
        g.fillRect(1,1,692,592);

        //border
        g.setColor(Color.yellow);
        g.fillRect(0, 0, 3, 592); //creating left yellow line
       g.fillRect(0, 0, 692, 3); //upper line

        g.fillRect(691, 0, 3, 592);


        //paddle
        g.setColor(Color.green);
        g.fillRect(playerX,550,100,8);

        //Ball
        g.setColor(Color.red);
        g.fillOval(ballposX,ballposY,20,20);

    }
    private void moveLeft() {
        //If i willl press left then my left will be true
        play=true;
        playerX-=20;
    }
    private void moveRight() {
        //if i will press Right then play will be true;
        play=true;
        playerX+=20;
    }
//here we are checking user is pressing which key --left or right
    public void keyPressed(KeyEvent e){
        if(e.getKeyCode()==KeyEvent.VK_LEFT){
            if(playerX<=10)
                playerX=10;
            else
                moveLeft();
        }
        if(e.getKeyCode()==KeyEvent.VK_RIGHT){
            if(playerX>=600)
                playerX=600;
            else
                moveRight();
        }
        //my ball is not moving so i m doing repaintt
        repaint();

    }



   //Here i am writing code to move the ball
    @Override
    public void actionPerformed(ActionEvent e) {
        //if play will be true
        if(play){
            if (ballposX < 0) {
                ballXdir = -ballXdir;
            }
            if (ballposY < 0) {
                ballYdir = -ballYdir;
            }
            if (ballposX > 670) {
                ballXdir = -ballXdir;
            }

            Rectangle ballRect=new Rectangle(ballposX,ballposY,20,20);
            Rectangle paddleRect=new Rectangle(playerX,550,100,8);
            if(ballRect.intersects(paddleRect))
            {
                ballYdir=-ballYdir;
            }
            ballposX+=ballXdir;
            ballposY+=ballYdir;

        }
        repaint();

    }
    @Override
    public void keyReleased(KeyEvent e) {

    }
    @Override
    public void keyTyped(KeyEvent e) {

    }


}