import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class KeyHandler implements KeyListener // Key Listener gets input from user-> reads the keyboard
{
    public boolean upPressed, downPressed, leftPressed, rightPressed; // the keys that we press to move the dog

    @Override
    public void keyTyped(KeyEvent e) {     
        
    }

    @Override
    public void keyPressed(KeyEvent e) { // when key is pressed then boolean = true, VK_W -> W
     int code = e.getKeyCode();
     if(code==KeyEvent.VK_W){ 
         upPressed = true;
    }
     if(code==KeyEvent.VK_S){
        downPressed = true;
    }
    if(code==KeyEvent.VK_A){
        leftPressed = true;
    }
    if(code==KeyEvent.VK_D){
        rightPressed = true;
    }

    
    if(code== KeyEvent.VK_E){
        
    }
       
}

    @Override
    public void keyReleased(KeyEvent e) { // Dog stops when, stop using key -> otherwise dog continues on path
        int code = e.getKeyCode();
        if(code==KeyEvent.VK_W){
            upPressed = false;
       }
        if(code==KeyEvent.VK_S){
           downPressed = false;
       }
       if(code==KeyEvent.VK_A){
           leftPressed = false;
       }
       if(code==KeyEvent.VK_D){
           rightPressed = false;
       }
          
       }
        
}
    

