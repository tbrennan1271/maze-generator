import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;

/**
* RenderMaze
* Works in conjunction with DrawMaze to create a visual representation of the
* maze by looking at all the cells
*
* @author Tyler Brennan
*/
public class RenderMaze extends JPanel{
  public Player player;
  private int dimX;
  private int dimY;
  private int offset;
  private int width;
  private int height;
  private Cell current;

  /**
  * Constructor to establish all the variables needed
  */
  public RenderMaze() {
    current = Maze.maze.cells[0][0]; // Starting point for player
    player = new Player();
    offset = 10;
    dimX = 400;
    dimY = 400;
    width = (dimX - offset * 2) / Maze.maze.col;
    height = (dimY - offset * 2) / Maze.maze.row;
  }

  /**
  * Sets the dimensions for the window
  */
  public Dimension getPreferredSize() {
    return new Dimension(dimX, dimY);
  }

  /**
  * Uses the walls array of each cell in the maze to determine which walls to drawLine
  * @param Graphics g   Used to draw all the elements in the window
  */
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    // Create walls for each cell
    for(int i = 0; i < Maze.maze.col; i ++){
      for(int j = 0; j < Maze.maze.row; j++){
        Cell cell = Maze.maze.cells[i][j];
        int x = cell.x;
        int y = cell.y;
        if(cell.walls[0]){    // North wall
          g.drawLine((x + 1) * width + offset, y * height + offset,       x * width + offset,       y * height + offset);
        } if(cell.walls[1]){  // East wall
          g.drawLine((x + 1) * width + offset, y * height + offset,      (x + 1) * width + offset, (y + 1) * height + offset);
        } if(cell.walls[2]){  // South wall
          g.drawLine(x * width + offset,      (y + 1) * height + offset, (x + 1) * width + offset, (y + 1) * height + offset);
        } if(cell.walls[3]){  // West wall
          g.drawLine(x * width + offset,      (y + 1) * height + offset,  x * width + offset,       y * height + offset);
        }
        g.fillRect((player.x  * width) + (width/3) + offset, (player.y * height) + (height/3) + offset, width/3, height/3);
      }
    }
  }
}
