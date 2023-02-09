package DemoGame;
//to make game i need to use JFrame here i am importing
import  javax.swing.JFrame;
public class MainClass {
    public static void main(String[] args) {
        //making object of JFrame
        JFrame f=new JFrame();
        GamePlay gamePlay=new GamePlay();
        f.setTitle("Brick Breaker");
        f.setSize(700,600);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        f.setResizable(false);
        f.add(gamePlay);
//
    }
}