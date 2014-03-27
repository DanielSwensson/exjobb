

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComponent;

public class GUINod extends JComponent {

	private static final long serialVersionUID = 1L;
	private int radius = 15;
	private String p;
	private boolean markerad;
	public static int antalmarkerade = 0;

	public GUINod(int x, int y, String p) {

		setPreferredSize(new Dimension(x - radius, y - radius));
		setBounds(x, y, radius + 50, radius +10);
		markerad = false;
		addMouseListener(new markera());
		this.p = p;

	}

	public Boolean GetMarkerad() {
		return markerad;
	}

	public String GetPlats() {
		return p;
	}

	protected void paintComponent(Graphics g) {

		super.paintComponent(g);
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		if (markerad == false) {
			g.setColor(Color.RED);
			g.fillOval(0, 0, 13, 13);
			g.setColor(Color.BLACK);
			g.setFont(new Font("Helvetica", Font.BOLD, 12));
			g.drawString(p, 0, 22);

		} else {
			g.setColor(Color.RED);
			g.fillOval(0, 0, 13, 13);
			g.setColor(Color.BLACK);
			g.fillOval(3, 3, 8, 8);
			g.setFont(new Font("Helvetica", Font.BOLD, 12));
			g.drawString(p, 0, 22);
		}
	}

	class markera extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {
			if (markerad == false) {
				if (antalmarkerade <= 2) {
					markerad = true;
					antalmarkerade += 1;
				}
				if (antalmarkerade > 2) {
					markerad = false;
					GUIDialogrutor.fel("Du kan bara markera två platser");
					antalmarkerade -= 1;
				}
			} else {
				markerad = false;
				antalmarkerade -= 1;
			}
			repaint();
		}
	}

}
