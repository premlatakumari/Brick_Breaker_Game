//This code is the main class for a game called "Brick Breaker" written in Java
package DemoGame;
//to make game i need to use JFrame here i am importing
//here i am importing the "jFrame" class from the javax.swing pakage.The JFrame class is used to create a top-level window in a Java Swing application.

//Java Swing is a graphical user interface (GUI) toolkit for Java, which provides a set of lightweight, platform-independent components for building user interfaces in Java.
import  javax.swing.JFrame;
public class MainClass {
    public static void main(String[] args) {
        //making object of JFrame
        //JFrame f = new JFrame(); creates a new instance of the JFrame class and assigns it to the variable "f". JFrame is a class in the Java Swing library that represents the main window of a graphical user interface.
        JFrame f=new JFrame();
        //GamePlay gamePlay = new GamePlay(); creates a new instance of the GamePlay class and assigns it to the variable "gamePlay". It is assumed that the GamePlay class is a custom class that represents the gameplay of the Brick Breaker game.
        GamePlay gamePlay=new GamePlay();
        //sets the title of the JFrame to "Brick Breaker Game".
        f.setTitle("Brick Breaker Game");
        //sets the size of the JFrame to 700 pixels wide and 600 pixels tall.
        f.setSize(700,600);
        //centers the JFrame on the screen.
        f.setLocationRelativeTo(null);
        //sets the default close operation of the JFrame to exit the application when the close button is clicked.
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //makes the JFrame visible on the screen.
        f.setVisible(true);
        // the ability to resize the JFrame.
        f.setResizable(true);
        //adds the "gamePlay" object to the JFrame. This means that the "gamePlay" object will be displayed inside the JFrame.
        f.add(gamePlay);

    }
}