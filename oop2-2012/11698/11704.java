import java.awt.*;

public abstract class GameObject implements Drawable
{
    protected int x,y, w,h, screenWidth, screenHeight, speedX, speedY;

    public GameObject(int screenWidth, int screenHeight){
        this.screenWidth= screenWidth;
        this.screenHeight= screenHeight;

    }

    public void draw(Graphics g){
        g.setColor(Color.WHITE);
        g.fillRect(x -w/2, y-h/2, w, h);

    }

    public void update(){
        x+=speedX;
        y+=speedY;

    }
    
    public void checkCollision(GameObject other){
        
        int distanceX = Math.abs(this.x-other.x);
        int distanceY = Math.abs(this.y-other.y);
        if (distanceX < this.w/2 + other.w/2 && distanceY< this.h/2 + other.h/2){
            
            //COLLIDE!
            handleCollision(other);
        }
    }
    
    public abstract void handleCollision(GameObject other);

}

