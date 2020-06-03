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
  private int dimX;
  private int dimY;
  private int offset;
  private int width;
  private int height;
  private Maze maze;

  /**
  * Constructor to establish all the variables needed
  * @param Maze maze  grid containing all the cells
  */
  public RenderMaze(Maze maze) {
    this.maze = maze;
    offset = 10;
    dimX = 400;
    dimY = 400;
    width = (dimX - offset * 2)/maze.col;
    height = (dimY - offset * 2)/maze.row;
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
    for(int i = 0; i < maze.col; i ++){
      for(int j = 0; j < maze.row; j++){
        Cell cell = maze.cells[i][j];
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
        /*if(cell.visited){
          g.fillRect(x * width + offset, y * width + offset, width, height);
        }*/
      }
    }
  }
}
