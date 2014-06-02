package units;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;

public class SuperUnit {
	protected double xLocation;
	protected double yLocation;
	protected double xSpeed;
	protected double ySpeed;
	protected int width;
	protected int height;
	protected URL imgURL;
	protected ImageIcon ii;
	protected Image sprite;
	protected int hp = 5;

	public void draw(Graphics g) {
		g.setColor(Color.WHITE);
		g.drawImage(sprite, (int) xLocation, (int) yLocation, width, height,
				main.Game.painter);
	}

	public double getXLocation() {
		return xLocation;
	}

	public double getYLocation() {
		return yLocation;
	}

	public double getWidth() {
		return width;
	}

	public double getHeight() {
		return height;
	}

}
