import java.util.Stack;
import java.util.ArrayList;
import java.util.Random;

/**
* Maze
* A grid containing all the cells that makes up the entire maze
*
* @author Tyler Brennan
*/
public class Maze{
  public final int col;
  public final int row;
  public Cell[][] cells;

  /**
  * Constructor to initialize the 2D array and fills it with all the cells
  */
  public Maze(){
    col = 20;
    row = 20;
    cells = new Cell[col][row];
    fillCells();
  }

  /**
  * Initializes the 2D array to be filled with blank cells
  */
  public void fillCells(){
    for(int i = 0; i < col; i++){
      for(int j = 0; j < row; j++){
        cells[i][j] = new Cell(i, j);
      }
    }
  }

  /**
  * Checks all neighbors and picks a random one that has not already been visited
  * @param int i  column of the 2D array
  * @param int j  row of the 2D array
  * @return Cell  randomly selected neighboring cell
  */
  public Cell neighbors(int i, int j){
    Random rand = new Random();
    ArrayList<int[]> visit = new ArrayList<int[]>();  // Will store each neighbor cell that has not been visited
    int[] vals;                                       // Will store the index of the cell, and the wall to delete
    if(j - 1 >= 0 && !cells[i][j - 1].visited){        // N
      vals = new int[]{i, j - 1, 0};
      visit.add(vals);
    }
    if(i + 1 < col && !cells[i + 1][j].visited){      // E
      vals = new int[]{i + 1, j, 1};
      visit.add(vals);
    }
    if(j + 1 < row && !cells[i][j + 1].visited){      // S
      vals = new int[]{i, j + 1, 2};
      visit.add(vals);
    }
    if(i - 1 >= 0 && !cells[i - 1][j].visited){        // W
      vals = new int[]{i - 1, j, 3};
      visit.add(vals);
      }
    if(visit.size() > 0){
      int next = rand.nextInt(visit.size());
      int[] res_arr = visit.get(next);
      cells[i][j].walls[res_arr[2]] = false;                              // Delete proper wall for this cell
      cells[res_arr[0]][res_arr[1]].walls[(res_arr[2] + 2) % 4] = false;  // Delete opposing wall for next cell
      return cells[res_arr[0]][res_arr[1]];
    }
    return null;
  }

  /**
  * Repeatedly calls neighbors() to generate a maze and store each cell in a
  * stack. If there are no unvisited neighbors, then work back in the stack
  * until a neighbor is available and repeat.
  */
  public void generateMaze(){
    Stack<Cell> path = new Stack<Cell>();
    Cell current = cells[0][0];
    current.walls[0] = false;     // No north wall to start
    path.push(current);
    while(!path.empty()){
      path.push(current);
      current.visited = true;
      current = neighbors(current.x, current.y);  // Update current to a random unvisited neighbor
      while(current == null){                     // Loop until there is a random unvisited neighbor
        if(!path.empty()){
          current = path.pop();
          current = neighbors(current.x, current.y);  // Search for unvisited neighbors in the previous cell
        } else break;
      }
    }
    cells[col - 1][row - 1].walls[2] = false; // Clear the south wall of the opposite corner to end
  }

  public static void main(String[] args){
    Maze maze = new Maze();
    DrawMaze draw = new DrawMaze(maze);
    maze.generateMaze();
  }
}
