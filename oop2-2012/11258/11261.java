package game;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Maria Hansson och Gustav Larsson
 */
public class Game {

    Scanner sc = new Scanner(System.in);
    ArrayList<Enemy> monsterArena = new ArrayList<Enemy>();
    Random dice = new Random();
    String itemName;
    Character player;

    Game(Character player) {
        this.player = player;
    }

    int readInt(String question) {
        for (;;) {
            try {
                System.out.println(question);
                int x = Integer.parseInt(sc.nextLine());
                return x;
            } catch (NumberFormatException e) {
                System.out.println("Fail - needs to be a number");
            }
        }
    }

    public String readString(String fråga) {
        System.out.print(fråga);
        String answer = sc.nextLine();
        return answer;
    }

    public void choseItem() {
        boolean found = false;
        while (found == false) {

            itemName = readString(player.getInventory()
                    + "\nChose item by writing it's name: ");
            for (int x = 0; x < player.getInventory().size(); x++) {
                if (player.getInventory().get(x).getName().equalsIgnoreCase(itemName)) {
                    found = true;
                }
            }
        }
    }

    public void useItem() {

        int x = 0;
        int choice;
        do {
            choice = readInt("1. Use on self.\n2. Use on enemy.");
        } while (choice > 2);

        switch (choice) {

            case 1:
                for (x = 0; x < player.getInventory().size(); x++) {
                    if (player.getInventory().get(x).getName().equalsIgnoreCase(itemName)) {

                        int hurt = player.getInventory().get(x).getStat() * dice.nextInt(6);
                        player.setHealth(player.getHealth() - hurt);
                        if (player.getInventory().get(x) instanceof Weapon) {
                            durability();
                        } else if (player.getInventory().get(x) instanceof Fist) {
                        } else {
                            player.getInventory().remove(x);
                        }
                        if (player.getHealth() > 0) {
                            System.out.println("You use " + itemName + " on yourself, you got " + player.getHealth() + " health remaining.");

                        } else {

                            System.out.println("You use " + itemName + " on yourself.");
                        }
                    }
                }
                break;
            case 2:
                for (x = 0; x < player.getInventory().size(); x++) {
                    if (player.getInventory().get(x).getName().equalsIgnoreCase(itemName)) {
                        int hurt = player.getInventory().get(x).getStat() * dice.nextInt(6);
                        monsterArena.get(0).setHealth(monsterArena.get(0).getHealth() - hurt);

                        if (player.getInventory().get(x) instanceof Weapon) {
                            durability();
                        } else if (player.getInventory().get(x) instanceof Fist) {
                        } else {
                            player.getInventory().remove(x);
                        }

                        if (monsterArena.get(0).getHealth() > 0) {
                            System.out.println("You hit for "
                                    + hurt
                                    + " damage with "
                                    + itemName
                                    + " on the monster "
                                    + monsterArena.get(0)
                                    + ", it now has "
                                    + monsterArena.get(0).getHealth()
                                    + " health remaining");

                        } else {
                            System.out.println("You hit for "
                                    + hurt
                                    + " damage with "
                                    + itemName
                                    + " on the monster "
                                    + monsterArena.get(0));


                        }
                    }
                }
                break;

            default:
                System.out.println("Command failed.");

                break;
        }
    }

    public void durability() {
        for (int x = 0; x < player.getInventory().size(); x++) {
            if (player.getInventory().get(x).getName().equalsIgnoreCase(itemName)) {

                ((Weapon) player.getInventory().get(x)).setDurability();
                System.out.println("You use " + itemName + " it now has " + ((Weapon) player.getInventory().get(x)).getDurability() + " durability left");

                if (((Weapon) player.getInventory().get(x)).getDurability() == 0) {
                    player.getInventory().remove(x);
                    System.out.println("Your " + itemName + " broke");
                }
            }
        }
    }

    void checkOverKill() {
        if (monsterArena.get(0).getHealth() <= 0) {
            System.out.println("Overkill: " + (monsterArena.get(0).getHealth() * (-1)));
            System.out.println("Monster is dead.");
        }
        if (player.getHealth() <= 0) {
            System.out.println("Overkill: " + (player.getHealth() * (-1)));
            System.out.println("You are dead.");
        }
    }

    public void enemyAttack() {
        int hurt = monsterArena.get(0).getStrength() * dice.nextInt(6);
        player.setHealth(player.getHealth() - hurt);
        if (player.getHealth() - hurt > 0) {
            System.out.println(monsterArena.get(0)
                    + " hits you for "
                    + hurt
                    + " damage, you have "
                    + player.getHealth()
                    + " health remaining.");
        } else {
            System.out.println(monsterArena.get(0)
                    + " hits you for "
                    + hurt
                    + " damage.");
        }
    }

    public void lootItem() {
        ArrayList<Item> randomItems = new ArrayList<Item>();
        Candy newItem = new Candy("Strawberry shot", -100, 6);
        Salt newItem1 = new Salt("Salt", 10, 8);
        Weapon newItem2 = new Weapon("Giant axe", 20, 2, 2, 15);
        randomItems.add(newItem);
        randomItems.add(newItem1);
        randomItems.add(newItem2);
        int dice3 = dice.nextInt(3);
        player.getInventory().add(randomItems.get(dice3));
        System.out.println("You loot: " + randomItems.get(dice3));


    }

    public void killScore() {

        player.setKillScore(10);
    }

    public boolean findItem() {
        String itemName = sc.nextLine();
        boolean found = false;
        for (int x = 0; x < player.getInventory().size(); x++) {
            if (player.getInventory().get(x).equals(itemName)) {
                found = true;
            }
        }
        return found;
    }

    public void startWeapon() {
        player.addItem(new Fist("Fists", 1));
        player.getInventory().add(new Weapon("Wooden Sword", 2, 20, 20, 5));
    }

    public void createArena() {
        monsterArena.add(new Enemy("Toothinator", 20, 3));
        monsterArena.add(new Enemy("Sugar Mushroom", 16, 4));
        monsterArena.add(new Enemy("Frenzied Moose", 30, 12));

    }

    public void playGame() {
        monsterArena.get(0);
        System.out.println("A wild " + monsterArena.get(0) + " with " + monsterArena.get(0).getHealth() + " health appears.");
    }
}
