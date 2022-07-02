import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;


public class gameBoard extends JPanel implements Runnable{
   
    //Screen Settings
    final int originalTileSize = 16;
    final int scale = 3;
    public final int tileSize = originalTileSize * scale; 
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize * maxScreenCol;
    public final int screenHeight = tileSize * maxScreenRow;
    public final int gameOverState = 4;
    public final int charachterState = 4;
 

    tileManager tiles = new tileManager(this);
    KeyHandler keyH = new KeyHandler();
    public Collision checker = new Collision(this);

    Thread gameThread;
    player player = new player(this, keyH);
    
    
    public gameBoard(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);

    }

   
    
    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();

    }

    
    @Override
    public void run() {

        //important game loop
        double drawInterval=1000000000/60;  // FPS = 60
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer=0;
        int drawCount = 0;

        while(gameThread != null)
        {
            currentTime = System.nanoTime(); 

            delta +=(currentTime -lastTime) / drawInterval;

            timer += (currentTime - lastTime);

            lastTime = currentTime;

            if(delta >= 1){
        
                    update();// update info such as charachter positions
                    repaint();
                    delta--;
                    drawCount++;
            }

           if(timer >= 1000000000){
               System.out.println("FPS" + drawCount); 
               drawCount = 0;
               timer = 0;
           }
        }     
        
    }

    public void update(){  //update 
         
        player.update();

    
    }

   public void paintComponent(Graphics g){
       super.paintComponent(g);

       Graphics2D g2 = (Graphics2D)g;

       tiles.draw(g2); 
      
       

       player.draw(g2);

       g2.dispose(); 
   }
   
    }      

