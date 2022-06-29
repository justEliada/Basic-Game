import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class hi extends gameBoard{
 
    private JFrame frame = new JFrame();
    private JButton btnAddUser = new JButton();
    private JButton btnDisplay = new JButton();
    
    //User Variables:
    private ArrayList<user> userArray = new ArrayList<user>();
    private String name;
    
    public hi() {
        
        //Frame Attributes:
        frame.setLayout(null);
        frame.setTitle("Vendosi te dhenat Tuaja: ");
        frame.setSize(400, 400);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.getContentPane().setBackground(new Color(194, 240, 240));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //btnAddUser Attributes:
        btnAddUser.setText("Klikoni");
        btnAddUser.setSize(200, 50);
        btnAddUser.setLocation(90, 100);
        btnAddUser.setBackground(new Color (0, 122, 153)); 
        btnAddUser.setOpaque(true); 
        btnAddUser.setBorderPainted(false);   
        
        //btnAddUser Click Event:
        btnAddUser.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {
                name = JOptionPane.showInputDialog("Vendosni Emrin: ");
                
                //Add User To Array:
                user newUser = new user(name);
                userArray.add(newUser);
            }
        });
        
        //btnDisplay Attributes:
        btnDisplay.setText("Lista");
        btnDisplay.setSize(200, 50);
        btnDisplay.setLocation(90, 200);
        btnDisplay.setBackground(new Color (0, 122, 153)); 
        btnDisplay.setOpaque(true); 
        btnDisplay.setBorderPainted(false);   
        
                
        //btnDisplay Click Event:
        btnDisplay.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {
                for(int i = 0; i < userArray.size(); i++){
                    JOptionPane.showMessageDialog(null, "Emri: " + userArray.get(i).getName());
                }
            }

        });
        
        //Add Frame Objects:
        frame.add(btnAddUser);
        frame.add(btnDisplay);
    }
 
}
 
 

