package units;

import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

import objects.Bullet;

import main.Game;
import main.PaintClass;

public class Player extends SuperUnit {
	private boolean shooting;
	private boolean holdingUp;
	private boolean holdingDown;
	private boolean holdingLeft;
	private boolean holdingRight;
	private int maxSpeed = 10;
	private int keyCode;
	private double accelerationSpeed = 0.1;
	private boolean allowShooting;
	private int shootingTimer;
	private boolean invulnerable;
	private int invulTimer;
	public boolean dead;
	private int score = 0;
	private int healthRegenTimer = 0;

	public Player() {
		imgURL = getClass().getResource("/sprites/Ship.png");
		ii = new ImageIcon(imgURL);
		sprite = ii.getImage();
		this.hp = 100;
		this.xLocation = 100;
		this.yLocation = 100;
		this.width = 100;
		this.height = 100;

	}

	@SuppressWarnings("static-access")
	public void keyPressed(KeyEvent e) {
		keyCode = e.getKeyCode();
		if (keyCode == e.VK_A) {
			holdingLeft = true;
		}
		if (keyCode == e.VK_D) {
			holdingRight = true;

		}
		if (keyCode == e.VK_W) {
			holdingUp = true;
		}
		if (keyCode == e.VK_S) {
			holdingDown = true;
		}

	}

	@SuppressWarnings("static-access")
	public void keyReleased(KeyEvent e) {
		keyCode = e.getKeyCode();
		if (keyCode == e.VK_A) {
			holdingLeft = false;
		}
		if (keyCode == e.VK_D) {
			holdingRight = false;

		}
		if (keyCode == e.VK_W) {
			holdingUp = false;
		}
		if (keyCode == e.VK_S) {
			holdingDown = false;
		}

	}

	public void updateLocation() {

		if (holdingUp && ySpeed > -maxSpeed) {
			ySpeed -= accelerationSpeed;
		}
		if (holdingDown && ySpeed < maxSpeed) {
			ySpeed += accelerationSpeed;
		}
		if (holdingLeft && xSpeed > -maxSpeed) {
			xSpeed -= accelerationSpeed;
		}
		if (holdingRight && xSpeed < maxSpeed) {
			xSpeed += accelerationSpeed;
		}
		xLocation += xSpeed;
		yLocation += ySpeed;

		if (shooting) {
			shoot();
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
		if (this.hp <= 0) {
			dead = true;
		}
		healthRegenTimer++;
		if (this.hp < 100 && healthRegenTimer > 15) {
			this.hp++;
			healthRegenTimer = 0;
		}
	}

	public void startShooting() {
		shooting = true;
	}

	public void stopShooting() {
		shooting = false;
	}

	public void damage() {
		if (!invulnerable) {
			this.hp -= 10;
			invulnerable = true;
		}
		invulTimer++;
		if (invulTimer > 10) {
			invulnerable = false;
			invulTimer = 0;
		}
	}

	public void shoot() {
		if (allowShooting) {
			double xDifference = PaintClass.getMouseX()
					- (this.xLocation + width / 2);
			double yDifference = PaintClass.getMouseY()
					- (this.yLocation + height / 2);
			double distance = Math.atan2(yDifference, xDifference);

			Bullet bullet = new Bullet((int) (this.xLocation + this.width / 2),
					(int) (this.yLocation + this.height / 2),
					Math.cos(distance), Math.sin(distance), this.xSpeed,
					this.ySpeed);
			Game.bullets.add(bullet);
			allowShooting = false;

		}
		shootingTimer++;
		if (shootingTimer > 10) {
			shootingTimer = 0;
			allowShooting = true;
		}

	}

	public int getHP() {
		return this.hp;
	}

	public int getScore() {
		return score;
	}

	public void increaseScore() {
		score++;
	}

}
