package objects;

import javax.swing.ImageIcon;
import main.Game;
import units.SuperUnit;

public class Bullet extends SuperUnit {
	public Bullet(int xLoc, int yLoc, double xSpeedParam, double ySpeedParam,
			double inheritXSpeed, double inheritYSpeed) {
		this.width = 8;
		this.height = 8;
		this.xLocation = xLoc - this.width / 2;
		this.yLocation = yLoc - this.height / 2;
		this.xSpeed = (xSpeedParam * 9);
		this.ySpeed = (ySpeedParam * 9);
		imgURL = getClass().getResource("/sprites/Ship.png");
		ii = new ImageIcon(imgURL);
		sprite = ii.getImage();
	}

	public void updateLocation() {
		xLocation += xSpeed;
		yLocation += ySpeed;
		if (this.xLocation > 2000 || this.xLocation < -100
				|| this.yLocation < -100 || this.yLocation > 1200) {
			Game.removeBullet(this);
		}
	}
}
