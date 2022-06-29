import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.awt.Graphics2D;
import javax.imageio.ImageIO;

public class tileManager {
    gameBoard gb;
    public tile[] t;
    public int mapTileNum[][];

    
    //declaring constructors here
    public tileManager(gameBoard gb){
        this.gb = gb;
        t = new tile[10];
        mapTileNum = new int[gb.maxScreenCol][gb.maxScreenRow];

        getTileImage();

        loadMap();

    }

    // images for tile background
    public void getTileImage(){
        try{

            // we put a 0, 1, 2 for the numbers that reperesent each different Tile
            t[0] = new tile();
            t[0].image = ImageIO.read(getClass().getResourceAsStream("groundTiles.png")); // change tile to soild -> charachter collides
            t[0].collision = true;

            t[1] = new tile();
            t[1].image = ImageIO.read(getClass().getResourceAsStream("ground2.png"));

            
            t[2] = new tile();
            t[2].image = ImageIO.read(getClass().getResourceAsStream("water2.png"));
            t[2].collision = true;


        }
        catch(IOException e){

            e.printStackTrace();

        }

    }
  
    //Looping and mapping out the background
    public void loadMap(){
        try {
            InputStream is = getClass().getResourceAsStream("map.txt"); 
            BufferedReader br = new BufferedReader(new InputStreamReader(is)); // reads input from map.txt file

            int col = 0;
            int row = 0;

            while(col < gb.maxScreenCol && row< gb.maxScreenRow){ // 16, 12
                
                String line = br.readLine();
                while(col<gb.maxScreenCol){
                    String numbers[] = line.split(" "); 
        
                    int num = Integer.parseInt(numbers[col]);

                    mapTileNum[col][row] = num;
                    col ++;
                }
                if(col ==gb.maxScreenCol){
                    col = 0;
                    row++;

                }

            }
            br.close(); 

            
            
        } catch (Exception e) {
            
        }
    }

    
    //printing out the mapping + background
    public void draw(Graphics2D g2){
        
        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;
        
        while (col<gb.maxScreenCol && row < gb.maxScreenRow) {
            int tileNum = mapTileNum[col][row];
            g2.drawImage(t[tileNum].image,x,y,gb.tileSize,gb.tileSize,null);
            col++;
            x += gb.tileSize;

            if(col == gb.maxScreenCol){
                col = 0;
                x = 0;
                row++;
                y += gb.tileSize; // ts = 16
            }

        }
    }
    
    
}
