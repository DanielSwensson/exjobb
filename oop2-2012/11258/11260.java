
package game;

import java.util.Random;

/**
 *
 * @author Maria Hansson och  Gustav Larsson
 */
public class Enemy {

    private static Random rnd = new Random();
    private String name;
    private int health;
    private int strength;

    Enemy(String name, int health, int strength) {
        this.name = name;
        this.health = rnd.nextInt(20) + 20;
        this.strength = strength;
    }

    public String toString() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int newHealth) {
        health = newHealth;

    }

    public String getName() {
        return name;
    }

    public int getStrength() {
        return strength;
    }
}
