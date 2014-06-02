package game;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Maria Hansson och Gustav Larsson
 */
public class MainMenu {

    Scanner sc = new Scanner(System.in);
    Character newPlayer;
    ArrayList<Character> scoreboard = new ArrayList<Character>();
    Game game = null;

    public String readString(String fråga) {
        System.out.print(fråga);
        String answer = sc.nextLine();
        return answer;
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

    public void newGame() {
        String name = readString("Create a character \nEnter Name: ");
        newPlayer = new Character(name, 100, 0);
        if (alreadyExists(scoreboard, newPlayer) == true) {

            System.out.println("That name is taken!");
        } else {

            game = new Game(newPlayer);
            scoreboard.add(newPlayer);
            game.startWeapon();
        }
    }

    private static boolean alreadyExists(ArrayList<Character> scoreboard, Character newPlayer) {
        boolean found = false;
        for (Character p : scoreboard) {
            if (newPlayer.getName().equals(p.getName())) {
                found = true;
            } //if
        } // for

        return found;
    }

    public void printScoreboard() {
        for (Character allPlayers : scoreboard) {
            System.out.println(allPlayers);
        }
    }

    public void printKillScore() {
        for (int x = 0; x < scoreboard.size(); x++) {
            System.out.println(scoreboard.get(x).getName() + " has " + scoreboard.get(x).getKillScore() + " points");
        }
    }

    public void pickPlayer() {
        String foundName = readString("Name: ");
        for (int x = 0; x < scoreboard.size(); x++) {
            if (scoreboard.get(x).getName().equalsIgnoreCase(foundName)) {
                scoreboard.get(x).getInventoryScore();
            }
        }
    }

    public void sortScoreboard() {

        for (int b = 0; b < 100; b++) {
            for (int x = 0; x < scoreboard.size() - 1; x++) {


                if (scoreboard.get(x).getFinalScore() < scoreboard.get(x + 1).getFinalScore()) {
                    Character swap = scoreboard.get(x);
                    scoreboard.remove(x);
                    scoreboard.add(swap);
                }

            }
        }
    }

    public void quit() {
        System.exit(0);
    }

    public void youLose() {
        System.out.println("Game over man, game over!");
    }

    public void youWin() {
        System.out.println("You won zeh game!");
    }

    public void mainMenu() {


        for (;;) {
            int choice = readInt("Arena - The Challenge. \n"
                    + "Choose your action: \n"
                    + "1. New Game \n"
                    + "2. Show Score \n"
                    + "3. Quit");

            switch (choice) {
                case 1:
                    int arraySize = scoreboard.size();
                    newGame();
                    if (arraySize < scoreboard.size()) {
                        game.createArena();

                        while ((newPlayer.getHealth() > 0 && game.monsterArena.size() > 0)) {
                            game.playGame();
                            while ((game.monsterArena.get(0).getHealth() > 0) && (newPlayer.getHealth() > 0)) {
                                game.choseItem();
                                game.useItem();

                                if ((game.monsterArena.get(0).getHealth() > 0) && (newPlayer.getHealth() > 0)) {
                                    game.enemyAttack();

                                }
                                game.checkOverKill();
                            }
                            if ((newPlayer.getHealth() > 0)) {
                                game.lootItem();
                                game.killScore();
                                game.monsterArena.remove(0);

                            }
                        }
                        if (game.monsterArena.isEmpty()) {
                            youWin();
                        } else {
                            youLose();
                        }
                    }

                    break;

                case 2:

                    sortScoreboard();
                    printScoreboard();
                    if (scoreboard.isEmpty()) {
                        System.out.println("List is empty");
                        break;
                    }

                    choice = readInt("Choose your action: \n"
                            + "1. Show best player \n"
                            + "2. Show scoreboard without item score \n"
                            + "3. Show inventory of specific player\n"
                            + "4. Return to menu");

                    switch (choice) {
                        case 1:
                            System.out.println(scoreboard.get(0).getName() + "'s inventory:");
                            scoreboard.get(0).getInventoryScore();

                            break;
                        case 2:
                            printKillScore();
                            break;
                        case 3:
                            pickPlayer();
                            break;
                        case 4:
                            break;
                        default:
                            System.out.println("wrong, try something better");
                    }

                    break;

                case 3:
                    System.out.println("Closing down. Bye.");
                    quit();

                default:
                    System.out.println("Command failed.");
            }
        }
    }

    public static void main(String[] args) {

        MainMenu mm = new MainMenu();
        mm.mainMenu();
    }
}