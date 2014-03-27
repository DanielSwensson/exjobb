import java.awt.*;
import javax.swing.*;

class Nod extends JComponent{
	private boolean vald = false;
	private String referens;
	Nod(int x, int y, String ref){
		setBounds(x-2,y-2,14,14);
		referens = ref;
		Dimension d = new Dimension(12,12);
		setPreferredSize(d);
	}
	public String getRef(){
		return referens;
	}
	public boolean isVald(){
		return vald;
	}
	public void shiftVald(){
		if (vald) 
			vald=false;
		else 
			vald=true;
	}
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.BLUE);
		g.fillOval(0,0,12,12);
		
		if (!isVald())
			g.setColor(Color.RED);
		
		else 
			g.setColor(Color.GREEN);
			
		g.fillOval(3,3,6,6);	
	}
}