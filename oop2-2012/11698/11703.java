import java.awt.event.*;
import java.util.HashSet;
public class Game {

    private DrawClass draw;
    private Background background;
    private Ball ball;
    private Paddle p1,p2;
    private HashSet<Integer> keys;
   

    public Game(){//konstruktor
        keys= new HashSet<Integer>();
        draw = new DrawClass ();
        int w= draw.getWidth();
        int h= draw.getHeight();

        ball= new Ball (w,h);
        p1= new Paddle(w, h, true);
        p2= new Paddle(w,h, false);

        background= new Background(w);

        draw.add(background);
        draw.add(ball);
        draw.add(p1);
        draw.add(p2);
        draw.addKeyListener(new Listener());

        draw.repaint();
        gameLoop();
    }

    private void gameLoop(){
        while(true){
            draw.repaint();
            handleInput();
            ball.update();
            p1.update();
            p2.update();
            gameLogic();

            try{
                Thread.sleep(40);

            }catch(InterruptedException e){}
        }
    }

    
    private void gameLogic(){
        ball.update();
        p1.update();
        p2.update();
        ball.checkCollision(p1);
        ball.checkCollision(p2);
        
          if (ball.x <0){
            ball.reset();
            background.addScore(2);
        }
        
          if (ball.x > draw.getWidth()){
            ball.reset();
            background.addScore(1);
        }


        
    }
    
    private void handleInput(){
        if(keys.contains(KeyEvent.VK_UP) && !keys.contains(KeyEvent.VK_DOWN)){

            p2.up();

        }else if (!keys.contains(KeyEvent.VK_UP) && keys.contains(KeyEvent.VK_DOWN)){

            p2.down();

        }else {
            p2.stop();

        }

        if(keys.contains(KeyEvent.VK_W) && !keys.contains(KeyEvent.VK_S)){

            p1.up();

        }else if (!keys.contains(KeyEvent.VK_W) && keys.contains(KeyEvent.VK_S)){

            p1.down();

        }else {
            p1.stop();

        }
    }
    class Listener implements KeyListener{
        @Override
        public void keyPressed(KeyEvent e){
            keys.add(e.getKeyCode());

        }

        @Override
        public void keyReleased(KeyEvent e){
            keys.remove(e.getKeyCode());

        }

        @Override
        public void keyTyped(KeyEvent e){

        }//
    }

    public static void main (String [] game){
        new Game();
    }
}
