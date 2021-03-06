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
    Timer timer = new Timer(100, new ActionListener() { // Timer to update the JPanel

        /**
        * Every time the timer is triggered, repaint the pannel or stop the
        * timer depending on if the win condition is met
        * @param e    ActionEvent from each time the timer is triggered
        */
        public void actionPerformed(ActionEvent e) {
          render.repaint();
          if(render.player.checkWin()){
            ((Timer)e.getSource()).stop();
          }
        }
    });
    timer.start();
    window.setVisible(true);
    window.setResizable(false);
    window.setDefaultCloseOperation(window.EXIT_ON_CLOSE);
    render.addKeyListener(render.player);
    render.setFocusable(true);
    render.requestFocusInWindow();
    window.add(render);
    window.pack();
  }
}
