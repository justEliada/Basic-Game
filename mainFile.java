//Loje ne Java-> Perdorimi i koncepteve, stacks, queues, backtracking, recursion
// Strukture te dhenash
// @author Eliada Ballazhi, Antonela Leka, Sara Qoku, Imelda Vajushi, Fiqiret Daiu
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class mainFile {
    private static hi hi;

    public static void main (String[] args){

   
      JFrame window = new JFrame();

      //window that pops up -> data
      window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      window.setResizable(false);
      window.setTitle("Doge Game");

      gameBoard board = new gameBoard();
      window.add(board);
      window.pack(); // window to be sized  to fit the prfered layouts and subcontentes 

      window.setLocationRelativeTo(null); // Opens window directly in center 
      window.setVisible(true);

      //**********************************************************board.setUpGame();
      
      board.startGameThread();  
      JOptionPane.showMessageDialog(null, "Welcome Player, Vendosni te dhenat tuaja:");
      
      hi = new hi();
    
    
     }
  }

// panel -> game over, try again, end points -> through stack
// dog->collects coins, if out of frame-> end game-> if collide with water-> loses all coins 


