package units;

import javax.swing.ImageIcon;

import main.Game;

public class MediumRock extends SuperRock {
	public MediumRock(double initX, double initY) {
		this.width = 75;
		this.height = 75;

		this.xLocation = initX;
		this.yLocation = initY;
		imgURL = getClass().getResource("/sprites/MediumRock1.png");
		if (Math.random() * 2 < 1)
			imgURL = getClass().getResource("/sprites/MediumRock2.png");
		ii = new ImageIcon(imgURL);
		sprite = ii.getImage();
		setSpeed();
	}

	protected void destroyThis() {
		Game.splitRock(this);
	}

}
