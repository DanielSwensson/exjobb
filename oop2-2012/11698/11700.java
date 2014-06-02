import java.awt.*;
public class Ball extends GameObject
{
    public Ball(int screenWidth, int screenHeight){

        super (screenWidth, screenHeight);

        x= screenWidth/2;
        y=screenHeight/2;
        w=screenHeight/40;
        h=w;
        
        speedX=10;
    }

    @Override
    public void update(){
        super.update();
        if(y > screenHeight || y<0){
            speedY*= -1;

        }

      
    }

    public void reset(){
        x= screenWidth/2;
        y=screenHeight/2;
        speedX*=-1;
        speedY=0;
    }

    @Override
    public void handleCollision(GameObject other){
        
        int distanceY = this.y - other.y;

        speedX*=-1;

        speedY=distanceY/6;
    }
}