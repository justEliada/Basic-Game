
public class Collision {
   
    gameBoard gb;


    public Collision(gameBoard gb){
        this.gb = gb;

    }
    
    public void CheckTile(entity e){
        int  entityLeftx = e.x + e.solidArea.x;
        int  entityRightx = e.x + e.solidArea.x + e.solidArea.width;
        int  entityTopy = e.y + e.solidArea.y;
        int  entityBottomy = e.y + e.solidArea.y + e.solidArea.height;

        int entityLeftCol = entityLeftx/gb.tileSize;
        int entityRightCol = entityRightx/gb.tileSize;
        int entityTopRow = entityTopy/gb.tileSize;
        int entityBottomRow = entityBottomy/gb.tileSize;

        int tileNum1, tileNum2;

        switch(e.direction){
            case "up":
            entityTopRow = (entityTopy - e.speed)/gb.tileSize;
            tileNum1 = gb.tiles.mapTileNum[entityLeftCol][entityTopRow];
            tileNum2 = gb.tiles.mapTileNum[entityRightCol][entityTopRow];
            
            if(gb.tiles.t[tileNum1].collision == true || gb.tiles.t[tileNum2].collision == true){
                e.collisionOn = true;
            }
            break;
            case "down":
            entityBottomRow = (entityBottomy + e.speed)/gb.tileSize;
            tileNum1 = gb.tiles.mapTileNum[entityLeftCol][entityBottomRow];
            tileNum2 = gb.tiles.mapTileNum[entityRightCol][entityBottomRow];
            
            if(gb.tiles.t[tileNum1].collision == true || gb.tiles.t[tileNum2].collision == true){
                e.collisionOn = true;
            }
        
            break;
            case "left":
            entityLeftCol = (entityLeftx - e.speed)/gb.tileSize;
            tileNum1 = gb.tiles.mapTileNum[entityLeftCol][entityTopRow];
            tileNum2 = gb.tiles.mapTileNum[entityLeftCol][entityBottomRow];
            
            if(gb.tiles.t[tileNum1].collision == true || gb.tiles.t[tileNum2].collision == true){
                e.collisionOn = true;
            }
       
            break;
            case "right":
            entityRightCol = (entityRightx + e.speed)/gb.tileSize;
            tileNum1 = gb.tiles.mapTileNum[entityLeftCol][entityTopRow];
            tileNum2 = gb.tiles.mapTileNum[entityRightCol][entityBottomRow];
            
            if(gb.tiles.t[tileNum1].collision == true || gb.tiles.t[tileNum2].collision == true){
                e.collisionOn = true;
            }
           
            break;
        }



    }
}
