import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
public class DrawClass 
{
    private JFrame frame;
    private LinkedList<Drawable> renderList;
    private Canvas canvas;
    private int width, height;
    
    public DrawClass()
    {
        renderList = new LinkedList<Drawable>();
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize(); // hämta skärmstorlek
        height=d.height;
        width=d.width;
        frame.setSize(d); // ändra fönstrets storlek till skärmstorleken
        //frame.setUndecorated(true); // avkommentera för odekorerat fönster (stäng med alt+f4 el cmd+q)
        canvas= new Canvas();
        frame.add(canvas); // lägg till rityta till fönstret
        frame.setVisible(true);
    }

    public void repaint(){
        canvas.repaint();
    }
    
    public void addKeyListener(KeyListener k){
        frame.addKeyListener(k);
    }

    public void add(Drawable drawable){ 
        renderList.add(drawable);
    }

    
    public int getWidth(){
        return width;
    }
    
    public int getHeight(){
        return height;
    }
    
    class Canvas extends JPanel {
        @Override
        public void paint(Graphics g){
            for(Drawable drawable: renderList){
                drawable.draw(g);
            }
        }
    }

}
