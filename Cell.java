/**
* Cell
* Represents each individual index of a grid, storing whether or not import junit.framework.TestCase;
* has been visited and the walls that need to be drawn
*
* @author Tyler Brennan
*/
public class Cell{
  public boolean[] walls;  // [N, E, S, W]
  public boolean visited;  // Dictates whether the cell has already been visited
  public int x;
  public int y;

  /**
  * Constructor that stores the location, states it has not been visited, and
  * states that all walls need to be drawn
  * @param int x  the x value of the cell in the maze (2D array)
  * @param int y  the y value of the cell in the maze (2D array)
  */
  public Cell(int x, int y){
    this.x = x;
    this.y = y;
    walls = new boolean[] {true, true, true, true};
    visited = false;
  }
}
