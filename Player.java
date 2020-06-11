import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

/**
* Player takes keyboard inputs and marks down the coordinates of the corresponding cell
*/
public class Player implements KeyListener{
  public int x;
  public int y;
  public int count;
  private char[] input;

  /**
  * Constructor that pulls the inital starting coordinates
  */
  public Player(){
    x = Maze.maze.cells[0][0].x;
    y = Maze.maze.cells[0][0].y;
    count = 0;
    input = new char[] {'w', 'd', 's', 'a'};
  }

  /**
  * Handle the key-typed event from the text field
  * @param e  The keyboard input
  */
  public void keyTyped(KeyEvent e){}

  /**
  * Handle the key-pressed event from the text field
  * @param e  The keyboard input
  */
  public void keyPressed(KeyEvent e) {}

  /**
  * Handle the key-released event from the text field
  * @param e  The keyboard input
  */
  public void keyReleased(KeyEvent e) {
    char key = e.getKeyChar();
    System.out.println("Pressed " + (int)e.getKeyChar());
    if(key == input[0] && y > 0 && checkWalls(0)){                    // North ('w')
      y -= 1;
      count += 1;
      System.out.println(x + ", " + y);
    } if(key == input[1] && x < Maze.maze.col - 1 && checkWalls(1)){  // East ('d')
      x += 1;
      count += 1;
      System.out.println(x + ", " + y);
    } if(key == input[2] && y < Maze.maze.row - 1 && checkWalls(2)){  // South ('s')
      y += 1;
      count += 1;
      System.out.println(x + ", " + y);
    } if(key == input[3] && x > 0 && checkWalls(3)){                  // West ('a')
      x -= 1;
      count += 1;
      System.out.println(x + ", " + y);
    }
  }

  /**
  * Determines if there is a wall blocking the chosen direction
  * @param index    the integer value corresponding to the direction
  * @return boolean boolean value of if the chosen path is blocked by a wall
  */
  private boolean checkWalls(int index){
    if(Maze.maze.cells[x][y].walls[index]){
      return false;
    } else {
    return true;
    }
  }

  /**
  * Determines if the player is located in the bottom right corner, which
  * is the end of the maze
  * @return boolean   boolean value of if the player has reached the end
  */
  public boolean checkWin(){
    if(x == Maze.maze.col - 1 && y == Maze.maze.row - 1){
      return true;
    }
    return false;
  }
}
