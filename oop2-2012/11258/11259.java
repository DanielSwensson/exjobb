
package game;

import java.util.ArrayList;

/**
 *
 * @author Maria Hansson och  Gustav Larsson
 */
public class Character {

    private ArrayList<Item> inventory = new ArrayList<Item>();
    private String name;
    private int health;
    private int killScore;

    Character(String name, int health, int killScore) {
        this.name = name;
        this.health = 100;
        this.killScore = 0;


    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
    }

    public int getHealth() {
        return health;

    }

    public void setHealth(int newHealth) {

        if (newHealth > 100) {
            newHealth = 100;
        }
        health = newHealth;
    }

    public void setKillScore(int newScore) {
        killScore = killScore + newScore;
    }

    public int getKillScore() {
        return killScore;
    }

    public void addItem(Item item) {
        inventory.add(item);
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public void getInventoryScore() {
        for (int x = 0; x < inventory.size(); x++) {
            System.out.print(inventory.get(x).getName() + " ");
            System.out.println(inventory.get(x).getPoint());
        }


    }

    public double getFinalScore() {
        double itemScore = 0;
        for (int x = 0; x < inventory.size(); x++) {
            itemScore = itemScore + inventory.get(x).getPoint();
        }

        return killScore + itemScore;
    }

    public String toString() {
        return name + " got " + getFinalScore() + " points. ";
    }
}
