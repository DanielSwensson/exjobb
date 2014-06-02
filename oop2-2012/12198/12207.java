package units;

import main.Game;

public class SuperRock extends SuperUnit {

	protected void setSpeed() {
		this.ySpeed = (Math.random() * 4) - 2;
		this.xSpeed = (Math.random() * 4) - 2;
	}

	public void updateLocation() {
		xLocation += xSpeed;
		yLocation += ySpeed;

		for (int i = 0; i < Game.bullets.size(); i++) {
			if (Game.bullets.get(i).getXLocation()
					+ Game.bullets.get(i).getWidth() > this.xLocation
					&& Game.bullets.get(i).getYLocation()
							+ Game.bullets.get(i).getHeight() > this.yLocation
					&& Game.bullets.get(i).getXLocation() < this.xLocation
							+ this.width
					&& Game.bullets.get(i).getYLocation() < this.yLocation
							+ this.height) {
				Game.removeBullet(Game.bullets.get(i));
				this.hp--;
			}
		}

		if (Game.player.getXLocation() + Game.player.getWidth() > this.xLocation
				&& Game.player.getYLocation() + Game.player.getHeight() > this.yLocation
				&& Game.player.getXLocation() < this.xLocation + this.width
				&& Game.player.getYLocation() < this.yLocation + this.height) {
			Game.player.damage();
		}

		if (this.hp <= 0) {
			destroyThis();
		}
		if (this.xLocation > Game.getXRes()) {
			this.xLocation = -(double) this.width;
		}
		if (this.xLocation < -(double) this.width) {
			this.xLocation = Game.getXRes();
		}
		if (this.yLocation > Game.getYRes()) {
			this.yLocation = -(double) this.height;
		}
		if (this.yLocation < -(double) this.height) {
			this.yLocation = Game.getYRes();
		}

	}

	protected void destroyThis() {
		Game.splitRock(this);
	}

}
