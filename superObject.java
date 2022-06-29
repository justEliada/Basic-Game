import java.awt.image.BufferedImage;
import java.awt.Graphics2D;

public class superObject {
    public BufferedImage image;
    public String name;
    public boolean collision = false;
    public int x, y;

    public void draw(Graphics2D g2, gameBoard gb){
        g2.drawImage(image,x,y,gb.tileSize,gb.tileSize,null);

    }
    
}
