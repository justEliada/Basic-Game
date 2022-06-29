import java.awt.image.BufferedImage;
import java.awt.Rectangle;
public class entity  {
    

    public int x, y;
    public int speed;
    public int value = 5;
    public BufferedImage up1,down1,left1,right1;
    public String direction;
    public Rectangle solidArea;
    public boolean collisionOn = false;


    // charachter atributes for pop up panel
    public int level;
    public int maxLife;
    public int strength;
    public int attack;
    public int defense;
    public int coin;


}
