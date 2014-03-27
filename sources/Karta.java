import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Karta extends JPanel{
    private Image bild;

    Karta(String path){
		bild = new ImageIcon(path).getImage();
		setPreferredSize(new Dimension(bild.getWidth(null), bild.getHeight(null)));
		setLayout(null);
    }

    protected void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(bild, 0,0, getWidth(),getHeight(), this);
    }
}
