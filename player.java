import java.awt.Graphics2D;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.Rectangle;
import java.util.ArrayList;
public class player extends entity{

    gameBoard gb;
    KeyHandler keyH; // takes key from keyhandler

       public ArrayList<entity> inventory = new ArrayList<>(); // INVENTORY FOR ARRAYLIST

    
        public player(gameBoard gb, KeyHandler keyH){ // calling the methods used
        this.gb = gb;
        this.keyH = keyH;


        solidArea = new Rectangle(); // used for the player collision
        solidArea.x = 12; //solid area < than player charachter
        solidArea.y = 10;
        solidArea.width = 20;
        solidArea.height = 17;

        setDefaultValues();
        getPlayerImage();

    }

    public void setDefaultValues(){
        x = 100;
        y = 100; 
        speed = 4; // speed of the dog
        direction = "right"; // default direction, default tile of the dog -> 100,100


        // PLAYER STATUS
       // level = 1;
        //maxLife = 6;
       // life = maxLife;
       // coin = 0;
    }

    public void getPlayerImage(){

        try{
            //gets image of the dog, in different postions, when going up, down left, right
            up1 = ImageIO.read(getClass().getResourceAsStream("dog.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("dog.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("dog.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("dog copy.png"));


        } catch(IOException e){
            e.printStackTrace();
        }
    }
    public void update(){ // updates new positons of the dog -> only cech the direction
        if(keyH.upPressed == true || keyH.downPressed == true || 
        keyH.leftPressed == true || keyH.rightPressed == true) 
        

        {

        if(keyH.upPressed==true){ 
            direction = "up";
        

            }
            else if(keyH.downPressed==true){
            direction = "down";
  
        
            }
            else if(keyH.leftPressed==true){
            direction = "left";
        
         
            }
            else if(keyH.rightPressed==true){
            direction = "right";
        
  
            }

        // check tile collision
        collisionOn = false;
        gb.checker.CheckTile(this);

        // if collision = false, player moves

        if(collisionOn == false){

            switch(direction){
                case "up":
                y -= speed;
                break;
                case "down":
                y += speed;
                break;
                case "left":
                x -= speed;
                break;
                case "right":
                x += speed;
                break;
            }
        }

    }
    }
    public void draw(Graphics2D g2){

        BufferedImage image = null;

        switch(direction){ // shows image in each case
        case "up":
            image = up1;
            break;
        case "down":
            image = down1;
            break;
        case "left":
            image = left1;
            break;
        case "right":
            image = right1;
            break;
        }
      
        g2.drawImage(image, x, y,gb.tileSize, gb.tileSize,null); 
    }
}
