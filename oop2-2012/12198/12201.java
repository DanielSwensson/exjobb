package main;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class PaintClass extends JFrame implements Runnable,
		MouseMotionListener, MouseListener {
	private Image dbImage;
	private Graphics dbg;
	private static int mxi;
	private static int myi;
	private URL imgURL;
	private ImageIcon ii;
	private Image sprite;

	public PaintClass() {

		setSize(Game.getXRes(), Game.getYRes());
		setBackground(Color.WHITE);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Thread paintthread = new Thread(this);
		paintthread.start();
		addMouseMotionListener(this);
		addKeyListener(new AL());
		addMouseListener(this);
		imgURL = getClass().getResource("/sprites/BG.png");
		ii = new ImageIcon(imgURL);
		sprite = ii.getImage();
	}

	public void run() {
		while (true) {
			try {
				Thread.sleep(16);
				repaint();
			} catch (Exception e) {
			}
		}
	}

	@Override
	public void paint(Graphics g) {
		dbImage = createImage(getWidth(), getHeight());
		dbg = dbImage.getGraphics();
		paintComponent(dbg);
		g.drawImage(dbImage, 0, 0, this);
	}

	public void paintComponent(Graphics g) {
		g.drawImage(sprite, 0, 0, 1600, 900, this);
		Game.paintAllTheThings(g);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		mxi = e.getX();
		myi = e.getY();
		e.consume();

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		mxi = e.getX();
		myi = e.getY();
		e.consume();
	}

	public static int getMouseX() {
		return mxi;
	}

	public static int getMouseY() {
		return myi;
	}



	@Override
	public void mouseClicked(MouseEvent e) {
		// Oanvänd funktion, existerar p.g.a. krav från implementering.

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// Oanvänd funktion, existerar p.g.a. krav från implementering.
	}

  	@Override
	public void mouseExited(MouseEvent e) {
		// Oanvänd funktion, existerar p.g.a. krav från implementering.

	}

	@Override
	public void mousePressed(MouseEvent e) {
		Game.player.startShooting();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		Game.player.stopShooting();
	}
	
	
	public class AL extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			Game.player.keyPressed(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			Game.player.keyReleased(e);
		}
	}
	
	
}
