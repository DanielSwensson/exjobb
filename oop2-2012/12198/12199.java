package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

import objects.Bullet;

import units.*;

public class Game implements Runnable {

	public static Player player = new Player();
	public static ArrayList<Bullet> bullets = new ArrayList<Bullet>();
	public static ArrayList<BigRock> bigRocks = new ArrayList<BigRock>();
	public static ArrayList<MediumRock> mediumRocks = new ArrayList<MediumRock>();
	public static ArrayList<SmallRock> smallRocks = new ArrayList<SmallRock>();
	private static Font font = new Font("Small Fonts Regular", Font.PLAIN, 50);

	private static int xRes = 1600;
	private static int yRes = 900;
	public static PaintClass painter = new PaintClass();

	public Game() {
		Thread gameThread = new Thread(this);
		gameThread.start();
		spawnBigRock();
	}

	public static int getXRes() {
		return xRes;
	}

	public static int getYRes() {
		return yRes;
	}

	public static void paintAllTheThings(Graphics g) {
		if (!player.dead) {
			player.draw(g);
			g.setColor(Color.GREEN);
			g.fillRect(0, 0, 20,
					(int) (900 * ((double) player.getHP() / 100.0)));
		}

		for (int i = 0; i < bullets.size() && !bullets.isEmpty(); i++) {
			bullets.get(i).draw(g);
		}
		for (int i = 0; i < bigRocks.size() && !bigRocks.isEmpty(); i++) {
			bigRocks.get(i).draw(g);
		}
		for (int i = 0; i < mediumRocks.size() && !mediumRocks.isEmpty(); i++) {
			mediumRocks.get(i).draw(g);
		}
		for (int i = 0; i < smallRocks.size() && !smallRocks.isEmpty(); i++) {
			smallRocks.get(i).draw(g);
		}
		if (player.dead) {
			g.setFont(font);
			g.setColor(Color.RED);
			g.drawString("You are DEAD!", 600, 400);
		}
		g.setFont(font);
		g.setColor(Color.WHITE);
		g.drawString("Score: " + player.getScore(), 700, 800);

	}

	private void updateLocations() {
		if (!player.dead)
			player.updateLocation();
		for (int i = 0; i < bullets.size() && !bullets.isEmpty(); i++) {
			bullets.get(i).updateLocation();
		}
		for (int i = 0; i < bigRocks.size() && !bigRocks.isEmpty(); i++) {
			bigRocks.get(i).updateLocation();
		}
		for (int i = 0; i < mediumRocks.size() && !mediumRocks.isEmpty(); i++) {
			mediumRocks.get(i).updateLocation();
		}
		for (int i = 0; i < smallRocks.size() && !smallRocks.isEmpty(); i++) {
			smallRocks.get(i).updateLocation();
		}
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(16);
				updateLocations();
			} catch (Exception e) {
			}
		}
	}

	public static void spawnBigRock() {
		int sideSelection = (int) (Math.random() * 4);
		BigRock bigRock = new BigRock(-100, -100);
		if (sideSelection == 0) {
			bigRock = new BigRock(-100, Math.random() * getYRes());
		}
		if (sideSelection == 1) {
			bigRock = new BigRock(Math.random() * getXRes(), -100);
		}
		if (sideSelection == 2) {
			bigRock = new BigRock(getXRes() + 100, Math.random() * getYRes());
		}
		if (sideSelection == 3) {
			bigRock = new BigRock(Math.random() * getXRes(), getYRes() + 100);
		}

		bigRocks.add(bigRock);
	}

	public static void removeBullet(Bullet bulletToRemove) {
		bullets.remove(bullets.indexOf(bulletToRemove));

	}

	public static void splitRock(BigRock bigRockToRemove) {
		spawnBigRock();
		player.increaseScore();
		MediumRock mediumRock = new MediumRock(bigRocks.get(
				bigRocks.indexOf(bigRockToRemove)).getXLocation(), bigRocks
				.get(bigRocks.indexOf(bigRockToRemove)).getYLocation());
		mediumRocks.add(mediumRock);
		mediumRock = new MediumRock(bigRocks.get(
				bigRocks.indexOf(bigRockToRemove)).getXLocation(), bigRocks
				.get(bigRocks.indexOf(bigRockToRemove)).getYLocation());
		mediumRocks.add(mediumRock);
		bigRocks.remove(bigRocks.indexOf(bigRockToRemove));

	}

	public static void splitRock(MediumRock mediumRockToRemove) {
		player.increaseScore();

		SmallRock smallRock = new SmallRock(mediumRocks.get(
				mediumRocks.indexOf(mediumRockToRemove)).getXLocation(),
				mediumRocks.get(mediumRocks.indexOf(mediumRockToRemove))
						.getYLocation());
		smallRocks.add(smallRock);
		smallRock = new SmallRock(mediumRocks.get(
				mediumRocks.indexOf(mediumRockToRemove)).getXLocation(),
				mediumRocks.get(mediumRocks.indexOf(mediumRockToRemove))
						.getYLocation());
		smallRocks.add(smallRock);
		mediumRocks.remove(mediumRocks.indexOf(mediumRockToRemove));

	}

	public static void splitRock(SmallRock smallRockToRemove) {
		player.increaseScore();

		smallRocks.remove(smallRocks.indexOf(smallRockToRemove));
	}

	public static void splitRock(SuperRock superRock) {
		// TEMPORARY PLACEHOLDER METHOD
		System.err.println("This is not supposed to happen.");
	}

}
