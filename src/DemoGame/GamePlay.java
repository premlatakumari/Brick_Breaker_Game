package DemoGame;
//javax.swing.JPanel is a class from the Swing GUI library that represents a panel in a GUI. It is a container for other components such as buttons, labels, and text fields.
import javax.swing.JPanel;
//javax.swing.Timer is a class from the Swing GUI library that implements a timer that can be used for animation or for scheduling tasks.
import javax.swing.Timer;
//java.awt.Graphics2D is a class from the Abstract Window Toolkit (AWT) library that provides a set of methods for advanced 2D graphics rendering.
import java.awt.Graphics2D;
//java.awt.Rectangle is a class from the AWT library that represents a rectangle with an origin and dimensions.
import java.awt.Rectangle;
//java.awt.Graphics is a class from the AWT library that provides a basic set of methods for rendering graphics.
import java.awt.Graphics;
//java.awt.Color is a class from the AWT library that represents a color.
import java.awt.Color;
//java.awt.Font is a class from the AWT library that represents a font.
import java.awt.Font;
//java.awt.event.ActionEvent is a class from the AWT event library that represents an event that is generated when a user interacts with a component, such as clicking a button.
import java.awt.event.ActionEvent;
//java.awt.event.ActionListener is an interface from the AWT event library that allows an object to be notified when an action event occurs.
import java.awt.event.ActionListener;
//java.awt.event.KeyEvent is a class from the AWT event library that represents a key event, such as a key being pressed or released.
import java.awt.event.KeyEvent;
//java.awt.event.KeyListener is an interface from the AWT event library that allows an object to be notified when a key event occurs.
import java.awt.event.KeyListener;
//The class has instance variables (or fields) that store information about the state of the game such as whether it is currently being played (play), the current score (score), the number of bricks left (totalbricks), a Timer object (Timer) for managing the game's update cycle, a delay for the Timer (delay), the x-coordinate of the player's position (playerX), the x and y-coordinates of the ball's position (ballposX and ballposY), the direction of the ball's movement along the x and y axis (ballXdir and ballYdir), and a MapGenerator object (map) for generating the game's map.
//The class also overrides the actionPerformed and keyPressed methods of the ActionListener and KeyListener interfaces respectively, to respond to user input and update the state of the game.
public class GamePlay extends JPanel implements ActionListener, KeyListener {
    private boolean play = false;
    private int score = 0;
    private int totalbricks = 21;
    private Timer Timer;
    private int delay = 8;
    private int playerX = 310;
    private int ballposX = 120;
    private int ballposY = 350;
    private int ballXdir = -1;
    private int ballYdir = -2;
    private MapGenerator map;
    //Constructor
    //This code defines the constructor of the GamePlay class. The constructor performs the following actions:
    public GamePlay() {
        //Creates an instance of the MapGenerator class, passing the arguments 3 and 7 to the constructor. This sets up a map with 3 rows and 7 columns of bricks.
        map = new MapGenerator(3, 7);
        //Calls the addKeyListener method and passes this as an argument. This means that the current instance of the GamePlay class will listen for keyboard events.
        addKeyListener(this);
        //Calls the setFocusable method and passes true as an argument. This sets the focus of the JPanel to true, allowing it to receive keyboard events.
        setFocusable(true);
        //Calls the setFocusTraversalKeysEnabled method and passes false as an argument. This disables the focus traversal keys, such as Tab, to allow the panel to receive keyboard events.
        setFocusTraversalKeysEnabled(false);
        //Creates a new instance of the java.util.Timer class, passing delay and this as arguments. delay is set to 8 and this means the current instance of the GamePlay class will receive action events from the timer.
        Timer = new Timer(delay, this);
        //Starts the timer by calling the start method.
        Timer.start();
    }

    public void paint(Graphics g) {
        //this will fill the entire window with a pink rectangle, effectively painting the background of the game.
        g.setColor(Color.pink);
        g.fillRect(1, 1, 692, 592);
        //it will call the draw method map is instance which consists of bricks in this case
        map.draw((Graphics2D) g);
        //trying to create border
        g.setColor(Color.black);
        g.fillRect(0, 0, 3, 592);
        g.fillRect(0, 0, 692, 3);
        g.fillRect(691, 0, 3, 592);
        //it will show the score in right corner
        g.setColor(Color.green);
        g.setFont(new Font("serif", Font.BOLD, 25));
        g.drawString("" + score, 590, 30);
        // drawing paddle
        //the color to yellow and draws a rectangle for the player's paddle
        g.setColor(Color.yellow);
        g.fillRect(playerX, 550, 100, 8);
        //drawing ball
        //The ball is then drawn by setting the color to green and filling an oval with that color. The ball's position is determined by the values of the variables "ballposX" and "ballposY".
        g.setColor(Color.yellow);
        g.fillOval(ballposX, ballposY, 20, 20);
        //The code then checks the game status. If the ball's position has dropped below the bottom of the screen, the game is over and the code displays a game over message and instructions to restart the game by pressing the Enter key. If all the bricks have been destroyed, the game is also considered to be over, and a similar message is displayed.
        if (ballposY > 570) {
            play = false;
            ballXdir = 0;
            ballYdir = 0;
            g.setColor(Color.red);
            g.setFont(new Font("serif", Font.BOLD, 30));
            g.drawString("    Game Over Score: " + score, 190, 300);
            g.setFont(new Font("serif", Font.BOLD, 30));
            g.drawString("   Press Enter to Restart", 190, 340);
        }
        //This code is checking if the total number of bricks in the game is equal to 0. If the condition is true, it means the player has successfully broken all the bricks, and has won the game. The following actions are performed in the code:
        if(totalbricks == 0){
            //The play variable is set to false to stop the movement of the ball.
            play = false;
            //The ballYdir and ballXdir variables are set to -2 and -1 respectively, to reset the direction of the ball.
            ballYdir = -2;
            ballXdir = -1;
            //The color of the text is set to green using g.setColor(Color.green).
            g.setColor(Color.green);
            //A font of size 30 and bold with a font family of "serif" is set using g.setFont(new Font("serif",Font.BOLD,30)).
            g.setFont(new Font("serif",Font.BOLD,30));
            //The string "Wow! You are winner: score" is drawn on the screen at a position of (150, 300).
            g.drawString("    Wow! You are winner: "+score,150,300);
            //Another font of size 30 and bold with a font family of "serif" is set using g.setFont(new Font("serif", Font.BOLD, 30)).
            g.setFont(new Font("serif", Font.BOLD, 30));
            //The string "Press Enter to Restart" is drawn on the screen at a position of (190, 340)
            g.drawString("   Press Enter to Restart", 190, 340);
        }
        //The g.dispose() method is called to release the graphics resources.
        g.dispose();
    }
    //The code is a part of a Java program that implements the functionality of a brick breaker game. The code is an implementation of the actionPerformed method of the ActionListener interface. The method is called every time the Timer object "Timer" starts.
    @Override
    public void actionPerformed(ActionEvent e) {
        Timer.start();
        //The method checks if the game is in play (variable "play" is true) and if so, it performs the following actions:
        if (play) {
            //Check if the ball has intersected with the player's paddle. If so, it changes the direction of the ball in the y-axis (ballYdir = -ballYdir).
            if (new Rectangle(ballposX, ballposY, 20, 20).intersects(new Rectangle(playerX, 550, 100, 8))) {
                ballYdir = -ballYdir;
            }
           A:
            //Loop through the map of bricks in the game to see if the ball has intersected with any of them. If the ball has intersected with a brick, it changes the value of the corresponding brick in the map to 0 and decrements the total number of bricks. The score is also incremented by 5. If the ball has hit the brick in the x-axis, it changes direction in the x-axis (ballXdir = -ballXdir). If the ball has hit the brick in the y-axis, it changes direction in the y-axis (ballYdir = -ballYdir).
            for (int i = 0; i < map.map.length; i++) {
                for (int j = 0; j < map.map[0].length; j++) {
                    if (map.map[i][j] > 0) {
                        int brickX = j * map.bricksWidth + 80;
                        int brickY = i * map.bricksHeight + 50;
                        int bricksWidth = map.bricksWidth;
                        int bricksHeight = map.bricksHeight;
                        Rectangle rect = new Rectangle(brickX, brickY, bricksWidth, bricksHeight);
                        Rectangle ballrect = new Rectangle(ballposX, ballposY, 20, 20);
                        Rectangle brickrect = rect;
                        if (ballrect.intersects(brickrect)) {
                            map.setBricksValue(0, i, j);
                            totalbricks--;
                            score += 5;
                            //Updates the position of the ball by adding the direction values (ballXdir, ballYdir) to the current position of the ball (ballposX, ballposY).
                            if (ballposX + 19 <= brickrect.x || ballposX + 1 >= brickrect.x + bricksWidth) {
                                ballXdir = -ballXdir;
                            } else {
                                ballYdir = -ballYdir;
                            }
                            break A;
                        }
                    }
                }
            }
            //If the ball hits the left or right wall, it changes direction in the x-axis (ballXdir = -ballXdir). If the ball hits the top wall, it changes direction in the y-axis (ballYdir = -ballYdir).
            ballposX += ballXdir;
            ballposY += ballYdir;
            if (ballposX < 0) {
                ballXdir = -ballXdir;
            }
            if (ballposY < 0) {
                ballYdir = -ballYdir;
            }
            if (ballposX > 670) {
                ballXdir = -ballXdir;
            }
        }
        //Repaint the game board.
        repaint();
    }
    @Override
    public void keyTyped(KeyEvent e) {
    }
    @Override
    public void keyReleased(KeyEvent e) {

    }
    //this code is handling the player's movement by checking the input from the keyboard and making sure that the player's position stays within the limits of the game screen. If the right arrow key is pressed and the player's X position is less than 600, the player moves to the right. If the left arrow key is pressed and the player's X position is greater than 10, the player moves to the left.
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (playerX >= 600) {
                playerX = 600;
            }
            else {
                moveRight();
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if (playerX < 10) {
                playerX = 10;
            } else {
                moveLeft();
            }
        }
        //This code checks if the user has pressed the enter key. If the game is not currently in play (i.e., if "play" is false), the code resets the ball position (X and Y coordinates), sets the ball's direction of movement, sets the player's position, sets the total number of bricks in the game, creates a new MapGenerator object with the specified number of rows and columns, and calls the repaint() method to redraw the game screen. In effect, this code allows the player to restart the game by pressing the enter key.
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!play) {
                ballposX = 120;
                ballposY = 350;
                ballXdir = -1;
                ballYdir = -2;
                score = 0;
                playerX = 310;
                totalbricks = 21;
                map = new MapGenerator(3, 7);
                repaint();
            }
        }
    }
    //The moveRight() method increases the player's X position by 20, which will move the player 20 units to the right. same for moveleft only direction will be left
    //In both methods, the play boolean variable is set to true, indicating that the game is in progress.
    public void moveRight ()
    {
        play = true;
        playerX += 20;
    }
    public void moveLeft ()
    {
        play = true;
        playerX -= 20;
    }
}
