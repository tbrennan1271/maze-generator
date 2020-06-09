import javax.swing.JFrame;
import javax.swing.Timer;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
  public DrawMaze(){
    RenderMaze render = new RenderMaze();
    JFrame window = new JFrame("Maze - Tyler Brennan");
    Timer timer = new Timer(200, new ActionListener() { // Timer to update the JPanel
        // @Override
        public void actionPerformed(ActionEvent e) {
          render.repaint();
        }
    });
    timer.start();

    window.setVisible(true);
    window.setDefaultCloseOperation(window.EXIT_ON_CLOSE);
    render.addKeyListener(render.player);
    render.setFocusable(true);
    render.requestFocusInWindow();
    window.add(render);
    window.pack();
  }
}
