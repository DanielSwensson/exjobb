import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Game {

	static Map worldMap = new Map();
	static Player player = new Player(50, 2, 0);
	static Scanner input = new Scanner(System.in);

	static ArrayList<WordList> wordListList = new ArrayList<WordList>();

	public static void main(String[] args) {
		
		wordListList.add(new WordList("movement", new String[] { "go", "walk", "run" }));
		wordListList.add(new WordList("take", new String[] { "take", "grab", "pick" }));
		wordListList.add(new WordList(new String[] { "sword", "cat", "key", "ring", "pizza" }));
		wordListList.add(new WordList(new String[] { "north", "east", "west", "south" }));

		boolean gameActive = true;
		help(); 

		System.out.println(getRoom(player.getX(), player.getY()));

		do {
			System.out.print("\nEnter command here: ");

			String word[] = processCommand(input.nextLine());

			switch (word[0]) {

			case "movement":
				if (legalMove(word[1]) && (word[1] != "error")) {
					enterNextRoom(word[1]);
				} else {
					System.out.println("Not possible");
				}
				break;

			case "take":
				pickUpItem(word[1]);
				break;

			case "look":
				
				System.out.println("\n" + currentRoom().getDescription());
				
				break;

			case "help":
	
				help();
				
				break;
				
			case "status":
				System.out.println("\nYou have " + player.getHealth() + " hp.");
				break;
			case "I":
				player.getInventory().printInv();
				break;

			case "map":
				worldMap.printMap(player);
				break;
		
			case "quit":
				gameActive = false;
				input.close();
				break;

			default:
				System.out.println("Wrong command");
				break;

			}
		} while (gameActive);
	}


	public static Room currentRoom() {
		return worldMap.getRoom(player.getX(), player.getY());
	}

	public static boolean legalMove(String destination) {

		switch (destination) {

		case "north":
			if (player.getY() - 1 < 0) {
				return false;
			}
			break;

		case "south":
			if (player.getY() + 1 >= worldMap.getMaxY()) {
				return false;
			}
			break;

		case "west":
			if (player.getX() - 1 < 0) {
				return false;
			}
			break;

		case "east":
			if (player.getX() + 1 >= worldMap.getMaxX()) {
				return false;
			}
			break;

		default:
			return false;
	
		}

		if (nextRoomExists(destination))
			return true;
		return false;

	}

	public static void pickUpItem(String itemName) {
		
			if (currentRoom().getItem() != null && itemName.equalsIgnoreCase(currentRoom().getItem().getName())) {
				if(currentRoom().getItem() instanceof Food ){
					player.eat((Food)currentRoom().getItem());	
					System.out.println("You ate a " + itemName);
				}else{
				player.getInventory().add(currentRoom().getItem());
				}
				
				currentRoom().removeItem();
			} else {
				System.out.println("There is no such item here!");
				}
		}

	public static String[] processCommand(String command) {

		int bigEnough = 10;
		String word[] = new String[bigEnough];

		if (command.contains(" ")) {
			word = compressCommand(command.split(" "));
		} else {
			word[0] = command;
			word[1] = "isEmpty";
		}

		for (int i = 0; i < wordListList.size(); i++) {
			if (wordListList.get(i).checkIfSynonym(word[0]))
				word[0] = wordListList.get(i).returnSynonym(word[0]);
		}

		return word;

	}

	public static String[] compressCommand(String[] arrayOfWords) {

		ArrayList<String> words = new ArrayList<String>();

		Collections.addAll(words, arrayOfWords);

		boolean wordHit = false;

		for (int i = 0; i < words.size(); i++) {
			wordHit = false;
			for (int j = 0; j < wordListList.size(); j++) {
				for (int k = 0; k < wordListList.get(j).getSize(); k++) {
					if (words.get(i).equalsIgnoreCase(
							wordListList.get(j).getWord(k))) {
						wordHit = true;
					}

				}
			}
			if (wordHit == false || words.get(i).equals("I")) {
				words.remove(i);
				i--;
			}
		}

		String[] arrayOfCommands = new String[words.size() + 1];

		if (words.size() <= 1 ) {
			words.add("isEmpty");
			words.add("isEmpty");
		}

		return words.toArray(arrayOfCommands);
	
	}

	public static void enterNextRoom(String direction) {
	
		System.out.println();
		player.movePlayer(direction);
		
			if (currentRoom().getRoomEvent() != null && !currentRoom().getRoomEvent().getIsCompleted()) {
				player = currentRoom().getRoomEvent().startEvent(player);

			}
			
			player = randomMonsterEvent(player.getX(), player.getY(), player);
		
		System.out.println(currentRoom());
		
	}

	public static boolean nextRoomExists(String destination) {
		int testHealth = 100;
		Player copy = new Player(testHealth, player.getX(), player.getY());
		copy.movePlayer(destination);
		if ((getRoom(copy.getX(), copy.getY())) == null)
			return false;
		return true;
	}

	public static Room getRoom(int x, int y) {
		return worldMap.getRoom(x, y);
	}
	
	
public static Player randomMonsterEvent(int x, int y, Player player){
		
		Monster monster = null;
		
		Random rand = new Random();
		int number = rand.nextInt(100)+1;
		
		if(number > 96){
			monster = new Dragon();
		}else if(number > 60 && number < 96){
			monster = new Rat();
		}
		else if(number >45 && number < 60){
			monster = new Orc();
		}
		
		if((monster != null) && (currentRoom().getRoomEvent() == null || currentRoom().getRoomEvent().getIsCompleted())){
			MonsterEvent randEvent = new MonsterEvent(monster);
			randEvent.startEvent(player);
		}
		return player;
	}
	
	
	public static void help(){
		
		System.out.println("Welcome to MansionMaze. You are a player in a  run down mansion\n"+
				"and have just entered your first room. Your task is to find \n" +
				"the treasure in the mansion by moving from room to room, being smart,\nusing items" +
				" and killing monsters.\n");
		
		System.out.println("----------Command instructions----------");
		System.out.println("Move around: ex. go north, run east, walk west, go south");
		System.out.println("Take item: ex. take cat, pick key, grab sword etc.");
		System.out.println("To get help, type help");
		System.out.println("To view map, type map");
		System.out.println("To view status, type status");
		System.out.println("To view inventory, type I");
		System.out.println("To quit, type quit");
		System.out.println("To view room description, type look");
		System.out.println("----------------------------------------");
		
	}

}
