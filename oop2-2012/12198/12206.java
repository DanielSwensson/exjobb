package units;

import javax.swing.ImageIcon;

import main.Game;

public class SmallRock extends SuperRock {
	public SmallRock(double initX, double initY) {
		this.width = 40;
		this.height = 40;

		this.xLocation = initX;
		this.yLocation = initY;
		imgURL = getClass().getResource("/sprites/SmallRock1.png");
		if (Math.random() * 2 < 1)
			imgURL = getClass().getResource("/sprites/SmallRock2.png");
		ii = new ImageIcon(imgURL);
		sprite = ii.getImage();
		setSpeed();
	}

	protected void destroyThis() {
		Game.splitRock(this);
	}

}
