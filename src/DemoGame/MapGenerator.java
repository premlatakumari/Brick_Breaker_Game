package DemoGame;

//"BasicStroke," is used for defining the thickness, end caps style, line join style, miter limit, and dash attributes of a stroke. This is used in the creation of shapes with a specified line width and style in a Graphics context.
import java.awt.BasicStroke;
//"Color," represents color values using the RGB color model. It provides predefined constants for commonly used colors, and it also allows you to create custom color values.
import java.awt.Color;
//"Graphics2D," is an extension of the Graphics class that provides more sophisticated control over the use of graphics and imaging. This class provides methods for drawing shapes, rendering text, and manipulating images, among others.
import java.awt.Graphics2D;
//crating this file to make bricks
//The class has a two-dimensional array called map which represents the bricks in the game. When an object of the class is created using the constructor, it takes two arguments row and col that determine the number of rows and columns of bricks respectively.
public class MapGenerator {
    public int map[][];
    public int bricksWidth;
    public int bricksHeight;
    //The constructor initializes the map array by setting all the values to 1, which indicates that the brick is present. The width and height of each brick are also calculated based on the number of rows and columns.
    public MapGenerator(int row , int col)
    {
        map = new int[row][col];
        for (int[] map1 : map) {
            for (int j = 0; j < map[0].length; j++)
            {
                map1[j] = 1;
            }
        }
        bricksWidth = 540/col;
        bricksHeight = 150/row;
    }
    //he draw method takes a Graphics2D object g as an argument and draws the bricks on the game screen. It loops through the map array and draws a blue rectangle for each brick with a value greater than 0. It also draws a black border around each rectangle to give it a 3D effect.
    public void draw(Graphics2D g) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++)
            {
                if (map[i][j] > 0) {
                    g.setColor(Color.blue);
                    g.fillRect(j * bricksWidth + 80, i * bricksHeight + 50, bricksWidth, bricksHeight);
                    g.setStroke(new BasicStroke(3));
                    g.setColor(Color.black);
                    g.drawRect(j * bricksWidth + 80, i * bricksHeight + 50, bricksWidth, bricksHeight);
                }
            }
        }
    }
    //The setBricksValue method takes a value, a row number, and a column number as arguments. It sets the value of the specified brick in the map array to the given value. This can be used to update the map when a brick is hit by the ball.
    public void setBricksValue(int value,int row,int col)
    {
        map[row][col] = value;
    }
}
