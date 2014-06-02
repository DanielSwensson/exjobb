package units;

import javax.swing.ImageIcon;

import main.Game;

public class BigRock extends SuperRock {
	public BigRock(double initX, double initY) {
		this.width = 100;
		this.height = 100;
		this.xLocation = initX;
		this.yLocation = initY;

		imgURL = getClass().getResource("/sprites/BigRock1.png");
		if (Math.random() * 2 < 1)
			imgURL = getClass().getResource("/sprites/BigRock2.png");
		ii = new ImageIcon(imgURL);
		sprite = ii.getImage();
		setSpeed();
	}

	protected void setSpeed() {
		double xDifference = Game.player.getXLocation()
				- (xLocation + width / 2);
		double yDifference = Game.player.getYLocation()
				- (yLocation + height / 2);
		double distance = Math.atan2(yDifference, xDifference);
		this.xSpeed = Math.cos(distance);
		this.ySpeed = Math.sin(distance);

	}

	protected void destroyThis() {
		Game.splitRock(this);
	}

}
