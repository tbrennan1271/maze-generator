import javax.swing.JFrame;

/**
* DrawMaze
* Creates the window to display the maze
* Works directly with RenderMaze to display each cell
*
* @author Tyler Brennan
*/
public class DrawMaze{

  /**
  * Constructor to create the window that displays the maze
  * @param Maze maze  grid containing all the cells
  */
  public DrawMaze(Maze maze){
    RenderMaze render = new RenderMaze(maze);
    JFrame window = new JFrame("Maze - Tyler Brennan");

    window.setVisible(true);
    window.setDefaultCloseOperation(window.EXIT_ON_CLOSE);
    window.add(render);
    window.pack();
  }
}
