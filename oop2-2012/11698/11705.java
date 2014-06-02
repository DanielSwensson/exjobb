import java.awt.*;
import java.awt.event.*;

public class Paddle extends GameObject
{
    public Paddle(int screenWidth, int screenHeight, boolean isLeft){

        super (screenWidth, screenHeight);

        w=screenHeight/40;
        h=screenHeight/10;
        y=screenHeight/2;

        if(isLeft){
            x= w;
        }else{
            x=screenWidth - w;
        }
    }

    public void up(){
        speedY=-10;

    }

    public void down(){
        speedY=10;
    }

    public void stop(){
        speedY=0;
    }

    @Override
    public void update(){
        super.update();
        if(y-h/2<0){
            y=h/2;
        }else if (y+h/2>screenHeight){
            y=screenHeight -h/2;
        }
    }

    @Override
    public void handleCollision(GameObject other){

    }

}
